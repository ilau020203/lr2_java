package com.company.views.grafic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphController {
    private static JFrame[] graphs = new JFrame[6];
    public static DrawGraphs[] dg = new DrawGraphs[graphs.length];
    public static final ArrayList<Long> sizes = new ArrayList<Long>();

    public static void initAndRun(ArrayList<Long> addArrayList,ArrayList<Long> removeArrayList,ArrayList<Long> addLinkedList, ArrayList<Long> removeLinkedList){

        sizes.add(new Long(10));
        sizes.add(new Long(100));
        sizes.add(new Long(1000));
        sizes.add(new Long(10000));
        sizes.add(new Long(100000));

        for(int i = 0; i < graphs.length; i++){
            graphs[i] = new JFrame();

            graphs[i].setSize(new Dimension(800,600));
            switch (i){
                case 0:
                    graphs[i].setTitle("add ArrayList");
                    dg[i] = new DrawGraphs();
                    dg[i].inputOY=addArrayList;
                    dg[i].inputOX=sizes;

                    break;
                case 1:
                    graphs[i].setTitle("remove  ArrayList");
                    dg[i] = new DrawGraphs();
                    dg[i].inputOY=removeArrayList;
                    dg[i].inputOX=sizes;
                    break;
                case 2:
                    graphs[i].setTitle("add LinkedList");
                    dg[i] = new DrawGraphs();
                    dg[i].inputOY=addLinkedList;
                    dg[i].inputOX=sizes;
                    break;
                case 3:
                    graphs[i].setTitle("remove LinkedList");
                    dg[i] = new DrawGraphs();
                    dg[i].inputOY=removeLinkedList;
                    dg[i].inputOX=sizes;
                    break;

            }



            graphs[i].add(dg[i]);

            graphs[i].setVisible(true);


        }
    }

}
