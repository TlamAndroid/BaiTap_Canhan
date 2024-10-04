package com.example.pracc3.model;

import java.io.Serializable;

public class Country implements Serializable {
    private final String nation;
    private final String capital;
    private final String population;
    private final String area;
    private final String destiny;
    private final String worldShare;
    private final int flag;

    public Country(int flag, String nation, String capital, String population, String area, String destiny, String worldShare) {
        this.flag = flag;
        this.nation = nation;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.destiny = destiny;
        this.worldShare = worldShare;
    }

    public String getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public String getDestiny() {
        return destiny;
    }

    public int getFlag() {
        return flag;
    }

    public String getNation() {
        return nation;
    }

    public String getPopulation() {
        return population;
    }

    public String getWorldShare() {
        return worldShare;
    }
}