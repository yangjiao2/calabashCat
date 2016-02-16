package com.calabashCat.android.sample.data.exception.exceptions;


public class MissingParameter extends YelpAPIError {
    public MissingParameter(int code, String message, String id, String text) {
        super(code, message, id, text);
    }
}
