package com.jakapong.instagram.Entries;

/**
 * Created by mee on 10/20/14 AD.
 */
public class EventFilter extends EventEntry {

    ProvinceEntry province;
    GeographyEntry geography;
    EventTypeEntry eventtype;
    UserEntry user;

    public UserEntry getUser() {
        return user;
    }

    public void setUser(UserEntry user) {
        this.user = user;
    }

    public ProvinceEntry getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntry province) {
        this.province = province;
    }

    public GeographyEntry getGeography() {
        return geography;
    }

    public void setGeography(GeographyEntry geography) {
        this.geography = geography;
    }

    public EventTypeEntry getEventtype() {
        return eventtype;
    }

    public void setEventtype(EventTypeEntry eventtype) {
        this.eventtype = eventtype;
    }


}
