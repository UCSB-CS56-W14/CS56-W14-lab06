package edu.ucsb.cs56.w14.drawings.chrisluo.advanced;
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
   A House
      
   @author Phill Conrad 
   @author Chris Luo
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class PumpkinJack extends Pumpkin implements Shape
{
    public PumpkinJack(double x, double y, double width, double height)
    {
	// construct the basic pumpkin
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	Ellipse2D.Double eye1 =
	    new Ellipse2D.Double(x-25,y-25,x-25,y-25);
	Ellipse2D.Double eye2 =
	    new Ellipse2D.Double(x+25, y-25,width-10, height +10);
	Line2D.Double mouth =
	    new Line2D.Double(x, y, width, height);
	
	// add the eyes to the pumpkin
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholepumpkin = this.get();
        wholepumpkin.append(eye1, false);
        wholepumpkin.append(eye2, false);
        wholepumpkin.append(mouth, false); 
    }

}
