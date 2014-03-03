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
   A radio that extends class Radio to include buttons

   
   @author Kevin Jih
   @version for CS56, Winter 14, UCSB

*/

public class RadioWithButtons extends Radio implements Shape
{
     /**
        Constructor
       
        @param x x coord of upper left corner of Radio
        @param y y coord of upper left corner of Radio
        @param width width of Radio
        @param height height of Radio
     */
    public RadioWithButtons(double x, double y, double width, double height)
    {
	super(x,y,width,height);

	double buttonWidth = width * 0.0625;
	double buttonHeight = height * 0.166;
	double topLeftX = x + width * 0.375;
	double topLeftY = y + height * 0.666;

	Rectangle2D.Double b1 =
	    new Rectangle2D.Double(topLeftX, 
				   topLeftY, 
				   buttonWidth, 
				   buttonHeight);
	Rectangle2D.Double b2 =
	    new Rectangle2D.Double(topLeftX + buttonWidth,
				   topLeftY,
				   buttonWidth,
				   buttonHeight);
	Rectangle2D.Double b3 =
	    new Rectangle2D.Double(topLeftX + buttonWidth*2,
				   topLeftY,
				   buttonWidth,
				   buttonHeight);
	Rectangle2D.Double b4 =
	    new Rectangle2D.Double(topLeftX + buttonWidth*3,
				  topLeftY,
				  buttonWidth,
				  buttonHeight);

	GeneralPath wholeRadio = this.get();
	wholeRadio.append(b1, false);
	wholeRadio.append(b2, false);
	wholeRadio.append(b3, false);
	wholeRadio.append(b4, false);
    }
}
