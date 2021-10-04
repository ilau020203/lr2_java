package com.company.models.animal.types;

import com.company.models.MemberOfForest;
import com.company.models.animal.Animal;
import org.jetbrains.annotations.NotNull;

public  class Predator extends Animal {
    public Predator(String species, int mass) {
        super(species, mass);
    }

    /**
     * check on eatable
     * @param memberOfForest who eat
     * @return true if may be eat
     */
    @Override
    public boolean eatable(@NotNull MemberOfForest memberOfForest) {
        if(memberOfForest.getMass()!=0){
            if(memberOfForest.getMass()<this.mass){
                return memberOfForest instanceof Animal;
            }
            else return false;

        }else return false;
    }
}
