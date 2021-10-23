package com.company.models.animal;

import com.company.models.MemberOfForest;

import java.util.ArrayList;

public abstract class Animal extends MemberOfForest {
    protected boolean alive;

    public Animal(String species, int mass) {
        super(species, mass);
        this.alive=true;
    }
    protected abstract boolean processEating(MemberOfForest memberOfForest);

    /**
     * animal find food
     * @param forest forest where find food
     * @return array of object 0 index : MemberOfForest, 1 index : bool
     */

    public MemberOfForest findFood(ArrayList<MemberOfForest> forest) {
        for (MemberOfForest item:forest) {
            if (this.eatable(item)) {
                return  item;
            }
        }
        return  null;
    }
    public  void eating(MemberOfForest memberOfForest){
        if(memberOfForest == null){
            return;
        }
        if(processEating(memberOfForest)) memberOfForest.setMass(this.mass/10);

    }
    /**
     * check on eatable
     * @param memberOfForest who eat
     * @return true if may be eat
     */
    public abstract boolean eatable(MemberOfForest memberOfForest);

    /**
     * function animal is attacked somebody
     * @param mass may be eaten
     * @return true if die
     */
    @Override
    public Boolean setMass(int mass) {
        this.mass-=mass;
        this.alive=false;
        return  true;
    }
}
