package com.jakapong.instagram.Entries;

import com.jakapong.instagram.EntriesDate.TrainingData;
import com.jakapong.instagram.EntriesDate.TrainingMediaData;

import java.util.ArrayList;

/**
 * Created by mee on 10/20/14 AD.
 */
public class Training extends TrainingEntry {

    ArrayList<TrainingMediaEntry> trainingmedia;

    public ArrayList<TrainingMediaEntry> getTrainingmedia() {
        return trainingmedia;
    }

    public void setTrainingmedia(ArrayList<TrainingMediaEntry> trainingmedia) {
        this.trainingmedia = trainingmedia;
    }

    UserEntry user;


    public UserEntry getUser() {
        return user;
    }

    public void setUser(UserEntry user) {
        this.user = user;
    }
}
