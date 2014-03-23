package edu.ucsb.cs56.w14.drawings.dalin.advanced;
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


import java.lang.Object;
import java.awt.geom.RectangularShape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

/**
   A vector drawing of fish that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Dalin Wang
   @version for CS56, Winter 14, UCSB
   
*/
public class Fish extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of fishbody if the fish were a rectangle
       @param y y coord of upper left corner of fishbody if the fish were a rectangle
       @param width width of the fish
       @param height of fish
     */
    
    public Fish(double x, double y, double width, double height)
    {
        
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        Ellipse2D.Double fishbody = new Ellipse2D.Double (x , y , width, height);
        Line2D.Double toptail = new Line2D.Double (x - width/4.0 , y , x , y + height/2.0);
        Line2D.Double middletail = new Line2D.Double ( x - width/4.0, y , x - width/4.0 , y + height);
        Line2D.Double bottomtail = new Line2D.Double ( x - width/4.0, y + height , x , y + height/2.0);
        Ellipse2D.Double fisheye = new Ellipse2D.Double(x + 0.70* width , y + height/3.0 , width / 8.0 , width/8.0);
       
        
        // put the whole fish together
      
        GeneralPath wholeFish = this.get();
        wholeFish.append(fishbody, false);
        wholeFish.append(toptail, false);
        wholeFish.append(middletail, false);
        wholeFish.append(bottomtail, false);
        wholeFish.append(fisheye,  false);

        
    }
   
}
