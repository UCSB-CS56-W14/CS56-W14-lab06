package edu.ucsb.cs56.w14.drawings.wang00.advanced;
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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, Winter 14, UCSB
   
*/
public class chair extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of seat
       @param y y coord of lower left corner of seat
       @param width width of the seat
       @param height of seat 
     */
    public chair(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double seatHeight =  height;
       
        
        Rectangle2D.Double seat = 
            new Rectangle2D.Double(x, y,
                          width, seatHeight);

	Rectangle2D.Double back = 
            new Rectangle2D.Double(x+width, y-5*height,
				   height, width);
                          
        
        Line2D.Double leg1 = 
            new Line2D.Double (x+height*0.5, y + height,
                               x, y+3*height);
                               
        Line2D.Double leg2 =
            new Line2D.Double (x+width-height*0.5, y + height,
                               x + width, y + 3*height);

        // put the whole chair together
       
        GeneralPath wholeChair = this.get();
        wholeChair.append(seat, false);
        wholeChair.append(back, false);
        wholeChair.append(leg1, false); 
	wholeChair.append(leg2, false); 
        
    }

}
