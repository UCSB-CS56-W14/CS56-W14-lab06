
package edu.ucsb.cs56.w14.drawings.dmhartsook.advanced;
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
   A vector drawing of a cookie that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Deanna Hartsook
   @version for CS56, Winter 14, UCSB
   
*/
public class Cookie extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x - x coord of the center of the cookie
       @param y - y coord of the center of the cookie
       @param radius - radius of cookie
     */
    public Cookie(double x, double y, double r)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, and radius.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        GeneralPath cookie = this.get();
        cookie.append(new Circle(x, y, r), false);
        
    }

}
