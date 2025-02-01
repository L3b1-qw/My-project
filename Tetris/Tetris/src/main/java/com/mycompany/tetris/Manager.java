package com.mycompany.tetris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import mino.Block;
import mino.Mino;
import mino.Mino_Bar;
import mino.Mino_L1;
import mino.Mino_L2;
import mino.Mino_Square;
import mino.Mino_T;
import mino.Mino_Z1;
import mino.Mino_Z2;

public class Manager {
    //create AREA to play
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;
    
    //Mino Use for Ez to call child Method 
    Mino Currentmino;
    final int MINO_START_X;
    final int MINO_START_Y;
    
    Mino nextMino;
    final int NEXTMINO_X;
    final int NEXTMINO_Y;
    public static ArrayList<Block> staticBlocks = new ArrayList(); // put the inactive mino in staticBlocks
    
    //Drop
    public static int dropInterval = 60; //Mean Drop a block in very 60 frame or 1 Sec.
    
    //EndGame
    boolean gameOver; 
    
    public Manager() {
        left_x = (GamePanel.WIDTH/2) - (WIDTH/2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y+HEIGHT;
        
        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE;
        
        //setNEXTMINO_X and NEXTMINO_Y
        NEXTMINO_X = right_x + 175;
        NEXTMINO_Y = top_y +500;
                
        //Set the Starting Mino
        Currentmino = pickMino();
        Currentmino.setXY(MINO_START_X, MINO_START_Y);
        //create Show next mino
        nextMino = pickMino();
        nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
    }
    
    private Mino pickMino() {
        //randon Mino
        Mino mino = null;
        int i = new Random().nextInt(7);
        switch(i) {
            case 0 : mino = new Mino_L1();break;
            case 1 : mino = new Mino_L2();break;
            case 2 : mino = new Mino_Square();break;
            case 3 : mino = new Mino_Bar();break;
            case 4 : mino = new Mino_T();break;
            case 5 : mino = new Mino_Z1();break;
            case 6 : mino = new Mino_Z2();break;
        }
        return mino;
    }
    
    public void update() {
        //check if the currentMino is update
        if (Currentmino.active == false ) {
            //if the mino is not active so put the staticBlocks
            staticBlocks.add(Currentmino.b[0]);
            staticBlocks.add(Currentmino.b[1]);
            staticBlocks.add(Currentmino.b[2]);
            staticBlocks.add(Currentmino.b[3]);
            
            //Check if the Game Over
            if(Currentmino.b[0].x == MINO_START_X && Currentmino.b[0].y == MINO_START_Y) {
                gameOver = true;
            }
            
            Currentmino.deactivating = false;
            
            //repleate a current with the nextMINO
            Currentmino = nextMino;
            Currentmino.setXY(MINO_START_X,MINO_START_Y);
            nextMino = pickMino();
            nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
            
            //check when mino become a inactive check if line(s) can be delete
            checkDelete();
        }
        else {
           Currentmino.update(); 
           checkDelete();
        }
    }
    
    public void checkDelete() {
        //count a number the block in the line(rows)
        //if count to 12 can delete because have 12 block 
        int x =left_x;
        int y =top_y;
        int blockCount = 0;
        while (x < right_x && y < bottom_y) {
            for (int i = 0; i < staticBlocks.size(); i++) {
                if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {
                    //increase the  count if there  is a static block
                    blockCount++;
                }
            }
            
            x += Block.SIZE;
            
            if (x == right_x) {
                
                //if the blockcount hits 12 : mean all the current y(rows) is all filled with block
                //So delete it
                if (blockCount == 12 ){
                    for (int i = staticBlocks.size()-1; i > -1; i--) {
                        //remove all block in the curren y line
                        if (staticBlocks.get(i).y == y) {
                            staticBlocks.remove(i);
                        }
                    }
                    //line has been delete so need  to silde down black
                    for (int i = 0; i < staticBlocks.size(); i++) {
                        //if block is above the current y ,move down
                        if (staticBlocks.get(i).y < y) {
                            staticBlocks.get(i).y += Block.SIZE;
                        }
                    }
                    
                }
                
                blockCount = 0;
                x = left_x;
                y += Block.SIZE;   
            }      
        } 
    } 
    
    public void drwn(Graphics2D g2) {
        //Draw main play Area
        g2.setColor(Color.pink);
        g2.setStroke(new BasicStroke(4f)); //BasicStroke = line : It mean set width of LINE
        g2.drawRect(left_x-4, top_y-4, WIDTH+8, HEIGHT+8); //Draw Rectangle
        
        //Draw show Mino
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 200, 200);
        
        //draw a next MINO
        nextMino.draw(g2);
        
        //draw a static block
        for (int i = 0; i < staticBlocks.size(); i++) {
            staticBlocks.get(i).draw(g2); //scan the arrays and draw it 1 by 1
        }
        
        //Draw Mino in class Mino
        if (Currentmino != null) {
            Currentmino.draw(g2);
        }
        g2.setColor(Color.red);
        g2.setFont(g2.getFont().deriveFont(50f));
        if(gameOver) {
                x = left_x +25 ;
                y = top_y + 320;
                g2.drawString("GAME OVER", x, y);
            }
    }
    
}
