package edu.ucsb.cs56.w14.drawings.ericchen.advanced;
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
   A Camera
      
   @author Eric Chen
   @version for CS56, W14, UCSB, 02/21/2014
   
*/
public class CameraWithStand extends Camera implements Shape
{
    /**
     * Constructor for objects of class Camera
     */
    public CameraWithStand(double x, double y, double width, double height)
    {
	// construct the basic camera shell
	super(x,y,width,0.3 * height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three windows, spaced like this, where w=width/10.0;
	// | +--+ +--+ +--+ |
	// | |  | |  | |  | |
	// | +--+ +--+ +--+ |
	// |w 2w w 2w w w2 w|
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;

	// Make a stand where 

	double standWidth = 0.10 * width;
	double standHeight = 0.7 * height;

	Rectangle2D.Double stand =
	    new Rectangle2D.Double(x + (0.45 * width), y + (0.3 * height), standWidth, standHeight);
	
	// add the stand to the camera
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeCamera = this.get();
        wholeCamera.append(stand, false);
    }

}
