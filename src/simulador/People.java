package simulador;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Edy
 */
public class People extends Agents {

    int counterch = 0;
   LinkedList<Agents> e = new LinkedList<Agents>();

    LinkedList<Thread> t = new LinkedList<Thread>();
    Agents TempPeople;
    Thread thread;
    String srcImg;

  MonitorBands mb = new MonitorBands();
  ControlPanel cp;
  MonitorGeneral monitorg;
  public Agents Aball;
  
    public People(String classimage,  int posx, int posy,ControlPanel c) throws IOException {
      // super(classimage, posx, posy);
        cp = c;  
        int hm = 100;
        monitorg = new MonitorGeneral(18);
       
                 Aball = new Agents("img/Mguy"+1+".png", 0,0 ,monitorg,mb,"People"
                + ""+11111," ",1,cp);
                 Aball.rol="Ball";
                 Aball.permitActivity = true;
                 Aball.bControl = new BallControl();
                 Aball.initialPosition(1);
                 Aball.players.add(Aball);
                   this.addAgent(Aball);
                  iAgents.add(Aball);
                   
                   Agents tmp = new Agents("img/Mguy"+1+".png", 0,0 ,monitorg,mb,"People"
                + ""+11111," ",1,cp);
                   tmp.rol = "controler";
                   tmp.initialPosition(0);
                   tmp.permitActivity = true;
                   tmp.rules = new Rules();
                   
                   tmp.players.add(tmp);
                   iAgents.add(tmp);
                   this.addAgent(tmp);
        setPublic();
       
 System.out.println("PEOPLE CREATED ...");
    }
public People(){}
    /**
     * sets the enemy variables according to the stage
     *
     */

public void setPublic() throws IOException {
Random rnd = new Random();
int playersnumber = 18;
//System.out.println(cp);

 //int x1 =10;
boolean t1f=true,t2f=false;
System.out.println("Dato: "+playersnumber);
        for (int playercurrent = 0; playercurrent < playersnumber ; playercurrent++) {
         
                 Agents newagent = null;
                newagent = new Agents("img/Mguy"+1+".png", 100,220 ,monitorg,mb,"People"
                + ""+playercurrent," ",1,cp);
                newagent.ballAgent = Aball;
                newagent.rules = new Rules();

                if( playercurrent == 0){
                  newagent.rol = newagent.getRol( );
                  newagent.initialPosition(2);

                  newagent.team = 2;
                  newagent.permitActivity = true;
                  System.err.println("Creado "+newagent.rol+" Coordenadas: "+newagent.x+ " , "+newagent.y);
                } 
                if(playercurrent>=1 & playercurrent < 10){
                newagent.rol = newagent.getRol( );
                if(newagent.rol.equals("First Baseman")) newagent.initialPosition(4);
                if(newagent.rol.equals("Second Baseman")) newagent.initialPosition(5);
                if(newagent.rol.equals("Third Baseman")) newagent.initialPosition(6);
                if(newagent.rol.equals("Catcher")) newagent.initialPosition(3);
                if(newagent.rol.equals("Left Fielder")) newagent.initialPosition(7);
                if(newagent.rol.equals("Center Fielder")) newagent.initialPosition(8);
                if(newagent.rol.equals("Right Fielder")) newagent.initialPosition(9);
                if(newagent.rol.equals("Pitcher")) newagent.initialPosition(1);
                
                newagent.team = 1;
                
                }
                else{
                    
               if(playercurrent > 0){ newagent.team = 2;
               newagent.rol = "wait";
               newagent.initialPosition(1);}
                }
              
                
              
             newagent.permitActivity = true;
             newagent.move = "right";
             newagent.makeSprits();
             newagent.players.add(newagent);  
                     
            //agrego al jugador que se ha creado a la lista de agentes    
            this.addAgent(newagent);
        //    System.out.println("ADDED: "+players.get(playercurrent).rol);

                
        }
        
               
              
        /*
        n=number of integrants per band
        div = number of members per band
        */
        /*
        int b=3;
        int in=5;
       // int bands=50/div;
        int bands,integrants;
       bands = 10;
       integrants= 5;
  
         for (int x = 0; x < bands; x++) {
             for (int y=0;y<integrants;y++)
             this.addAgent(new Agents("img/Mguy4.png", 30,30 ,monitorg,mb,"artista"+y,"grupo"+y,2,cp));
         }
 */
    }

    /**
     * traverse the array of enemies and draws them one by one
     *
     * @param g variable paint of class drawn
     */

    public void draw(Graphics2D g) {
       
        for (int i = 0; i < e.size(); i++) {
            
            try{
            TempPeople = e.get(i);
            TempPeople.draw(g,e);}
            catch(Exception e)
            {
           e.printStackTrace();
            }
            
        }
    }

    /**
     * starts the threads of all players
     */
    public void setBehavior() {

        for (int i = 0; i < e.size(); i++) {

            thread = new Thread(e.get(i));
            thread.start();
          
        }

    }
    

    /**
     * adds one person to a linkedlist
     *
     * @param people the person we will add
     * @return
     */
    public People addAgent(Agents people) {
      //  people.setName("People: "+index);
        e.add(people);
        return this;
    }

    /**
     * removes one person to the linked list
     *
     * @param people the enemy to remove
     */
    
    public void removeAgent(Agents people) {
        e.remove(people);
    }

}
