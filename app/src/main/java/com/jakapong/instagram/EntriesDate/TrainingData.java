package com.jakapong.instagram.EntriesDate;


import com.jakapong.instagram.Entries.Training;
import com.jakapong.instagram.MasterEntry;

import java.util.ArrayList;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class TrainingData extends MasterEntry {

        ArrayList<Training> data;

        public ArrayList<Training> getData() {
            return data;
        }

        public void setData(ArrayList<Training> data) {
            this.data = data;
        }

}

