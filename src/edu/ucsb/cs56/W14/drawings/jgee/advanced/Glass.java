package edu.ucsb.cs56.w14.drawings.jgee.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

public class Glass extends GeneralPathWrapper  implements Shape {

/** Constructor

@param x x coord of lower left corner of glass
@param y y coord of lower left corner of glass
@param width width of glass
@param height height of glass 
*/
	public Glass(double x, double y, double width, double height) {
		Line2D.Double leftSide = new Line2D.Double(x,y,x,y+height);
		Line2D.Double rightSide = new Line2D.Double(x+width,y+height,x+width,y);
		Ellipse2D.Double rim = new Ellipse2D.Double(x,y,width,5);
		GeneralPath wholeGlass = this.get();
		wholeGlass.append(leftSide, false);
		wholeGlass.append(rightSide, true);
		wholeGlass.append(rim, false);
	}
}