package edu.ucsb.cs56.w14.drawings.kylejorgensen.advanced;
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
   A subclass of SoccerBall that adds pentagons on the ball to make it look more realistic. 
      
   @author Phill Conrad 
   @author Kyle Jorgensen, TA
   @version for Lab 06, CS56, W14
   
*/
public class SoccerBallWithPentagons extends SoccerBall implements Shape
{
	public SoccerBallWithPentagons(double centerx, double centery, double radius)
	{
		// call the constructor of SoccerBall
		super(centerx, centery, radius);

		GeneralPath wholeSoccerBall = this.get();

		// append the 3 pentagons within the soccerball
		appendPentagon(wholeSoccerBall, centerx, centery+(radius/2), radius/3, 1);
		appendPentagon(wholeSoccerBall, centerx+radius*.3536, centery-radius*.3536, radius/3, -1);
		appendPentagon(wholeSoccerBall, centerx-radius*.6, centery-radius*(.3536/2), radius/3, -1);
	}


	/**
       This function is a helper funtion used by drawBall to append the pentagons within the ball
       @param thisPath  the GeneralPath wrapper object
       @param centerx  the x coordinate for the center of the pentagon
       @param centery  the y coordinate for the center of the pentagon
       @param radius  the distance to each of the 5 corners of the pentagon
       @param yDirection  used to "flip" the pentagon - should be 1 for normal or -1 for upside down

     */
    public void appendPentagon(GeneralPath thisPath, double centerx, 
			     double centery, double radius, int yDirection)
    {

	int y = yDirection; //ydirection can be 1 or -1, changes direction
	Line2D.Double l1 = new Line2D.Double(centerx,
					     centery-radius*y,
					     centerx+radius*.951,
					     centery-radius*.309*y);
	Line2D.Double l2 = new Line2D.Double(centerx+radius*.951,
					     centery-radius*.309*y,
					     centerx+radius*.5879,
					     centery+radius*.809*y);
	Line2D.Double l3 = new Line2D.Double(centerx+radius*.5879,
					     centery+radius*.809*y,
					     centerx-radius*.5879,
					     centery+radius*.809*y);
	Line2D.Double l4 = new Line2D.Double(centerx-radius*.5879,
					     centery+radius*.809*y,
					     centerx-radius*.951,
					     centery-radius*.309*y);
	Line2D.Double l5 = new Line2D.Double(centerx-radius*.951,
					     centery-radius*.309*y,
					     centerx,
					     centery-radius*y);
	
	thisPath.append(l1, false);
	thisPath.append(l2, false);
	thisPath.append(l3, false);
	thisPath.append(l4, false);
	thisPath.append(l5, false);
    }
}