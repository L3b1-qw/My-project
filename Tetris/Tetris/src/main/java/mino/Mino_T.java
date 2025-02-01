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
public class Mino_T extends Mino{
    public Mino_T() {
        create(new Color(255,153,255)); //Call create Method in Mino class We Extends It
                                             //Adn Set Color
    }
    public void setXY(int x,int y) {
        /*
                o
              o o o
        */
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x - Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y;
    }
    public void getDirection1() {
        /*
                o
              o o o
        */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y;
        //Use a tempB to Creat a same thing Block 
        updateXY(1);
    }
    public void getDirection2() {
        /*
            o
            o o
            o
        */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE; 
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Block.SIZE;
        //Update block rotate
        updateXY(2);
    }
    public void getDirection3() {
        /*
            o o o
              o
        */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y; 
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y;
        updateXY(3);
    }
    public void getDirection4() {
        /*      
            o
          o o
            o
        */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE; 
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y - Block.SIZE;
        updateXY(4);
    }
}
