import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import javax.swing.ImageIcon;

public class Main {
   public Render s;
   public PlayerShip player= new PlayerShip();
   private Image bg;
   private Image txt1;
   private Image txt2;
   private Image txt3;
   private Image txt4;
   private Ani a;
   private int moveSpeed = 5;
   public boolean waitingForKeyPress = false;
   public boolean upPressed = false;
   public boolean downPressed = false;
   public boolean rightPressed = false;
   public boolean leftPressed = false;
   public boolean islooping = true;
   private static final DisplayMode modes1[] = {
      new DisplayMode(800,600,32,0),
      new DisplayMode(800,600,24,0),
      new DisplayMode(800,600,16,0),
      new DisplayMode(640,480,32,0),
      new DisplayMode(640,480,24,0),
      new DisplayMode(640,480,16,0),
      
   };;
   public void run(DisplayMode dm2){

      s = new Render();
      DisplayMode dm = s.find1stcompatmode(modes1);
      s.setFullScreen(dm);
      loadmenu();
      player.loadplayer();
      movieLoop();
      while(islooping){
         movieLoop();
         player.setHorizontalMovement(0);
         if ((leftPressed) && (!rightPressed)) {
            player.setHorizontalMovement(-moveSpeed);
         } else if ((rightPressed) && (!leftPressed)) {
            player.setHorizontalMovement(moveSpeed);
         }
      }
         s.restoreScreen();
   }
   public void movieLoop(){
      long startTime = System.currentTimeMillis();
      long cumTime = startTime;
      while(cumTime - startTime<2000){
         long timePassed = System.currentTimeMillis() - cumTime;
         cumTime = System.currentTimeMillis();
         player.f.update(timePassed);
         a.update(timePassed);
         Graphics2D g = s.getGraphics();
         draw(g);
         g.dispose();
         s.update();
         try{
            Thread.sleep(10);
         }catch(Exception ex){}
         }
      }
   public void loadmenu(){
      bg = new ImageIcon("img/equipo1.png").getImage();
      txt1 = new ImageIcon("img/equipo2.png").getImage();
      txt2 = new ImageIcon("img/equipo1.png").getImage();
      txt3 = new ImageIcon("img/equipo2.png").getImage();
      txt4 = new ImageIcon("img/equipo1.png").getImage();;
      a = new Ani();
      a.addScene(txt1, 80);
      a.addScene(txt2, 80);
      a.addScene(txt3, 80);
      a.addScene(txt4, 80);
   }
   
   public void draw(Graphics2D g){
      g.drawImage(bg,0,0, null);
      g.drawImage(player.f.getImage(), player.getX() ,player.getY(), null);
      g.drawImage(a.getImage(), 400, 150, null);
   }
 class KeyInputHandler extends KeyAdapter {
   
   /**
    * Notification from AWT that a key has been pressed. Note that
    * a key being pressed is equal to being pushed down but *NOT*
    * released. Thats where keyTyped() comes in.
    *
    * @param e The details of the key that was pressed 
    */
   public void keyPressed(KeyEvent e) {
      // if we're waiting for an "any key" typed then we don't 
      // want to do anything with just a "press"
      if (waitingForKeyPress) {
         return;
      }
      if (e.getKeyCode() == KeyEvent.VK_UP) {
         upPressed = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         downPressed = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         leftPressed = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         rightPressed = true;
      }
   } 
   
   /**
    * Notification from AWT that a key has been released.
    *
    * @param e The details of the key that was released 
    */
   public void keyReleased(KeyEvent e) {
      // if we're waiting for an "any key" typed then we don't 
      // want to do anything with just a "released"
      if (waitingForKeyPress) {
         return;
      }
      if (e.getKeyCode() == KeyEvent.VK_UP) {
         upPressed = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         downPressed = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         leftPressed = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         rightPressed = false;
      }
   }
   }
public static void main(String argv[]) {
   DisplayMode dm = new DisplayMode(800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
   Main game = new Main();
   game.run(dm);
}
}