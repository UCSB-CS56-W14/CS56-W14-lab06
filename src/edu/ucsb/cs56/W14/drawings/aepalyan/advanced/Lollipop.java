package edu.ucsb.cs56.w14.drawings.aepalyan.advanced;
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
   A vector drawing of a face that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Eric Palyan 
   @version for CS56, Winter 14, UCSB
   
*/
public class Face extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the face
       @param height height of the face
     */
    public Face(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	
	double eyeLocationX = x*.75;
	double eyeLocationY = y*.75;
        
        // Make the first story
        Eclipse2D.Double face = new Eclipse2D.Double(x, y, width, height);

	// Make the eyes
	Eclipse2D.Double leftEye = new Eclipse2D.Double(eyeLocationX, eyeLocationY,

                          
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftRoof = 
            new Line2D.Double (x, y + roofHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightRoof =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + roofHeight);

        // put the whole house together
       
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(firstStory, false);
        wholeHouse.append(leftRoof, false);
        wholeHouse.append(rightRoof, false); 
        
    }

}
