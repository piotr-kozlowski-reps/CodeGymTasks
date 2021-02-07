package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.ad.Advertisement;
import com.codegym.task.task27.task2712.ad.StatisticsAdvertisementManager;
import com.codegym.task.task27.task2712.statistics.StatisticsManager;

import java.util.*;

public class ManagerTablet {

    public void printAdRevenue() {
        StatisticsManager statisticsManager = StatisticsManager.getInstance();
        Map<String, Long> profitMap = statisticsManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookUtilization() {
        StatisticsManager statisticsManager = StatisticsManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticsManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            System.out.println(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName)+59)/60 ) + " min");
            }

            System.out.println();
        }
    }


    public void printActiveVideoSet() {
        List<Advertisement> activeAdsList = StatisticsAdvertisementManager.getInstance().getActiveAds();

        Collections.sort(activeAdsList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        for (Advertisement ad : activeAdsList){
            System.out.println(ad.getName() + " - " + ad.getImpressionsRemaining());
        }

    }

    public void printArchivedVideoSet() {

        List<Advertisement> inactiveAdsList = StatisticsAdvertisementManager.getInstance().getInactiveAds();

        Collections.sort(inactiveAdsList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        for (Advertisement ad : inactiveAdsList){
            System.out.println(ad.getName());
        }

    }

}
