 package edu.ucsb.cs56.w14.drawings.keithwaldron.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
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
   A House
      
   @author Keith Waldron 
   @version for CS56, W11, UCSB, 02/23/2014
   
*/
public class Bifocals extends Glasses implements Shape
{
    /**
     * Constructor for objects of class Glasses
     */
    public Bifocals(double x, double y, double radius)
    {
	// construct the basic glasses shell
	super(x,y, radius);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

     	double mid = radius/2;     
	double rBegin= x+radius*2+mid; //begining x of right arm

	//left lense bifocal seperation
	Line2D.Double lin1 = 
            new Line2D.Double (x, y+mid,
                               x+radius, y+mid);
        //right lense bifocal seperation
        Line2D.Double lin2 =
            new Line2D.Double  (rBegin-radius, y+mid,
                               rBegin, y+mid);
	
	// add the lense seperation to the glasses to make bifocals

        GeneralPath wholeGlasses = this.get();
        wholeGlasses.append(lin1, false);
        wholeGlasses.append(lin2, false);

    }

}
