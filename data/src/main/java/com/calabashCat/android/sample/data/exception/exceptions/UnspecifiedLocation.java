package com.calabashCat.android.sample.data.exception.exceptions;


public class UnspecifiedLocation extends YelpAPIError {
    public UnspecifiedLocation(int code, String message, String id, String text) {
        super(code, message, id, text);
    }
}
