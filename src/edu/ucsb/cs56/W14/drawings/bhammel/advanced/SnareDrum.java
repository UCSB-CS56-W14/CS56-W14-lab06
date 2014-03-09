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

public class SnareDrum extends GeneralPathWrapper implements Shape
{
	/**
		Constructor

		@param x x coord of upper left corner of snare drum
		@param y y coord of upper left corner of snare drum
		@param width width of snare drum
		@param height height of snare drum
    */

	public SnareDrum(double x, double y, double width, double height)
	{
		Ellipse2D.Double head = new Ellipse2D.Double(x, y, width, 0.3 * height);

		double yExtra = 0.15 * height;

		Line2D.Double leftSide = new Line2D.Double(x, y + yExtra, x, y + height);
		Line2D.Double rightSide = new Line2D.Double(x + width, y + yExtra, x + width, y + height);
		Line2D.Double bottom = new Line2D.Double(x, y + height, x + width, y + height);

		double increment = width/5;
		double tensionRod2Increment = increment * 2;
		double tensionRod3Increment = increment * 3;
		double tensionRod4Increment = increment * 4;

		Line2D.Double tensionRod1 = new Line2D.Double(x + increment, y + (0.27 * height), x + increment, y + height);
		Line2D.Double tensionRod2 = new Line2D.Double(x + tensionRod2Increment, y + (0.3 * height), x + tensionRod2Increment, y + height);
		Line2D.Double tensionRod3 = new Line2D.Double(x + tensionRod3Increment, y + (0.3 * height), x + tensionRod3Increment, y + height);
		Line2D.Double tensionRod4 = new Line2D.Double(x + tensionRod4Increment, y + (0.27 * height), x + tensionRod4Increment, y + height);

		GeneralPath wholeDrum = this.get();
		wholeDrum.append(head, false);
		wholeDrum.append(leftSide, false);
		wholeDrum.append(rightSide, false);
		wholeDrum.append(bottom, false);
		wholeDrum.append(tensionRod1, false);
		wholeDrum.append(tensionRod2, false);
		wholeDrum.append(tensionRod3, false);
		wholeDrum.append(tensionRod4, false);
	}
}
