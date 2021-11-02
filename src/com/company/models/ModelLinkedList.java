package com.company.models;

import com.company.models.animal.types.Herbivorous;
import com.company.models.animal.types.Predator;
import com.company.models.interfaces.IModel;
import com.company.models.plant.types.Grass;
import com.company.models.plant.types.Tree;
import com.company.models.utils.RandomString;
import com.company.views.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ModelLinkedList implements IModel {
    LinkedList<MemberOfForest> forest;

    String path;
    public ModelLinkedList(int n,String path  )  {

        this.path=path;
        if(n==-1){
            forest= new LinkedList<MemberOfForest>();
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
            {
                forest=((LinkedList<MemberOfForest>)ois.readObject());
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                Log.alwaysWrite(ex.getMessage());
            }
            Log.tryWrite("db is loaded");
        }else {
            forest = new LinkedList<MemberOfForest>();
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
    public  void delete(int i){
        forest.remove(i);
    }
    public void addRandom(int count ){
        RandomString randomString =(new RandomString());

        for (int i=0;i<count;i++ ){
            String special=randomString.nextString();
            int key =1+ (new Random()).nextInt(3);
            int mass = 1+  (new Random()).nextInt(10000);
            switch (key) {
                case 1:
                    forest.add(new Predator(special,mass));
                    break;
                case 2:
                    forest.add((new Herbivorous(special,mass)));
                    break;
                case 3:
                    forest.add((new Tree(special,mass)));
                    break;
                case 4:
                    forest.add((new Grass(special,mass)));
                    break;
            }

        }
    }
    public ArrayList<MemberOfForest> getForest() {
        return new ArrayList<MemberOfForest>(forest);
    }
}
