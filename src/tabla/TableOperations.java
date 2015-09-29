/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tabla;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Crisg
 */
public class TableOperations {

    public JTable table;
    public ArrayList<ThreadOperations> Tarray;
   public  int acceses;
    TableOperations(JTable setTable) {
        acceses=0;
        table = setTable;
        
        
    }

    
    
    public void OutOfSc(ThreadOperations hilo) {
       
      //  table.setValueAt(" ", hilo.id, 1);
        table.setValueAt(" ", hilo.id, 1);
     
    }
    public void DeadThread(ThreadOperations hilo){
       // table.setValueAt(" ", hilo.id, 1);
        table.setValueAt(" muerto", hilo.id, 1);
      
    }
    
    public void DeadThread(reader hilo){
       // table.setValueAt(" ", hilo.id, 1);
        table.setValueAt(" muerto", hilo.id, 1);
      
    }
   
   
    
}
