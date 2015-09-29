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
public class DrinksMonitor {
    int waitingdrinks=0;
     Agents drinks[];
    public boolean flagb=false;
    public Integer countd=0;
    Semaphore semaphored;
    public DrinksMonitor(int size)
    {
    drinks= new Agents[size];
    semaphored = new Semaphore(3);
    
    }
   
    public void enterDrinksArea(Agents a,int actual)
    {
        try{
            a.m.transition++;
             a.multiplePaths(a.ALocation, actual,a.m.transition);
           a.m.transition--;
           //  a.chooseLocation(8);
           waitingdrinks++;
        semaphored.acquire();
        waitingdrinks--;
        for(int i=0;i<drinks.length;i++)
        {
        if(drinks[i] == null)
        {
       
        drinks[i] =a;
        a.ALocation=2;
      //  a.chooseLocation(6);
        synchronized(countd){
         countd++;
        }
        Random random = new Random();
     int time = random.nextInt(10000) + 1;
        new DoingSomethingDrinks().BuyingaDrink(time, a);
        drinks[i]=null;
        break;
        }
        }
        
         synchronized(countd){
         countd--;
        }
        
        semaphored.release();
       
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        
        
    
    }
    
    
    
    
    
}
