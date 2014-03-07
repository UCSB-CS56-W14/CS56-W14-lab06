package edu.ucsb.cs56.w14.drawings.bhammel.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a snare drum that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Brandon Hammel
   @version for CS56, W14, UCSB, 02/13/2014
   
*/

public class SnareDrumWithStand extends SnareDrum implements Shape
{
	/**
		Constructor

		@param x x coord of upper left corner of snare drum
		@param y y coord of upper left corner of snare drum
		@param width width of snare drum
		@param height height of snare drum
    */

	public SnareDrumWithStand(double x, double y, double width, double height)
	{
		super(x, y, width, height);

		Line2D.Double stand = new Line2D.Double(x + (0.5 * width), y + height, x + (0.5 * width), y + (2 * height));
		Line2D.Double leftLeg = new Line2D.Double(x + (0.5 * width), y + (1.7 * height), x + (0.3 * width), y + (2 * height));
		Line2D.Double rightLeg = new Line2D.Double(x + (0.5 * width), y + (1.7 * height), x + (0.7 * width), y + (2 * height));

		GeneralPath wholeDrum = this.get();
		wholeDrum.append(stand, false);
		wholeDrum.append(leftLeg, false);
		wholeDrum.append(rightLeg, false);
	}
}
