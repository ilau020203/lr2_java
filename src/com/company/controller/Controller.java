package com.company.controller;

import com.company.models.MemberOfForest;
import com.company.models.Model;

import com.company.models.animal.Animal;
import com.company.models.animal.types.Herbivorous;
import com.company.models.animal.types.Predator;
import com.company.models.plant.types.Grass;
import com.company.models.plant.types.Tree;
import com.company.views.Log;
import com.company.views.View;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;



public class Controller {
    Model model;
    Properties properties;
    Boolean authorized;
    Scanner scanner;
    public Controller(Model model, Properties properties){
        this.model=model;
        this.properties=properties;
        scanner=new Scanner(System.in);
        authorized=false;
        Log.isRun=properties.get("debug").equals("true");
    }
    public boolean swichMenu()  {
        if(!authorized){
            View.login();
            if(scanner.nextLine().equals(properties.get("login"))){
                View.password();
                if (scanner.nextLine().equals(properties.get("password"))){
                    authorized=true;
                    Log.tryWrite("user is authorized");
                }
                else{
                    View.badPassword();
                    Log.tryWrite("bad password");
                }
            }else{
                View.badLogin();
                Log.tryWrite("bad login");
            }
            return true;
        }
        View.menu(properties.get("root").equals("true"));

        int key =Integer.parseInt(scanner.nextLine());
        switch (key) {
            case 0:
                return false;
            case 1:
                addMemberOfForest();
                break;
            case 2:
                findFood();
                break;
            case 3:
                View.printForest(model.getForest());
                break;
            case 4:
                Log.tryWrite("начат автотест");
                Model testModel = (new Model(0,""));
                testModel.standardFill();
                test(testModel.getForest());
                Log.tryWrite("конец автотеста");

                break;
        }
        return  true;
    }
    private void addMemberOfForest(){
        View.typeMemberOfForest();
        int key =Integer.parseInt(scanner.nextLine());
        View.special();
        String special = scanner.nextLine();
        View.massa();
        int massa = Integer.parseInt(scanner.nextLine());
        switch (key) {

            case 1:
                model.addMemberOfForest(new Predator(special,massa));
                break;
            case 2:
                model.addMemberOfForest(new Herbivorous(special,massa));
                break;
            case 3:
                model.addMemberOfForest(new Tree(special,massa));
                break;
            case 4:
                model.addMemberOfForest(new Grass(special,massa));
                break;
        }
    }
    private void findFood(){

    }

    public static void test(ArrayList<MemberOfForest> model){
        try {
            Animal animal = (Animal) model.get(0);
            MemberOfForest memberOfForest = animal.findFood(model);
            View.printAttacked(animal, memberOfForest);
            animal = (Animal) model.get(2);
            memberOfForest = animal.findFood(model);
            View.printAttacked(animal, memberOfForest);
            Log.tryWrite("автотест выполнен");
        }catch (Exception e) {
            System.err.println("Ошибка - "+e.getMessage());
            Log.alwaysWrite("Ошибка - "+e.getMessage());

        }
    }
}
