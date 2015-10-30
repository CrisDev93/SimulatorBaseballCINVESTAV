/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Agents;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Cristian Michel
 */
public class Out {
    
    //Primitives 
    public boolean flag = true;

    /**
     @param a it's the agent more close of the ball 

     */
    public void CatchBallBeforeField(Agents a)
    {
    System.out.println("**** CatchBallBeforeField ****");    
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    Agents batter = a.getAgent("Batter");
    b.sinalRule = 1;
    int location [] = {b.xTemp,b.yTemp};
    a.movements.toAnyPlace(a, location);
    
    }
    
    /**
     @param a it's the agent more close of the ball 
     @param pass it's the key of the recursion if pass == 1 then throw ball with the same position of the ball and agents, else make a recursion with the pass == 0 */
   public synchronized void getBallAndThrow(Agents a,int pass) throws InterruptedException
   {
        System.out.println("**** getBallAndThrow ****");    
   
  //     System.out.println("YA LLEGUE A GET BALL AND THROW");
    int xTemp,yTemp;
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    while(b.xTemp == 0 & b.yTemp == 0){try {
        Thread.sleep(300);
        System.out.println("GetBallAndThrow 0 y 0");
        } catch (InterruptedException ex) {
            Logger.getLogger(Out.class.getName()).log(Level.SEVERE, null, ex);
         
        }
}
    xTemp = b.xTemp + a.r.nextInt(15 - 10) + 10;
    yTemp = b.yTemp + a.r.nextInt(15 - 10) + 10;
    int location [] = {xTemp,yTemp};
    a.movements.toAnyPlace(a,location);
   while(b.goal == false){
       try{
       wait(5);
       }
       catch(InterruptedException e){return;}
   }
    CatchBallBeforeField(a);
    int [] obj  = b.movements.getNextBaseClose(a);
   
  //  System.out.println("EL MÁS OPTIMO: "+obj[0]+","+obj[1]+" y FirstBaseman es: "+Agents.FIRSTBASEMAN[0]+","+Agents.FIRSTBASEMAN[1]);
 b.speed = b.speedCalculated(obj);
 b.pause = false;
 b.speed = 3;

 Movements nm = new Movements();
 while(b.inMove){
 wait(5);
 }
 b.pause = false;
 b.flag = true;
 nm.toAnyPlace(b,obj);

   }
   
   
   
 
       
   
  public  void outGameBatter(Agents batter)
  {
  batter.releaseRol(batter.rol);

  batter.rol = "wait";
  Movements nm = new Movements();
  nm.toWaitZone(batter);
  }
}
