/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Agents;
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
    
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    if(a.x < b.xTemp) sumarx = true;
    if(a.y < b.yTemp) sumary = true;
    
    while(flag)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == b.xTemp && a.y == b.yTemp){ a.flagmove = false;
    System.out.println("DONE !");
    
    break;
    }
    else {
  //  System.out.println("Now: "+a.x+","+a.y+" Goal: "+b.x+","+b.y);
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
      } 
   //  System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == b.xTemp);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == b.yTemp);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
    // Acá finaliza el recorrido a la pelota    
    
    
    }
    
    
    /**
     @param a it's the agent more close of the ball 
     @param pass it's the key of the recursion if pass == 1 then throw ball with the same position of the ball and agents, else make a recursion with the pass == 0 */
   public void getBallAndThrow(Agents a,int pass)
   {
    int xTemp,yTemp;
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    xTemp = a.xTemp + a.r.nextInt(50 - 20) + 20;
    yTemp = a.yTemp + a.r.nextInt(50 - 20) + 20;
    if(a.x < b.x) sumarx = true;
    if(a.y < b.y) sumary = true;
    
    while(flag)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == b.x && a.y == b.y){ a.flagmove = false;
    System.out.println("DONE !");
    
    break;
    }
    else {
  //  System.out.println("Now: "+a.x+","+a.y+" Goal: "+b.x+","+b.y);
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
      } 
   //  System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == b.x);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == b.y);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
    // Acá finaliza el recorrido a la pelota    
   while(b.goal == false);
   this.CatchBallBeforeField(a);
   
   
   
   
   }
   
    
}