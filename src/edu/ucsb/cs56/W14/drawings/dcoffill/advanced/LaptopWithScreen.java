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
 A vector drawing of a house that implements
 the Shape interface, and so can be drawn, as well as
 rotated, scaled, etc.

 @author David Coffill
 @version for CS56, Winter 14, UCSB

 */
public class LaptopWithScreen extends Laptop implements Shape
{
	/**
	 * Constructor
	 * @param x x coord of lower left corner of laptop drawing
	 * @param y y coord of lower left corner of laptop drawing
	 * @param width width of the entire laptop drawing (including perspective)
	 * @param height of entire laptop drawing (including perspective)
	 */

	public LaptopWithScreen(double x, double y, double width, double height)
	{
		// Draw the laptop first
		super(x, y, width, height);
		GeneralPath gp = this.get();

		// Set dimensions for the case size, AKA the width/height of the
		// non-perspective part of the laptop
		double lidWidth = 0.7 * width;
		double lidHeight = 0.7 * height;

		double lidLowerLeftY = y - height + lidHeight;
		double lidLowerLeftX = x + width - lidWidth;

		// Draw the screen
		Rectangle2D screen = new Rectangle2D.Double(lidLowerLeftX + 0.1 * lidWidth, lidLowerLeftY - 0.9 * lidHeight,
				0.8 * lidWidth,	0.8 * lidHeight);

		// Add the screen to the drawing path
		GeneralPath entireLaptop = this.get();
		entireLaptop.append(screen, false);

}

}
