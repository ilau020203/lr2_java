package com.company;

import com.company.models.MemberOfForest;
import com.company.models.Model;
import com.company.models.animal.Animal;

import com.company.models.animal.types.Herbivorous;
import com.company.models.animal.types.Predator;

import com.company.models.plant.types.Grass;
import com.company.models.plant.types.Tree;

import java.util.ArrayList;

import static com.company.controller.Controller.controller;

public class Main {





    public static void main(String[] args) {
        Model model = new Model(0);
        model.standardFill();
        controller(model.getForest());
    }
}
