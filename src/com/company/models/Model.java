package com.company.models;

import com.company.models.animal.types.Herbivorous;
import com.company.models.animal.types.Predator;
import com.company.models.plant.types.Grass;
import com.company.models.plant.types.Tree;
import com.company.views.Log;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Model {
    ArrayList<MemberOfForest> forest;

    String path;
    public Model(int n,String path  )  {

        this.path=path;
        if(n==-1){
            forest= new ArrayList<MemberOfForest>();
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
            {
                forest=((ArrayList<MemberOfForest>)ois.readObject());
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                Log.alwaysWrite(ex.getMessage());
            }
            Log.tryWrite("db is loaded");
        }else {
            forest = new ArrayList<MemberOfForest>(n);
        }
    }
    public void addMemberOfForest(MemberOfForest memberOfForest){
        forest.add(memberOfForest);
    }
    public void save(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(forest);
            System.out.println("File has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            Log.alwaysWrite(ex.getMessage());
        }
        Log.tryWrite("save data base");
    }
    public void standardFill()  {
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

