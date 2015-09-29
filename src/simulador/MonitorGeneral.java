/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Cristian
 */

public class MonitorGeneral {
    public int transition=0;
    public int inter = 0;
    Stack<Agents> waiting = new Stack<Agents>();
    ArrayList teams = new ArrayList();
   
    Agents bufferagents[];
 
    private boolean flagenter = false;
    int c = 0;
    StackAgentsWait verify;
    Semaphore semaphore;
    BathroomMonitor bm;
    DrinksMonitor dm;
    MerchMonitor mm;
    Concert concert;
    int waitingagents=0; 
    public boolean flagconcert = true;
    public MonitorGeneral() {
    }
    /*It's constructor receive the size of the general buffer*/
      
    
    
    public MonitorGeneral(int sizebuffer) {
        bufferagents = new Agents[sizebuffer];
        //   System.out.println("Aquí wey: "+bufferagents);
        verify = new StackAgentsWait(this);
       
//        cp.setVisible(true);
        NULLSField();
        bm = new BathroomMonitor(90);
        dm = new DrinksMonitor(100);
        mm = new MerchMonitor(100);
        concert = new Concert();
        semaphore = new Semaphore(sizebuffer);
    }

    private void NULLSField() {
        for (int i = 0; i < bufferagents.length; i++) {
            bufferagents[i] = null;
        }

    }
    
    
    
    /*This method add agents to the buffer of Agents
     it's do an iteration to the buffer and if it's have a null space asign this agent to the space
     if else the agents is add to a Stack to be in wait mode*/

    public void addAgents(Agents a) {
        try {
            waitingagents++;
            
            semaphore.acquire();
           
            inter++;
           
            waitingagents--;
           
                
            for (int i = 0; i < bufferagents.length; i++) {
                
                if (bufferagents[i] == null) {
                    bufferagents[i] = a;
                    flagenter = true;
                  //  System.out.println("La persona: " + a.name + "ha entrado al concierto");
                    Activity activity = new Activity();
                    
                    activity.selectingActivity(bufferagents[i],bm,dm,mm,concert);
                    bufferagents[i] = null;
                    inter--; 
                    semaphore.release();

                   
                   // System.out.println(waitingagents);
                   //cp.outc.setText("see");
                    break;
                } else {
                    flagenter = false;
                }

            }
        } catch (Exception e) {
        }
    }

}
