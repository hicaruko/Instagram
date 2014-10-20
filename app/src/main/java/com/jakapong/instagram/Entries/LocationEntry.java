package com.jakapong.instagram.Entries;

import com.jakapong.instagram.MasterEntry;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class LocationEntry extends MasterEntry {

    String id;
    String title;
    String description;
    String location;
    String create_at;
    String update_at;
    String app_id;
    String creator_id;
    String location_type_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public String getLocation_type_id() {
        return location_type_id;
    }

    public void setLocation_type_id(String location_type_id) {
        this.location_type_id = location_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
