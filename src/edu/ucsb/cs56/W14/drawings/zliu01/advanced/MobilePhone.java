package edu.ucsb.cs56.w14.drawings.zliu01.advanced;
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
   A vector drawing of a face that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Zhe Liu
   @version for CS56, W14, UCSB
   
*/
public class MobilePhone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of MobilePhone
       @param y y coord of lower left corner of MobilePhone
       
       @param width width of the MobilePhone
       @param height of MobilePhone
     */
    public MobilePhone(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double phoneHeight = height;
        double screenHeight = (phoneHeight * 4) / 5;
        double screenWidth = (width * 4) / 5;
        // Make the shape of face
        
        Rectangle2D.Double phone =  new Rectangle2D.Double(x,y,width,height);
		//make the shape of screen
        double screenX = x + (width - screenWidth) / 2;
        double screenY = y + (height - screenHeight) / 2;
	Rectangle2D.Double screen =  new Rectangle2D.Double(screenX,screenY,screenWidth,screenHeight);

        // put the whole face together
       
        GeneralPath wholePhone = this.get();
        wholePhone.append(phone, false);
        wholePhone.append(screen,false);
    }

}
