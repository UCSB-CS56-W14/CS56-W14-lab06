package edu.ucsb.cs56.w14.drawings.tomcraig.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   An eye (wrapper around a General Path, implements Shape)
   (edited from CoffeeCup)
   @author Tom Craig
   @version for CS56, W11, UCSB, 02/23/2011

*/
public class Eye extends GeneralPathWrapper implements Shape
{


    /**
     * Constructor for objects of class Eye
     */
    public Eye(double x, double y, double width, double height)
    {
		Circle eyeBall = new Circle(x, y, width/2);
		Circle pupil = new Circle(x + width*.1, y, width/20);

	    GeneralPath wholeEye = this.get();
		wholeEye.append(eyeBall, false);
		wholeEye.append(pupil, false);

    }
}
