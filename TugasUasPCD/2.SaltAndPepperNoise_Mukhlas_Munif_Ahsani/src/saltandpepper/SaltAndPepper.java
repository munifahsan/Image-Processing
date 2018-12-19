
package saltandpepper;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class SaltAndPepper {
    static BufferedImage image2;
    static File f = null;
    public static void main(String[] args) throws IOException {
        try
	{
			
	BufferedImage image1 = ImageIO.read(new File("G:\\TugasUasPCD\\fruits.png"));
	int width = image1.getWidth();
	int height = image1.getHeight();
			
	for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                Color c = new Color(image1.getRGB(j, i));
                int red = (int)(c.getRed() * 0.299);
	        int green = (int)(c.getGreen() * 0.587);
	        int blue = (int)(c.getBlue() *0.114);
	        int rgb = range(red+green+blue,8);
	        Color newColor = new Color(rgb,rgb,rgb);
	               
	        image1.setRGB(j,i,newColor.getRGB());
	        }
	    }
			
			try{
			      f = new File("G:\\TugasUasPCD\\saltpepper_fruits.png");
			      ImageIO.write(image1, "png", f);
			    }catch(IOException e){
			      System.out.println(e);
			    }

		}
		catch(IOException e)
		{
			System.out.print("No");
		}		
		
	}
	
	public static int range(int n, double prob) {
		double res = ((100 * prob)/10);
		
		int[]array = new int[(int)res];
		array[0]= 1;
		array[1]=255;
		
		for (int i = 2 ; i <= res - 2; i++)
		{
			array[i] = n;
		}
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
    }
    
}
