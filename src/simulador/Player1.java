package simulador;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player1 extends Hero {
    
    private ArrayList lasers;
    private boolean shot;
    private long lastPressProcessed = 0;
    

    public Player1(String classimage, int hp, int posx, int posy) {
        super(classimage, hp, posx, posy);
        lasers = new ArrayList();
        shot = true;
    }
    
    @Override
    public ArrayList getLasers(){
        return lasers;
    }
    
     public void keyPressed(KeyEvent e) {
              
		int key = e.getKeyCode();
                
                if(key == KeyEvent.VK_T) {
			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());
                    
		}
                if(key == KeyEvent.VK_H) {
			
                    			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());

		}

		if(key == KeyEvent.VK_LEFT) {
			setDx(-2);         
                        			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());

		}
                
               

		if(key == KeyEvent.VK_RIGHT) {
                    setDx(2);       
                    			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());

		}
                
               

		if(key == KeyEvent.VK_UP) {
                    setDy(-2);
                    			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());

		}
                

		if(key == KeyEvent.VK_DOWN) {
                    setDy(2);
                    			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());

		}
            
                if(key == KeyEvent.VK_CONTROL && shot){ 
                    			System.out.println("cordenadas son X"+getX()+"  Y:"+getY());

            
            
                      
                      
               
                
        }
	}
        public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if(key == KeyEvent.VK_LEFT) {
                    setDx(0);
		}

		if(key == KeyEvent.VK_RIGHT) {
                      setDx(0);
		}

		if(key == KeyEvent.VK_UP) {
                      setDy(0);
                }

		if(key == KeyEvent.VK_DOWN) {
                      setDy(0);
		}
                if(key == KeyEvent.VK_CONTROL){
                    shot = true;
                }
	}
   
        
}
