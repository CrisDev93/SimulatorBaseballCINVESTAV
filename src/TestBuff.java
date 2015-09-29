import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class TestBuff extends Component {

    BufferedImage img;
    BufferedImage img2;
    BufferedImage bigImg;
    BufferedImage[] sprites;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
       //g.drawImage(img2, 18, 0, null); //letter size 20x20 ; set lower to overlap
        g.drawImage(sprites[0], 36, 0, null); //this is whats causing the error

    }

    public TestBuff() {
       try {
           img = ImageIO.read(new File("src/simulador/img/equipo1.png"));
           img2 = ImageIO.read(new File("src/simulador/img/equipo2.png"));



           /////////////////////////////


        bigImg = ImageIO.read(new File("src/simulador/img/equipo1.png"));


        final int width = 20;
        final int height = 20;
        final int rows = 5;
        final int cols = 5;
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

        sprites[0] = bigImg.getSubimage(1,1,1,1); //where I tried to define the array myself

           /////////////////////////////////////////////


       } catch (IOException e) {
       }

    }

    public Dimension getPreferredSize() { //sets size of screen
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null)); //sets size to one image //// change to all images
       }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Load Image Sample");

        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        f.add(new TestBuff());
        f.pack();
        f.setVisible(true);
    }
}