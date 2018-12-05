package com.bigfm.com.BigFmDataManagement.hazelcast;

public enum CacheMap {



   BEAM_DETAILS("beam details");

    private String mapName;

    CacheMap(String mapName) {

        this.mapName = mapName;
    }

    public String getMapName() {

        return mapName;
    }
}
