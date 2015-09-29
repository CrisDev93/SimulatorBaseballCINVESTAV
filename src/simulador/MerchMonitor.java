/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Cristian
 */
public class MerchMonitor {
    
     Agents merch[];
    public boolean flagm=false;
    public Integer countm=0;
    Semaphore semaphorem;
    int waitingmerch =0;
    public MerchMonitor(int size)
    {
    merch= new Agents[size];
    semaphorem = new Semaphore(3);
    
    }
   
    public void enterMerchArea(Agents a,int actual)
    {
        try{
            a.m.transition++;
          a.multiplePaths(a.ALocation, actual,a.m.transition);  
          a.m.transition--;
      //   a.chooseLocation(9);
         waitingmerch++;
        semaphorem.acquire();
        waitingmerch--;
       a.ALocation=1;
        for(int i=0;i<merch.length;i++)
        {
        if(merch[i] == null)
        {
       
        merch[i] =a;
    //    a.chooseLocation(3);
        synchronized(countm){
         countm++;
        } 
       
        Random random = new Random();
     int time = random.nextInt(10000) + 1;
        new DoingMerch().BuyingaMerch(time, a);
        merch[i]=null;
        break;
        }
        }
        
        synchronized(countm){
         countm--;
        }
        semaphorem.release();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        
        
    
    }
    
    
    
    
    
    
}
