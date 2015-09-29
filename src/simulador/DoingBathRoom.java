/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.Random;

/**
 *
 * @author Cristian
 */
public class DoingBathRoom {
    
    int t =0;
    public void doingSomethingBathRoom(int time,Agents a)
    {
         a.travel.add(a.name+ "fue al baño a las "+Drawn.clock.getTime());
    while(t<time)
    {
        try{
     //       System.out.println("En el baño...");
        Random r = new Random();
   int tmpx = a.x;
   int tmpy = a.y;
   //aca se realizan los movimientos del personaje cuando esta ya establecido en algun lugar
 //  a.x = a.x + r.nextInt(10)+1;
  // a.y = a.y + r.nextInt(10)+1;
   Thread.sleep(1000);
  a.x = tmpx;
  a.y = tmpy;
        }
        catch(Exception e){
            
        e.printStackTrace();
        }
    t = t + 1000 ;
    }
        
    }
    
}
