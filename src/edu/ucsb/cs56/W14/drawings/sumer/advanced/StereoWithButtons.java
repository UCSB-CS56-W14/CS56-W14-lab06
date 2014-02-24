package edu.ucsb.cs56.w14.drawings.sumer.advanced;
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
   A Stereo
      
   @author Sumer Sinha 
   @version for CS56, W14, UCSB, 02/23/2013
   
*/
public class StereoWithButtons extends Stereo implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public StereoWithButtons(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	GeneralPath gp = this.get();

	Ellipse2D.Double win1 =
	    new Ellipse2D.Double(x+.15*width, y+.2*height, .3 * height, .2*width);

	Ellipse2D.Double win2 =
	    new Ellipse2D.Double(x + width-.15*width -.2*width, y+.2*height, .3 * height, .2*width);

	Ellipse2D.Double win3 =
	    new Ellipse2D.Double(x + .375*width, y+.1*height, .1 * height, .05*width);

	Ellipse2D.Double win4 =
	    new Ellipse2D.Double(x + .475*width, y+.1*height, .1 * height, .05*width);

	Ellipse2D.Double win5 =
	    new Ellipse2D.Double(x + .575*width, y+.1*height, .1 * height, .05*width);


	GeneralPath wholeStereo = this.get();
	wholeStereo.append(win1,false);
	wholeStereo.append(win2,false);
	wholeStereo.append(win3,false);
	wholeStereo.append(win4,false);
	wholeStereo.append(win5,false);
	 
    }

}
