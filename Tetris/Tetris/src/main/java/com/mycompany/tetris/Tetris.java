/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tetris;
import javax.swing.*;
public class Tetris {

    public static void main(String[] args) {
        JFrame window = new JFrame("Tetris Game");
        window.setResizable(false); //cant not move screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when exit program
        
        GamePanel gp = new GamePanel(); 
        window.add(gp);/////////////Make a Size of gamepanel to size of window//////////////
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gp.Lunch();
    }
}
