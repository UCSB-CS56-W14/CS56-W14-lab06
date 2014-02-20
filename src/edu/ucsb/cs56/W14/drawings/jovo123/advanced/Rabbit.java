package edu.ucsb.cs56.w14.drawings.jovo123.advanced;
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
   A Rabbit
      
   @author JosephineVo 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class Rabbit extends Rodent implements Shape
{
    /**
     * Constructor for objects of class Rabbit
     */
    public Rabbit(double x, double y, double r)
    {
	// construct the basic rodent
	super(x,y,r);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make two ears with height 2*r and width r/2;
	//
	// The ears will be at top of the head

	double earHeight = 2 * r;
	double earWidth = 0.5 * r;
	double earY = y - (2.7*r);
	double earLX = x - r;
	double earRX = x + r / 2;

	Ellipse2D.Double leftEar =
	    new Ellipse2D.Double(earLX, earY, earWidth, earHeight);
	Ellipse2D.Double rightEar =
	    new Ellipse2D.Double(earRX, earY, earWidth, earHeight);
	
	// add the ears to the house

        GeneralPath rabbit = this.get();
        rabbit.append(leftEar, false);
        rabbit.append(rightEar, false); 
    }

}
