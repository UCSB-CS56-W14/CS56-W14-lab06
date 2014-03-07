package edu.ucsb.cs56.w14.drawings.l_y_s.advanced;
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
   A Triforce
   
   @author Phill Conrad
   @author Logan Schmidt 
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class Triforce extends Triangle implements Shape
{
    /**
     * Constructor for objects of class Triforce
     */
    public Triforce(double x, double y, double width, double height)
    {
	// construct the basic triangle
	super(x,y,width,height);
	
	//Calculate the midpoints of the lines of the basic triangle
	double xMidPointLeft = (x+(x+(width/2)))/2;
	double yMidPointLeft = (y+(y-height))/2;
	double xMidPointRight = ((x+(width/2))+(x+width))/2;
	double yMidPointRight = ((y-height)+y)/2;
	double xMidPointBottom = (x+(x+width))/2;
	double yMidPointBottom = (y+y)/2;
	
	//Draw inverted triangle within the basic triangle using midpoints
	Line2D.Double leftLine2 = new Line2D.Double(xMidPointLeft, yMidPointLeft, xMidPointBottom, yMidPointBottom);
	Line2D.Double rightLine2 = new Line2D.Double(xMidPointBottom, yMidPointBottom, xMidPointRight, yMidPointRight);
	Line2D.Double topLine = new Line2D.Double(xMidPointLeft, yMidPointLeft, xMidPointRight, yMidPointRight);

	//Add to general path
	GeneralPath wholeTriforce = this.get();
	wholeTriforce.append(leftLine2, false);
	wholeTriforce.append(rightLine2, false);
	wholeTriforce.append(topLine, false);
    }

}
