package edu.ucsb.cs56.w14.drawings.dcoffill.advanced;
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
 A vector drawing of a laptop that implements
 the Shape interface, and so can be drawn, as well as
 rotated, scaled, etc.

 @author David Coffill
 @version for CS56, Winter 14, UCSB

 */
public class Laptop extends GeneralPathWrapper implements Shape
{
	/**
	 * Constructor
	 * @param x x coord of lower left corner of laptop drawing
	 * @param y y coord of lower left corner of laptop drawing
	 * @param width width of the entire laptop drawing (including perspective)
	 * @param height of entire laptop drawing (including perspective)
	 */
	public Laptop(double x, double y, double width, double height)
	{

		// Set dimensions for the case size, AKA the width/height of the
		// non-perspective part of the laptop
		double lidWidth = 0.7 * width;
		double lidHeight = 0.7 * height;

		double lidLowerLeftY = y - height + lidHeight;
		double lidLowerLeftX = x + width - lidWidth;

		Line2D.Double baseLeft = new Line2D.Double(x, y, lidLowerLeftX, lidLowerLeftY);
		Line2D.Double baseRight = new Line2D.Double(x + lidWidth, y, lidLowerLeftX + lidWidth, lidLowerLeftY);
		Line2D.Double baseBottom = new Line2D.Double(x, y, x + lidWidth, y);

		Rectangle2D.Double lid = new Rectangle2D.Double(lidLowerLeftX, y - height, lidWidth, lidHeight);


        GeneralPath entireLaptop = this.get();
        entireLaptop.append(baseLeft, false);
        entireLaptop.append(baseRight, false);
		entireLaptop.append(baseBottom, false);
		entireLaptop.append(lid, false);

	}

}
