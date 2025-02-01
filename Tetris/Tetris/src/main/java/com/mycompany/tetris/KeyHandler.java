package com.mycompany.tetris;
import java.awt.event.*;
public class KeyHandler implements KeyListener{
    public static boolean upPressed, downPressed, leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W)
        {
            upPressed = true;
        }
        else if (code == KeyEvent.VK_S)
        {
            downPressed = true;
        }
        else if (code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        else if (code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
