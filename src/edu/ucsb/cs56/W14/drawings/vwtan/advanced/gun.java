package edu.ucsb.cs56.w14.drawings.vwtan.advanced;
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
   A vector drawing of a gun that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Vincent Tan
   @version for CS56, Winter 14, UCSB
   
*/
public class gun extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of gun
       @param y y coord of upper left corner of gun
       @param width width of the gun
       @param height of the gun (including first story and second story)
    */
    
    public gun(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double HandleHeight = .75 * height;
        double tipWidth = .03 * width;
	
	double BodyHeight = height - HandleHeight;
        double tipHeight = BodyHeight * .5;
	double HandleWidth = .20 * width;
	double triggerXComponent = x + (.70 *width);
	double triggerYComponent = y + BodyHeight;
        double triggerHeight = BodyHeight*.75;
	double triggerWidth = width*.05;
	
        // Make the Body of the Gun
        
        Rectangle2D.Double Gun_Body = 
            new Rectangle2D.Double(x + tipWidth, y ,
				   width*.97, BodyHeight);
                          
        // make the Handle.   
	
        Rectangle2D.Double Gun_Handle = 
            new Rectangle2D.Double(x + .8*width, y+BodyHeight  ,
				   HandleWidth, HandleHeight);

	// Make the trigger

	Rectangle2D.Double Gun_Trigger = 
            new Rectangle2D.Double(triggerXComponent, triggerYComponent ,
				   triggerWidth, triggerHeight);

	// Make the tip of the Gun
	Rectangle2D.Double Gun_Tip = 
	    new Rectangle2D.Double(x, y+ (BodyHeight * .25), tipWidth, tipHeight); 

        // put the Gun together
       
        GeneralPath wholeGun = this.get();
        wholeGun.append(Gun_Body, false);
        wholeGun.append(Gun_Handle, false);
        wholeGun.append(Gun_Trigger, false); 
        wholeGun.append(Gun_Tip, false);
    }
    
}
