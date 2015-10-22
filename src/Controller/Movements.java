/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Agents;
import java.util.ArrayList;
import Model.Coords;
import View.WindowSimulator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Cristian Michel
 */ 
public class Movements {
    public boolean flag = true;
    
    public synchronized void toHome(Agents a)
    {
    int up = 1;
    if(a.rol.equals("wait")) up = 10;
    boolean sumarx=false;
    boolean sumary=false;
    int xl,yl;
    if(a.rol.equals("Ball")){ xl = 520; yl = 525 + 10;}
    else {
    xl = Agents.BATTER[0];
    yl = Agents.BATTER[1];
   String [] sm = this.getTypeOfMove(a,xl,yl);
   a.move = sm[0];
   a.pointer = Integer.parseInt(sm[1]);
    
    }
    if(a.x < xl) sumarx = true;
    if(a.y < yl) sumary = true;
    while(a.pause == false)
    {
     try{
     Thread.sleep(a.speed);
     
     if(a.x == xl && a.y == yl){
         if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = true;
         a.pointer = 0;
         a.flagmove = false;break;
     
     }
  
    else {
     //  System.out.println("Homing");
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
      } 
     //System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == xl);
    else {
    if(sumarx) a.x = a.x + up;
    else a.x  = a.x - up;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == yl);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
  if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = false;

    }
    
    public synchronized void toFirstBase(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    
    int up;
    if(a.rol.equals("Ball") ) up = 1;
    else  up = 2;
   // System.out.println("to first");

    if(a.x < Agents.FIRSTBASEMAN[0]) sumarx = true;
    if(a.y < Agents.FIRSTBASEMAN[1]) sumary = true;
    if(!a.rol.equals("Ball"))
    {
     String [] sm = this.getTypeOfMove(a,Agents.FIRSTBASEMAN[0],Agents.FIRSTBASEMAN[1]);
     a.move = sm[0];
     a.pointer = Integer.parseInt(sm[1]);
     a.flagmove = true;
   //  System.out.println("*******  "+sm[0]+" **************");
        
    }
    while(a.pause == false)
    {
//    System.err.println(a.pause + " TO F " + a.rol);
     try{
     if(a.x > Agents.FIRSTBASEMAN[0] && sumarx) a.x = Agents.FIRSTBASEMAN[0];
     if(a.x < Agents.FIRSTBASEMAN[0] && sumarx == false) a.x = Agents.FIRSTBASEMAN[0];
     if(a.y > Agents.FIRSTBASEMAN[1] && sumary) a.y = Agents.FIRSTBASEMAN[1];
     if(a.y < Agents.FIRSTBASEMAN[1] && sumary == false) a.y = Agents.FIRSTBASEMAN[1];
     Thread.sleep(a.speed);
//    System.out.println(a.rol + " A "+ a.speed + "ms de velocidad");
    if(a.x == Agents.FIRSTBASEMAN[0] && a.y == Agents.FIRSTBASEMAN[1]){ 
        if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = true;
        a.flagmove = false; 
        a.pointer = 0;
        break;
    
    }
    else {
      
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == Agents.FIRSTBASEMAN[0]);
    else {
    if(sumarx) a.x = a.x + up;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == Agents.FIRSTBASEMAN[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    

    if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = false;
    a.flagmove = false;  
    }
    
    public void toSecondBase(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    a.speed = 40;
    
//    System.out.println("to second");
    if(a.x < Agents.SECONDBASEMAN[0]) sumarx = true;
    if(a.y < Agents.SECONDBASEMAN[1]) sumary = true;
    if(!a.rol.equals("Ball"))
    {
     String [] sm = this.getTypeOfMove(a,Agents.SECONDBASEMAN[0],Agents.SECONDBASEMAN[1]);
     a.move = sm[0];
     a.pointer = Integer.parseInt(sm[1]);
     a.flagmove = true; 
        
    }
    while(a.pause == false)
    {
  
     try{
     
     Thread.sleep(a.speed);

    if(a.x == Agents.SECONDBASEMAN[0] && a.y == a.SECONDBASEMAN[1]){
      if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = true;
        a.flagmove = false;
        a.pointer = 0;
        break;}
    else {
   
     //System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == Agents.SECONDBASEMAN[0]);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == a.SECONDBASEMAN[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
    if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = false;
    a.flagmove = false; 
    }
    
    public void toThirdBase(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    
    if(a.x < Agents.THIRDBASEMAN[0]) sumarx = true;
    if(a.y < Agents.THIRDBASEMAN[1]) sumary = true;
    if(!a.rol.equals("Ball"))
    {
     String [] sm = this.getTypeOfMove(a,Agents.THIRDBASEMAN[0],Agents.THIRDBASEMAN[1]);
     a.move = sm[0];
     a.pointer = Integer.parseInt(sm[1]);
      
        
    }
    while(a.pause == false)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == Agents.THIRDBASEMAN[0] && a.y == Agents.THIRDBASEMAN[1]){
      if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = true;
        a.flagmove = false;
        a.pointer = 0;
        a.flagmove = true;
        break;}
    else {
      
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == Agents.THIRDBASEMAN[0]);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == Agents.THIRDBASEMAN[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    
   if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = false;
   a.flagmove = false;
    }
    
    
 public void toBall(Agents a)
    {
    
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
    if(a.x < b.x) sumarx = true;
    if(a.y < b.y) sumary = true;
    
    while(a.pause == false)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == b.x && a.y == b.y){
    if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = true;

        a.flagmove = false;
        a.pointer = 0;
   // System.out.println("DONE !");
    
    break;
    }
    else {
  //  System.out.println("Now: "+a.x+","+a.y+" Goal: "+b.x+","+b.y);
      
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
     catch(Exception e){e.printStackTrace();}   
    }
    
if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = false;
        
    }
 
 public Agents getBestAgent(Agents ball)
 {
     /*I create the array of agents that can get the ball in this moment*/
     Agents[] a = new Agents[6];
     while(ball.xTemp == 0 && ball.yTemp == 0){try {
         Thread.sleep(40);
         } catch (InterruptedException ex) {
             Logger.getLogger(Movements.class.getName()).log(Level.SEVERE, null, ex);
         }
}
     a[0] = ball.getAgent("First Baseman");
     a[1] = ball.getAgent("Second Baseman");
     a[2] = ball.getAgent("Third Baseman");
     a[3] = ball.getAgent("Left Fielder");
     a[4] = ball.getAgent("Center Fielder");
     a[5] = ball.getAgent("Right Fielder");
    // a[6] = ball.getAgent("Short Fielder");
        /*And now, I sort the array using bubble sort algorithm with the parameters x and y calculating the distance between these 2 points (ball and agent) of each agent,
        afther that I return the agent more close */
        for (int i = 0 ; i<a.length ; i++) {
            for(int j = 0;j<a.length-1;j++)
            {
                if(getDistance(a[j],ball) > getDistance(a[j+1],ball))
                {
                    Agents tmp1 = a[j];
                    Agents tmp2 = a[j+1];
                    a[j] = tmp2;
                    a[j+1] = tmp1;
                }
                
            }
        }
     
 return a[0];
 }

 private double getDistance(Agents agent,Agents ball){
     // System.out.println("Agente: "+agent+" Pelota: "+ball);
     double distance;
    
     distance = Math.sqrt(  (  Math.pow((ball.xTemp - agent.x),2)   +    Math.pow((ball.yTemp - agent.y),2)  )   );
  //   System.out.println("-----> "+distance);
 return distance;
 }
 
 public void ball(Agents a)
 {
    a.pointer = 9;
    a.initialPosition(1);
    boolean sumarx=false;
    boolean sumary=false;
    int morex,morey;
    morex = a.r.nextInt(20 + 15)+15;
    morey = a.r.nextInt(40 + 30)+ 30;
    int [] tmp = {515,525};
    tmp[0]+= morex;
    tmp[1]+= morey;
    if(a.x < tmp[0]) sumarx = true;
    if(a.y < tmp[1]) sumary = true;
    while(a.pause == false)
    {
     try{
     a.sleep(a.speed);
    if(a.x == tmp[0] && a.y == tmp[1]){ a.flagmove = false;
    a.pointer = 0;
    a.pause = true;
    break;}
    else {
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      } 
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == tmp[0]);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == tmp[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    
        
    }
 
 
 public void toPitcherGo(Agents a,int xm,int ym)
    {
          a.pointer = 9;

    boolean sumarx=false;
    boolean sumary=false;
    int xl,yl;
    if(a.rol.equals("Ball")){ xl = xm; yl = ym;}
    else {
    xl = Agents.PITCHER[0];
    yl = Agents.PITCHER[1];
    }
    if(a.x < xl) sumarx = true;
    if(a.y < yl) sumary = true;
    while(a.pause == false)
    {
        
  //   System.out.println(a.sinalRule);
     try{
     Thread.sleep(a.speed);
     
     if(a.x == xl && a.y == yl){
         if(a.rol.equals("Ball") && a.sinalRule == 1){ a.getAgent("Batter").pause = true;
         //         System.out.println("READY "+a.getAgent("Batter").rol+ " STATUS : "+a.getAgent("Batter").pause);

         }

         a.flagmove = false;a.goal = true; break;}
  
    else {
   //    System.out.println("Homing");
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      } 
     //System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == xl);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == yl);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    
        
    }
 public void toWaitZone(Agents a)
    {
    a.pause = false;
    boolean sumarx=false;
    boolean sumary=false;
    
    int up;
    
  //  System.out.println("to first");
    int xGo,yGo;
    yGo = a.r.nextInt(219 - 163 ) + 163;
    xGo = a.r.nextInt(1057 - 873) + 873;
    if(a.x < xGo) sumarx = true;
    if(a.y < yGo) sumary = true;
     if(!a.rol.equals("Ball"))
    {
     String [] sm = this.getTypeOfMove(a,xGo,yGo);
     a.move = sm[0];
     a.pointer = Integer.parseInt(sm[1]);
     a.flagmove = true;
  //   System.out.println("*******  "+sm[0]+" **************");
        
    }
    while(a.pause == false)
    {
   // System.err.println("TO WAIT ZONE" );
     try{
     if(a.x > xGo && sumarx) a.x = xGo;
     if(a.x < xGo && sumarx == false) a.x =  xGo;
     if(a.y > yGo && sumary) a.y = yGo;
     if(a.y < yGo && sumary == false) a.y = yGo;
     Thread.sleep(a.speed);
  //   System.out.println(a.rol + " A "+ a.speed + "ms de velocidad");
    if(a.x == xGo && a.y == yGo){ 
        a.flagmove = false; 
        a.pointer = 0;
        a.move = "";
        break;
    
    }
    else {
      
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == xGo);
    else {
    if(sumarx) a.x = a.x + 1;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == yGo);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    

    
    }
    
 public void toStrike(Agents a)
    {
    a.pause = false;
    boolean sumarx=false;
    boolean sumary=false;
    
    int up;
    
  //  System.out.println("to first");
    int xGo,yGo;
    yGo = Agents.CATCHER[1];
    xGo = Agents.CATCHER[0] + 20;
    if(a.x < xGo) sumarx = true;
    if(a.y < yGo) sumary = true;
     if(!a.rol.equals("Ball"))
    {
     String [] sm = this.getTypeOfMove(a,xGo,yGo);
     a.move = sm[0];
     a.pointer = Integer.parseInt(sm[1]);
     a.flagmove = true;
  //   System.out.println("*******  "+sm[0]+" **************");
        
    }
    while(a.pause == false)
    {
     try{
     if(a.x > xGo && sumarx) a.x = xGo;
     if(a.x < xGo && sumarx == false) a.x =  xGo;
     if(a.y > yGo && sumary) a.y = yGo;
     if(a.y < yGo && sumary == false) a.y = yGo;
     Thread.sleep(a.speed);
   //  System.out.println(a.rol + " A "+ a.speed + "ms de velocidad");
    if(a.x == xGo && a.y == yGo){ 
        a.flagmove = false; 
        a.pointer = 0;
        a.move = "";
        break;
    
    }
    else {
      
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == xGo);
    else {
    if(sumarx) a.x = a.x + 1;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == yGo);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    

    
    }
    
  public synchronized void toFoulZone(Agents a,int [] coords)
    {
    boolean sumarx=false;
    boolean sumary=false;
    
    int up = 5;

    if(a.x < coords[0]) sumarx = true;
    if(a.y < coords[1]) sumary = true;
    if(!a.rol.equals("Ball"))
    {
     String [] sm = this.getTypeOfMove(a,coords[0],coords[1]);
     a.move = sm[0];
     a.pointer = Integer.parseInt(sm[1]);
     a.flagmove = true;
   //  System.out.println("*******  "+sm[0]+" **************");
        
    }
    while(a.pause == false)
    {
   // System.err.println(a.pause + " TO F " + a.rol);
     try{
     if(a.x > coords[0] && sumarx) a.x =coords[0];
     if(a.x < coords[0] && sumarx == false) a.x =coords[0];
     if(a.y > coords[1]&& sumary) a.y = coords[1];
     if(a.y < coords[1] && sumary == false) a.y = coords[1];
     Thread.sleep(a.speed);
     //System.out.println(a.rol + " A "+ a.speed + "ms de velocidad");
    if(a.x == coords[0] && a.y == coords[1]){ 
        if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = true;
        a.flagmove = false; 
        a.pointer = 0;
        break;
    
    }
    else {
      
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == coords[0]);
    else {
    if(sumarx) a.x = a.x + up;  
    else a.x  = a.x - up;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == coords[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){e.printStackTrace();}   
    }
    

    if(a.rol.equals("Ball") && a.sinalRule == 1) a.getAgent("Batter").pause = false;
    a.flagmove = false;  
    }

 public void trhowBall(Agents ball,int [] coords,int opc,int [] something)
 {
 if(opc == 10) ball.initialPosition(1);
    
// if(opc == 11 ){ Agents btt = ball.getAgent("Batter"); btt.flag = true; btt.speed = 30;toFirstBase(btt);} 
 if(coords == Agents.FIRSTBASEMAN) toFirstBase(ball);
 if(coords == Agents.SECONDBASEMAN) toSecondBase(ball);
 if(coords == Agents.THIRDBASEMAN) toThirdBase(ball);
 if(coords == Agents.PITCHER) toPitcherGo(ball,something[0],something[1]);
 if(coords == Agents.BATTER) toHome(ball);
 if(opc == 10 ) {ball.getAgent("Batter").flag = true; toHome(ball);}
 if(opc == 2) {this.toStrike(ball);}
 }
 
 
 
 /**
  @param a it's the controller*/
 public int [] getNextBaseClose(Agents a)
 {
 Agents batter = a.getAgent("Batter");
 Coords distances [] = {getDistanceBase(batter,Agents.FIRSTBASEMAN),getDistanceBase(batter,Agents.SECONDBASEMAN),getDistanceBase(batter,Agents.THIRDBASEMAN)};
       for(int i = 0 ; i< distances.length; i++)
       {
            for (int j=0;j<distances.length - 1;j++)
            {
                Coords tmp1,tmp2;
                tmp1 =  distances[j];
                tmp2 = distances[j+1];
                double tmptmp1,tmptmp2;
                tmptmp1  = tmp1.distance;
                tmptmp2 = tmp2.distance;
                if( tmptmp1 > tmptmp2)
                {
                    distances[j] =  tmp2;
                    distances[j+1] = tmp1;
                }
                
            }
        }  
 
 return distances[0].coords;
 }
 public Coords getDistanceBase(Agents batter, int [] base)
 {
      
     Coords cords;
     cords = new Coords();
     cords.coords = base;
     cords.distance =  Math.sqrt(  (  Math.pow((batter.x - base[0]),2)   +    Math.pow((batter.y - base[1]),2)  )   ); 
         
      return cords;
     
}
 
public  String [] getTypeOfMove(Agents a,int xGoal,int yGoal)
{
System.out.println(a.x+ ", "+a.y+" -> "+xGoal+", "+yGoal);
if(xGoal > yGoal)
{
    if(a.x < xGoal) 
    {
        String [] s =  {"right","6"};
        return s;
    }
    else
    {
        String [] s = {"left","3"};
        return s; 
    }
}
else 
{
    if(a.y < yGoal)
    {
        String [] s = {"down","9"};
        return s;
    }
    else 
    {

        String [] s = {"up","0"};
        return s;

    }

    
}
    
    
}



public int [] getCoordsFoul(Agents a)
{
int coordsFoul[] = new int[2];  
    if(a.r.nextBoolean())
    {
    coordsFoul[0] = a.r.nextInt(400 - 80 ) + 80;
    coordsFoul[1] = 400 + (coordsFoul[0]  - 50);
    }
    else{
    coordsFoul[0] = a.r.nextInt(1100 - 650 ) + 650;
    coordsFoul[1] = 400 + (coordsFoul[0]  - 650);
    }
return coordsFoul;
}

}
