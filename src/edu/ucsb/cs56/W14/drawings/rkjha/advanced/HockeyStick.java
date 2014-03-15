package edu.ucsb.cs56.w14.drawings.rkjha.advanced;
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
      
   @author Rishabh Jha
   @version for CS56, Winter 14, UCSB
   
*/
public class HockeyStick extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of HockeyStick
       @param y y coord of upper left corner of HockeyStick
       @param width width of the base of the HockeyStick
       @param height height of HockeyStick from base to top of grip 
    */
    public HockeyStick(double x, double y, double width, double height)
    {
        //NOTE: I'm aware that this is two rectangles overlapping each other, hence a small square will be shown at the intersecting area
        // I like to call this "added aesthetic value" to what would otherwise be a boring block-shaped L :-)


        //Setting up parameters
        
        double baseHeight = .15 * height;    // How high the portion of the stick you try to hit the puck with is
        double gripWidth = .15 * width;      // How wide the hockey stick is in terms of gripping area
        
        double upperLeftBaseCorner = y + (.85 * height);
        
        // Make the long, handle part
        
        Rectangle2D.Double handle = 
            new Rectangle2D.Double(x, y, gripWidth, height);
                          
        // Make the base (striking) part 

        Rectangle2D.Double base = 
            new Rectangle2D.Double(x, upperLeftBaseCorner, width, baseHeight);
        // put the whole hockey stick together
       
        GeneralPath wholeHockeyStick = this.get();
        wholeHockeyStick.append(handle, false);
        wholeHockeyStick.append(base, false);
        
    }

}
