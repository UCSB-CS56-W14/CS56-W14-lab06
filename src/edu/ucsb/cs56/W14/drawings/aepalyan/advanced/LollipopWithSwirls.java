package edu.ucsb.cs56.w14.drawings.aepalyan.advanced;
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
   A Lollipop with Swirls

   @author Eric Palyan
   @version for CS56, W14, UCSB, 02/23/2014

*/
public class LollipopWithSwirls extends Lollipop implements Shape
{
    /**
     * Constructor for objects of class LollipopWithSwirlds
     */
    public LollipopWithSwirls(double x, double y, double width, double height)
    {
        // construct the basic lollipop outline
        super(x,y,width,height);

        // get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();

	// make swirls
	GeneralPath wholeLollipop = this.get();
	Ellipse2D.Double swirl;
	for(int i = 0; i < 5; i++) {
	    x += width*.05;
	    y += height*.05;
	    width *= .9;
	    height *= .9;
	    swirl = new Ellipse2D.Double(x, y, width, height);
	    wholeLollipop.append(swirl, false);
	}
       
    }

}
