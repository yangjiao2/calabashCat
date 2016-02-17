package com.calabashCat.android.sample.data.entities;

import java.io.Serializable;
import java.util.List;


public class SearchResponse implements Serializable {

    /**
     * span : {"latitude_delta":0.04693337000000497,"longitude_delta":0.03879615184169438}
     * center : {"latitude":37.78578235,"longitude":-122.4129723855265}
     */

    private Region region;
    /**
     * region : {"span":{"latitude_delta":0.04693337000000497,"longitude_delta":0.03879615184169438},"center":{"latitude":37.78578235,"longitude":-122.4129723855265}}
     * total : 12586
     * businesses : [{"is_claimed":true,"rating":4.5,"mobile_url":"http://m.yelp.fr/biz/hrd-san-francisco-2?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw","rating_img_url":"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/99493c12711e/ico/stars/v1/stars_4_half.png","review_count":1761,"name":"HRD","rating_img_url_small":"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/a5221e66bc70/ico/stars/v1/stars_small_4_half.png","url":"http://www.yelp.fr/biz/hrd-san-francisco-2?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw","categories":[["Restaurant Asiatique","asianfusion"]],"menu_date_updated":1441920733,"phone":"+14155432355","image_url":"http://s3-media4.fl.yelpcdn.com/bphoto/KEwOE6RPiGRm2H0zVHVAgA/ms.jpg","location":{"cross_streets":"Taber Aly & Park Ave","city":"San Francisco","display_address":["521A 3rd St","SoMa","San Francisco, CA 94107","USA"],"geo_accuracy":9.5,"neighborhoods":["SoMa"],"postal_code":"94107","country_code":"US","address":["521A 3rd St"],"coordinate":{"latitude":37.7810450986458,"longitude":-122.395337771053},"state_code":"CA"},"display_phone":"+1-415-543-2355","rating_img_url_large":"http://s3-media4.fl.yelpcdn.com/assets/2/www/img/9f83790ff7f6/ico/stars/v1/stars_large_4_half.png","menu_provider":"single_platform","id":"hrd-san-francisco-2","is_closed":false},{"is_claimed":true,"rating":4.5,"mobile_url":"http://m.yelp.fr/biz/the-codmother-fish-and-chips-san-francisco?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw","rating_img_url":"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/99493c12711e/ico/stars/v1/stars_4_half.png","review_count":1711,"name":"The Codmother Fish and Chips","rating_img_url_small":"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/a5221e66bc70/ico/stars/v1/stars_small_4_half.png","url":"http://www.yelp.fr/biz/the-codmother-fish-and-chips-san-francisco?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw","categories":[["Restaurant Britannique","british"],["Fish & Chips","fishnchips"],["Restaurant de fruits de mer","seafood"]],"phone":"+14156069349","snippet_text":"le poisson fait 100m depuis la baie pour se retrouver ds l assiette. les filles aux commandes ont la peche ;) , leur sauce maison est à ne pas rater","image_url":"http://s3-media4.fl.yelpcdn.com/bphoto/7PytB3z6QbM22DFpW8mK8Q/ms.jpg","snippet_image_url":"http://s3-media2.fl.yelpcdn.com/photo/Qbmc6Y78t5uRZM57Dp-d-g/ms.jpg","display_phone":"+1-415-606-9349","rating_img_url_large":"http://s3-media4.fl.yelpcdn.com/assets/2/www/img/9f83790ff7f6/ico/stars/v1/stars_large_4_half.png","id":"the-codmother-fish-and-chips-san-francisco","is_closed":false,"location":{"cross_streets":"Jones St & Taylor St","city":"San Francisco","display_address":["496 Beach  St","North Beach/Telegraph Hill","San Francisco, CA 94133","USA"],"geo_accuracy":9.5,"neighborhoods":["North Beach/Telegraph Hill","Fisherman's Wharf"],"postal_code":"94133","country_code":"US","address":["496 Beach  St"],"coordinate":{"latitude":37.8071157,"longitude":-122.4172602},"state_code":"CA"}},{"is_claimed":true,"rating":4.5,"mobile_url":"http://m.yelp.fr/biz/ikes-place-san-francisco?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw","rating_img_url":"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/99493c12711e/ico/stars/v1/stars_4_half.png","review_count":6853,"name":"Ike's Place","rating_img_url_small":"http://s3-media2.fl.yelpcdn.com/assets/2/www/img/a5221e66bc70/ico/stars/v1/stars_small_4_half.png","url":"http://www.yelp.fr/biz/ikes-place-san-francisco?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw","categories":[["Sandwich","sandwiches"]],"menu_date_updated":1451466044,"phone":"+14155536888","snippet_text":"This place is just unbelievable. Incroyable!! \n\nLes sandwichs sont tellement bons, il doit y avoir un secret derrière. Une sauce ou qqchose. Un truc quoi....","image_url":"http://s3-media1.fl.yelpcdn.com/bphoto/omuEMSqU6gvTOEVsmekuuQ/ms.jpg","snippet_image_url":"http://s3-media2.fl.yelpcdn.com/photo/5uUfUyKo_5ajxVC3B9Muug/ms.jpg","display_phone":"+1-415-553-6888","rating_img_url_large":"http://s3-media4.fl.yelpcdn.com/assets/2/www/img/9f83790ff7f6/ico/stars/v1/stars_large_4_half.png","menu_provider":"single_platform","id":"ikes-place-san-francisco","is_closed":false,"location":{"cross_streets":"Dehon St & Sanchez St","city":"San Francisco","display_address":["3489 16th St","Castro","San Francisco, CA 94114","USA"],"geo_accuracy":9.5,"neighborhoods":["Castro"],"postal_code":"94114","country_code":"US","address":["3489 16th St"],"coordinate":{"latitude":37.764449,"longitude":-122.430607},"state_code":"CA"}}]
     */

