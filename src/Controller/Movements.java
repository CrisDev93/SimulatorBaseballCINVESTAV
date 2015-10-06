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
public class Movements {
    public boolean flag = true;
    
    public void toHome(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    int xl,yl;
    if(a.rol.equals("Ball")){ xl = 520; yl = 525 + 10;}
    else {
    xl = a.BATTER[0];
    yl = a.BATTER[1];
    }
    if(a.x < xl) sumarx = true;
    if(a.y < yl) sumary = true;
    while(true)
    {
     try{
     Thread.sleep(a.speed);
     
     if(a.x == xl && a.y == yl){ a.flagmove = false;System.out.println("DONE"); break;}
  
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
     catch(Exception e){ e.printStackTrace(); }   
    }
    
        
    }
    
    public void toFirstBase(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    
    if(a.x < a.FIRSTBASEMAN[0]) sumarx = true;
    if(a.y < a.FIRSTBASEMAN[1]) sumary = true;
    while(true)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == a.FIRSTBASEMAN[0] && a.y == a.FIRSTBASEMAN[1]){ a.flagmove = false; break;}
    else {
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
      } 
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == a.FIRSTBASEMAN[0]);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == a.FIRSTBASEMAN[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
        
    }
    
    public void toSecondBase(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    
    if(a.x < a.SECONDBASEMAN[0]) sumarx = true;
    if(a.y < a.SECONDBASEMAN[1]) sumary = true;
    while(true)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == a.SECONDBASEMAN[0] && a.y == a.SECONDBASEMAN[1]){ a.flagmove = false; break;}
    else {
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
      } 
     //System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == a.SECONDBASEMAN[0]);
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
    
        
    }
    
    public void toThirdBase(Agents a)
    {
    boolean sumarx=false;
    boolean sumary=false;
    
    if(a.x < a.THIRDBASEMAN[0]) sumarx = true;
    if(a.y < a.THIRDBASEMAN[1]) sumary = true;
    while(true)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == a.THIRDBASEMAN[0] && a.y == a.THIRDBASEMAN[1]){ a.flagmove = false; break;}
    else {
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
      } 
    // System.out.println("Moving -> "+a.rol);
     /*Condicionales para X */   
    if(a.x == a.THIRDBASEMAN[0]);
    else {
    if(sumarx) a.x++;
    else a.x --;
    }
    
    /*Condicionales para Y*/
    
   if(a.y == a.THIRDBASEMAN[1]);
   else{
   if(sumary) a.y++;
   else a.y --;
   }
    }
    }
     catch(Exception e){ e.printStackTrace(); }   
    }
    
        
    }
    
    
 public void toBall(Agents a)
    {
    
    boolean sumarx=false;
    boolean sumary=false;
    Agents b = a.getAgent("Ball");
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
    
        
    }
 
 public Agents getBestAgent(Agents ball)
 {
     /*I create the array of agents that can get the ball in this moment*/
     Agents[] a = new Agents[6];
     a[0] = ball.getAgent("First Baseman");
     a[1] = ball.getAgent("Second Baseman");
     a[2] = ball.getAgent("Third Baseman");
     a[3] = ball.getAgent("Left Fielder");
     a[4] = ball.getAgent("Center Fielder");
     a[5] = ball.getAgent("Right Fielder");
    // a[6] = ball.getAgent("Short Fielder");
     
     /*And now, I sort the array using bubble sort algorithm with the parameters x and y calculating the distance between these 2 points (ball and agent) of each agent,
     afther that I return the agent more close */
     
     for(int i = 0 ; i<a.length; i++)
     {
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
     distance = Math.sqrt(  (  Math.pow((ball.x - agent.x),2)   +    Math.pow((ball.y - agent.y),2)  )   );
     
 return distance;
 }
 
 public void ball(Agents a)
 {
     a.initialPosition(1);
    boolean sumarx=false;
    boolean sumary=false;
    int morex,morey;
    morex = a.r.nextInt(25 + 15)+15;
    morey = a.r.nextInt(90 + 30)+ 30;
    int [] tmp = {515,525};
    tmp[0]+= morex;
    tmp[1]+= morey;
    if(a.x < tmp[0]) sumarx = true;
    if(a.y < tmp[1]) sumary = true;
    while(true)
    {
     try{
     Thread.sleep(a.speed);
    if(a.x == tmp[0] && a.y == tmp[1]){ a.flagmove = false; break;}
    else {
      if(!(a.rol.equals("Ball")|| a.rol.equals("controler")))  
      {
      a.flagmove= true;
      a.move="right";
      a.pointer = 9;
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
     catch(Exception e){ e.printStackTrace(); }   
    }
    
        
    }
 
 
 public void toPitcherGo(Agents a,int xm,int ym)
    {
    boolean sumarx=false;
    boolean sumary=false;
    int xl,yl;
    if(a.rol.equals("Ball")){ xl = xm; yl = ym;}
    else {
    xl = a.BATTER[0];
    yl = a.BATTER[1];
    }
    if(a.x < xl) sumarx = true;
    if(a.y < yl) sumary = true;
    while(true)
    {
     try{
     Thread.sleep(a.speed);
     
     if(a.x == xl && a.y == yl){ a.flagmove = false;System.out.println("DONE"); break;}
  
    else {
   //    System.out.println("Homing");
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
     catch(Exception e){ e.printStackTrace(); }   
    }
    
        
    }
 
 
 
 public void trhowBall(Agents ball,int [] coords,int opc,int [] something)
 {
 if(opc == 10) ball.initialPosition(1);
// if(opc == 11 ){ Agents btt = ball.getAgent("Batter"); btt.flag = true; btt.speed = 30;toFirstBase(btt);} 

 if(coords == ball.FIRSTBASEMAN) toFirstBase(ball);
 if(coords == ball.SECONDBASEMAN) toSecondBase(ball);
 if(coords == ball.THIRDBASEMAN) toThirdBase(ball);
 if(coords == ball.PITCHER) toPitcherGo(ball,something[0],something[1]);
 if(coords == ball.BATTER) toHome(ball);
 if(opc == 10 ) {ball.getAgent("Batter").flag = true; toHome(ball);}
 
 }
 
 
 public int [] getNextBaseClose()
 {
 
 
 return null;
 }
 
}
