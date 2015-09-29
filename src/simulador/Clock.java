/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edy
 */
public class Clock implements Runnable{

    public int Horas;
    public int Minutos;
    public int Segundos;
    public int CustomClock;

    public Clock() {
        Horas = 0;
        Minutos = 0;
        Segundos = 0;
    }

    public void clockBehavior(int kindofClock,int h,int m,int s) {
        switch (kindofClock) {
            case 1: {
                if (this.Segundos > 59) {
                    this.Segundos = 0;
                    this.Minutos = this.Minutos + 1;
                }
                if (this.Minutos > 59) {
                    this.Minutos = 0;
                    this.Horas = this.Horas + 1;
                }
                if (this.Horas > 23) {
                    this.Horas = 0;

                }
                break;
            }
            case 2: {
                if (this.Segundos > s) {
                    this.Segundos = 0;
                    this.Minutos = this.Minutos + 1;
                }
                if (this.Minutos > m) {
                    this.Minutos = 0;
                    this.Horas = this.Horas + 1;
                }
                if (this.Horas > h) {
                    this.Horas = 0;

                }
                break;
            }
        }

    }

    public int getHoras() {
        return Horas;
    }

    public void setConfiguration(int Horas) {
        this.CustomClock = Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }

    public int getMinutos() {
        return Minutos;
    }

    public void setMinutos(int Minutos) {
        this.Minutos = Minutos;
    }

    public int getSegundos() {
        return Segundos;
    }

    public void setSegundos(int Segundos) {
        this.Segundos = Segundos;
    }

    public String getTime(){
        String hour;
        hour=this.Horas+":"+this.Minutos+":"+this.Segundos;
        return hour;
    }
    @Override
    public void run() {
       while (true){
       
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
           }
           this.Segundos=this.Segundos+1;
           clockBehavior(1,1,1,1);
      
    }
    }
}
