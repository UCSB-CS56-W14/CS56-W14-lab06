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
   A vector drawing of the Star of David that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Kevin Mai
   @version for CS56, Winter 14, UCSB
   
*/
public class StarOfDavid extends Triangle implements Shape
{
    /**
       Constructor
       @param x x-coord of bottom left corner of triangle
       @param y y-coord of bottom corner of triangle
       @param length length of side of triangle
     */
    public StarOfDavid(double x, double y, double length)
    {
	//Construct the triangle
	super(x, y, length);
	//Draws the flipped triangle    
	GeneralPath gp = this.get();
	double h = Math.sqrt(3)/2*length;
        double lhalf = length/2;
	double adjuster = 0.333*h;

        Line2D.Double leftside =
            new Line2D.Double (x, y + adjuster, x + lhalf, y + h + adjuster);

        Line2D.Double topside =
            new Line2D.Double (x, y + adjuster, x + length, y + adjuster);

        Line2D.Double rightside =
            new Line2D.Double (x + lhalf, y + h + adjuster, x + length, y + adjuster);
	
	gp.append(leftside, false);
	gp.append(topside, false);
	gp.append(rightside, false);
    }

}
