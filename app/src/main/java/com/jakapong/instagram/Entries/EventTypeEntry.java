package com.jakapong.instagram.Entries;

import com.jakapong.instagram.MasterEntry;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class EventTypeEntry extends MasterEntry {

   String id;
   String title;
   String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
