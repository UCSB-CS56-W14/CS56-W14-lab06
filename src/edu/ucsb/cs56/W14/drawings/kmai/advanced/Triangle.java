package edu.ucsb.cs56.w14.drawings.kmai.advanced;
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
      
   @author Kevin Mai
   @version for CS56, Winter 14, UCSB
   
*/
public class Triangle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       @param x x-coord of bottom left corner of triangle
       @param y y-coord of bottom corner of triangle
       @param length length of side of triangle
     */
    public Triangle(double x, double y, double length)
    {
	double h = Math.sqrt(3)/2*length;
	double lhalf = length/2;

	Line2D.Double leftside =
	    new Line2D.Double (x, y + h, x + lhalf, y);
	
	
	Line2D.Double rightside =
	    new Line2D.Double (x + lhalf, y, x + length, y + h);
	
	Line2D.Double bottomside =
	    new Line2D.Double (x, y + h, x + length, y + h);
			       

        GeneralPath wholeTriangle = this.get();
        wholeTriangle.append(leftside, false);
	wholeTriangle.append(rightside, false);
	wholeTriangle.append(bottomside, false); 
        
    }

}
