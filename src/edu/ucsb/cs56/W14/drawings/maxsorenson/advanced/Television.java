package edu.ucsb.cs56.w14.drawings.maxsorenson.advanced;
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
   A vector drawing of a television that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Max Sorenson 
   @version for CS56, Winter 14, UCSB
   
*/
public class Television extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of television
       @param y y coord of lower left corner of television
       @param width width of the television
       @param height of television (including stand)
     */
    public Television(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double standHeight = .10 * height;
        double standWidth = 1.10 * width;
	double tvHeight = height - standHeight;
        
        double tvUpperLeftY = y + height;
	double standLowerLeftX = x - (.05 * width);
        double standLowerLeftY = y + (10*standHeight);

        // Make the stand
        
        Rectangle2D.Double tvStand = 
            new Rectangle2D.Double(standLowerLeftX, standLowerLeftY ,
				   standWidth, standHeight);

	Rectangle2D.Double tvTop = 
            new Rectangle2D.Double(x, y ,
                          width, height);
                          
        // make the television.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        /*Line2D.Double left = 
            new Line2D.Double (x, y + roofHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightRoof =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + roofHeight);
	*/
        // put the whole television together
       
        GeneralPath wholeTelevision = this.get();
        wholeTelevision.append(tvStand, false);
        wholeTelevision.append(tvTop, false);
        //wholeHouse.append(rightRoof, false); 
        
    }

}
