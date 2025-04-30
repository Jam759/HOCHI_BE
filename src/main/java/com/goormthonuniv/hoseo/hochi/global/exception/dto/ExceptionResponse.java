package com.goormthonuniv.hoseo.hochi.global.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // ✅ null 필드는 JSON에 안 넣는다!
public class ExceptionResponse {
    private final LocalDateTime timestamp; // 에러 발생 시간
    private final int status;              // HTTP 상태코드 숫자 (ex: 404)
    private final String code;             // 에러 코드명 (ex: "NOT_FOUND")
    private final String message;          // 에러 메시지
    private final String path;             // 요청 URL (선택사항)

    @Builder
    public ExceptionResponse(int status, String code, String message, String path){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.code = code;
        this.message = message;
        this.path = path;
    }

}
