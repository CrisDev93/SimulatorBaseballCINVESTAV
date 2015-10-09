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
        
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    b.sinalRule = 1;
    if(a.x < b.xTemp) sumarx = true;
    if(a.y < b.yTemp) sumary = true;
    
    while(flag)
    {
     try{
    //     System.out.println("gonna for "+b.xTemp+","+b.yTemp);

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
//   a.movements.trhowBall(b, a.movements.getNextBaseClose(a),0, null);
    
    }
    
    
    
    /**
     @param a it's the agent more close of the ball 
     @param pass it's the key of the recursion if pass == 1 then throw ball with the same position of the ball and agents, else make a recursion with the pass == 0 */
   public void getBallAndThrow(Agents a,int pass)
   {
       a.pointer = 9;
       System.out.println("YA LLEGUE A GET BALL AND THROW");
    int xTemp,yTemp;
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    while(b.xTemp == 0 & b.yTemp == 0){try {
        Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Out.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    xTemp = b.xTemp + a.r.nextInt(15 - 10) + 10;
    yTemp = b.yTemp + a.r.nextInt(15 - 10) + 10;
    if(a.x < xTemp) sumarx = true;
    if(a.y < yTemp) sumary = true;
    
    while(flag)
    {
     try{
   // System.out.println("gonna for "+xTemp+","+yTemp);
     Thread.sleep(a.speed);
    if(a.x == xTemp && a.y == yTemp){ a.flagmove = false;
    System.out.println("DONE BEST AGENT GOAL !");
    
    break;
    }
    else {
  //  System.out.println("Now: "+a.x+","+a.y+" Goal: "+b.x+","+b.y);
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      
      } 
   //  System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == xTemp);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == yTemp);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
    // Acá finaliza el recorrido a la pelota    
   while(b.goal == false){System.out.println("No goal");
       
   }
    CatchBallBeforeField(a);
    int [] obj  = b.movements.getNextBaseClose(a);
    System.out.println("EL MÁS OPTIMO: "+obj[0]+","+obj[1]+" y FirstBaseman es: "+Agents.FIRSTBASEMAN[0]+","+Agents.FIRSTBASEMAN[1]);

 b.movements.trhowBall(b,obj, 0, null);
   
   
   
   
   }
   
    
}
