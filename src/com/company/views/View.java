package com.company.views;

import com.company.models.MemberOfForest;

import java.util.ArrayList;

public class View {

    public static void typeMemberOfForest(){
        System.out.println("1 хишник");
        System.out.println("2 травоядное");
        System.out.println("3 трава");
        System.out.println("4 дерево");

    }

    public  static  void  special(){
        System.out.println("введите название вида");

    }
    public  static  void  massa(){
        System.out.println("введите массу");
    }
    public static void printAttacked(MemberOfForest eaten, MemberOfForest whoWasEaten){
        System.out.println(eaten.getSpecies()+" eat "+whoWasEaten.getSpecies());
    }
    public static  void  login(){
        System.out.println("Ведите логин");
    }
    public  static  void password(){
        System.out.println("Ведите пароль");
    }
    public  static  void badPassword(){
        System.out.println("неправильный пароль");
    }
    public static  void  badLogin(){
        System.out.println("неправильный огин");
    }
    public static void menu(boolean root){
        System.out.println("1 добавить кого-то в лес");
        System.out.println("2 начать охоту в лесу ");
        System.out.println("3 печать всех членов лета");
        System.out.println("");
        if(root){
            System.out.println("4 запустить автотест");
        }
        System.out.println("5 random test");
        System.out.println("0 выход");

    }
    public static void printForest(ArrayList<MemberOfForest>forest){
        for (MemberOfForest item:forest) {
            System.out.println(item.toString());
        }
    }
}

