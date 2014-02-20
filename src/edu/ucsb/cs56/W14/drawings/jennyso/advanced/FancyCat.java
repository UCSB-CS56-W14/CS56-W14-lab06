package edu.ucsb.cs56.w14.drawings.jennyso.advanced;
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
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class FancyCat extends Cat implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public FancyCat(double x, double y, double width, double height)
    {
	// construct the basic cat shell
	super(x,y,width*.75,height*.75);

	//modify cat head dimensions to accomodate hat
	double headHeight = height*.75;
	double headWidth = width*.75;
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double brimWidth = 0.6 * width;
	double hatHeight = .25*height;
	double hatWidth = 0.3*width;

	Line2D.Double brim =
	    new Line2D.Double(x - brimWidth/2.0, y-headHeight, 
			      x + brimWidth/2.0, y-headHeight);
	Rectangle2D.Double hat =
	    new Rectangle2D.Double(x-hatWidth/2.0, y-height, 
				   hatWidth, hatHeight);
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeCat = this.get();
        wholeCat.append(brim, false);
        wholeCat.append(hat, false);
    }

}
