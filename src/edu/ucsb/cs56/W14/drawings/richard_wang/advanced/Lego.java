package edu.ucsb.cs56.w14.drawings.richard_wang.advanced;
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
   A Lego
      
   @author Richard Wang
   @version for CS56, W14, UCSB, 2/27/14
   
*/
public class Lego extends Cube implements Shape
{
    /**
     * Constructor for objects of class Lego
     */
    public Lego(double x, double y, double length)
    {
	// construct the basic cube shell
	super(x,y,length);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

        Ellipse2D.Double e1 =
	    new Ellipse2D.Double(x + (length)/5, y + (length)/5, length/5, length/5);
	Ellipse2D.Double e2 =
	    new Ellipse2D.Double(x + 3 * (length)/5, y + (length)/5, length/5, length/5);
	Ellipse2D.Double e3 =
	    new Ellipse2D.Double(x + (length)/5, y + 3 * (length)/5, length/5, length/5);
	Ellipse2D.Double e4 =
	    new Ellipse2D.Double(x + 3 * (length)/5, y + 3 * (length)/5, length/5, length/5);
	
        GeneralPath wholeLego = this.get();
        wholeLego.append(e1, false);
        wholeLego.append(e2, false);
        wholeLego.append(e3, false); 
	wholeLego.append(e4, false);
    }

}
