package com.company.models.plant;

import com.company.models.MemberOfForest;

public abstract class Plant extends MemberOfForest {

    public Plant(String species, int mass) {
        super(species, mass);
    }

    /**
     * function plant is attacked somebody
     * @param mass may be eaten
     * @return true if die
     */
    @Override
    public Boolean attacked(int mass) {
        if(mass>this.mass){
            this.die();
            return true;

        }
        else{
            this.mass-=mass;
            return false;
        }
    }
}
