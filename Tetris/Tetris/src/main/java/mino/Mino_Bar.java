/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mino;

import java.awt.Color;

/**
 *
 * @author user
 */
public class Mino_Bar extends Mino{
    public Mino_Bar() {
        create(new Color(102,0,102)); //Call create Method in Mino class We Extends It
                                             //Adn Set Color
    }
    public void setXY(int x,int y) {
        /*
          o o o o
        */
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x - Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y;
    }
    public void getDirection1() {
        /*
            o o o o
        */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x- Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y;
        //Use a tempB to Creat a same thing Block 
        updateXY(1);
    }
    public void getDirection2() {
        /*
            o
            o
            o 
            o
        */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x ;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE; 
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Block.SIZE;
        //Update block rotate
        updateXY(2);
    }
    public void getDirection3() {
        getDirection1(); //because it rotate is a same of Direction1
    }
    public void getDirection4() {
        getDirection2(); //because it rotate is a same of Direction2
    }
}
