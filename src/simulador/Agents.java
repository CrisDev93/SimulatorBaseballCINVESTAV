package simulador;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Edy
 */
public class Agents implements Runnable {
       public static ArrayList<Agents> players = new ArrayList<Agents>();

    public  int leftconcert =0,inconcert,ALocation,dx,dy,x,y,type=0,team,pointer=0,destination=0;
    public boolean pause,flag = false,alive,permitActivity,flagmove = false,turn = false,evento = false,nextStack=true,inMovement = false,ballflag = false;
    private Image image;
    String filename = "img/rguy3";
    public ArrayList travel;
    MonitorGeneral m;
    MonitorBands mb;
    public String name,rol,band,move="";
    Random r = new Random();
    LinkedList<Agents> e = new LinkedList<Agents>();
    ArrayList iAgents = new ArrayList();

    ControlPanel cp;
    static String [] rols = {"Batter","Pitcher","Catcher","First Baseman","Second Baseman","Third Baseman","Short Stop","Left Fielder","Center Fielder","Right Fielder"};
    BufferedImage img,bigImg; 
    BufferedImage[] sprites;
    Image ball;
    public BallControl bControl;
    public static Agents ballAgent;
    public static Rules rules;
    public static String rulecurrent="";
    public static int[] PITCHER = {523,475},CATCHER={515,545},BATTER={515,525},FIRSTBASEMAN={640,460},SECONDBASEMAN={527,400},
            THIRDBASEMAN={403,465},SHORTSTOP,LEFTFIELDER={351,334},CENTERFIELDER={515,313},RIGHTFIELDER={687,323};
 //PITCHER = {523,475};
    public static RulesReader rr = new RulesReader();
    public Movements movements = new Movements();
    int speed = 0;
    public Agents() {   

    }

