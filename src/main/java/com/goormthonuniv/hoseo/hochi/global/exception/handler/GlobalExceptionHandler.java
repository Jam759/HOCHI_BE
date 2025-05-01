package com.goormthonuniv.hoseo.hochi.global.exception.handler;


import com.goormthonuniv.hoseo.hochi.global.exception.dto.ExceptionResponse;
import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import com.goormthonuniv.hoseo.hochi.global.exception.rootException.BaseExceptionInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ✅ 1. 우리가 만든 BaseException (예: NotFound, Duplicated 등) 처리
    @ExceptionHandler(AbstractBaseExceptionInterface.class)
    public ResponseEntity<ExceptionResponse> handleBaseException(BaseExceptionInterface e, HttpServletRequest request) {
        log.error(e.getDevMessage());
        ExceptionResponse response = ExceptionResponse.builder()
                .status(e.getStatus().value())
                .code(e.getErrorCode())
                .message(e.getErrorMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response, e.getStatus());
    }

    // ✅ 2. @Valid 실패 (RequestBody DTO 검증 실패)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        String errorMessage = "잘못된 RequestBody 입력입니다.";

        ExceptionResponse response = ExceptionResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code("INVALID_REQUEST")
                .message(errorMessage)
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // ✅ 3. @Validated 실패 (RequestParam, PathVariable 검증 실패)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolation(ConstraintViolationException e, HttpServletRequest request) {
        String errorMessage = e.getConstraintViolations().stream()
                .findFirst()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .orElse("잘못된 RequestParam 혹은 PathVariable 입력입니다.");

        ExceptionResponse response = ExceptionResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code("INVALID_REQUEST")
                .message(errorMessage)
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    // ✅ 5. 알 수 없는 모든 예외 (최후방)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e, HttpServletRequest request) {

        e.printStackTrace(); // 혹시 몰라서 콘솔에도 출력

        ExceptionResponse response = ExceptionResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .code("INTERNAL_SERVER_ERROR")
                .message("서버 내부 오류가 발생했습니다.")
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
