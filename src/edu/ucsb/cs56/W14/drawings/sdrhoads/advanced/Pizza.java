package edu.ucsb.cs56.w14.drawings.sdrhoads.advanced;
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
   A vector drawing of a pizza slice that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sidney Rhoads 
   @version for CS56, W14, UCSB
   
*/
public class Pizza extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of the pizza slice
       @param y y coord of lower left corner of the pizza slice
       @param width width at the crust of the pizza
       @param length length of pizza from crust to point.
     */
    public Pizza(double x, double y, double width, double length)
    {
                          
        // make the trangular slice.  
        Line2D.Double crust =
        	new Line2D.Double (x, y, x + width, y);

        Line2D.Double leftside = 
            new Line2D.Double (x, y, x + width/2, length);
                               
        Line2D.Double rightside =
            new Line2D.Double (x + width, y, x + width/2, length);
            
        // put the whole pizza together 
        GeneralPath wholePizza = this.get();
        wholePizza.append(crust, false);
        wholePizza.append(leftside, false);
        wholePizza.append(rightside, false); 
        
    }

}