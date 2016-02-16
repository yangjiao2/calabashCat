package com.calabashCat.android.sample.data.exception.exceptions;


public class InvalidOAuthCredentials extends YelpAPIError {
    public InvalidOAuthCredentials(int code, String message, String id, String text) {
        super(code, message, id, text);
    }
}
