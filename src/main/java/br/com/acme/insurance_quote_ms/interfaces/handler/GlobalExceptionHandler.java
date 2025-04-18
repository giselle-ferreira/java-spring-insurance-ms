package br.com.acme.insurance_quote_ms.interfaces.handler;

import br.com.acme.insurance_quote_ms.domain.exception.InvalidQuoteException;
import br.com.acme.insurance_quote_ms.interfaces.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidQuoteException.class)
    public ErrorResponseDTO handleInvalidQuoteException(InvalidQuoteException ex){
        return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
