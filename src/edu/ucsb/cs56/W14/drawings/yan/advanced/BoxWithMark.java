package edu.ucsb.cs56.w14.drawings.yan.advanced;
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
   A Box with Mark
      
   @author Bonan Yan 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class BoxWithMark extends Box implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public BoxWithMark(double x, double y, double width, double height)
    {
	// construct the basic box 
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	

	double m = 0.10 * width;
	double markTop = y + 0.5 * height;
	double markHt =  0.25 * height;

       
	Rectangle2D.Double mark =
	    new Rectangle2D.Double(x + 4.0*m, markTop, 2.0 * m, markHt);
		
	// add the square mark to the box
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeBox = this.get();
        wholeBox.append(mark, false);
        
    }

}
