package edu.ucsb.cs56.w14.drawings.tomcraig.advanced;
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
   An with and iris
   (edited from HouseWithWindows)
   @author Tom Craig
   @version for CS56, W11, UCSB, 02/23/2011

*/
public class EyeWithIris extends Eye implements Shape
{
    /**
     * Constructor
     */
    public EyeWithIris(double x, double y, double width, double height)
    {
		// construct the basic Eye
		super(x,y,width,height);

		//Single circle that will go around the pupil

		Circle iris = new Circle(x + width*.1, y, width/4);

	    GeneralPath wholeEye = this.get();
		wholeEye.append(iris, false);
    }
}
