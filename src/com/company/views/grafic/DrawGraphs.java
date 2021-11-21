package com.company.views.grafic;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;


/**
 * draw graph as component
 */
public class DrawGraphs extends JComponent {
    private static final Line oX = new Line(50,550,750,550, Color.black);
    private static final Line oY = new Line(50,50,50,550,Color.black);

    public ArrayList<Long> inputOX;
    public ArrayList<Long> inputOY;

    /**
     * overrided paintComponent
     * @param g
     */
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        //coordinates
        draw_coordinates(g2, oX, oY);
        draw(g2,inputOY,inputOX);

    }

    public static void draw_coordinates(Graphics2D g2, Line oX, Line oY){
        //oX
        g2.setColor(oX.color);
        Line2D lineOX = new Line2D.Double(oX.x1, oX.y1, oX.x2, oX.y2);
        g2.draw(lineOX);
        g2.fill(lineOX);
        Line2D lineOX1 = new Line2D.Double(oX.x2-10, oX.y1-10, oX.x2, oX.y2);
        g2.draw(lineOX1);
        g2.fill(lineOX1);
        Line2D lineOX2 = new Line2D.Double(oX.x2-10, oX.y1+10, oX.x2, oX.y2);
        g2.draw(lineOX2);
        g2.fill(lineOX2);
        Font FTitleX = new Font("Arial", Font.PLAIN, 15);
        g2.setFont(FTitleX);
        g2.drawString("Num Elems", oX.x2-50, oX.y2-15);

        //oY
        g2.setColor(oX.color);
        Line2D lineOY = new Line2D.Double(oY.x1, oY.y1, oY.x2, oY.y2);
        g2.draw(lineOY);
        g2.fill(lineOY);
        Line2D lineOY1 = new Line2D.Double(oY.x1-10, oY.y1+10, oY.x2, oY.y1);
        g2.draw(lineOY1);
        g2.fill(lineOY1);
        Line2D lineOY2 = new Line2D.Double(oY.x1+10, oY.y1+10, oY.x2, oY.y1);
        g2.draw(lineOY2);
        g2.fill(lineOY2);
        Font FTitleY = new Font("Arial", Font.PLAIN, 15);
        g2.setFont(FTitleX);
        g2.drawString("Time, nsec", oY.x1+15, oY.y1);



    }

    public static void draw(Graphics2D g2,ArrayList<Long> inputOy,ArrayList<Long> inputOx){

        //oX nums
        for(int i = 0; i < inputOx.size(); i++){
            g2.setColor(Color.BLACK);
            Line2D tempLine = new Line2D.Double(50+ i*100 ,
                    550-5,
                    50+i*100,
                    550+5);
            g2.draw(tempLine);
            g2.fill(tempLine);
            Font FTitle = new Font("Arial", Font.PLAIN, 10);
            g2.setFont(FTitle);
            g2.drawString(inputOx.get(i)+"", 50+i*100, 550+10);
        }
        //oY nums
        for(int i = 0; i < 5; i++){
            g2.setColor(Color.BLACK);
            Line2D tempLine = new Line2D.Double(50-5,
                    550-100*i,
                    50+5,
                    550-100*i);
            g2.draw(tempLine);
            g2.fill(tempLine);
            Font FTitle = new Font("Arial", Font.PLAIN, 10);
            g2.setFont(FTitle);
            g2.drawString(i*inputOy.get(inputOy.size()-3)*5+"", 50-30, 550-100*i);
        }
        //ArrayList
        for(int i = 0; i < inputOy.size()-1; i++){
            g2.setColor(Color.BLUE);
            Line2D tempLine = new Line2D.Double(50+i*100,
                    550-inputOy.get(i)/inputOy.get(inputOy.size()-3)*50,
                    50+(i+1)*100,
                    550-inputOy.get(i+1)/inputOy.get(inputOy.size()-3)*50);
            g2.draw(tempLine);
            g2.fill(tempLine);
        }


    }





}
