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
public class Mino_Square extends Mino{
    public Mino_Square() {
        create(new Color(102,0,102)); //Call create Method in Mino class We Extends It
                                             //Adn Set Color
    }
    public void setXY(int x,int y) {
        /*
          o o 
          o o
        */
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Block.SIZE;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }
    //Have No direction because rotate is a same 
    public void getDirection1() {}
    public void getDirection2() {}
    public void getDirection3() {}
    public void getDirection4() {}
}
