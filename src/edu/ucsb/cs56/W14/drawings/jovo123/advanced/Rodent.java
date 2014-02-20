package edu.ucsb.cs56.w14.drawings.jovo123.advanced;
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
   A vector drawing of a rodent that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Josephine Vo
   @version for CS56, Winter 11, UCSB
   
*/
public class Rodent extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of center of the rodents face
       @param y y coord of center of the rodents face
       @param r radius of the rodents face
     */
    public Rodent(double x, double y, double r)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, and r.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double cheekSize = .66 * r;
        double cheekX = x - r;
        double cheekY = y - r / 3;
        
	double eyeSize = .05 * r;
	double eyeLX = x - r/2;
	double eyeRX = x + r/2;
	
	
        // Make the outline of the face
        
        Ellipse2D.Double face = 
            new Ellipse2D.Double(x - r, y - r,
                          2 * r, 2 * r);
                          
        // make the cheek.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
	Ellipse2D.Double cheek = 
	    new Ellipse2D.Double(cheekX, cheekY, cheekSize, cheekSize);

	Ellipse2D.Double eyeL =
	    new Ellipse2D.Double(eyeLX, y, eyeSize, eyeSize);

	Ellipse2D.Double eyeR =
	    new Ellipse2D.Double(eyeRX, y, eyeSize, eyeSize);

	Rectangle2D.Double nose =
	    new Rectangle2D.Double(x - r/4, y + r/2, .05 * r, .05 * r);

        // put the rodent together
       
        GeneralPath rodent = this.get();
	rodent.append(face, false);
        rodent.append(cheek, false);
        rodent.append(eyeL, false);
        rodent.append(eyeR, false); 
        rodent.append(nose, false);   
    }

}
