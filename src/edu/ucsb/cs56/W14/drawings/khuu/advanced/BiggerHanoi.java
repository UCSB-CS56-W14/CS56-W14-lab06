package edu.ucsb.cs56.w14.drawings.khuu.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   The Tower of Hanoi
      
   @author Phill Conrad 
   @author LesleyKhuu
   @version for CS56, W14, UCSB, 02/22/2014
   
*/
public class BiggerHanoi extends Hanoi implements Shape
{
    /**
     * Constructor for objects of class BiggerHanoi
     */
    public BiggerHanoi(double x, double y, double width, double height)
    {
	// construct the basic Tower Hannoi
        super(x,y,width,height);
        
        double bigBlockWidth = width+(4*(width/3));
        double smallBlockWidth = width+(2*(width/3));
        double blockHeight = height/3;
        
        double smallBlockX = x-(width/3);
        double smallBlockY = y+(height);
        double bigBlockX = x-(2*(width/3));
        double bigBlockY = y+height+((height/3));
               
                
        
        Rectangle2D.Double bigBlock =
        new Rectangle2D.Double(bigBlockX, bigBlockY ,
                               bigBlockWidth, blockHeight);
        
        Rectangle2D.Double smallBlock =
        new Rectangle2D.Double(smallBlockX, smallBlockY ,
                               smallBlockWidth, blockHeight);
        
       
        
        GeneralPath gp = this.get();
        gp.append(smallBlock,false);
        gp.append(bigBlock,false);
       
	
    }

}
