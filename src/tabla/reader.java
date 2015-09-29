/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import simulador.Agents;
import simulador.Joptionpane;

/**
 *
 * @author Edy
 */
public class reader extends Agents implements Runnable {
  public boolean living = true;
  
    public int id;
    TableOperations log;
    public  String strLine;
    public  String container;
    public  String name;
    public  String alive;
        public  int file;

    public reader(int file) throws IOException {
         this.file=file;
    }
    
    public reader(TableOperations cs, int i) throws IOException{
        log = cs;
        id = i;
        this.file=i;
    }
    
public  void readFromfile(int file){
            
        
        try {
           
            while (true) {
                 FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "\\procesos\\people"+file+".txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                
                strLine = br.readLine();
                 
     
               StringTokenizer st = new StringTokenizer(strLine);
               name=st.nextToken();
               alive=st.nextToken();
               if(alive.equals("10")){
                      log.DeadThread(this);
               }
                if(alive.equals("100")){
                    System.out.println("it worked up this time ----------------------------------");
                    new Joptionpane("hola").show();    
               }
                System.out.println(name+" "+alive);
             br.close();
                    Thread.sleep(500);
            }
         
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        
    }
    
     public static void main(String args[]) throws IOException{
         
        reader hot = new reader(0);
        reader hot1 = new reader(1);
        reader hot2 = new reader(2);
        Thread thread = new Thread(hot);
            thread.start();
             thread = new Thread(hot1);
            thread.start();
             thread = new Thread(hot2);
            thread.start();
        
        
        
    }    

    public reader() throws IOException {
    }

    @Override
    public void run() {
    //readFromfile(file);
    }

   
}
