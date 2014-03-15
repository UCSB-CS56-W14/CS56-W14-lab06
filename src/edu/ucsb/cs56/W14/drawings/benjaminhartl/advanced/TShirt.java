package edu.ucsb.cs56.w14.drawings.benjaminhartl.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A T Shirt (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Benjamin Hartl 
   @version for CS56, W14, UCSB, 02/13/2014
   
*/
public class TShirt extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class TShirt
     */
    public TShirt(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* TShirt
        
        final double ORIG_ULX = 70;
        final double ORIG_ULY = 50;
        final double ORIG_HEIGHT = 125;
        final double ORIG_WIDTH = 160;
                
        GeneralPath leftSide = new GeneralPath();
      
        // left side of TShirt
       
        leftSide.moveTo(150,50);
        leftSide.lineTo(100,50);
        leftSide.lineTo(70,80);
        leftSide.lineTo(90,100);
        leftSide.lineTo(100,90);
        leftSide.lineTo(100,175);
	leftSide.lineTo(150,175);
        
         Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 160 pixels
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 160.0, 0.0);
       
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholeShirt = new GeneralPath ();
        wholeShirt.append(leftSide, false);
        wholeShirt.append(rightSide, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeShirt, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable shirt
        
	this.set(new GeneralPath(s));
        
    }

}
