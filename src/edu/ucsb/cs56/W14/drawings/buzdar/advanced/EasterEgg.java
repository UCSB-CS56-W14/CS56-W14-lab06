package edu.ucsb.cs56.w14.drawings.buzdar.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class EasterEgg extends Egg implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public EasterEgg(double x, double y, double width, double height)
    {
	// construct the basic egg shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double w = 0.10 * width;
	double winTop = y + 0.5 * height;
	double winHt =  0.25 * height;

	Ellipse2D.Double win1 =
	    new Ellipse2D.Double(x + w, winTop, 2.0 * w, winHt);
	Ellipse2D.Double win2 =
	    new Ellipse2D.Double(x + 4.0*w, winTop, 2.0 * w, winHt);
	Ellipse2D.Double win3 =
	    new Ellipse2D.Double(x + 7.0*w, winTop, 2.0 * w, winHt);
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(win1, false);
        wholeHouse.append(win2, false);
        wholeHouse.append(win3, false); 
    }

}
