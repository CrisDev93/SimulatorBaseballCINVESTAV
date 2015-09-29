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
public class DoingMerch {
      int t=0;
    public void BuyingaMerch(int time,Agents a)
    {
         a.travel.add(a.name+ "compró una mercancía a las "+Drawn.clock.getTime());
   while(t<time)
   {
   try{
  // System.out.println("I'm buying a Merch");
   Random r = new Random();
   int tmpx = a.x;
   int tmpy = a.y;
   //se implementan los movimientos de los personajes cuando ya estan en un lugar establecido
   //a.x = a.x + r.nextInt(10)+1;
   //a.y = a.y + r.nextInt(10)+1;
   Thread.sleep(100);
   //a.x = tmpx;
  // a.y = tmpy;
   }
   
   
   catch(Exception e){
   System.out.println(e);
   }
       
       
   t= t+100;
   }
    
    }
    
}
