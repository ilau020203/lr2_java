package com.company.controller;

import com.company.models.MemberOfForest;
import com.company.models.Model;

import com.company.models.animal.Animal;
import com.company.models.animal.types.Herbivorous;
import com.company.models.animal.types.Predator;
import com.company.models.interfaces.IModel;
import com.company.models.plant.types.Grass;
import com.company.models.plant.types.Tree;
import com.company.models.utils.ErrorController;
import com.company.views.Log;
import com.company.views.View;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;



public class Controller {
    IModel model;
    Properties properties;
    Boolean authorized;
    Scanner scanner;
    ErrorController errorController;
    public ArrayList<Long> outInput;
    public ArrayList<Long> outDelete;

    public Controller(IModel model, Properties properties,ErrorController errorController){
        this.model=model;
        this.errorController=errorController;
        this.properties=properties;
        scanner=new Scanner(System.in);
        authorized=false;
        Log.isRun=properties.get("debug").equals("true");
        outInput=new ArrayList<>();
        outDelete=new ArrayList<>();
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
            case 5:
                randomStart();
                break;
        }
        return  true;
    }
    private void randomStart(){
        for(int i = 10 ; i < 10000000;i*=10){
            System.out.println("asdf");
            Log.alwaysWrite("start "+ i +" length "+properties.get("model")+" add");
            long start = System.currentTimeMillis();
            randomAdd(i);
            Log.alwaysWrite("finish "+ i +" length "+properties.get("model")+" add " + (System.currentTimeMillis()- start) );
            Log.alwaysWrite("start "+ i +" length "+properties.get("model")+" delete");
            start = System.currentTimeMillis();
            randomDelete(i);
            Log.alwaysWrite("finish "+ i +" length "+properties.get("model")+" delete "+ (System.currentTimeMillis()- start));
        }
    }
    public void autoTest(){
        for(int i = 10 ; i < 1000000;i*=10){
            Log.alwaysWrite("start "+ i +" length "+properties.get("model")+" add");
            long start = System.nanoTime();
            randomAdd(i);
            outInput.add(System.nanoTime()- start);
            Log.alwaysWrite("finish "+ i +" length "+properties.get("model")+" add " + (System.nanoTime()- start) );
            Log.alwaysWrite("start "+ i +" length "+properties.get("model")+" delete");
            start = System.nanoTime();
            randomDelete(i);
            outDelete.add(System.nanoTime()- start);
            Log.alwaysWrite("finish "+ i +" length "+properties.get("model")+" delete "+ (System.nanoTime()- start));

        }
    }


    private void randomAdd(int n){
        model.addRandom(n);
    }
    private void randomDelete(int n){
        for(int i = 0; i <n; i++){
            model.delete(0);
        }
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
