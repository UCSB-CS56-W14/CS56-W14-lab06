package edu.ucsb.cs56.w14.drawings.blakezimmerman.advanced;
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
   A Tire Swing
       
   @author Blake Zimmerman
   @version for CS56, W14, UCSB, 02/13/2014
   
*/
public class TireSwing extends Tire implements Shape
{
    /**
     * Constructor for objects of class TireSwing
     */
    public TireSwing(double x, double y, double r, double width)
    {
	// construct the basic tire shell
	super(x,y,r,width);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	/* Make five lines: one for the rope, one for the tree
	   branch, one for the ground, and two for the tree
	*/

	final double lenR = ((r + width) * 3) + r;
	final double lenB = lenR - r;
	final double xOfB = x - (r + width)/3;
	final double yOfB = y - r - lenR;
	final double lenT = (r + width) * 5;
	final double widthOfT = (r + width) * 1.5;
	final double xOfG = x - r - width - (r + width)/3;
	final double yOfG = y + r + width + (r + width)/3;

	// creates the rope
	Line2D.Double rope =
	    new Line2D.Double(x, y - r, x, yOfB);

	// creates the tree branch
	Line2D.Double branch =
	    new Line2D.Double(xOfB, yOfB, xOfB + lenB, yOfB);

	// creates the left side of the tree
	Line2D.Double treeL = 
	    new Line2D.Double(xOfB + lenB, yOfB, xOfB + lenB, yOfG); 

	// creates the right side of the tree
	Line2D.Double treeR = 
	    new Line2D.Double(xOfB + lenB + widthOfT, yOfB, xOfB + lenB + widthOfT, yOfG);

	// creates the ground
	Line2D.Double ground =
	    new Line2D.Double(xOfG, yOfG, xOfB + lenB + widthOfT, yOfG);
	
	// add the rope, branch, ground, and tree for the tire swing
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeTire = this.get();
        wholeTire.append(rope, false);
        wholeTire.append(branch, false);
        wholeTire.append(treeL, false);
	wholeTire.append(treeR, false);
	wholeTire.append(ground, false);
    }

}
