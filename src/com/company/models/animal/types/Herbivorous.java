package com.company.models.animal.types;

import com.company.models.MemberOfForest;
import com.company.models.animal.Animal;
import com.company.models.plant.Plant;

public  class Herbivorous  extends Animal {
    public Herbivorous(String species, int mass) {
        super(species, mass);
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
}
