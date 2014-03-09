package edu.ucsb.cs56.w14.drawings.cantor.advanced;
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
   A vector drawing of a triangle that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Antonio Cantor
   @version for CS56, Winter 14, UCSB
   
*/
public class Triangle extends GeneralPathWrapper implements Shape
{

public Triangle(double x, double y, double w, double h)
	{

	//bottom side
	Line2D.Double bottomside =
	new Line2D.Double (x/3,y,w,h);

	//right side
	Line2D.Double rightside =
	new Line2D.Double (x/3,y/3,w,h );
	
	//left side
	Line2D.Double leftside =
	new Line2D.Double (x/3,y/3,w/3,h);

	//put the whole triangle together
	GeneralPath wholeTriangle = this.get();
	wholeTriangle.append(leftside, false);
	wholeTriangle.append(rightside, false);
	wholeTriangle.append(bottomside, false);
	}

}
