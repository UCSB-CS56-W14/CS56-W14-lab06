package edu.ucsb.cs56.w14.drawings.jrcryan.advanced;
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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a popsicle on a stick that 
   implements the Shape interface, and so can be 
   drawn, as well as rotated, scaled, etc.
      
   @author Jenna Cryan
   @version for CS56, Winter 14, UCSB
   
*/
public class PopsicleOnAStick extends Popsicle implements Shape
{
    /**
       Constructor for PopsicleOnAStick class

       @param x x coord of upper left corner of body of popsicle
       @param y y coord of upper left corner of popsicle (not including stick)
       @param width width of the popsicle
       @param height of popsicle (not including stick)
     */
    public PopsicleOnAStick(double x, double y, double width, double height)
    {
	// calls super constructor to make body of popsicle
	super(x, y, width, height);

	GeneralPath gp = this.get();

	// get lower x coord, ycoord, height, and width for popsicle stick
	double stickX = x + (width * .5) - ((width * .34) * .5);
	double stickY = y + (height * .97);
	double stickHeight = height * .3333;
	double stickWidth = width * .3333;
	Rectangle2D.Double stick = new Rectangle2D.Double(stickX, stickY, stickWidth, stickHeight);

	// gets popsicle body and appends stick to bottom center
	GeneralPath popsicleOnStick = this.get();
	popsicleOnStick.append(stick, false);
    }

}
