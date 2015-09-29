/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Cristian
 */
public class MonitorBands {
    
    int nband=0;

    Activity activity;
    public MonitorBands()
    {

    activity = new Activity();
    }
    public void addBands(Agents a)
    {
    activity.activityBand(a);
      
    }
    
    
    
    
}
