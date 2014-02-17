package edu.ucsb.cs56.w14.drawings.kfomenko.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;  
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A Basket With Berries
      
   @author Kateryna Fomenko
   @version for CS56, W14, UCSB, 02/17/2014
   
*/
public class BasketWithBerries extends Basket implements Shape
{
    public BasketWithBerries(double x, double y, double width, double height)
    {
		// construct the basic house shell
		super(x,y,width,height);

		// get the GeneralPath that we are going to append stuff to
		GeneralPath gp = this.get();
	
		// Make five berries, located on each 6th of the basket, where xi=i*width/6.0, i = 1,2,3,4,5;
		// (x,y) = center coordinates, r = radius
		// Berry = new Ellipse with following parameters--
		// (x-r), (y-2r), (r*2), (r*2) OR (x-r), (y-2r), (r*4/3), (r*2) 
		// radius = (width/8.0)

		 double x1 = (x + width/6.0);
		 double x2 = (x + width/3.0);
		 double x3 = (x + width/2.0);
		 double x4 = (x + (2.0/3.0)*width);
		 double x5 = (x + (5.0/6.0)*width);
		
	 	 double radius = (width/8.0);

       Ellipse2D.Double berry1 = new Ellipse2D.Double(x1-radius, y - (3.0/4.0)* radius, 2.0 * radius,2.0 * radius);
       Ellipse2D.Double berry2 = new Ellipse2D.Double(x2-radius, y - 2.0 * radius, 2.0 * radius,2.0 * radius);
       Ellipse2D.Double berry3 = new Ellipse2D.Double(x3-radius, y - (3.0/4.0)* radius, 2.0 * radius,2.0 * radius);
       Ellipse2D.Double berry4 = new Ellipse2D.Double(x4-radius, y - 2.0 * radius, 2.0 * radius,2.0 * radius);
       Ellipse2D.Double berry5 = new Ellipse2D.Double(x5-radius, y - (3.0/4.0)* radius, 2.0 * radius,2.0 * radius);

		// add the berries to the basket
		     GeneralPath basketWithBerrys = this.get();
		     basketWithBerrys.append(berry1, false);
		     basketWithBerrys.append(berry2, false);
		     basketWithBerrys.append(berry3, false); 
		     basketWithBerrys.append(berry4, false); 
		     basketWithBerrys.append(berry5, false); 
		 }

}
