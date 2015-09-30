package View;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Edy
 */
public class Hero extends Thread {
      private int HitPoints;
    private int Score;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private final Object valueLock = new Object();
    private boolean pause;
    private boolean flag;
    private String sprite;
    private Image image;
    
    private ArrayList lasers;
    private boolean shot;
    private boolean bossSlayer;
    
    public ArrayList getLasers(){
        return lasers;
        
    } public Rectangle getBounds(){
            return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
        }
    /**
     * class constructor used to draw and set a hero attributes
     * @param classimage the image
     * @param hp hitpoints of the hero
     * @param posx initial position in x
     * @param posy initial position in y
     */
    public Hero(String classimage, int hp, int posx, int posy) {
        bossSlayer=false;
        flag = true;
        pause = false;
        x = posx;
        y = posy;
        HitPoints = hp;
        Score = 0;
        ImageIcon img = new ImageIcon(this.getClass().getResource(classimage));
        image = img.getImage();
        
         lasers = new ArrayList();
        shot = true;
    }
    
    public boolean getPrice(){
        return this.bossSlayer;
    }
    
    /**
    *here we notify when one player kills the boss
    */
    public boolean ClaimPrize(){
        this.bossSlayer=true;
        return bossSlayer;
    }
    
    /**
    *stops player movement when his hp reachs 0
    */
    public void isDead() {
        if (this.HitPoints <= 0) {
            pause=true;
            pause();
        }
    }

    public int getHitPoints() {
        return HitPoints;
    }

    public void setHitPoints(int HitPoints) {
        this.HitPoints = HitPoints;
    }
    
    /**
    * this class reduces player hp by a set amount
    * @param damage reduces hp by this amount
    */
    public void Damaged(int damage) {
        this.HitPoints = HitPoints-damage;
    }

    public int getScore() {
        return Score;
    }
    
    
    

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
   /**
    * increases player's score
    * @param addedScore increases score of player by this amount
    */
    public void getScore(int addedScore) {
        this.Score = this.Score + addedScore;
    }

    

    public void setShot(boolean disparo){
        this.shot=disparo;
    }
    
 public boolean unpause() {
        synchronized (valueLock) {
            pause = false;
            valueLock.notify();  // notifyAll() might be safer...    
        }
        return false;
    }

    public boolean pause() {
        try {
            synchronized (valueLock) {
                while (pause != false) {
                   
                    valueLock.wait();
                }
                // value is now true    
            }
               } catch (InterruptedException x) {
            System.out.println("interrupted while waiting");
        }
        return true;
    }
    
    /**
    * allow the player to move and check if is dead 
    * 
    */
    public void move() {
       isDead();
          x += dx;
           y += dy;  
        
        

       
    }

    public void run() {
        
               move();
            
         
            
        

    }
}
