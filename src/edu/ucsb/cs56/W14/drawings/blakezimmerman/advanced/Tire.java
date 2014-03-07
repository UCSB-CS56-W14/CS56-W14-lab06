package edu.ucsb.cs56.w14.drawings.blakezimmerman.advanced;
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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a tire that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Blake Zimmerman
   @version for CS56, Winter 14, UCSB
   
*/
public class Tire extends GeneralPathWrapper implements Shape
{
    /**
       Constructor to build a tire

       @param x x coord of center of circle
       @param y y coord of center of circle 
       @param r r radius of inner circle
       @param width width between the inner circle and outer circle
     */
    public Tire(double x, double y, double r, double width)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, r and width.

	// The diameter of the outer circle

	double outerDia = 2*(r + width);

        // Make the inner circle

        Ellipse2D.Double innerCircle =  new Ellipse2D.Double (x - r, y - r, 2*r, 2*r);                 
        
	// Make the outer circle

	Ellipse2D.Double outerCircle = new Ellipse2D.Double (x - (r + width), y - (r + width), outerDia, outerDia);

        // put the whole tire together

        GeneralPath wholeTire = this.get();
        wholeTire.append(innerCircle, false);
        wholeTire.append(outerCircle, false); 
        
    }

}
