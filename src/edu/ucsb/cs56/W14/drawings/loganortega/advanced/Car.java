package edu.ucsb.cs56.w14.drawings.loganortega.advanced;
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
   A vector drawing of a car that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
   For best result, keep dimensions of car to 2x1 ratio.
      
   @author Logan Ortega
   @version for CS56, Winter 14, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape
{
    /**
       Constructor for Object of type Car

       @param x x coord of upper left corner of car
       @param y y coord of upper left corner of car
       @param width width of the car frame
       @param height height of car frame
     */
    public Car(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	// Declare constants to increase maintainability 
        final double tireRadius = 0.125 * height; // the radius of wheel is 1/8 of Car height
	final double rimRadius = 0.0625 * height; // the radius of rim is 1/2 of tireRadius
	final double widthWindow = 0.2 * width; // the width of windshield is 1/5 of Car width
	final double heightWindow = 0.4 * height; // the height of windshield is 2/5 of Car height
	
	// Make the car frame 
	Rectangle2D.Double carFrame = 
	    new Rectangle2D.Double(x, y, width, height); 
	
	// Make the window for the car frame
	Rectangle2D.Double frontWindow =
	    new Rectangle2D.Double(x, y + 0.1 * height, widthWindow, heightWindow);
	
	// Make the tire and rim shapes
	Circle frontWheel =
	    new Circle(x + (0.15 * x), y + height, tireRadius);
	Circle frontRim = 
	    new Circle(x + (0.15 * x), y + height, rimRadius);
	Circle backWheel = 
	    new Circle(x + width - (0.15 * x), y + height, tireRadius);
	Circle backRim = 
	    new Circle(x + width - (0.15 * x), y + height, rimRadius);
                          
	
        // put the whole house together
       
        GeneralPath wholeCar = this.get();
        wholeCar.append(carFrame, false);
	wholeCar.append(frontWindow, false);
        wholeCar.append(frontWheel, false);
        wholeCar.append(frontRim, false);
	wholeCar.append(backWheel, false);
	wholeCar.append(backRim, false);
        
    }

}
