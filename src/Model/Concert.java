/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import Controller.DoingConcert;
/**
 *
 * @author Cristian
 */
public class Concert {
       
    
int howmany=0;
   
    /*In this method the Thread Agent sleep one time while te real time is finish
     and with the objetc Agents it change of position with a random number*/
    public void ListeningConcert(Agents a,int time,int actual)
    {
     
 
      //  System.out.println("Entraré a escuchar el concierto...");
        new DoingConcert().listenConcert(a, actual,time);
      //  System.out.println("Ya escuché el concierto");
      
        
        }
    
    
    }
    
    

