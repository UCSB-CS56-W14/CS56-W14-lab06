package edu.ucsb.cs56.w14.drawings.asdf.advanced;
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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Weihan Wang
   @version for CS56, Winter 14, UCSB
   
*/
public class Face extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the face
       @param height of the face
    */
    public Face(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double faceHeight = 0.5 * height; 
        double upHeight = height - faceHeight;
        double faceUpperLeftY = y + upHeight;
	double eyeDistance=width/6;

	//make two eyes

	Ellipse2D.Double eyeL =
	    new Ellipse2D.Double(x+eyeDistance, faceUpperLeftY+5, height/6, height/6);

	Ellipse2D.Double eyeR =
	    new Ellipse2D.Double(x+eyeDistance*4, faceUpperLeftY+5, height/6, height/6);
        
        // Make a face
        
        Rectangle2D.Double Face = 
            new Rectangle2D.Double(x, faceUpperLeftY ,
				   width,faceHeight);
                         
       
        GeneralPath wholeFace = this.get();
        wholeFace.append(Face, false);
        wholeFace.append(eyeL, false);
        wholeFace.append(eyeR, false);
    }

}
