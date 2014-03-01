package edu.ucsb.cs56.w14.drawings.vlara.advanced;
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
   A vector drawing of a hourglass that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Vincente Lara
   @version for CS56, Winter 14, UCSB
   
*/
public class Hourglass extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of house
       @param y y coord of upper left corner of house
       @param width width of the hourglass
       @param height of hourglass
     */
    public Hourglass(double x, double y, double width, double height)
    {   
	//Fixed initial bug that had the width as just a number
	//and not the acutal width.
	//
	double actualWidth = x + width;
	double actualHeight = y + height;

        //The first diagonal of the hourglass
        //                \
        //                 \
        //looks like this   \

    	Line2D.Double firstDiagonal = 
	   new Line2D.Double(x, y, actualWidth, actualHeight);

        //The second diagonal of the hourglass
        //                 \   /
        //                  \ /
        //                  / \
        //looks like this  /   \               

	Line2D.Double secondDiagonal = 
	   new Line2D.Double(actualWidth, y, x, actualHeight);

	//Add the top and bottom lines of the hourglass
	//             -------
	//              \   /
	//               \ /
	//               / \
	//              /   \
	//             ------- 

	Line2D.Double top = 
	   new Line2D.Double(x, y, actualWidth, y);

	Line2D.Double bottom = 
	   new Line2D.Double(x, actualHeight, actualWidth, actualHeight);

	GeneralPath wholeHourglass = this.get();
	wholeHourglass.append(firstDiagonal, false);
	wholeHourglass.append(secondDiagonal, false);
	wholeHourglass.append(top, false);
	wholeHourglass.append(bottom, false); 
     }
}
