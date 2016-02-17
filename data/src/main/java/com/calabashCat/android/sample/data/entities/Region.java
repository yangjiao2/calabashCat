package com.calabashCat.android.sample.data.entities;

public class Region {
    /**
     * latitude_delta : 0.04693337000000497
     * longitude_delta : 0.03879615184169438
     */

    private Span span;
    /**
     * latitude : 37.78578235
     * longitude : -122.4129723855265
     */

    private Center center;

    public void setSpan(Span span) {
        this.span = span;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Span getSpan() {
        return span;
    }

    public Center getCenter() {
        return center;
    }
}
