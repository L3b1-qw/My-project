package mino;

import com.mycompany.tetris.KeyHandler;
import com.mycompany.tetris.Manager;
import java.awt.*;

public class Mino {
    public Block b[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;
    public int direction  = 1; //create a direction to rotation a Mino
    boolean leftCollision, rightCollision, bottomCollision; // create value to use Collision at play Area
    public  boolean active = true; //Detective a Mino
    public boolean deactivating;
    int deactivateCount = 0;
    
    public void create (Color c) {
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }
    public void setXY (int x, int y) {}
    public void updateXY (int direction) {
        
        RotationCollision();
        // if coolission is not happening can update a rotate 
        // else cant update
        if (leftCollision == false && rightCollision == false &&bottomCollision == false ) {
            this.direction = direction;
            b[0].x = tempB[0].x;
            b[0].y = tempB[0].y;
            b[1].x = tempB[1].x;
            b[1].y = tempB[1].y;
            b[2].x = tempB[2].x;
            b[2].y = tempB[2].y;
            b[3].x = tempB[3].x;
            b[3].y = tempB[3].y;
        }
        
        
    }
    public void getDirection1() {}
    public void getDirection2() {}
    public void getDirection3() {}
    public void getDirection4() {}
    public void MovementCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;
        //reset a boolean
        
        //check static block collision
        checkBlockCollision();
        
        // check frame collision : left wall
        // Scaner a block arrays and check a x value if equal the area_leftX
        // It mino touching a wall so leftCollision is True
        for (int i = 0; i < b.length; i++) {
            if (b[i].x  == Manager.left_x) {
                leftCollision = true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i].x + Block.SIZE == Manager.right_x) {
                rightCollision = true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i].y  + Block.SIZE == Manager.bottom_y) {
                bottomCollision = true;
            }
        }
    }
    public void RotationCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;
        //reset a boolean
        
        //check static block collision
        checkBlockCollision();
        
        // check frame collision : left wall
        // Scaner a block arrays and check a x value if equal the area_leftX
        // It mino touching a wall so leftCollision is True
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].x  < Manager.left_x) {
                leftCollision = true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].x + Block.SIZE > Manager.right_x) {
                rightCollision = true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].y  + Block.SIZE > Manager.bottom_y) {
                bottomCollision = true;
            }
        }
    }
    private void checkBlockCollision() { //Check a block collision when hit another block
        //Scan the staticbloack arrays
        for (int i = 0; i < Manager.staticBlocks.size(); i++) {
            int targetX = Manager.staticBlocks.get(i).x;
            int targetY = Manager.staticBlocks.get(i).y;
            //check down
            for (int j = 0; j < b.length; j++) {
                if(b[j].y + Block.SIZE == targetY && b[j].x == targetX) {
                    bottomCollision = true;
                }
            }
            for (int j = 0; j < b.length; j++) {
                if(b[j].x - Block.SIZE == targetX && b[j].y == targetY) {
                    leftCollision = true;
                }
            }
            for (int j = 0; j < b.length; j++) {
                if(b[j].x + Block.SIZE == targetX && b[j].y == targetY) {
                    rightCollision = true;
                }
            }
            
        }
    }
    public void update () {
        if (deactivating) {
            deactivating();
        }
        
        //Move Mino
        if(KeyHandler.upPressed) {
            switch (direction) { // <- Use to Rotate by switch case when Pressed up
                case 1: getDirection2();break;
                case 2: getDirection3();break;
                case 3: getDirection4();break;
                case 4: getDirection1();break;
            }
            KeyHandler.upPressed = false;
        }
        
        MovementCollision();
        
        if(KeyHandler.downPressed) {
            //check if move down not hit the wall can move
            if (bottomCollision == false ) {
              b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;

                //When monved down reset the autoDropCounter
                autoDropCounter = 0;  
                
            }
            
            KeyHandler.downPressed = false;
        }
        if(KeyHandler.leftPressed) {
            if (leftCollision == false ) {
              b[0].x -= Block.SIZE;
              b[1].x -=Block.SIZE;
              b[2].x -= Block.SIZE;
              b[3].x -= Block.SIZE;  
            }
            
            KeyHandler.leftPressed = false;
        }
        if(KeyHandler.rightPressed) {
            if (rightCollision == false) {
              b[0].x += Block.SIZE;
                b[1].x += Block.SIZE;
                b[2].x += Block.SIZE;
                b[3].x += Block.SIZE;  
            }

            KeyHandler.rightPressed = false;
        }
        
        //this IF bottomCollision is happen so deActivate the mino autoDropCounter will bypass
        if (bottomCollision) {
            deactivating = true;
        }
        else {
           autoDropCounter++; //Increases drop in every frame
           if (autoDropCounter == Manager.dropInterval) {
               b[0].y += Block.SIZE;
               b[1].y += Block.SIZE;
               b[2].y += Block.SIZE;
               b[3].y += Block.SIZE;
               autoDropCounter = 0; 
        }
        
        }
    }
    private void deactivating() {
        deactivateCount++;
        //wait 45 frame
        if (deactivateCount == 45) {
            deactivateCount = 0 ;
            MovementCollision(); //check if the bottom is still hittinh
            
            if(bottomCollision) {
                active = false;
            }
        }
    }
    public void draw (Graphics2D g2) { //Draw a Block Here
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x, b[0].y, Block.SIZE, Block.SIZE);
        g2.fillRect(b[1].x, b[1].y, Block.SIZE, Block.SIZE);
        g2.fillRect(b[2].x, b[2].y, Block.SIZE, Block.SIZE);
        g2.fillRect(b[3].x, b[3].y, Block.SIZE, Block.SIZE);
        
    }
}
