package com.company;

import com.company.controller.Preloader;
import com.company.models.Model;

import java.util.GregorianCalendar;
import java.util.Properties;
import com.company.controller.Controller;
import com.company.models.ModelLinkedList;
import com.company.models.interfaces.IModel;
import com.company.models.utils.ErrorController;
import com.company.views.Log;
import com.company.views.grafic.GraphController;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        Log.alwaysWrite("Запуск программы");
        ErrorController errorController=new ErrorController();
        try {
            Properties prop = new Properties();
            Preloader PRL = new Preloader("config.properties", prop);
            IModel model1,model2;
            model1 = new Model(-1, prop.getProperty("dataBase"));
            model2 = new ModelLinkedList(-1, prop.getProperty("dataBase"));
            Controller controller1 = new Controller(model1, prop,errorController);
            Controller controller2 = new Controller(model2, prop,errorController);
            controller1.autoTest();
            controller2.autoTest();
            JFrame.setDefaultLookAndFeelDecorated(true);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    GraphController.initAndRun(controller1.outInput,controller1.outDelete,controller2.outInput,controller2.outDelete);
                }
            });


            model1.save();
            model2.save();
        } catch (Exception e) {
            errorController.addError(e);
        }


        Log.alwaysWrite("Конец программы");
    }
}
