package com.jakapong.instagram.EntriesDate;


import com.jakapong.instagram.Entries.MediaTypeEntry;
import com.jakapong.instagram.Entries.Training;
import com.jakapong.instagram.MasterEntry;

import java.util.ArrayList;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class TrainingMediaData extends MasterEntry {

        ArrayList<MediaTypeEntry> data;

        public ArrayList<MediaTypeEntry> getData() {
            return data;
        }

        public void setData(ArrayList<MediaTypeEntry> data) {
            this.data = data;
        }

}

