package com.jakapong.instagram.Entries;

import java.util.ArrayList;

/**
 * Created by mee on 10/20/14 AD.
 */
public class LeaderBoard extends LeaderBoardEntry {


    ArrayList<UserEntry> user;

    public ArrayList<UserEntry> getUser() {
        return user;
    }

    public void setUser(ArrayList<UserEntry> user) {
        this.user = user;
    }
}
