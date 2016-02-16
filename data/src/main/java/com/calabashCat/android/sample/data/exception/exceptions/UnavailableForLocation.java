package com.calabashCat.android.sample.data.exception.exceptions;


public class UnavailableForLocation extends YelpAPIError {
    public UnavailableForLocation(int code, String message, String id, String text) {
        super(code, message, id, text);
    }
}
