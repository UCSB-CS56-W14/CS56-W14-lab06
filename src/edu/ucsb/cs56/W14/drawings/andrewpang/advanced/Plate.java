package edu.ucsb.cs56.w14.drawings.andrewpang.advanced;
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
   A vector drawing of a plate that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Andrew Pang
   @version for CS56, Winter 14, UCSB
   
*/
public class Plate extends GeneralPathWrapper implements Shape
{
    /**
     * Constructor for objects of class Plate
     * @param x    x coordinate of center of plate
     * @param y    y coordinate of center of plate
     * @param r    radius of plate
     */
    public Plate(double x, double y, double radius)
    {

        double innerRadius = radius * .7;
        
        Circle outerRim = new Circle(x, y, radius);
        Circle innerRim = new Circle(x, y, innerRadius);
       
        GeneralPath wholePlate = this.get();
        wholePlate.append(outerRim, false);
        wholePlate.append(innerRim, false);
        
    }

}

class Circle extends java.awt.geom.Ellipse2D.Double implements java.awt.Shape
{ 
    /**
     * Constructor for objects of class Circle
     * @param x    x coordinate of center of circle
     * @param y    y coordinate of center of circle
     * @param r    radius of circle
     */
    public Circle(double x, double y, double r)
    {
        // invoke the super class constructor,
        // i.e. the one for Ellipse2D.Double, which takes
        // upper-left-x, upper-left-y (of the bounding box)
        // width, and height
        
        super( x - r, y - r,   /* upper left corner of bounding box */
               r * 2,  r * 2); /* width and height are double the radius */
    }
    
} 