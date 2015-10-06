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

/**
 *
 * @author Cristian Michel
 */
public class Escenarios extends Movements{
    
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
     
     batter.destination = 1;
     
     ry = a.r.nextInt(60 - 30 ) + 30;
     rx = a.r.nextInt(40 - 10 )+ 10;
     
     rDestionation = a.r.nextBoolean();
     
     System.out.println(rDestionation);
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
     trhowBall(balon,PITCHER,11,nco);
     
     Agents ba = getBestAgent(balon);
     ba.speed = batter.speed * 2;
     ba.move ="down";
     toBall(ba);
     trhowBall(balon,FIRSTBASEMAN,0,null);
     
    
    }
    public void bola(Agents a)
    {
    Agents pitcher,batter,balon;
    
    pitcher = a.getAgent("Pitcher");
    
    batter  = a.getAgent("Batter");
    balon    = a.getAgent("Ball");
     balon.speed = 20;
     balon.movements.ball(balon);
     
    
    
    }
            
    
    
}
