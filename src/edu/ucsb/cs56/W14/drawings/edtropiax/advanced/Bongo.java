package edu.ucsb.cs56.w14.drawings.edtropiax.advanced;
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
   A Bongo
   
      
   @author Marcus Liou
   @version for CS56, W14, UCSB, 02/27/2014
   
*/
public class Bongo extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class Bongo
     */
    public Bongo(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* bongo
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 900.0; 
                
        GeneralPath leftSide = new GeneralPath();
      
        // left side of bongo
       
        leftSide.moveTo(200,400);
        leftSide.lineTo(160,360);
        leftSide.lineTo(130,300);
        leftSide.lineTo(100,200);
        leftSide.lineTo(100,100);
        
        GeneralPath topAndBottom = new GeneralPath();
       
        topAndBottom.moveTo(100,100);
        topAndBottom.lineTo(500,100); // top of cup
        
        topAndBottom.moveTo(200,400);
        topAndBottom.lineTo(400,400); // bottom of cup
       
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 400.0, 0.0);
        
        // now we put the whole thing together ino a single path.
       
        GeneralPath leftBongo = new GeneralPath();
        leftBongo.append(topAndBottom, false);
        leftBongo.append(leftSide, false);
        leftBongo.append(rightSide, false);
        Shape rightBongo = ShapeTransforms.translatedCopyOf(leftBongo, 500.0, 0.0);
	GeneralPath topConnect = new GeneralPath();
	topConnect.moveTo(500,200);
	topConnect.lineTo(600,200);
	GeneralPath bottomConnect = new GeneralPath();
	topConnect.moveTo(470,300);
	topConnect.lineTo(630,300);
	GeneralPath wholeBongo = new GeneralPath();
	wholeBongo.append(leftBongo, false);
	wholeBongo.append(rightBongo, false);
	wholeBongo.append(topConnect, false);
	wholeBongo.append(bottomConnect, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeBongo, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable bongo
        
	this.set(new GeneralPath(s));
        
    }

}
