package edu.ucsb.cs56.w14.drawings.wshih.advanced;
import java.awt.geom.GeneralPath; // Combinations of lines and curves
import java.awt.geom.AffineTransform; // Translation, rotation, scale
import java.awt.Shape; // General class for shapes

// All imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   CirclesWithSquares adds squares in the bottom right 
   @author Phill Conrad 
   @author George Shih
   @version for CS56, W14, UCSB, 02/26/2014
*/

public class CirclesWithSquares extends Circles implements Shape {

    /**
       Constructor for objects of class CirclesWithSquares
       @param x x coord of the center of the circles
       @param y y coord of the center of the circles
       @param r radius 
       @param dr change in radius of consecutive circles
     */

    public CirclesWithSquares(double x, double y, double r, double dr) {

	// Construct the basic Circles
	super(x,y,r,dr);

	// Get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make some squares that appear in the bottom right

	double length = r / 2;
	
	Rectangle2D.Double square1 =
	    new Rectangle2D.Double(x, y, r, r);
	Rectangle2D.Double square2 =
	    new Rectangle2D.Double(x, y, r + dr, r + dr);
	Rectangle2D.Double square3 =
	    new Rectangle2D.Double(x, y, r + 2*dr, r + 2*dr);
	
	// Add the squares to the circles
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(square1, false);
        wholeHouse.append(square2, false);
        wholeHouse.append(square3, false); 
    }

}
