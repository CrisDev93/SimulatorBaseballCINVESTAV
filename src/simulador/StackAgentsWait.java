/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class StackAgentsWait extends MonitorGeneral implements Runnable {
    
    Thread t;
    MonitorGeneral mg;
    /*This constructor receive an Object of type MonitorGeneral and it do a new thread and run it*/
    public StackAgentsWait(MonitorGeneral tmp){
    t = new Thread(this);
    t.start();
    this.mg = tmp;
    }
    /*In the metodh run it compare if the buffer have a null space
     * if it's true it invoke to the metodh for add an agent from the MonitorGeneral class
     */
    public void run()
    {
     
    }
    
    
    
}
