/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Agents;
import View.Drawn;

/**
 *
 * @author Cristian
 */
public class DoingConcert {
    
    int time =0;
    public void listenConcert(Agents a,int actual,int t)
    {
        t  = t* 1000;
        boolean ready ;
        
   
        while(true)
        {
            try{
                Drawn.stamp.inConcert=Drawn.stamp.inConcert+1;
      //  System.out.println("The people: "+a.name+"are listening the concert");
                a.ALocation=4;
                a.multiplePaths(a.ALocation, actual,a.m.transition);
     // a.chooseLocation(1);
      int tmpy;
      tmpy = a.y;
     //aca se implementan los movimientos cuando esta en un lugar ya establecido
     // a.y = a.y + 5;
  
     // a.y = tmpy;
     
        Thread.sleep(100);
        time=time+100;
            
            }
            catch(Exception e){
            e.printStackTrace();}
                
            }
    
    }
    
}
