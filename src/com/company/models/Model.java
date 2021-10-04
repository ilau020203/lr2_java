package com.company.models;

import com.company.models.animal.types.Herbivorous;
import com.company.models.animal.types.Predator;
import com.company.models.plant.types.Grass;
import com.company.models.plant.types.Tree;

import java.util.ArrayList;

public class Model {
    ArrayList<MemberOfForest> forest;
    public Model(int n){
        forest=new ArrayList<MemberOfForest>(n);
    }
    public void standardFill(){
        forest.add(new Predator("wolf",100));
        forest.add(new Herbivorous("Koal",5));
        forest.add(new Herbivorous("Koal",5));
        forest.add(new Grass("somePlant",1));
        forest.add(new Tree("someTree", 100000000));
    }

    public ArrayList<MemberOfForest> getForest() {
        return forest;
    }
}
