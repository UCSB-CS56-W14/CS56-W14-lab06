package edu.ucsb.cs56.w14.drawings.jstaahl.advanced;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;


/**
 *  A class with a main method that can write a drawing to a graphics file.
 *  
 *  @author P. Conrad, 
 *  @version for CS56, W11 UCSB
 */

public class WritePictureToFile
{
    public static void usage()
    {
       System.out.println("Usage: java WritePictureToFile whichImage mypic");
       // @@@ modify the next line to describe your picture
       System.out.println(" whichImage should be 1,2 or 3");
       System.out.println(" whichImage chooses from drawPicture1, 2 or 3");
       System.out.println(" .png gets added to the filename");
       System.out.println("  e.g. if you pass mypic, filename is mypic.png"); 
       System.out.println("Example: java WritePictureToFile 3 foo");
       System.out.println(" produces foo.png from drawPicture3");
    }

    /** Write the drawFourCoffeeCups picture to a file.
     * 
     * @param args  The first command line argument is the file to write to.  We leave off the extension
     *              because that gets put on automatically.
     */

   public static void main(String[] args)
   {
     // make sure we have exactly one command line argument  
     if (args.length != 2)
     {
        usage();
        System.exit(1);
     }

     String whichPicture = args[0]; // first command line arg is 1, 2, 3 
     String outputfileName = args[1]; // second command line arg is which pic

     final int WIDTH = 640;
     final int HEIGHT = 480;
         
     // create a new image
     // TYPE_INT_ARGB is "RGB image" with transparency (A = alpha channel)
     
     BufferedImage bi = 
        new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB); 

     // g2 is a Graphics2D object that will draw into the BufferedImage object

     Graphics2D g2 = bi.createGraphics();
      
     if (whichPicture.equals("1")) {
	 AllMyDrawings.drawPicture1(g2);
     } else if (whichPicture.equals("2")) {
	 AllMyDrawings.drawPicture2(g2);
     } else if (whichPicture.equals("3")) {
      	 AllMyDrawings.drawPicture2(g2);
     }

     final String imageType = "png"; // choices: "gif", "png", "jpg"
      
     // We must declare this variable outside the try block, 
     // so we can see it inside the catch block

     String fullFileName = ""; 
    
     try 
     {
        fullFileName = outputfileName + "." + imageType; // make the file name
        File outputfile = new File(fullFileName); // the file we will try to write
        ImageIO.write(bi, imageType, outputfile); // actually write it
        System.out.println("I created " + fullFileName); // tell the user
     } 
     catch (IOException e)
     {
      System.err.println("Sorry, an error occurred--I could not create "+ fullFileName +"\n The error was: "+ e.toString());
     }

      
   }
}
