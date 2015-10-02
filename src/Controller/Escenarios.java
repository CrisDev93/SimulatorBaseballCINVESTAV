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
    
    public void contactoPelota(Agents a)
    {
     
    Agents pitcher,batter,balon;
    
    pitcher = a.getAgent("Pitcher");
    
    batter  = a.getAgent("Batter");
    balon    = a.getAgent("Ball");
    
    trhowBall(balon,BATTER,10,null);
     batter.destination = 1;
     int ry = a.r.nextInt(60 - 30 ) + 30;
     int rx = a.r.nextInt(40 - 10 )+ 10;
     boolean sor = a.r.nextBoolean();
     
     System.out.println(sor);
     int [] nco;
     if (sor)
     {
     int [] ncot = {PITCHER[0]  + rx,(PITCHER[1] - ry)};
     nco = ncot;
     }
     else {
     int [] ncot = {PITCHER[0] - rx,(PITCHER[1] - ry)};
     nco = ncot;
     }
     
     trhowBall(balon,PITCHER,11,nco);
     
    //batter.movements.toFirstBase(batter);
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
