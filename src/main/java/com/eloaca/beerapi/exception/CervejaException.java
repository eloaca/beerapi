package com.eloaca.beerapi.exception;

public class CervejaException extends Exception{

    private static final long serialVersionUID = -79685665918848640L;

    public CervejaException(String mensagem){
        super(mensagem);
    }
}
