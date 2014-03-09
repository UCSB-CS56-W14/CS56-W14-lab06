package edu.ucsb.cs56.w14.drawings.jrcryan.advanced;
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
   A vector drawing of a popsicle that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jenna Cryan
   @version for CS56, Winter 14, UCSB
   
*/
public class Popsicle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor for Popsicle class

       @param x x coord of upper left corner of popsicle
       @param y y coord of upper left corner of popsicle
       @param width width of the popsicle
       @param height height of popsicle
     */
    public Popsicle(double x, double y, double width, double height)
    {
	// creates ellipse base shape of popsicle
	Ellipse2D.Double popsicle = new Ellipse2D.Double(x, y, width, height);
	GeneralPath gp = this.get();
	gp.append(popsicle, false);
    }

}
