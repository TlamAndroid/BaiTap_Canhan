package com.example.pracc3.model;

public class Country {
    private final String nation, capital, population, arie, destiny, world_share;
    private final int flag;

    public int getFlag() {
        return flag;
    }

    public Country(int flag, String nation,String capital, String population, String arie,  String destiny, String world_share) {
        this.flag = flag;
        this.arie = arie;
        this.capital = capital;
        this.destiny = destiny;

        this.nation = nation;
        this.population = population;
        this.world_share = world_share;
    }

    public String getArie() {
        return arie;
    }

    public String getCapital() {
        return capital;
    }

    public String getDestiny() {
        return destiny;
    }

    public String getNation() {
        return nation;
    }

    public String getPopulation() {
        return population;
    }

    public String getWorld_share() {
        return world_share;
    }
}
