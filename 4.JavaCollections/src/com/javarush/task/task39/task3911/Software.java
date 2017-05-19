package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

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

        } else if (getCurrentVersion() == rollbackVersion) {

            return false;

        } else {
            Iterator<Map.Entry<Integer, String>> it = versionHistoryMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String> map = it.next();
                if (map.getKey() > rollbackVersion) {
                    it.remove();
                }
            }
            currentVersion = rollbackVersion;
            return true;
        }
    }
}
