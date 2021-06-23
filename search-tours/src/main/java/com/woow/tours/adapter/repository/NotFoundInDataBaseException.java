package com.woow.tours.adapter.repository;

public class NotFoundInDataBaseException extends RuntimeException{

    public NotFoundInDataBaseException() {
        super("Objeto não encontrado na base de dados");
    }
}
