import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayerShip{
   public Ani f;
   Image sf1;
   Image sf2;
   Image sf3;
   int x=400;
   int y=150;
   int dy;
   int dx;
   public PlayerShip() {
   }
   public void setHorizontalMovement(int dx) {
      this.dx= dx;
   }
   public void setVerticalMovement(int dy) {
      this.dy= dy;
   }
   public double getHorizontalMovement() {
      return dx;
   }
   public double getVerticalMovement() {
      return dy;
   }
   public void move(long delta) {
      if ((dx < 0) && (x < 10)) {
         return;
      }
      if ((dx > 0) && (x > 780)) {
         return;
      }
      x += dx;
      y += dy;
   }
   public int getX() {
      return (int) x;
   }
   public int getY() {
      return (int) y;
   }
   public void loadplayer(){
      sf1 = new ImageIcon("C:\\Users\\Nima\\workspace\\Compsci Game\\Sprites\\Playership\\stable fight\\f1playerstable.png").getImage();
      sf2 = new ImageIcon("C:\\Users\\Nima\\workspace\\Compsci Game\\Sprites\\Playership\\stable fight\\f2playerstable.png").getImage();
      sf3 = new ImageIcon("C:\\Users\\Nima\\workspace\\Compsci Game\\Sprites\\Playership\\stable fight\\f3playerstable.png").getImage();
      f = new Ani();
      f.addScene(sf1, 25);
      f.addScene(sf2, 25);
      f.addScene(sf3, 25);
   }
}