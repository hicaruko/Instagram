package com.jakapong.instagram.EntriesDate;

import com.jakapong.instagram.Entries.ProductEntry;
import com.jakapong.instagram.MasterEntry;

import java.util.ArrayList;

/**
 * Created by jakapong on 10/11/14 AD.
 */
public class ProductData extends MasterEntry {

        ArrayList<ProductEntry> data;

        public ArrayList<ProductEntry> getData() {
            return data;
        }

        public void setData(ArrayList<ProductEntry> data) {
            this.data = data;
        }

}

