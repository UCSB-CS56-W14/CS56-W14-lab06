package edu.ucsb.cs56.w14.drawings.khalid.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an ice cream cone that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Khalid Dhanani
   @version for CS56, Winter 11, UCSB
   
*/
public class IceCreamCone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of bottom of cone
       @param y y coord of bottom of cone
       @param r r of ice cream scoop
     */
    public IceCreamCone(double x, double y, double r)
    {
    
        double coneHeight = 4 * r;
        
        
        Ellipse2D.Double iceCream = 
            new Ellipse2D.Double(x - r, y - coneHeight - r,
                          2 * r, 2 * r);
                            
        Line2D.Double leftCone = 
            new Line2D.Double (x, y,
                               x - r, y - coneHeight);
                               
        Line2D.Double rightCone =
            new Line2D.Double (x, y,
                               x + r, y - coneHeight);

       
        GeneralPath wholeCone = this.get();
        wholeCone.append(leftCone, false);
        wholeCone.append(rightCone, false);
        wholeCone.append(iceCream, false); 
        
    }

}
