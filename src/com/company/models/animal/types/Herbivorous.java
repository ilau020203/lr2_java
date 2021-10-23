package com.company.models.animal.types;

import com.company.models.MemberOfForest;
import com.company.models.animal.Animal;
import com.company.models.plant.Plant;

public  class Herbivorous  extends Animal {
    public Herbivorous(String species, int mass) {
        super(species, mass);
    }

    /**
     * eat member of forest
     * @param memberOfForest
     * @return if member of forest die
  */
    @Override
     protected boolean processEating(MemberOfForest memberOfForest) {
     return true;
     }

     /**
     * check on eatable
     * @param memberOfForest who eat
     * @return true if may be eat
     */
    @Override
    public boolean eatable(MemberOfForest memberOfForest) {
        if(memberOfForest.getMass()!=0){
            return memberOfForest instanceof Plant;
        }else return false;
    }


    @Override
    public String toString() {
        return "Herbivorous{" +
                "alive=" + alive +
                ", species='" + species + '\'' +
                ", mass=" + mass +
                '}';
    }
}
