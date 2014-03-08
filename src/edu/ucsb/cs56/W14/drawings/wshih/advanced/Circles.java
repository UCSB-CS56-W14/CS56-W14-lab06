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
   A vector drawing of circles that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad
   @author George Shih
   @version for CS56, Winter 14, UCSB
*/

public class Circles extends GeneralPathWrapper implements Shape {
    
    /**
       Constructor
       @param x x coord of the center of the circles
       @param y y coord of the center of the circles
       @param r radius 
       @param dr change in radius of consecutive circles
     */

    public Circles(double x, double y, double r, double dr) {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, dr and n. If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        

	Circle circle1 = new Circle(x, y, r);
	Circle circle2 = new Circle(x, y, r + dr);
	Circle circle3 = new Circle(x, y, r + 2*dr);
	

        // Put the circles together
	
	GeneralPath total = this.get();
	total.append(circle1,false);
	total.append(circle2,false);
	total.append(circle3,false);
   
    }

}
