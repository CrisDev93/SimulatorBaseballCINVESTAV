/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.MonitorGeneral;
/**
 *
 * @author Cristian
 */
public class Activity extends MonitorGeneral {

    int time = 0;
    int flagfirst = 0;
    int waitingcamerino = 0;
    Random random = new Random();
    int v = 0;
   // BathroomMonitor bm;
   // DrinksMonitor dm;
   // MerchMonitor mm;
    int numband = 0;
    int numart = 0;
    Integer ntotal   = 0;
    Concert concert;
    Semaphore s;
    static int timetotal = 0;
    static boolean local = true;
    /*In this method it select a random number, this random number is for select an activity to do*/

    public void selectingActivity(Agents a, Concert concert) {
      //  this.bm = b;
   //     this.dm = dm;
    //    this.mm = mm;
        this.concert = concert;
        
        try {
            int al = 0;
               //System.out.println("Soy : "+a.name);
               while (al < 4 & local & a.permitActivity) {
                {
             //       System.out.println(" Hola soy : "+a.rol);
                 //   int option = random.nextInt(4) + 1;
                   int option = 1;
 
                    int time = random.nextInt(10) + 1;
    //option = 1;
                    // System.out.println("Acá: "+option);
                    switch (option) {

                        case 1:
                            
                            this.concert.ListeningConcert(a, time, 4);

                            break;
                        case 2: {
                  //          bm.enterBathroom(a, 3);

                        }
                        ;

                        break;
                        case 3:
                    //        dm.enterDrinksArea(a, 1);
                            break;
                        case 4:
                      //      mm.enterMerchArea(a, 2);
                            break;

                    }
                    // System.out.println("Realizaré otra actividad");
                    al++;
                }
            }
            
      //     else {System.out.println("Soy el agente :"+a.name);}

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void activityBand(Agents a) {
        camerino(a);

    }

    public void camerino(Agents a) {
        int timeconcert = 10 * 20;
        int timetostart = 10;
        try {
            s = new Semaphore(10);
            waitingcamerino++;
        //    a.chooseLocation(5);
            try {
                Thread.sleep(10 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            s.acquire();

            stage(a);
            s.release();
            waitingcamerino--;

            //  System.out.println(timeconcert+" & "+ timetotal);
            if (timetotal == timeconcert) {

                flagconcert = false;
                local = false;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stage(Agents a) {
        timetotal++;
        // System.out.println("La banda "+a.band + " está en el escenario");
        try {
            flagfirst++;
          // a.chooseLocation(2);
            Thread.sleep(10* 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
