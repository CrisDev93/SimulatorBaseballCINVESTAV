/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Agents;
import static Model.Agents.BATTER;
import static Model.Agents.FIRSTBASEMAN;
import static Model.Agents.PITCHER;
import java.util.ArrayList;

/**
 *
 * @author Cristian Michel
 */


public class Escenarios {

  public  Strike strike = new Strike();
 
    /**
    @param a  variable Agents that represent the controler agents and it's for get and Access to the methods of Agents class
    */
    public void contactoPelota(Agents a,boolean isHit)
    {
    Movements movimientos = new Movements();
    //Some instances of Agents class for get an especific agents access
    Agents pitcher,batter,balon;
    // A boolean variable for generate a randomly movement for the ball for example if rDestinations is true the movement in 'X' will be more long. 
    boolean rDestionation;
    // Variables of X and Y coords randomly. 
    int rx,ry;
    pitcher = a.getAgent("Pitcher");
    batter  = a.getAgent("Batter");
    balon    = a.getAgent("Ball");
    balon.pause = false;
   movimientos.trhowBall(balon,BATTER,10,null);
     
 
     
     ry = a.r.nextInt(100 - 70 ) + 70;
     rx = a.r.nextInt(40 - 10 )+ 10;
     
     rDestionation = a.r.nextBoolean();
     
    // System.out.println(rDestionation);
     int [] nco;
     if (rDestionation)
     {
     int [] ncot = {PITCHER[0]  + rx,(PITCHER[1] - ry)};
     nco = ncot;
     }
     else {
     int [] ncot = {PITCHER[0] - rx,(PITCHER[1] - ry)};
     nco = ncot;
     }
     balon.xTemp = nco[0];
     balon.yTemp = nco[1];
   //  System.out.println("BALLL COORDS TMP "+balon.xTemp+","+balon.yTemp);
     
     if(isHit)batter.destination = 2;
     else batter.destination = 1;
     balon.pause = false;
     System.out.println("Soy Ball y me voy a las coordenadas: "+balon.xTemp+ ","+balon.yTemp);
     movimientos.trhowBall(balon,PITCHER,11,nco);
     
     
    
    }
    public void bola(Agents a)
    {
    Agents pitcher,batter,balon;
    
  
     balon    = a.getAgent("Ball");
     balon.speed = 20;
     balon.pause = false;
     System.out.println("Velocidad previa "+balon.speed);
     balon.movements.ball(balon);
     
    
    
    }
            
    public void foul(Agents ball)
    {
     try{
    ball.initialPosition(1);
    ball.sleep(2000);
    ball.movements.trhowBall(ball,BATTER,0,null);
    ball.sleep(100);
    ball.speed = 17;
    ball.pause = false;
    ball.movements.toFoulZone(ball,ball.movements.getCoordsFoul(ball));
     }
     catch(Exception e)
     {
     e.printStackTrace(); 
     }
    
    }
    
  public void changeOfTeam(Agents a)  
  {
      //
      try{
  ArrayList<Agents> ofensivos = new ArrayList<Agents>();   
  ArrayList<Agents> defensivos = new ArrayList<Agents>();   
  Agents.currentnumber = 0;
  Agents.waitLock = 1;
   
  // separamos en grupos a los ofensivos y a los defensivos
  for(Agents agente : a.players)
  {
  if(agente.rol.equals("Ball") || agente.rol.equals("controler"));
  else {
  if(agente.tipo.equals("ofensivo")) ofensivos.add(agente);
  else {
  defensivos.add(agente);
  }
  }
  
  }
  //ofensiva == batter
  int contador = 0;
  for(Agents ofensivo: ofensivos) {
      contador ++;
  ofensivo.tipo = "defensivo";
  switch(contador){
      case 1:{
      ofensivo.rol = "Pitcher";
      ofensivo.pointer = 9;
      ofensivo.initialPosition(1);
      }break;
       case 2:{
      ofensivo.rol = "Catcher";
      ofensivo.initialPosition(3);
      }break;
      case 3:{
      ofensivo.rol = "First Baseman";
      ofensivo.initialPosition(4);
      }break;
     case 4:{
      ofensivo.rol = "Second Baseman";
      ofensivo.initialPosition(5);
      }break;     
      case 5:{
      ofensivo.rol = "Third Baseman";
      ofensivo.initialPosition(6);
      }break;
      case 6:{
      ofensivo.rol = "Right Fielder";
      ofensivo.initialPosition(9);
      }break;
      case 7:{
      ofensivo.rol = "Left Fielder";
      ofensivo.initialPosition(7);
      }break;
     case 8:{
      ofensivo.rol = "Center Fielder";
      ofensivo.initialPosition(8);
      }break;
     case 9:{
      ofensivo.rol = "Short Stop";
      ofensivo.initialPosition(10);
      }break;
  
  
  }
  }
   for(int i = 0; i<Agents.rols.length;i++)
   {
       Agents.rols[i] = "";
   }
   int count = 0;
  for(Agents defensivo: defensivos) {
  count++;
  if(count == 1)
  {
  defensivo.tipo = "ofensivo";
  defensivo.rol = "Batter";
  defensivo.number  = Agents.currentnumber + 1;
  Agents.currentnumber++;
  defensivo.initialPosition(2);
  }
  else{
  Thread.sleep(2000);
  defensivo.tipo = "ofensivo";
  
  defensivo.destination = -3;
  
  defensivo.pun = 1;
  System.out.println("VAN: "+count+" y es "+defensivo.rol);
  }
  }
 
      }
      catch(Exception e){e.printStackTrace();}

  }
  
  
 
}