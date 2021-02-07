package com.codegym.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsAdvertisementManager {


    private static StatisticsAdvertisementManager statsAdsManager= new StatisticsAdvertisementManager();       //fields
    private AdvertisementStorage adsStorage = AdvertisementStorage.getInstance();
    public static StatisticsAdvertisementManager getInstance(){
        return statsAdsManager;
    }                                                  //get/set
    private StatisticsAdvertisementManager(){}                                                                //constructor


    //
    public List<Advertisement> getActiveAds() {

        List<Advertisement> allVideosList = new ArrayList<>(adsStorage.list());
        List<Advertisement> activeAdsList = new ArrayList<>();

        for (Advertisement entry : allVideosList){
            if (entry.isActive()) activeAdsList.add(entry);
        }

        return activeAdsList;
    }

    public List<Advertisement> getInactiveAds() {

        List<Advertisement> allVideosList = new ArrayList<>(adsStorage.list());
        List<Advertisement> inactiveAdsList = new ArrayList<>();

        for (Advertisement entry : allVideosList){
            if (!entry.isActive()) inactiveAdsList.add(entry);
        }

        return inactiveAdsList;
    }

}
