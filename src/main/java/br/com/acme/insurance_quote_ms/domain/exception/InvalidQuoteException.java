package br.com.acme.insurance_quote_ms.domain.exception;

public class InvalidQuoteException extends RuntimeException {
    public InvalidQuoteException(String message){
        super(message);
    }
}
