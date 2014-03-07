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

public class FullGlass extends Glass implements Shape{
	public FullGlass(double x, double y, double width, double height){
		super(x,y,width,height);
		GeneralPath gp = this.get();
		Line2D.Double fillLine = new Line2D.Double(x,y+height*(0.25),x+width,y+height*(0.25));
		GeneralPath wholeGlass = this.get();
		wholeGlass.append(fillLine, false);
	}
}