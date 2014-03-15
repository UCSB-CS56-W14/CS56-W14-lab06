package edu.ucsb.cs56.w14.drawings.loganortega.advanced;
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
   A vector drawing of a Limo that implements the Shape interface, 
   and so can be drawn, as well as rotated, scaled, etc.
      
   @author Logan Ortega
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class Limo extends Car implements Shape
{
    /**
     * Constructor for objects of class Limo
       @param x x coord of upper left corner of limo
       @param y y coord of upper left corner of limo
       @param width width of the limo frame
       @param height height of limo frame 
     */
    public Limo(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make four windows, spaced like this, where v = 0.025 * width;
	// | +--+ +--+ +--+ +--+ |
	// | |  | |  | |  | |  | |
	// | +--+ +--+ +--+ +--+ |
	// |v 6v v 6v v 6v v 6v v|
	//
	// The top of window will be at y + 0.1*height and the
	// height of the window is 0.4*height;

	double v = 0.025 * width;
	double winTop = y + 0.1 * height;
	double winHt =  0.4 * height;

	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + (0.2*width) + v, winTop, 6.0 * v, winHt);
	Rectangle2D.Double win2 =
	    new Rectangle2D.Double(x + (0.2*width) + 8.0*v, winTop, 6.0 * v, winHt);
	Rectangle2D.Double win3 =
	    new Rectangle2D.Double(x + (0.2*width) + 15.0*v, winTop, 6.0 * v, winHt);
	Rectangle2D.Double win4 = 
	    new Rectangle2D.Double(x + (0.2*width) + 22.0*v, winTop, 6.0 * v, winHt);
	
	// add the windows to the Limo
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeLimo = this.get();
        wholeLimo.append(win1, false);
        wholeLimo.append(win2, false);
        wholeLimo.append(win3, false); 
	wholeLimo.append(win4, false);
    }

}
