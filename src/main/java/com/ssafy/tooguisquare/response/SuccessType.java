package com.ssafy.tooguisquare.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessType {

    //도메인별로 SuccessType 정의, 성공시 msg, data 반환

    //****************************Channel****************************//
    CHANNEL_LIST_CALLED_SUCCESSFULLY("채널 리스트 조회 성공"),

    //****************************Square****************************//
    ENTER_CHANNEL_SUCCESSFULLY("채널 입장 성공"),

    EXIT_CHANNEL_SUCCESSFULLY("채널 나가기 성공"),
    CREATE_ROOM_SUCCESSFULLY("방 생성 성공"),
    FAST_ENTER_SUCCESSFULLY("빠른입장 성공"),
    SEARCH_ROOM_SUCCESSFULLY("방 찾기 성공"),
    ROOM_LIST_CALLED_SUCCESSFULLY("방 목록 조회 성공"),
    USER_LIST_CALLED_SUCCESSFULLY("접속 중인 유저목록 조회 성공"),
    //****************************Room****************************//
    ROOM_ENTER_REQUEST_SUCCESSFULLY("방 접속 로직 정상 동작"),
    ENTER_ROOM_SUCCESSFULLY("방 접속 성공"),
    EXIT_ROOM_SUCCESSFULLY("유저 방 나가기 성공"),
    GET_ROOM_USER_LIST_SUCCESSFULLY("유저 리스트 조회 성공"),
    USER_KICK_OUT_SUCCESSFULLY("유저 강퇴 성공"), USER_READY_SUCCESSFULLY("유저 레디 성공");


    private final String msg; //success message

}
