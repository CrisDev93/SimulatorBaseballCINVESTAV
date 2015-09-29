
import java.util.Stack;
import java.util.concurrent.Semaphore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian
 */
public class PruebaThreadGroup implements Runnable{
     ThreadGroup grupo = new ThreadGroup("MyGroup");
    Semaphore s = new Semaphore(5);
    
    Stack<ThreadGroup> grupos = new Stack<ThreadGroup>();
    public void run()
    {
        
    if(true);
   
    }
    
    public void makeGrup(int nbands,int integrants)
    {
    for(int i=0;i<nbands;i++)
    {
     
    for(int j=0;i<integrants;j++)
        {
            Thread tmp=null;
           tmp = new Thread(this);
           tmp.setName("grupo"+i);
           tmp.start();
        }
    }
        
    
    }
    public static void main(String args[])
    {
   
    
    }
    
}