    /**
     * class constructor initializes some variables
     *
     * @param classimage the image going to be used
     * @param posx initial potition the sprite on x
     * @param posy initial potition the sprite on y
     * @param mon
     * @param mb
     * @param name
     * @param band
     * @param type
     * @param cp
     *
     */
    //MonitorGeneral m;
    public Agents(String classimage, int posx, int posy, MonitorGeneral mon, MonitorBands mb, String name, String band, int type,ControlPanel cp) {
        try{
        inconcert = 0;
        alive = true;
     //   flag = true;
        
        pause = false;
        this.name = name;
        
        ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(classimage));
        image = imgIcon.getImage();
        this.m = mon;
        travel = new ArrayList();
        this.type = type;
        this.mb = mb;
        this.band = band;
        this.cp = cp;
         ball = ImageIO.read(new File("src/simulador/img/ball.png"));
         
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
        
        
        
        
    }
    public void makeSprits()
    {
        try{
            
        if(this.team==1)bigImg = ImageIO.read(new File("src/simulador/img/equipo1Bat.png"));
        if(this.team==2)bigImg = ImageIO.read(new File("src/simulador/img/equipo2Bat.png"));
      
       //  System.err.print("EQUIPO : "+this.team);
         
final int width = bigImg.getWidth()/12;
final int height = bigImg.getHeight()/8;
final int rows = 4;
final int cols = 3;
sprites = new BufferedImage[rows * cols];

for (int i = 0; i < rows; i++)
{
    for (int j = 0; j < cols; j++)
    {
        sprites[(i * cols) + j] = bigImg.getSubimage(
            j * width,
            i * height,
            width,
            height
        );
    }
}   
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
    public String getRol(){
    synchronized(rols){
    for(int i = 0; i<rols.length;i++)
    {
    if(rols[i] != null){
    String rtmp = rols[i];
    rols[i] = null;
    return rtmp;
    }
    }
    return "wait";
    }
    }
    
    public void releaseRol(String rol){
    synchronized(rols){
    for (int i=0;i<rols.length;i++){
    if(rols[i] == null){
    rols[i] = rol;
    break;
    }
    
    }
    
    }
    
    }
    /**
     * checks if the enemy is still alive
     *
     * @return boolean variable alive
     */
    public boolean getAlive() {
        return this.alive;

    }

      /**
     * puts variable alive to false to kill someone
     */
    

    public void kill() {
        this.alive = false;
    }

    

 
    public void draw(Graphics2D g, LinkedList f) throws InterruptedException {
      Thread.sleep(5);
    //    System.out.println("Column: "+pointer+ " Row: "+row);
    //    System.out.println("I'm drawing" + this.rol);
        if(move.equals("up")  ){
            if(this.flagmove ){
                pointer++;
                  if(pointer > 8) pointer = 6;
              //  if (pointer > 3) pointer = 0;
                 
                g.drawImage(this.sprites[pointer], x, y, null);
            }
            else  g.drawImage(this.sprites[1], x, y, null);

               
        }
         if(move.equals("down")){
             if(this.flagmove){
                pointer++;
                if(pointer >11) pointer = 9;
              
                g.drawImage(this.sprites[pointer], x, y, null);
             }
             else  g.drawImage(this.sprites[1], x, y, null);

        }
         if(move.equals("left")){
             if(this.flagmove){
                pointer++;
                if(pointer >5) pointer = 3;
            
                g.drawImage(this.sprites[pointer], x, y, null);
             }
             else  g.drawImage(this.sprites[1], x, y, null);
        }
          if(move.equals("right")) {
                 if(this.flagmove){
                pointer++;
                  if(pointer > 8) pointer = 6;
              //  if (pointer > 3) pointer = 0;
                 try{
                g.drawImage(this.sprites[pointer], x, y, null);
                 }
                 catch(Exception e){System.err.println(rol+" No tiene sprite");}
             //   System.out.println(x+","+y);
            }  
           else { g.drawImage(this.sprites[1], x, y, null);
                }
                 
        }

          if(this.rol.equals("wait")){
          g.drawImage(this.sprites[1], x, y, null);
     //     System.out.println("Voy a dibujar a : "+rol+" en ->"+x+","+y);
          }
          if(this.rol.endsWith("Fielder")){
          g.drawImage(this.sprites[1], x, y, null);
          
          }
          if(this.rol.equals("Ball")){g.drawImage(this.ball, x, y, null);}
          if(this.rol.equals("Catcher")) g.drawImage(this.sprites[pointer], x, y, null);
          //if(this.rol.equals("Batter")) g.drawImage(this.sprites[this.pointer], x, y, null);
          if(this.rol.equals("First Baseman")) g.drawImage(this.sprites[this.pointer], x, y, null);
          
        this.e = f;
                //  System.out.println("Voy a dibujar a : "+rol+" en ->"+x+","+y);

    }

    /**
     * just in case used to check collitions
     *
     * @return the rectangle of the image
     */
    

    @Override
    public void run() {
        if (this.type == 1) {
            m.addAgents(this);
        }
        if (this.type == 2) {
            mb.addBands(this);
        }
    //    System.out.println("The people: " + this.name + " has left the concert");

        //e.remove(this);
        
      //  System.out.println(this.name);
        this.writeInfile(this.name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Agents.class.getName()).log(Level.SEVERE, null, ex);
        }
      //          communicationC(this.name);

        this.kill();
        leftconcert++;
        //new Joptionpane(this.travelprint()).show();
//  JOptionPane.showMessageDialog(null, travelprint());

    }

    /**
     * updates the enemy with random movement
     *
     */
    public Agents getAgent(String rol){
       
    for(Agents ag: players){
    
    if(ag.rol.equals(rol)) return ag;
    }
    return null;
    }
    public  void communicationC(String file){
          try {
           
          
                 FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "\\procesos\\"+file+".txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                
              String strLine = br.readLine();
                 
     
               StringTokenizer st = new StringTokenizer(strLine);
              
               String sFlag=st.nextToken();
               
              
          //      System.out.println(name+" "+alive);
             br.close();
                    Thread.sleep(100);
            
         
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        
    }

    public void initialPosition(int location) {
       // System.out.println("ASGINADOOOOOOOOOOOOO "+rol);
          if (location == 1)  {this.x = PITCHER[0]; this.y = PITCHER[1];}
          if (location == 2 ) {this.x = BATTER[0]; this.y = BATTER[1];}
          if (location == 3 ) {this.x = CATCHER[0]; this.y = CATCHER[1];}
          if(location == 4)   {this.x = FIRSTBASEMAN[0];  this.y=FIRSTBASEMAN[1];}
          if(location == 5)   {this.x = SECONDBASEMAN[0];  this.y=SECONDBASEMAN[1];}
          if(location == 6)   {this.x= THIRDBASEMAN[0]; this.y = THIRDBASEMAN[1];}
          if(location == 7)   {this.x= LEFTFIELDER[0]; this.y = LEFTFIELDER[1];}
          if(location == 8)   {this.x= CENTERFIELDER[0]; this.y = CENTERFIELDER[1];} 
          if(location == 9)   {this.x= RIGHTFIELDER[0]; this.y =  RIGHTFIELDER[1];}
          
        
     
        if(this.rol.equals("wait")){
        this.y = r.nextInt(219 - 163 ) + 163;
        this.x = r.nextInt(1057 - 873) + 873;
       
        }
        

        
        
        
    }
 
 public Stack getActualRule(String ru)
 {
  String tmp = "";   
  Stack rul = new Stack();
for(int i = 0; i< ru.length();i++){
if(ru.charAt(i) == '|' ){rul.add(tmp);tmp = ""; }
else {
tmp = tmp + ru.charAt(i);
}

}     
     
 return rul;
 }
public void moveAgents(int destinationl,int cont) throws InterruptedException {
    if(!(this.rol.equals("wait") || this.rol.equals("Ball") || this.rol.equals("controler"))){
    int opc = 0;
    if(opc == 1) movements.toFirstBase(this);
    if(opc == 2) movements.toSecondBase(this);
    if(opc == 3) movements.toThirdBase(this);
    if(opc == 4) movements.toHome(this);
    if(opc == 5) movements.toBall(this);
    
    Agents bt = this.getAgent("Ball");
   // System.out.println("BALL OBJECT: "+bt);
    
    }
    if(this.rol.equals("controler"))
    {
        System.out.println(this.rules.rulesFilter.get(0).player);
    }
        Agents bt = this.getAgent("Ball");
     //this.getAgent("controller").flag = true;
     if(this.rol.equals("controler"))
      {
      bt.speed = 20;
      System.out.println(" ROL : " + this.rol);
     this.movements.ball(bt);
     this.movements.trhowBall(bt,BATTER,10);
     this.movements.trhowBall(bt,PITCHER,0);
     Agents ba = movements.getBestAgent(bt);
     ba.speed = 30;
     ba.move ="down";
     this.movements.toBall(ba);
     this.movements.trhowBall(bt,FIRSTBASEMAN,0);
     
      }
    
    if(this.rol.equals("Batter") && this.flag)
    {
    this.speed = 140; 
    this.movements.toFirstBase(this);
    this.flag = false;
    }
    
    }
 public void multiplePaths(int current, int destiny,int cont) throws InterruptedException {
        switch (current) {
           
            case 4: {
                this.moveAgents(destiny,cont);
                break;
            }
        }
    }
 public void writeInfile(String archivo){
     //try {
    //       FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\procesos\\"+archivo+".txt"); 
      // Writes the content to the file
     // writer.write(archivo+" 10"); 
     // writer.flush();
      //writer.close();
         
		
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
 //}
 
 }
}
 