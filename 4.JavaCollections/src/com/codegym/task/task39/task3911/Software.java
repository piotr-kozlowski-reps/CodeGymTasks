package com.codegym.task.task39.task3911;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class Software {
    int currentVersion;

    //private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();
    private Map<Integer, String> versionHistoryMap = new ConcurrentSkipListMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {

        if (!versionHistoryMap.containsKey(rollbackVersion)) {
            return false;
        } else {
                currentVersion = rollbackVersion;
                for (Map.Entry<Integer, String> entry : versionHistoryMap.entrySet()) {
                    if (entry.getKey() > rollbackVersion) versionHistoryMap.remove(entry.getKey());
                }
        }

        return true;
    }
}
