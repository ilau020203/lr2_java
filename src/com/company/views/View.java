package com.company.views;

import com.company.models.MemberOfForest;

public class View {

    public static void view(MemberOfForest eaten, MemberOfForest whoWasEaten, Boolean die){
        System.out.println(eaten.getSpecies()+" eat "+whoWasEaten.getSpecies());
        if(die){
            System.out.println(whoWasEaten.getSpecies()+" die");
        }
        else{
            System.out.println(whoWasEaten.getSpecies()+" live");
        }
    }
}
