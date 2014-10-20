package com.jakapong.instagram.EntriesDate;


import com.jakapong.instagram.Entries.Location;
import com.jakapong.instagram.Entries.Training;
import com.jakapong.instagram.MasterEntry;

import java.util.ArrayList;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class LocationData extends MasterEntry {

        ArrayList<Location> data;

        public ArrayList<Location> getData() {
            return data;
        }

        public void setData(ArrayList<Location> data) {
            this.data = data;
        }

}

