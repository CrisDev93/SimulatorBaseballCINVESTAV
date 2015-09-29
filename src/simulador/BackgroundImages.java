/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Edy
 */

public class BackgroundImages {
public BufferedImage souvenir,souvenir1,souvenir2,logo,barril,baño,bateria,charco,graf,charco2;
public BufferedImage graf1,boci,bateria2,guitarra1,micro,sofa,table,plant,sofa1,drink,drink1,title,table1;
public BufferedImage auto,auto1;

public BackgroundImages(){
    Imageloading();
}
public void Imageloading(){
    try{
            souvenir = ImageIO.read(new File("src/simulador/img/sub1.png"));
            souvenir1 = ImageIO.read(new File("src/simulador/img/sub2.png"));
            souvenir2 = ImageIO.read(new File("src/simulador/img/sub3.png"));
            baño = ImageIO.read(new File("src/simulador/img/baño1.png"));
            charco = ImageIO.read(new File("src/simulador/img/charco.png"));
            graf = ImageIO.read(new File("src/simulador/img/graf.png"));
            charco2 = ImageIO.read(new File("src/simulador/img/charco2.png"));
            graf1 = ImageIO.read(new File("src/simulador/img/graf1.png"));
            boci = ImageIO.read(new File("src/simulador/img/boci.png"));
            bateria2 = ImageIO.read(new File("src/simulador/img/bateria2.png"));
            guitarra1 = ImageIO.read(new File("src/simulador/img/guitarra1.png"));
            micro = ImageIO.read(new File("src/simulador/img/microfono.png"));
            sofa = ImageIO.read(new File("src/simulador/img/sofa.png"));
            table = ImageIO.read(new File("src/simulador/img/table.png"));
            plant = ImageIO.read(new File("src/simulador/img/plant.png"));
            sofa1 = ImageIO.read(new File("src/simulador/img/sofa1.png"));
            drink = ImageIO.read(new File("src/simulador/img/drink.png"));
            drink1 = ImageIO.read(new File("src/simulador/img/drink1.png"));
            title = ImageIO.read(new File("src/simulador/img/title.png"));
            table1 = ImageIO.read(new File("src/simulador/img/table1.png"));
            auto = ImageIO.read(new File("src/simulador/img/auto.png"));
            auto1 = ImageIO.read(new File("src/simulador/img/auto1.png"));
            
        }catch(IOException ex){
            System.out.println("Error al cargar la imagen: " + ex.toString());
        }
}

public void Imagepaint(Graphics2D g2){
        g2.drawImage(souvenir,125,125,null);
        g2.drawImage(souvenir,135,125,null);
        g2.drawImage(souvenir1,155,135,null);
        g2.drawImage(souvenir1,165,135,null);
        g2.drawImage(souvenir2,185,125,null);
        g2.drawImage(souvenir2,195,125,null);
        g2.drawImage(souvenir2,205,135,null);
        g2.drawImage(souvenir2,215,135,null);
//        g2.drawImage(logo,555,180,null);
//        g2.drawImage(barril,575,140,null);
//        g2.drawImage(barril,595,140,null);
//        g2.drawImage(barril,620,140,null);
//        g2.drawImage(barril,640,140,null);
        g2.drawImage(baño,135,360,null);
        g2.drawImage(charco,145,400,null);
        g2.drawImage(charco,155,440,null);
        g2.drawImage(graf,170,405,null);
        g2.drawImage(charco2,155,415,null);
        g2.drawImage(graf1,125,475,null);
        g2.drawImage(boci,790,220,null);
        g2.drawImage(boci,845,230,null);
        g2.drawImage(boci,790,410,null);
        g2.drawImage(boci,840,380,null);
        g2.drawImage(bateria2,810,340,null);
        g2.drawImage(guitarra1,810,280,null);
        g2.drawImage(micro,790,300,null);
        g2.drawImage(sofa,941,240,null);
        g2.drawImage(table,950,280,null);
        g2.drawImage(plant,940,300,null);
        g2.drawImage(sofa1,965,310,null);
        g2.drawImage(drink,570,135,null);
        g2.drawImage(drink1,620,135,null);
        g2.drawImage(title,560,177,null);
        g2.drawImage(table1,190,160,null);
        g2.drawImage(table1,150,160,null);
        g2.drawImage(auto,150,530,null);
        g2.drawImage(auto1,650,530,null);

}
}
