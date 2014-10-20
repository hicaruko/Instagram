package com.jakapong.instagram;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class Api {

    String host = "http://api.popsud.com/";
    String apiGetProduct = "index.php?r=api/getproduct";

    String host2 = "http://api.appsocool.com/";
    String apiGetEvent = "api/event";


    public String getProduct(){
        return host + apiGetProduct;
    }

    public String getEvent(){
        return host2 + apiGetEvent;
    }


}
 