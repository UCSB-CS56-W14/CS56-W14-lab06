package edu.ucsb.cs56.w14.drawings.rkjha.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D; 
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A Hockey stick with a puck
      
   @author Rishabh Jha 
   @version for CS56, W14, UCSB, 02/23/2014
   
*/

public class HockeyStickWithPuck extends HockeyStick implements Shape{
    
    /**
       Constructor for HockeyStickWithPuck
    */

    public HockeyStickWithPuck(double x, double y, double width, double height) {
	//construct the basic hockey stick
	super(x,y,width,height);

       	GeneralPath gp = this.get();

	double xTopLeftCorner = x + (0.5 * width);
	double yTopLeftCorner = y + (0.6 * height);
	double puckDiameter = 0.2 * height;

	//construct the circle
	Ellipse2D.Double puck = new Ellipse2D.Double(xTopLeftCorner, yTopLeftCorner, puckDiameter, puckDiameter);

	//get the GeneralPath
	GeneralPath wholeFigure = this.get();
	wholeFigure.append(puck, false);

    }

}
