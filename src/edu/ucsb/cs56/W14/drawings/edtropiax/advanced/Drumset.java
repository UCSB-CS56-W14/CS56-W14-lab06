package edu.ucsb.cs56.w14.drawings.edtropiax.advanced;
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
   A Drumset, which is a bongo with some drumsticks
      
   @author Marcus Liou 
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class Drumset extends Bongo implements Shape
{
    /**
       Constructor for objects of class Drumset
     */
    public Drumset(double x, double y, double width, double height)
    {
	// construct the basic bongo shell
	super(x,y,width,height);

	// left drumstick 
	GeneralPath leftSide = new GeneralPath();
       
        leftSide.moveTo(x,y-(2.0/3.0)*height);
        leftSide.lineTo(x+(2.5/9.0)*width,y);

	// right drumstick 
	GeneralPath rightSide = new GeneralPath();
       
        rightSide.moveTo(x+width,y-(2.0/3.0)*height);
        rightSide.lineTo(x+(7.5/9.0)*width,y);
	
	//Add drumsticks to the whole thing
        GeneralPath wholeDrum = this.get();
        wholeDrum.append(leftSide, false);
        wholeDrum.append(rightSide, false);
    }

}
