package simulador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Labels {
    public  int inConcert;
    public int inBathroom;
    public int inDrinks;
    public int inSouvenirs;
    public int staffRoom;

    public int concertQueue;
    public int BathroomQueue;
    public int DrinksQueue;
    public int SouvenirQueue;
    public int Singing;
 
    
    
    
    private Drawn indicators;
  
    public Labels(Drawn palette){
    this.indicators=palette;
  
    }

    Labels() {
          init();
    }
    
    public  void init() {
        inConcert = 0;
        inBathroom = 0;
        inDrinks = 0;
        inSouvenirs = 0;
        staffRoom = 0;

        concertQueue = 0;
        BathroomQueue = 0;
        DrinksQueue = 0;
        SouvenirQueue = 0;
        Singing = 0;
    }
    
/**
 * 
 * @param g is a variable of the Graphics2D package, is used to paint the health bar
 * @param with is the size of the health bar.
 * @param x position in x axis to create the health bar.
 * @param y position in y axis to create the health bar.
 */    
 
    /**
     * 
     * @param g variable of the Graphics2D package.
     * @param score is the puntuation of the player.
     * @param x position in x axis to display the score.
     * @param y the position in y axis to display the score.
     */
    public void drawNumber(Graphics2D g,int score,int x, int y){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        g.drawString(String.valueOf(score), x, y);
    }
    
     public void separators(Graphics2D g,int score,int x, int y){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString(":", x, y);
    }
     
     public void drawLetters(Graphics2D g,int size,String legend,int x, int y){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, size));
        g.drawString(legend, x, y);
    }
    
        

    
}