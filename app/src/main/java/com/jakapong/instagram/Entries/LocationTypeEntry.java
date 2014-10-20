package com.jakapong.instagram.Entries;

import com.jakapong.instagram.MasterEntry;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class LocationTypeEntry extends MasterEntry {

    String id;
    String name;
    String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
