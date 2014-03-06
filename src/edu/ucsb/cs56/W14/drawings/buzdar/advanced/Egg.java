package edu.ucsb.cs56.w14.drawings.buzdar.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a egg that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Alan Buzdar
   @version for CS56, Winter 14, UCSB
   
*/
public class Egg  extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of egg
       @param y y coord of lower left corner of egg
       @param width width of the egg
       @param height of egg (including first story and second story)
     */
    public Egg
     (double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        
        Ellipse2D.Double egg = 
            new Ellipse2D.Double (x, y,
                               width, height);
                               

        // put the whole egg together
       
        GeneralPath wholeEgg = this.get();
        wholeEgg.append(egg, false); 
        
    }

}
