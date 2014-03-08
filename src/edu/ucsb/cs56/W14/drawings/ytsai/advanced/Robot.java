package edu.ucsb.cs56.w14.drawings.ytsai.advanced;
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
   A vector drawing of a robot that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, Winter 14, UCSB
   
*/
public class Robot extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public Robot(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double headWidth = .69 * width;
        double headHeight = .26 * height;
        
      
        // Make the body
    
        Rectangle2D.Double body = 
            new Rectangle2D.Double(x,y,width,height);
                          
        // make the head.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
	double startx = x + (.5*width - .5*headWidth);
	double starty = y - headHeight;
        Rectangle2D.Double head = 
            new Rectangle2D.Double (startx,starty, headWidth, headHeight);
     
	// make arms
	double armWidth = .25 * width;
	double armLength = .69 * height;

	Rectangle2D.Double larm = 
            new Rectangle2D.Double(x-armWidth,y+.05*height,armWidth,armLength);

	Rectangle2D.Double rarm = 
            new Rectangle2D.Double(x+width,y+.05*height,armWidth,armLength);

	// make legs
	Line2D.Double lleg = 
            new Line2D.Double (x + .2*width, y+height, x + .2*width, y+1.269*height);
	Line2D.Double rleg = 
            new Line2D.Double (x + .8*width, y+height, x + .8*width, y+1.269*height);
        // put the whole Robot together
       
        GeneralPath wholeRobot = this.get();
        wholeRobot.append(body, false);
        wholeRobot.append(head, false);
        wholeRobot.append(larm, false); 
	wholeRobot.append(rarm, false); 
	wholeRobot.append(lleg, false);
	wholeRobot.append(rleg, false);
		
    }

}
