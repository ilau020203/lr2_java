package com.company;

import com.company.controller.Preloader;
import com.company.models.Model;
import java.util.Properties;
import com.company.controller.Controller;
import com.company.models.ModelLinkedList;
import com.company.models.interfaces.IModel;
import com.company.models.utils.ErrorController;
import com.company.views.Log;


public class Main {

    public static void main(String[] args) {
        Log.alwaysWrite("Запуск программы");
        ErrorController errorController=new ErrorController();
        try {
            Properties prop = new Properties();
            Preloader PRL = new Preloader("config.properties", prop);
            IModel model;
            if(prop.get("model")=="ArrayList") {
                 model = new Model(-1, prop.getProperty("dataBase"));
            }else if(prop.get("model")=="LinkedList"){
                 model = new ModelLinkedList(-1, prop.getProperty("dataBase"));
            } else{
                 model = new Model(0, prop.getProperty("dataBase"));
            }
            Controller controller = new Controller(model, prop,errorController);
            boolean run = true;


            while(run) {
                run = controller.swichMenu();
            }
            model.save();
        } catch (Exception e) {
            errorController.addError(e);
        }


        Log.alwaysWrite("Конец программы");
    }
}
