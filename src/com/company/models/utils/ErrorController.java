package com.company.models.utils;

import com.company.views.Log;

import java.util.ArrayList;

public class ErrorController {
    ArrayList<Exception> exceptions;
    public ErrorController(){
        exceptions=new ArrayList<Exception>();
    }
    public void addError(Exception exception){
        Log.alwaysWrite(exception.getMessage());
        exceptions.add(exception);
    }
    public int getCountException(){
        return  exceptions.size();
    }
    public ArrayList<Exception> getExceptions(){
        return exceptions;
    }

}
