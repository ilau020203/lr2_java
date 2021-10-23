package com.company.models;

import java.io.Serializable;

public abstract class MemberOfForest implements Serializable {
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



    public  Boolean setMass(int mass) {
        this.mass = mass;
        return  false;
    }
}
