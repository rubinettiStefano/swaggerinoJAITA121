package com.generation.swaggerino.controller.exceptions;

public class EntityNotFoundException extends RuntimeException
{

    public EntityNotFoundException(String message)
    {
        super(message);
    }

}
