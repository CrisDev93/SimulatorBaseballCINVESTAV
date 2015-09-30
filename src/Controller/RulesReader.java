/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Agents;
import java.io.File;
import java.util.Stack;

/**
 *
 * @author Cristian Michel
 */
public class RulesReader extends Agents{
    
    
    
    
    public void reader(Agents a)
    {
        
        String rulel = a.rules.getRule();
    if(a.nextStack)a.rulecurrent = a.rules.getRule();
      if(rulel.equals("") == false){
          System.out.println("CURRENT : "+a.rulecurrent);
      
      Stack ru = a.getActualRule(a.rulecurrent);
      System.out.println("REGLA ACTUAL : "+a.rulecurrent);
      String ele =(String) ru.firstElement();
      Agents tmp = a.getAgent((String)ele);
      System.out.println("------->"+ele+tmp);
      if(tmp.inMovement == false){
      if(tmp.rol.equals("Ball")){
      int [] cords = getCoords((String) ru.get(1));
      int xn,yn;
      if(ru.get(2).equals("1")){ 
     
      xn = cords[0];
      yn = cords[1] ;
           
      }
      else {
      xn = cords[0];
      yn = cords[1];
      
      }
      System.out.println(xn+","+yn);
      tmp.bControl.moveLocation(tmp.x, tmp.y, xn, yn, tmp);
      }
      else a.destination = 1;
      }
      
     
    }
      a.ballflag = true;
    }
    
    
    
    
    
    
 public int [] getCoords(String location){
     System.out.println(location+"X");
     if(location.endsWith("Pitcher")) return PITCHER;
     if(location.endsWith("Batter")) return BATTER;
     if(location.endsWith("Catcher")) return CATCHER;
     if(location.endsWith("First Baseman")) return FIRSTBASEMAN;
     if(location.endsWith("Second Baseman")) return SECONDBASEMAN;
     if(location.endsWith("Third Baseman")) return THIRDBASEMAN;
     if(location.endsWith("Left Fielder")) return LEFTFIELDER;
     if(location.endsWith("Center Fielder")) return CENTERFIELDER;
     if(location.endsWith("Right Fielder")) return RIGHTFIELDER;
     if(location.endsWith("Ball")) return BATTER;
 return BATTER;
 }
}
