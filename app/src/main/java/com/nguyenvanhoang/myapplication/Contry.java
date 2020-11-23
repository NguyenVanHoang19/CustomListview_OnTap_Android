package com.nguyenvanhoang.myapplication;

public class Contry {
    private String name ;
    private String flag;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Contry(String name, String flag, int population) {
        this.name = name;
        this.flag = flag;
        this.population = population;
    }
    public Contry() {
        super();
    }
    @Override
    public String toString() {
        return this.name + " (Population: )" + this.population + ")";
    }
}
