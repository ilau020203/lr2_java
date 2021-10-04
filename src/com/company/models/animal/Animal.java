package com.company.models.animal;

import com.company.models.MemberOfForest;

import java.util.ArrayList;

public abstract class Animal extends MemberOfForest {
    protected boolean alive;

    public Animal(String species, int mass) {
        super(species, mass);
        this.alive=true;
    }

    /**
     * animal find food
     * @param forest forest where find food
     * @return array of object 0 index : MemberOfForest, 1 index : bool
     */

    public ArrayList<Object> findFood(ArrayList<MemberOfForest> forest) {
        for (MemberOfForest item:forest) {
            if(this.eatable(item))
            {
                ArrayList<Object> out =new ArrayList<Object>(2);
                out.add(0,item);
                out.add(1,item.attacked(this.mass/10));
                return out;
            }
        }
        return new ArrayList<>(2);
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
    public Boolean attacked(int mass) {
        this.die();
        this.alive=false;
        return  true;
    }
}
