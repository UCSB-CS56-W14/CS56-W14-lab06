package edu.ucsb.cs56.w14.drawings.kjih.advanced;
import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
import java.awt.Shape;

import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;


/**
   A vector drawing of a radio that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Kevin Jih
   @version for CS56, Winter 14, UCSB

*/
public class Radio extends GeneralPathWrapper implements Shape
{
     /**
	Constructor

	@param x x coord of upper left corner of Radio
	@param y y coord of upper left corner of Radio
	@param width width of Radio
	@param height height of Radio
     */
    public Radio(double x, double y, double width, double height)
    {
	double rightCircleCenterX = x + (width * 0.75);
	double leftCircleCenterX = x + (width * 0.25);
	double circleCenterY = y + (height * 0.5);
	double radiusX = width * 0.125;
	double radiusY = height * 0.25;
	
	Rectangle2D.Double frame = 
	    new Rectangle2D.Double(x, y, width, height);

	Ellipse2D.Double rightSpeaker =
	    new Ellipse2D.Double(rightCircleCenterX - (radiusX/2), 
				 circleCenterY - (radiusY/2), 
				 radiusX,
				 radiusY);

	Ellipse2D.Double leftSpeaker =
	    new Ellipse2D.Double(leftCircleCenterX - (radiusX/2),
				 circleCenterY - (radiusY/2),
				 radiusX,
				 radiusY);

	Line2D.Double antenna =
	    new Line2D.Double(rightCircleCenterX, y,
			      rightCircleCenterX, y - (height*0.75));

	GeneralPath wholeRadio = this.get();
	wholeRadio.append(frame, false);
	wholeRadio.append(rightSpeaker, false);
	wholeRadio.append(leftSpeaker, false);
	wholeRadio.append(antenna, false);
    }
}
