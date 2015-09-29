/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

/**
 *
 * @author Cristian Michel
 */
public class BallControl extends Agents {
    public int paso=1;
    private boolean sumarx = false;
    private boolean restarx = false;
    private boolean sumary = false;
    private boolean restary = false; 
    public boolean moving = true;
    public void moveLocation(int xold,int yold,int xnew,int ynew,Agents age){
    
        sumarx = false;
        sumary = false;
        restarx = false;
        restary = false;
        if(xnew<xold) restarx = true;
        else sumarx = true;
        if(ynew<yold)restary = true;
        else sumary=true;
        
       while(moving){
           try{
         age.nextStack = false;      
          Thread.sleep(20);
        //  System.out.println("Actual x : "+age.x+" Meta  x -> "+xnew);
         // System.out.println("Actual y : "+age.y+" Meta  x -> "+ynew);
      //  System.out.println("NOW CURRENT :"+age.rulecurrent);
       if(age.x == xnew && age.y == ynew ){ moving = false; age.nextStack = true;age.rulecurrent = "";} //System.out.println("IT'S DONE ");break;}
       else {
       if(sumarx & (age.x < xold)) age.x++;
       if(restarx & (age.x > xnew)) age.x--;
       if(sumary & (age.y < ynew)) age.y++;
       if(restary & (age.y > ynew)) age.y--;
       
       }
          
           
           
       
       }
              catch(Exception e) {
              e.printStackTrace();
              }

       
       }
System.out.println(moving);       
    
    
    }
    
public void makeaMovement(Agents a)
{
if(paso == 0){}
if(paso == 1){
int prob = a.r.nextInt(10 + 0) + 0;
if(prob>7){ moveLocation(a.x,a.y,a.BATTER[0],BATTER[1],a);System.out.println(true); }
else{
moveLocation(a.x,a.y,a.BATTER[0],(BATTER[1] +30 ),a);
}
}
if(paso == 2){}

}
    
}
