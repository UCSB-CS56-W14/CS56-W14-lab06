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
  A vector drawing of a lollipop that implements
  the Shape interface, and so can be drawn, as well as
  rotated, scaled, etc.

  @author Eric Palyan 
  @version for CS56, Winter 14, UCSB

*/
public class Lollipop extends GeneralPathWrapper implements Shape
{
	/**
	  Constructor

	  @param x x coord of lower left corner of lollipop head
	  @param y y coord of lower left corner of lollipop head
	  @param width width of the lollipop head
	  @param height height of the lolipop head
	  */
	public Lollipop(double x, double y, double width, double height)
	{

	    // Rather than having to scale at the end, we can just
	    // draw things the right way to begin with, using the
	    // x, y, width and height.   If you haven't already
	    // hard coded a particular drawing, this may be an easier
	    // way.
	    
	    
	    // Make the candy head
	    Ellipse2D.Double candy = new Ellipse2D.Double(x, y, width, height);
	    
            
	    // make the lollipop handle (stick)
	    Rectangle2D.Double handle = new Rectangle2D.Double(x+(width/2*.9), y+height, width*.1, height*.75);

	    // put the whole lollipop together
	    GeneralPath Lollipop = this.get();
	    Lollipop.append(candy, false);
	    Lollipop.append(handle, false);
	    
    }
    
}
