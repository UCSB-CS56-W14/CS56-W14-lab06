package edu.ucsb.cs56.w14.drawings.ziping_he.advanced;
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
   A Flag
      
   @author Phill Conrad
   @author Ziping He 
   @version for CS56, W14, UCSB, 02/20/2014
   
*/
public class FlagWithStick extends Flag implements Shape
{
    /**
     * Constructor for objects of class Flag
     */
    public FlagWithStick(double x, double y, double width, double height)
    {
	// construct the basic flag shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();


	//Make a stick on the left side of the flag length=height*(1.5)
	double length = height*(1);
	Line2D.Double stick = 
            new Line2D.Double (x, y,
                               x, y+length);
	



	// Make three windows, spaced like this, where w=width/10.0;
	// | +--+ +--+ +--+ |
	// | |  | |  | |  | |
	// | +--+ +--+ +--+ |
	// |w 2w w 2w w w2 w|
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;

	/*double w = 0.10 * width;
	double winTop = y + 0.5 * height;
	double winHt =  0.25 * height;

	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + w, winTop, 2.0 * w, winHt);
	Rectangle2D.Double win2 =
	    new Rectangle2D.Double(x + 4.0*w, winTop, 2.0 * w, winHt);
	Rectangle2D.Double win3 =
	    new Rectangle2D.Double(x + 7.0*w, winTop, 2.0 * w, winHt);
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")*/

        GeneralPath wholeFlag = this.get();
        wholeFlag.append(stick, false);
    }

}
