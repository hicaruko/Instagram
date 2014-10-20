package com.jakapong.instagram.EntriesDate;

import com.jakapong.instagram.Entries.LeaderBoard;
import com.jakapong.instagram.MasterEntry;

import java.util.ArrayList;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class LeaderboardData extends MasterEntry {

        ArrayList<LeaderBoard> data;

        public ArrayList<LeaderBoard> getData() {
            return data;
        }

        public void setData(ArrayList<LeaderBoard> data) {
            this.data = data;
        }

}

