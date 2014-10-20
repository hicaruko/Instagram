package com.jakapong.instagram;

import android.content.Context;
import android.util.Log;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.jakapong.instagram.EntriesDate.ProductData;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class ProductLoader extends ModelMaster {

    HashMap<String, Object> params = new HashMap<String, Object>();

    private String url;

    public ProductLoader(Context context) {
        super(context, "ProductLoader");
    }

    public void load() {

        run();
    }

    @Override
    public void run() {

        Api api = new Api();
        url = api.getProduct();

        AQuery aq = new AQuery(context);
        aq.ajax(url, String.class, new AjaxCallback<String>() {

            @Override
            public void callback(String url, String data, AjaxStatus status) {

                if (data != null) {
                    data = "{"+"\"data\""+":"+data+"}";
                    Log.e("data",data);


                    ObjectMapper om = new ObjectMapper();
                    try {
                        ProductData m = om.readValue(data, ProductData.class);
                        if (modelStatusListener != null){
                             modelStatusListener.onLoadDataSuccess(key,  m.getData());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (modelStatusListener != null){
                           modelStatusListener.onLoadDataFailed(key
                                    + " : IOException");
                        }
                    }

                } else {
                    if (modelStatusListener != null){
                        modelStatusListener.onLoadDataFailed("ProductLoader"
                                + ": data == null");


                    }
                }
            }
        });

    }
}
