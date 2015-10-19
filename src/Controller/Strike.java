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
public class Strike extends Movements {
    
    public void makeAStrike(Agents batter)
    {
    Agents ball = batter.getAgent("Ball");
    ball.initialPosition(1);
    ball.speed = 20;
    ball.movements.trhowBall(ball,null, 2, null);
    
    
    }
    
    
    
    
    
}
