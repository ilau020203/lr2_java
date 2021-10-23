package com.company.models.plant.types;

import com.company.models.plant.Plant;

public  class Tree extends Plant {
    @Override
    public String toString() {
        return "Tree{" +
                "species='" + species + '\'' +
                ", mass=" + mass +
                '}';
    }

    public Tree(String species, int mass) {
        super(species, mass);
    }
}
