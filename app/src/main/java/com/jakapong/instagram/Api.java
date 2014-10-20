package com.jakapong.instagram;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class Api {

    String host = "http://api.popsud.com/";
    String apiGetProduct = "index.php?r=api/getproduct";

    String host2 = "http://api.appsocool.com/";
    String apiGetEvent = "api/event";
    String apiGetTraining = "api/training";
    String apiGetLeaderboard = "api/Leaderboard";
    String apiGetLocation = "api/location";



    public String getProduct(){
        return host + apiGetProduct;
    }

    public String getEvent(){
        return host2 + apiGetEvent;
    }

    public String getTraining(){
        return host2 + apiGetTraining;
    }

    public String getLeaderboard(){
        return host2 + apiGetLeaderboard;
    }

    public String getLocation(){
        return host2 + apiGetLocation;
    }

}
 