package com.jakapong.instagram.EntriesDate;

import com.jakapong.instagram.Entries.Event;
import com.jakapong.instagram.Entries.ProductEntry;
import com.jakapong.instagram.MasterEntry;

import java.util.ArrayList;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class EventData extends MasterEntry {

        ArrayList<Event> data;

        public ArrayList<Event> getData() {
            return data;
        }

        public void setData(ArrayList<Event> data) {
            this.data = data;
        }

}

