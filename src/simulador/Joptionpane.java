package simulador;

import java.util.Timer;
import java.util.TimerTask;

public class Joptionpane extends javax.swing.JFrame {    
    
    public Joptionpane( String p) {        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("JOptionPane");
        PREGUNTA.setText(p);
        
        Comenzar_a_contar();       
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PREGUNTA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PREGUNTA.setText("Abriendo Panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(PREGUNTA)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(PREGUNTA)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void time_is_over(){ 
        this.dispose();//cierra ventana
    }
    
    public void Comenzar_a_contar() { 
           tiempo = new Timer();
           task = new TimerTask() {               
               int contador=0;
               public void run() {
                   contador++;
                   if(contador == duracion){                         
                        time_is_over();                     
                   }
               }                      
           };             
           tiempo.schedule(task,0,1000);            
    }
    

    private Timer tiempo ;
    private TimerTask task;
    private int duracion=3;    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PREGUNTA;
    // End of variables declaration//GEN-END:variables
  
}
