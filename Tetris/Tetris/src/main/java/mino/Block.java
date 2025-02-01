package mino;
import java.awt.*;

public class Block extends Rectangle{
    public int x,y;
    public static final int SIZE =30; //SET a Block of mino to 30*30 black 
    public Color c;
    
    public Block(Color c) { //Method for set color of mino
        this.c = c; 
    }
    public void draw (Graphics2D g2) { //draw a block with a color 
        g2.setColor(c);
        g2.fillRect(x, y, SIZE, SIZE);
    }
}


