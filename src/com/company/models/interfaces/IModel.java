package com.company.models.interfaces;

import com.company.models.MemberOfForest;

import java.util.ArrayList;

public interface IModel {
    public ArrayList<MemberOfForest> getForest() ;
    public void standardFill();
    public void save();
    public void addMemberOfForest(MemberOfForest memberOfForest);
    public  void delete(int i);
    public void addRandom(int count );
}
