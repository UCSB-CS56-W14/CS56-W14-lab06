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
 * A vector drawing of a bike that implements
 * the Shape interface, and so can be drawn, as well as
 * rotated, scaled, etc.
 *
 * @author Richard Waltman
 * @version for CS56, Winter 14, UCSB
*/
public class Bike extends GeneralPathWrapper implements Shape
{
	/**
	 * Constructor
	 *
	 * @param x x coord of center of left tire of bike
	 * @param y y coord of center of left tire of bike
	 * @param rTire radius of tires
	 */
	public Bike(double x, double y, double rTire)
	{
		//make the tires
		Circle leftTire =
			new Circle ( x, y, //upper left corner of box
						 rTire );				 //radius of tire

		Circle rightTire =
			new Circle ( x + rTire*6, //space between left and right
						 y , // y stays the same
				   	     rTire );

		//helper variables
		double topForkX = x + rTire/2;
		double topTubeY = y - rTire*1.2;
		double topSeatStayX = x + rTire*6 - rTire*1.1;

		Line2D.Double fork = //fork to front wheel
			new Line2D.Double ( x, y, topForkX, topTubeY );
		
		Line2D.Double seatStays = //fork to back wheel
			new Line2D.Double ( x + rTire*6, y, 
							    topSeatStayX,
							    topTubeY );

		Line2D.Double topTube = 
			new Line2D.Double ( topForkX, topTubeY,
								topSeatStayX, topTubeY);
			
		Line2D.Double handleBar =
			new Line2D.Double ( topForkX, topTubeY - rTire/2.2,
								topForkX, topTubeY + rTire/2.2 );
		Line2D.Double seatTube =
			new Line2D.Double ( topSeatStayX, topTubeY, 
								topSeatStayX, topTubeY + rTire*1.9 );

		Line2D.Double seatTubeToWheel =
			new Line2D.Double ( topSeatStayX, topTubeY + rTire*1.9,
								x + rTire*6, y);
		Line2D.Double downTube =
			new Line2D.Double ( topSeatStayX, topTubeY + rTire*1.9,
								topForkX, topTubeY);

		Rectangle2D.Double seat =
			new Rectangle2D.Double (topSeatStayX - rTire/3, 
								    topTubeY - rTire/6,
									rTire/1.5, rTire/6); 

		GeneralPath wholeBike = this.get();
		wholeBike.append(leftTire, false);
		wholeBike.append(fork, false);
		wholeBike.append(handleBar, false);
		wholeBike.append(topTube, false);
		wholeBike.append(seatStays, false);
		wholeBike.append(rightTire, false);
		wholeBike.append(seatTube, false);
		wholeBike.append(seatTubeToWheel, false);
		wholeBike.append(downTube, false);
		wholeBike.append(seat, false);
	}
}
								 
