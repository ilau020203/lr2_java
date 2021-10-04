package com.company.models;

public abstract class MemberOfForest {
    protected String species;
    protected int mass;

    public MemberOfForest(String species,int mass){
        this.species=species;
        this.mass=mass;
    }

    public int getMass() {
        return mass;
    }

    public String getSpecies() {
        return species;
    }


    public  void die(){

        this.mass=0;
    }
    public  abstract Boolean attacked(int mass);
}
