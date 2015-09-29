/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crisg
 */
public class ThreadOperations implements Runnable {
  static int inside = 1;
    static boolean alive = true;
  
    public int id;
    TableOperations log;

    ThreadOperations(TableOperations cs, int i) {
        log = cs;
        id = i;
    }

    @Override
    public void run(){
        while (alive) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
           log.DeadThread(this);
        }
       
    }

    public void stopThread() {
        alive = false;
    }

}
