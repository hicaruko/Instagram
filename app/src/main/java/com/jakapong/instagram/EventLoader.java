package com.jakapong.instagram;

import android.content.Context;
import android.util.Log;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.jakapong.instagram.EntriesDate.EventData;
import com.jakapong.instagram.EntriesDate.ProductData;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class EventLoader extends ModelMaster {

    HashMap<String, Object> params = new HashMap<String, Object>();

    private String url;

    public EventLoader(Context context) {
        super(context, "EventLoader");
    }

    public void load() {

        run();
    }

    @Override
    public void run() {
       // X_REST_API_TOKEN: RThEMDA1OUEtQjJGNi03Nzg3LTU0QzUtNzJBNkVBMDYyMjJE
        Api api = new Api();
        url = api.getEvent();
        AQuery aq = new AQuery(context);
        AjaxCallback<JSONObject> cb = new AjaxCallback<JSONObject>();
        cb.url(url).type(JSONObject.class).weakHandler(this, "JsonCallback");
        //cb.header("Content-Type", "application/json; charset=utf-8");
        cb.header("X_REST_API_TOKEN", "RThEMDA1OUEtQjJGNi03Nzg3LTU0QzUtNzJBNkVBMDYyMjJE");
        aq.ajax(cb);

    }

    public void JsonCallback(String url, JSONObject data, AjaxStatus status) throws JSONException {

        Log.e("url", url);

        Log.e("data", String.valueOf(data));

        if (data != null) {

//            data = "{"+"\"data\""+":"+data+"}";
            Log.e("data", String.valueOf(data));

            String Mydata = data.getString("data");

            JSONObject GetAll = new JSONObject(Mydata);
            String Event = GetAll.getString("event");
            Log.e("Event", String.valueOf(Event));
            Event = "{"+"\"data\""+":"+Event+"}";

            ObjectMapper om = new ObjectMapper();
            try {
                EventData m = om.readValue(Event, EventData.class);
                if (modelStatusListener != null){
                    modelStatusListener.onLoadDataSuccess("EventLoader",  m.getData());
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (modelStatusListener != null){
                    modelStatusListener.onLoadDataFailed("EventLoader"
                            + " : IOException");
                }
            }

        } else {
//            if (modelStatusListener != null){
//                modelStatusListener.onLoadDataFailed("EventLoader"
//                        + ": data == null");
//
//
//            }
        }
    }

}
