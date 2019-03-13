package com.stackroute.musicservice.Exceptions;
/*Create custom exceptions Track/MusicNotFoundException, Track/MusicAlreadyExistsException in a com.stack....exceptions package.
 Perform appropriate exception handling and propagation back.*/

public class MusicAlreadyExistsException extends Exception {
    private String message;

    public MusicAlreadyExistsException() {
    }

    public MusicAlreadyExistsException(String message) {
        super(message);
        this.message = message;

    }
}
