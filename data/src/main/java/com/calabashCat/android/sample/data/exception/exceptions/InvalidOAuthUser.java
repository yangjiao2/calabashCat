package com.calabashCat.android.sample.data.exception.exceptions;


public class InvalidOAuthUser extends YelpAPIError {
    public InvalidOAuthUser(int code, String message, String id, String text) {
        super(code, message, id, text);
    }
}
