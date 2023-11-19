package br.com.controle.financas.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Log4j2
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<CustomMessageValidation> handleValidationIntercep(MethodArgumentNotValidException  exception){

        List<CustomMessageValidation> validations = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            log.error("Erro de validação para o campo: {} com a mensagem: {}", fieldError.getField(), fieldError.getDefaultMessage());
            validations.add(CustomMessageValidation.builder()
                    .campo(fieldError.getField())
                    .descricao(fieldError.getDefaultMessage())
                    .build());
        });

        return validations;
    }
}
