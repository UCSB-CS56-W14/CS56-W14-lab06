package edu.ucsb.cs56.w14.drawings.ricklee.advanced;
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
   A Stickman with a Hat
      
   @author Rick Lee 
   @version for CS56, W14, UCSB, 02/13/2014
   
*/
public class StickmanWithHat extends Stickman implements Shape
{
    /**
     * Constructor for objects of class StickmanWithHat
     */
    public StickmanWithHat(double x, double y, double height)
    {
	// construct the basic stickman shell
	super(x,y,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	//Place a hat right on top of the head

	double hatHeight = 0.2*height;
	double hatWidth = 0.15*height;  //Width for the head of the hat
	double hatRimWidth = 0.25*height;
	
	//Draw the rim of the hat
	Line2D.Double hatRim = new Line2D.Double(x-(hatRimWidth/2),y-height,x+(hatRimWidth/2),y-height);

	//Draw the head of the hat
	Rectangle2D.Double hatHead = new Rectangle2D.Double(x-(hatWidth/2),y-height-hatHeight,hatWidth,hatHeight);
	
	// add hat to the stickman
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeStickman = this.get();
        wholeStickman.append(hatRim, false);
        wholeStickman.append(hatHead, false);
    }

}
