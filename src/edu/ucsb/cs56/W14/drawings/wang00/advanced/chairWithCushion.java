package edu.ucsb.cs56.w14.drawings.wang00.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A chair
      
   @author Phill Conrad 
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class chairWithCushion extends chair implements Shape
{
    /**
     * Constructor for objects of class chairWithCushion
     */
    public chairWithCushion(double x, double y, double width, double height)
    {
	// construct the basic chair
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double w = 0.8 * width;
	double h = 0.5 * height;
	
	// draw Ellipse2D.Double
	Ellipse2D.Double Cushion = new Ellipse2D.Double(x,y-0.15*width,w,h);
	    

        GeneralPath wholeChair = this.get();
        wholeChair.append(Cushion, false);
    }

}
