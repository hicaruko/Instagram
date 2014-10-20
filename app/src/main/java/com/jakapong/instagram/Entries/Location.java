package com.jakapong.instagram.Entries;

/**
 * Created by mee on 10/20/14 AD.
 */
public class Location extends LocationEntry {


    LocationTypeEntry locationtype;
    UserEntry user;

    public LocationTypeEntry getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(LocationTypeEntry locationtype) {
        this.locationtype = locationtype;
    }

    public UserEntry getUser() {
        return user;
    }

    public void setUser(UserEntry user) {
        this.user = user;
    }
}
