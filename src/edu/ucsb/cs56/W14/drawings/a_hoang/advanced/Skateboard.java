package edu.ucsb.cs56.w14.drawings.a_hoang.advanced;
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
   A Skateboard
      
   @author Anthony Hoang 
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class Skateboard extends Board implements Shape
{
    /**
     * Constructor for objects of class Skateboard
     */
    public Skateboard(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double lxCenter = x + 0.2 * width;
	double rxCenter = x + 0.8 * width;
	double lyCenter = y + height + 0.1 * height;
	double ryCenter = y + height + 0.1 * height;
	double radius = 0.1 * height;
	
	Circle lWheel = new Circle(lxCenter,lyCenter,radius);
	Circle rWheel = new Circle(rxCenter, ryCenter, radius);

	//add the wheels
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeBoard = this.get();
        wholeBoard.append(lWheel, false);
        wholeBoard.append(rWheel, false);
        
    }

}