    private int total;
    /**
     * is_claimed : true
     * rating : 4.5
     * mobile_url : http://m.yelp.fr/biz/hrd-san-francisco-2?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw
     * rating_img_url : http://s3-media2.fl.yelpcdn.com/assets/2/www/img/99493c12711e/ico/stars/v1/stars_4_half.png
     * review_count : 1761
     * name : HRD
     * rating_img_url_small : http://s3-media2.fl.yelpcdn.com/assets/2/www/img/a5221e66bc70/ico/stars/v1/stars_small_4_half.png
     * url : http://www.yelp.fr/biz/hrd-san-francisco-2?utm_campaign=yelp_api&utm_medium=api_v2_search&utm_source=spD-AitIBDBq_iDe40tCtw
     * categories : [["Restaurant Asiatique","asianfusion"]]
     * menu_date_updated : 1441920733
     * phone : +14155432355
     * image_url : http://s3-media4.fl.yelpcdn.com/bphoto/KEwOE6RPiGRm2H0zVHVAgA/ms.jpg
     * location : {"cross_streets":"Taber Aly & Park Ave","city":"San Francisco","display_address":["521A 3rd St","SoMa","San Francisco, CA 94107","USA"],"geo_accuracy":9.5,"neighborhoods":["SoMa"],"postal_code":"94107","country_code":"US","address":["521A 3rd St"],"coordinate":{"latitude":37.7810450986458,"longitude":-122.395337771053},"state_code":"CA"}
     * display_phone : +1-415-543-2355
     * rating_img_url_large : http://s3-media4.fl.yelpcdn.com/assets/2/www/img/9f83790ff7f6/ico/stars/v1/stars_large_4_half.png
     * menu_provider : single_platform
     * id : hrd-san-francisco-2
     * is_closed : false
     */

    private List<Business> businesses;

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Region getRegion() {
        return region;
    }

    public int getTotal() {
        return total;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

}
