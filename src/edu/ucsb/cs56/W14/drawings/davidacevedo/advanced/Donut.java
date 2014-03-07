package edu.ucsb.cs56.w14.drawings.davidacevedo.advanced;
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
import edu.ucsb.cs56.w14.drawings.davidacevedo.simple.Circle;

/**
   A drawing of a Donut that implements
   the Shape interface, so it can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author David Acevedo
   @version for Lab 06, CS56, Winter 14, UCSB
   
*/
public class Donut extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param centerx  the x coordinate for the center of the donut
       @param centery  the y coordinate for the center of the donut
       @param radius  the radius of the donut
     */
    public Donut(double centerx, double centery, double radius)
    {
    
	Circle donut = new Circle(centerx, centery, radius);
	Circle donutHole = new Circle(centerx, centery, radius*.33);
    GeneralPath wholeDonut = this.get();
		
    wholeDonut.append(donut, false);
	wholeDonut.append(donutHole, false);
    }
}