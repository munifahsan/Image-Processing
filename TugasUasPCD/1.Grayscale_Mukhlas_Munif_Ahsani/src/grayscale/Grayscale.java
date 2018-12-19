/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grayscale;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Amigo Paradise
 */

public class Grayscale {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedImage img = null;
    File f = null;

    //membaca gambar yang akan di convert
    try{
      f = new File("G:\\TugasUasPCD\\fruits.png");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println(e);
    }

    //mengambil panjang dan lebar gambar
    int width = img.getWidth();
    int height = img.getHeight();

    //mengconvert gambar ke grayscale
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;

        //menghitung rata rata
        int avg = (r+g+b)/3;

        //mengganti nilai RGB dengan rata rata
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }

    //menyimpan gambar yang telah di convert
    try{
      f = new File("G:\\TugasUasPCD\\fruits_RGB_Grayscale.png");
      ImageIO.write(img, "png", f);
    }catch(IOException e){
      System.out.println(e);
    }
        
    }
    
}
