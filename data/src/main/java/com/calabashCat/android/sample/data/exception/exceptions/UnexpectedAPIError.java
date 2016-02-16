package com.calabashCat.android.sample.data.exception.exceptions;


public class UnexpectedAPIError extends YelpAPIError {
    public UnexpectedAPIError(int code, String message) {
        this(code, message, null, null);
    }

    public UnexpectedAPIError(int code, String message, String id, String text) {
        super(code, message, id, text);
    }
}
