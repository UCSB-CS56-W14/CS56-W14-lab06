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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a camera that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Eric Chen 
   @version for CS56, Winter 14, UCSB
   
*/
public class Camera extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of camera
       @param y y coord of lower left corner of camera
       @param width width of the camera
       @param height of camera(including shutter)
     */
    public Camera(double x, double y, double width, double height)
    {
    
	double CameraBodyHeight = .85 * height;
        double ShutterHeight = 0.15 * height;
        double ShutterWidth =  .8 * width;
        double CameraBodyUpperLeftY = y + ShutterHeight;
        
        // Make the Camera Body
        
        Rectangle2D.Double CameraBody = 
            new Rectangle2D.Double(x, CameraBodyUpperLeftY,
                          width, CameraBodyHeight);
                          
        // make the Shutter

	Rectangle2D.Double Shutter = 
	    new Rectangle2D.Double(x + (0.1 * width), y, ShutterWidth, ShutterHeight);

	//make the Lens

       // here we use constants, so that if we want to change 
       // the dimensions later, or move the lenses around,
       // it becomes easier.
       // Instead of doing the math ourselves, and putting "hard coded numbers"
       // in the constructors for the Ellipses, we let the computer do the math!

	final double outerLensRadius;
	final double innerLensRadius;

	if (width < height) {
	    outerLensRadius = .25 * width;
	    innerLensRadius = .1 * width;
	}
	else {  
	    outerLensRadius = .25 * height;
	    innerLensRadius = .1 * height;
	}
	
	final double CameraBodyCenterX = x + (width / 2);
	final double CameraBodyCenterY = y + (CameraBodyHeight / 2);
	
	Circle outerLens = 
           new Circle
           (
	     CameraBodyCenterX,
             CameraBodyCenterY,
             outerLensRadius
	   );
       
       Circle innerLens = 
	   new Circle
	   (
	     CameraBodyCenterX,
	     CameraBodyCenterY,
	     innerLensRadius
	   );

       // put the whole camera together
       
        GeneralPath wholeCamera = this.get();
        wholeCamera.append(CameraBody, false);
        wholeCamera.append(Shutter, false);
        wholeCamera.append(outerLens, false);
	wholeCamera.append(innerLens, false);
    }

}
