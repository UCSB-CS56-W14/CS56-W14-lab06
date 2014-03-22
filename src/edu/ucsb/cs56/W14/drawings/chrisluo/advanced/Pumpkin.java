package edu.ucsb.cs56.w14.drawings.chrisluo.advanced;
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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Chris Luo
   @version for CS56, Winter 14, UCSB
   
*/
public class Pumpkin extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of pumpkin
       @param y y coord of lower left corner of pumpkin
       @param width width of the pumpkin
       @param height of pumpkin
     */
    public Pumpkin(double x, double y, double width, double height)
    {
        
        Ellipse2D.Double circle = 
            new Ellipse2D.Double(x,y,width,height);
        
        Line2D.Double stem =
	    new Line2D.Double (x+width/2,y,x+width/2,y-height/6);
       
        GeneralPath wholePumpkin = this.get();
        wholePumpkin.append(circle, false);
        wholePumpkin.append(stem, false);
        
    }
}
