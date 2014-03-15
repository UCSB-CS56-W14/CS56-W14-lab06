package edu.ucsb.cs56.w14.drawings.l_y_s.advanced;
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
   A vector drawing of a triangle that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
   
   @author Phill Conrad
   @author Logan Schmidt 
   @version for CS56, Winter 14, UCSB
   
*/
public class Triangle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of triangle
       @param y y coord of lower left corner of triangle
       @param width width of the triangle from lower left corner to lower right corner
       @param height of triangle from bottom to upper point
     */
    public Triangle(double x, double y, double width, double height)
    {
	//Draws each line of the triangle
	Line2D.Double leftLine = new Line2D.Double(x, y, x + (width/2), y - height);
	Line2D.Double rightLine = new Line2D.Double(x + (width/2), y - height, x + width, y);
	Line2D.Double bottomLine = new Line2D.Double(x, y, x + width, y);

	//Adds to general path
	GeneralPath wholeTriangle = this.get();
	wholeTriangle.append(leftLine, false);
	wholeTriangle.append(rightLine, false);
	wholeTriangle.append(bottomLine, false);

    }

}
