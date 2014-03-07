package edu.ucsb.cs56.w14.drawings.rtwaltman.advanced;
import java.awt.geom.GeneralPath; //combinations of lines and curves
import java.awt.geom.AffineTransform; //translation, rotation, scale
import java.awt.Shape; //general class for shapes

//all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/** 
 * A vector drawing of a Tandem Bike that implements
 * the Shape interface, and so can be drawn, and the Bike
 * class to use as a base image.
 *
 * @author Richard Waltman
 * @version for CS56, Winter 14, UCSB
*/
public class TandemBike extends Bike implements Shape
{
	/**
	 * Constructor for TandemBike
	 *
	 * @param x x coord of center of left tire of bike
	 * @param y y coord of center of left tire of bike
	 * @param rTire radius of tires
	 */
	public TandemBike(double x, double y, double rTire)
	{
		super(x,y,rTire); //calls Bike and creates the baseline bike

		//adding a second seat to Bike
		//helper variables
		double topForkX = x + rTire/2;
		double topTubeY = y - rTire*1.2;
		double topSeatStayX = x + rTire*6 - rTire*1.1;

		Rectangle2D.Double seat2 =
			new Rectangle2D.Double( (topForkX + topSeatStayX)/2,
									topTubeY - rTire/6,
									rTire/1.5, rTire/6 );		

		GeneralPath wholeBike = this.get();
		wholeBike.append(seat2, false);
	}
}
								 
