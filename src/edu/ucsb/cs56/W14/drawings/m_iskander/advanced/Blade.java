package edu.ucsb.cs56.w14.drawings.m_iskander.advanced;
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
   A drawing of a blade that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Mena Iskander
   @version for CS56, Winter 14, UCSB
   
*/
public class Blade extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of blade
       @param y y coord of lower left corner of blade
       @param width width of the blade
       @param height of blade
     */
    public Blade(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double bladeHeight = .75 * height;
        double tipHeight = height - bladeHeight;
        
        double tipUpperLeftY = y + tipHeight;
        
        // Make the body of the blade
        
        Rectangle2D.Double bladeBody = 
            new Rectangle2D.Double(x, tipUpperLeftY ,
                          width, bladeHeight);
                          

        // make the tip of the blade.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftTip = 
            new Line2D.Double (x, y + tipHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightTip =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + tipHeight);

        Line2D.Double middle =  new Line2D.Double (x+width/2, y, x+width/2,y+height );
        // put the blade together
       
        GeneralPath wholeBlade = this.get();
        wholeBlade.append(bladeBody, false);
        wholeBlade.append(leftTip, false);
        wholeBlade.append(rightTip, false); 
        wholeBlade.append(middle, false); 

    }

}
