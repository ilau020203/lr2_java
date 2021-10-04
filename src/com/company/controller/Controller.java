package com.company.controller;

import com.company.models.MemberOfForest;
import com.company.models.animal.Animal;

import java.util.ArrayList;

import static com.company.views.View.view;

public class Controller {
    public static void controller(ArrayList<MemberOfForest> model){
        Animal animal= (Animal) model.get(0);
        ArrayList<Object>out =animal.findFood(model);
        view(animal,(MemberOfForest)out.get(0),(Boolean)out.get(1));
        animal= (Animal) model.get(2);
        out =animal.findFood(model);
        view(animal,(MemberOfForest)out.get(0),(Boolean)out.get(1));
    }
}
