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
    
    
    public void ball(Agents a)
    {
    Agents pitcher,catcher,batter,ball;
    
    pitcher = a.getAgent("Pitcher");
    catcher = a.getAgent("Catcher");
    batter  = a.getAgent("Batter");
    ball    = a.getAgent("Ball");
    
     ball.speed = 20;
     System.out.println(" ROL : " + a.rol);
     ball(ball);
     trhowBall(ball,BATTER,10);
     trhowBall(ball,PITCHER,0);
     Agents ba = getBestAgent(ball);
     ba.speed = 30;
     ba.move ="down";
     toBall(ba);
     trhowBall(ball,FIRSTBASEMAN,0);
     
    
    
    }
            
    
    
}
