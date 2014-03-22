package edu.ucsb.cs56.w14.drawings.george123.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a ball that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author George Chen 
   @version for CS56, Winter 14, UCSB
   
*/
public class Ball extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of center of ball
       @param y y coord of center of ball
       @param radius radius of ball
     */
    public Ball(double x, double y, double radius)
    {

        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, radius.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

	Ellipse2D.Double outerBall = 
	    new Ellipse2D.Double(x, y, radius, radius);
		
	GeneralPath wholeBall = this.get();
	wholeBall.append(outerBall, false);

    }

}
