package simulador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Drawn extends JPanel implements ActionListener {

    private Player1 Player_1;
    public static Labels stamp;
    public People hatchery;
    private Timer timer;
    public static Clock clock;
    public BackgroundImages escenery;

    private Agents getIndicator;
    ImageIcon fondo;
    String pantalla;
    ControlPanel cp;

    /**
     * increases player's score
     *
     * @param nombre src of the stage image
     * @param stage identifier to choose a stage
     */
    public Drawn(String nombre) throws IOException {
        this.pantalla = nombre;
        setFocusable(true);
      //  this.cp = cpr;
        System.out.println("here: "+cp);
        stamp = new Labels(this);
        hatchery = new People("img/1grupo.jpg", 100, 150,cp);
        timer = new Timer(10, this);
        clock = new Clock();
        hatchery.setBehavior();
        addKeyListener(new teclado());
        Player_1 = new Player1("img/2grupos.png", 150, 529, 339);
        escenery = new BackgroundImages();
        timer.start();
                Thread t1 = new Thread(clock);
        t1.start();
        
        
    }
    

    public void paint(Graphics graphs) {

        Dimension tamanio = getSize();
        fondo = new ImageIcon(getClass().getResource(pantalla));

        Graphics2D g2 = (Graphics2D) graphs;
        graphs.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);

        setOpaque(false);
       // escenery.Imagepaint(g2);
        g2.drawImage(Player_1.getImage(), Player_1.getX(), Player_1.getY(), null);
        
        
        
        stamp.drawNumber(g2, hatchery.monitorg.waitingagents, 45, 210);
        /*
        stamp.drawLetters(g2, 25, "merchandise", 150, 53);
        stamp.drawLetters(g2, 20, "IN", 150, 70);
        stamp.drawLetters(g2, 20, "OUT", 195, 70);
        stamp.drawNumber(g2, hatchery.monitorg.mm.countm, 150, 90);
        stamp.drawNumber(g2, hatchery.monitorg.mm.waitingmerch, 195, 90);
        stamp.drawLetters(g2, 25, "drinks", 550, 53);
        stamp.drawLetters(g2, 20, "IN", 550, 70);
        stamp.drawLetters(g2, 20, "OUT", 595, 70);
        stamp.drawNumber(g2, hatchery.monitorg.dm.countd, 550, 90);
         stamp.drawNumber(g2, hatchery.monitorg.dm.waitingdrinks, 595, 90);
        stamp.drawNumber(g2, hatchery.monitorg.concert.howmany, 300, 350);
        stamp.drawNumber(g2, 4, 800, 350);
        stamp.drawLetters(g2, 25, "bathroom", 140, 300);
        stamp.drawLetters(g2, 20, "IN", 140, 320);
        stamp.drawLetters(g2, 20, "OUT", 195, 320);
        stamp.drawNumber(g2, hatchery.monitorg.bm.countb, 140, 340);
         stamp.drawNumber(g2, hatchery.monitorg.bm.waitingbathroom, 195, 340);
        stamp.drawNumber(g2, hatchery.mb.activity.waitingcamerino, 920, 310);
    
        stamp.drawLetters(g2, 20, "Transition:", 750, 161);
        stamp.drawNumber(g2, hatchery.monitorg.transition, 890, 161);
        
         stamp.drawLetters(g2, 20, "Left:", 460, 539);
        stamp.drawNumber(g2, hatchery.leftconcert, 520, 539);
        */
        hatchery.draw(g2);
        
        // clock paint
        //stamp.drawNumber(g2, clock.Horas, 720, 53);
        //stamp.drawNumber(g2, clock.Minutos, 760, 53);
        //stamp.drawNumber(g2, clock.Segundos, 800, 53);
        
      
        super.paint(graphs);
    }

    /**
     * repaints the panel with a timer to update the window also creates the
     * threads of the applications for example the players and enemies
     */
    public void actionPerformed(ActionEvent e) {
        Thread t = new Thread(Player_1);
        t.start();
        

       //hatchery.update();

        repaint();

    }
      

    private class teclado extends KeyAdapter {

        public synchronized void keyReleased(KeyEvent e) {
            Player_1.keyReleased(e);

        }

        public synchronized void keyPressed(KeyEvent e) {
            Player_1.keyPressed(e);

        }
    }

}
