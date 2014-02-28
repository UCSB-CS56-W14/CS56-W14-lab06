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
   A vector drawing of an ice cream cone with sprinkles that implements
   the Shape interface and extends IceCreamCone, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Khalid Dhanani
   @version for CS56, Winter 11, UCSB
   
*/
public class SprinkledIceCreamCone extends IceCreamCone implements Shape
{
    /**
       Constructor

       @param x x coord of bottom of cone
       @param y y coord of bottom of cone
       @param r r of ice cream scoop
     */
    public SprinkledIceCreamCone(double x, double y, double r)
    {
	super(x,y,r);

	GeneralPath gp = this.get();
        double coneHeight = 4 * r;
        
        Line2D.Double sprinkle1 = 
            new Line2D.Double(x - 0.2 * r, y - coneHeight - 0.2 * r,
                          x - 0.3 * r, y - coneHeight - 0.3 * r);
                            
        Line2D.Double sprinkle2 = 
            new Line2D.Double (x + 0.7 * r, y - coneHeight - 0.6 * r,
                               x + 0.8 * r, y - coneHeight - 0.5 * r);
                               
        Line2D.Double sprinkle3 =
            new Line2D.Double (x + 0.3 * r, y - coneHeight + 0.3 * r,
                               x + 0.4 * r, y - coneHeight + 0.5 * r);

       
        GeneralPath wholeCone = this.get();
        wholeCone.append(sprinkle1, false);
        wholeCone.append(sprinkle2, false);
        wholeCone.append(sprinkle3, false); 
        
    }

}
