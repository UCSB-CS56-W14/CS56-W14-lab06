package edu.ucsb.cs56.w14.drawings.vlara.advanced;
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
   A House
      
   @author Vincente Lara 
   @version for CS56, W14, UCSB, 02/25/2014
   
*/
public class HourglassFull extends Hourglass implements Shape
{

    public HourglassFull(double x, double y, double width, double height)
    {
	// construct the basic hourglass
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
        //add a top and bottom base to the hourglass
        //simple rectangle shape like so
        //
	double widthBase = width;
	double heightBase = .1 * height;
       
        //Fixed
        //width was just a number and not the distance between the points

	Rectangle2D.Double topBase =
	    new Rectangle2D.Double(x, y - heightBase, widthBase, heightBase);
	Rectangle2D.Double bottomBase =
	    new Rectangle2D.Double(x, (height + y), widthBase, heightBase);
	
	// add bases to the hourglass
        
        GeneralPath wholeHourglass = this.get();
        wholeHourglass.append(topBase, false);
        wholeHourglass.append(bottomBase, false);
	
    }

}
