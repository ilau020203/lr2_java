package com.company.models.animal.types;

import com.company.models.MemberOfForest;
import com.company.models.animal.Animal;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Predator extends Animal {
    public Predator(String species, int mass) {
        super(species, mass);
    }
    /**
     * eat member of forest
     * @param memberOfForest
     * @return if member of forest die
     */
    @Override
    protected boolean processEating(MemberOfForest memberOfForest) {
        Random random= new Random();
        return random.nextBoolean();
    }


    /**
     * check on eatable
     * @param memberOfForest who eat
     * @return true if may be eat
     */
    @Override
    public boolean eatable(@NotNull MemberOfForest memberOfForest) {
        return (memberOfForest instanceof Animal&&memberOfForest.getMass()!=0&&memberOfForest.getMass()<this.mass);
    }
    protected class other{

    }

    @Override
    public String toString() {
        return "Predator{" +
                "alive=" + alive +
                ", species='" + species + '\'' +
                ", mass=" + mass +
                '}';
    }
}

