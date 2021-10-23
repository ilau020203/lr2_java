package com.company.models.plant.types;

import com.company.models.plant.Plant;

public  class  Grass extends Plant {
    @Override
    public String toString() {
        return "Grass{" +
                "species='" + species + '\'' +
                ", mass=" + mass +
                '}';
    }

    public Grass(String species, int mass) {
        super(species, mass);
    }
}
