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


public class Escenarios extends Movements{

  public  Strike strike = new Strike();
    /**
    @param a  variable Agents that represent the controler agents and it's for get and Access to the methods of Agents class
    */
    public void contactoPelota(Agents a)
    {
    //Some instances of Agents class for get an especific agents access
    Agents pitcher,batter,balon;
    // A boolean variable for generate a randomly movement for the ball for example if rDestinations is true the movement in 'X' will be more long. 
    boolean rDestionation;
    // Variables of X and Y coords randomly. 
    int rx,ry;
    pitcher = a.getAgent("Pitcher");
    batter  = a.getAgent("Batter");
    balon    = a.getAgent("Ball");
    
     trhowBall(balon,BATTER,10,null);
     
 
     
     ry = a.r.nextInt(60 - 30 ) + 30;
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
     
     batter.destination = 1;
     trhowBall(balon,PITCHER,11,nco);
     
     
    
    }
    public void bola(Agents a)
    {
    Agents pitcher,batter,balon;
    
  
     balon    = a.getAgent("Ball");
     balon.speed = 20;
     balon.pause = false;
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
      try{
  ArrayList<Agents> ofensivos = new ArrayList<Agents>();   
  ArrayList<Agents> defensivos = new ArrayList<Agents>();   
  //Recorro el arreglo de jugadores y los voy separando en ofensivos y defensivos

  for(Agents agente : a.players)
  {
  if(agente.tipo.equals("ofensivo")) ofensivos.add(agente);
  else defensivos.add(agente);
  }
   // ahora libero los roles de los que antes eran defensivos
  for(Agents defensivo: defensivos) 
  {   
      if(defensivo.rol.equals("Ball") || defensivo.rol.equals("controler"));
      else{
          System.out.println("Libere a "+defensivo.rol);
          defensivo.releaseRol(defensivo.rol);}
     
  }
  while(a.isEmptyRols()){ 
      System.out.println(a.isEmptyRols());
      a.sleep(1000);}
  // itero el arreglo de defensivos y les cambio el tipo
  for(Agents ofensivo : ofensivos) ofensivo.tipo = "defensivo";
  //itero el arreglo de ofensivos y los cambio por defensivos
  for(Agents defensivo: defensivos) defensivo.tipo = "ofensivo";
  
  // itero nuevamente los roles que antes eran defensivos para mandarlos a la zona de espera
  for(Agents defensivo: defensivos)  defensivo.destination = -3;
  
  
      }
      catch(Exception e){e.printStackTrace();}
  }
  
  
 
}