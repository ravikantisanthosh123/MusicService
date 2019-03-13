package com.stackroute.musicservice.Exceptions;

/*Create custom exceptions Track/Music NotFoundException, Track/Music AlreadyExistsException in a com.stack....exceptions package.
 Perform appropriate exception handling and propagation back.*/
public class MusicNotFoundException extends Exception {
    private String message;

    public MusicNotFoundException() {
    }

    public MusicNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
