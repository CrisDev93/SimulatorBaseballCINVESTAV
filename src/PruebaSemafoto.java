/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Cristian
 */
public class PruebaSemafoto extends Thread{
    
    ArrayList a = new ArrayList();
     Semaphore g = new Semaphore(10,true);
     
     public void run()
     {
        try {
            addS(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaSemafoto.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public void addS(int s) throws InterruptedException
    {
   g.acquire();

   a.add(s);
   System.out.println("I'm doing something");
   Thread.sleep(1000);
   
   g.release();
  
    }
    
    public static void main(String args[])
    {
 
    for(int i=0;i<500;i++)
    {
      new PruebaSemafoto().start();
    }
    }
    
}
