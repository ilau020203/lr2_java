package com.company;

import com.company.controller.Preloader;
import com.company.models.Model;
import java.util.Properties;
import  com.company.controller.Controller;
import com.company.views.Log;


public class Main {

    public static void main(String[] args) {
        Log.alwaysWrite("Запуск программы");
        try {
            Properties prop = new Properties();
            Preloader PRL = new Preloader("config.properties", prop);
            Model model = new Model(-1,prop.getProperty("dataBase"));
            Controller controller = new Controller(model, prop);
            boolean run = true;


            while(run) {
                run = controller.swichMenu();
            }
            model.save();
        } catch (Exception e) {
            System.err.println("Ошибка - "+e.getMessage());
            Log.alwaysWrite("Ошибка - "+e.getMessage());

        }


        Log.alwaysWrite("Конец программы");
    }
}
