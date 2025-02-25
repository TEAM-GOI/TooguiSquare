package com.ssafy.tooguisquare.exception;

import com.ssafy.tooguisquare.response.ErrorResponse;
import com.ssafy.tooguisquare.response.ErrorRoomResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class, NoHandlerFoundException.class, TypeMismatchException.class})
    public ErrorResponse handleBadRequest(Exception e) {
        log.error("[BadRequestException]", e);
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("[HttpRequestMethodNotSupportedException]", e);
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, "지원 하지 않는 Http Method 입니다.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        log.error("[ConstraintViolationException]", e);
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomBadRequestException.class)
    protected ErrorResponse handleCustomBadRequestException(CustomBadRequestException e) {
        log.error("[CustomBadRequestException]");
        return ErrorResponse.from(e.getErrorType());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomRoomEnterException.class)
    protected ErrorRoomResponse handleCustomRoomEnterException(CustomRoomEnterException e) {
        log.error("[CustomRoomEnterException]");
        return ErrorRoomResponse.of(e.getErrorType(),e.getRoomId());
    }

    //validation에서 dto에서 @NotNull과 같은 것이 붙은 필드에 대해서 BindException이 발생했을때
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    protected ErrorResponse bindException(BindException e) {
        log.error("[BindException]");
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
