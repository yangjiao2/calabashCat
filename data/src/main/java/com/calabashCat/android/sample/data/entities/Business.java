package com.calabashCat.android.sample.data.entities;

import java.util.List;

public class Business {
    private boolean is_claimed;
    private double rating;
    private String mobile_url;
    private String rating_img_url;
    private int review_count;
    private String name;
    private String rating_img_url_small;
    private String url;
    private int menu_date_updated;
    private String phone;
    private String image_url;
    /**
     * cross_streets : Taber Aly & Park Ave
     * city : San Francisco
     * display_address : ["521A 3rd St","SoMa","San Francisco, CA 94107","USA"]
     * geo_accuracy : 9.5
     * neighborhoods : ["SoMa"]
     * postal_code : 94107
     * country_code : US
     * address : ["521A 3rd St"]
     * coordinate : {"latitude":37.7810450986458,"longitude":-122.395337771053}
     * state_code : CA
     */

    private Location location;
    private String display_phone;
    private String rating_img_url_large;
    private String menu_provider;
    private String id;
    private boolean is_closed;
    private List<List<String>> categories;

    public void setIs_claimed(boolean is_claimed) {
        this.is_claimed = is_claimed;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public void setRating_img_url(String rating_img_url) {
        this.rating_img_url = rating_img_url;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating_img_url_small(String rating_img_url_small) {
        this.rating_img_url_small = rating_img_url_small;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMenu_date_updated(int menu_date_updated) {
        this.menu_date_updated = menu_date_updated;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDisplay_phone(String display_phone) {
        this.display_phone = display_phone;
    }

    public void setRating_img_url_large(String rating_img_url_large) {
        this.rating_img_url_large = rating_img_url_large;
    }

    public void setMenu_provider(String menu_provider) {
        this.menu_provider = menu_provider;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public void setCategories(List<List<String>> categories) {
        this.categories = categories;
    }

    public boolean isIs_claimed() {
        return is_claimed;
    }

    public double getRating() {
        return rating;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public String getRating_img_url() {
        return rating_img_url;
    }

    public int getReview_count() {
        return review_count;
    }

    public String getName() {
        return name;
    }

    public String getRating_img_url_small() {
        return rating_img_url_small;
    }

    public String getUrl() {
        return url;
    }

    public int getMenu_date_updated() {
        return menu_date_updated;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage_url() {
        return image_url;
    }

    public Location getLocation() {
        return location;
    }

    public String getDisplay_phone() {
        return display_phone;
    }

    public String getRating_img_url_large() {
        return rating_img_url_large;
    }

    public String getMenu_provider() {
        return menu_provider;
    }

    public String getId() {
        return id;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public List<List<String>> getCategories() {
        return categories;
    }
}
