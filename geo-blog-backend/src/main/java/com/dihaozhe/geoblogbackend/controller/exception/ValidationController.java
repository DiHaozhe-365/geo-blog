package com.dihaozhe.geoblogbackend.controller.exception;

import com.dihaozhe.common.response.Result;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ValidationController  {

    @ExceptionHandler(ValidationException.class)
    public Result<Void> validateException(ValidationException exception) {
        log.warn("Resolve [{}: {}]", exception.getClass().getName(), exception.getMessage());
        return Result.failure(400, "邮箱格式错误");
    }

}
