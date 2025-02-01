package com.mycompany.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 1280; //Set W
    public static final int HEIGHT = 720; //Set H
    Thread GameThread; //Thread class for Run GameLoop*
    Manager m;
    final int FPS = 60;
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(0, 0, 0)); //Set Color 
        this.setLayout(null);
        //Implement KeyListener
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true); //Get the Key Input To KeyHandler Class
        
        
        m = new Manager();
    }
    public void Lunch() {
        GameThread = new Thread(this);
        GameThread.start(); //GameThread.start() use for call a run Method( public void run() )
    }

    @Override
    /*
    ALL THE GAME LOOP WANT "UPDATE" & "DRAW"
    this "Update" Mean use for update basicly x and y for move or int
    this "Draw" Mean Draw Object or UI TEXT
    */
    public void run() {
        double drawnInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime =  System.nanoTime();
        long currentTime;
        while(GameThread != null) {
            //Update And Repaint use for walk(loop) the game
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawnInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                }
            }
    }
    private void update() { //call update METHOD in manager class
        m.update();
    }
    public void paint(Graphics g) { //Convert Graphics to Graphics2D
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        m.drwn(g2); //call dram method in manager class
    }
}
