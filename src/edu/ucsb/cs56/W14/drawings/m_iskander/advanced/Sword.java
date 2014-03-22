package edu.ucsb.cs56.w14.drawings.m_iskander.advanced;
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
   A Sword by Mena Iskander
      
   @author Mena Iskander
   @version for CS56, W14, UCSB, 02/27/2014
   
*/
public class Sword extends Blade implements Shape
{
    /**
     * Constructor for objects of class Sword
     */
    public Sword(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//create the guard of the sword

	double guardWidth = 2 * width;
	double guardHeight =  0.1 * height;

	Rectangle2D.Double guard =
	    new Rectangle2D.Double(x-width/2, y+height, guardWidth, guardHeight);

	//create the handle of the guard

	double handleWidth=width*.3;
	double handleHeight=.6*height;

       	Rectangle2D.Double handle = new Rectangle2D.Double((x+width/2)-handleWidth/2, y+height,handleWidth, handleHeight);

	//Put the sword together

        GeneralPath wholeSword = this.get();
        wholeSword.append(guard, false);
        wholeSword.append(handle, false);
    }

}
