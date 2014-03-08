package edu.ucsb.cs56.w14.drawings.xin.advanced;
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
   A vector drawing of an balloon that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
   @author Yue Xin
   @version for CS56, Winter 14, UCSB
*/

public class Balloon extends GeneralPathWrapper implements Shape
{
    /**
     * Constructor for objects of class Balloon
     * @param x x coordinate of center of Balloon
     * @param y y coordinate of center of Balloon
     * @param r radius of Balloon
     */
    public Balloon(double x, double y, double r){

	double upperLeftX=x-r;
	double upperLeftY=y-r;
	double width= 2*r;
	double height= 3*r;

	Ellipse2D.Double b= new Ellipse2D.Double(upperLeftX, upperLeftY, width, height);
	GeneralPath balloon=this.get();
	balloon.append(b,false);

    }

}