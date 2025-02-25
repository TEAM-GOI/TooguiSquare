package com.ssafy.tooguisquare.exception;

import com.ssafy.tooguisquare.response.ErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomBadRequestException extends RuntimeException {

    private final ErrorType errorType;

}
