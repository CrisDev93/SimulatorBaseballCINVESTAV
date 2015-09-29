/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class BathroomMonitor {
    int waitingbathroom=0;
    Agents bathroom[];
    public boolean flagb=false;
    public Integer countb=0;
    Semaphore semaphoreb;
    public BathroomMonitor(int size)
    {
    bathroom= new Agents[size];
    semaphoreb = new Semaphore(10);
    
    }
   
    public void enterBathroom(Agents a,int actual)
    {
        try{
            a.m.transition++;
            a.multiplePaths(a.ALocation, actual,a.m.transition);
            a.m.transition--;
        //    a.chooseLocation(7); 
            
         waitingbathroom++;     
        semaphoreb.acquire();
      a.ALocation=3;
        for(int i=0;i<bathroom.length;i++)
        {
        if(bathroom[i] == null)
        {
       
        bathroom[i] =a;
        
         synchronized(countb){
          if(countb<10)countb++;
        
        }
       // a.chooseLocation(4);
        
        new DoingBathRoom().doingSomethingBathRoom(5,a);
        bathroom[i]=null;
        break;
        }
        }
        
        synchronized(countb){
         countb--;
        }
        waitingbathroom--;
        semaphoreb.release();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        
        
    
    }
    
    
    
}
