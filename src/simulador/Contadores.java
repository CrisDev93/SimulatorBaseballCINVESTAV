/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

/**
 *
 * @author Edy
 */
public class Contadores {

    public int inConcert;
    public int inBathroom;
    public int inDrinks;
    public int inSouvenirs;
    public int staffRoom;

    public int concertQueue;
    public int BathroomQueue;
    public int DrinksQueue;
    public int SouvenirQueue;
    public int Singing;

    public Contadores() {
    init();
    }

    public final void init() {
        inConcert = 0;
        inBathroom = 0;
        inDrinks = 0;
        inSouvenirs = 0;
        staffRoom = 0;

        concertQueue = 0;
        BathroomQueue = 0;
        DrinksQueue = 0;
        SouvenirQueue = 0;
        Singing = 0;
    }
    
    
}
