package edu.ucsb.cs56.w14.drawings.sdrhoads.advanced;
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
   A House
      
   @author Phill Conrad 
   @version for CS56, W14, UCSB
   
*/
public class PepperoniPizza extends Pizza implements Shape
{
    /**
     * Constructor for objects of class PepperoniPizza
     */
    public PepperoniPizza(double x, double y, double width, double length)
    {
	// construct the basic pizza shape
	super(x,y,width,length);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make the pepperonis,
	double rad = 0.10 * width;

	Circle pep1 = new Circle(x + width*.7, y - length*.4, rad); 
	Circle pep2 = new Circle(x + width*.3, y - length*.6, rad); 
	Circle pep3 = new Circle(x + width*.5, y - length*1.3, rad);

	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholePizza = this.get();
        wholePizza.append(pep1, false);
        wholePizza.append(pep2, false);
        wholePizza.append(pep3, false);
    }

}
