package edu.ucsb.cs56.w14.drawings.allisonshedden.advanced;
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
   A Cereal Bowl (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Allison Shedden 
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class CerealBowl extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class CerealBowl
     */
    public CerealBowl(double x, double y, double width, double height)
    {
	// original coordinates for bowl
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
                
        GeneralPath leftSide = new GeneralPath();
      
        // left side of bowl
       
        leftSide.moveTo(200,400);
        leftSide.lineTo(160,340);
        leftSide.lineTo(130,300);
        leftSide.lineTo(100,200);
        leftSide.lineTo(100,100);
        
        GeneralPath topAndBottom = new GeneralPath();
       
        topAndBottom.moveTo(100,100);
        topAndBottom.lineTo(500,100); // top of bowl
        
        topAndBottom.moveTo(200,400);
        topAndBottom.lineTo(400,400); // bottom of bowl

	GeneralPath stripe = new GeneralPath();

	stripe.moveTo(100,150);
	stripe.lineTo(500,150); // top of stripe
	
	stripe.moveTo(100,200);
        stripe.lineTo(500,200); // bottom of stripe
       
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // flip and move over
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 400.0, 0.0);
       
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholeBowl = new GeneralPath ();
        wholeBowl.append(topAndBottom, false);
        wholeBowl.append(leftSide, false);
        wholeBowl.append(rightSide, false);
	wholeBowl.append(stripe, false);
      
        // translate to the origin
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeBowl, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable bowl
        
	this.set(new GeneralPath(s));
        
    }

}
