package com.jakapong.instagram.Entries;

import com.jakapong.instagram.MasterEntry;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class TrainingMediaEntry extends MasterEntry {

   String id;
   String training_id;
   String title;
   String value;
   String media_type_id;
   String status;
   String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTraining_id() {
        return training_id;
    }

    public void setTraining_id(String training_id) {
        this.training_id = training_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMedia_type_id() {
        return media_type_id;
    }

    public void setMedia_type_id(String media_type_id) {
        this.media_type_id = media_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
