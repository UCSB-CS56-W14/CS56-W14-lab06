package edu.ucsb.cs56.w14.drawings.shuailang.advanced;
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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, Winter 11, UCSB
   
*/
public class showerHead extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of hose
       @param y y coord of lower left corner of hose
       @param width width of the hose
       @param height of hose 
     */
    public showerHead(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	//firstStoryHeight to hose1
        double hose1height =  height;
        //double roofHeight = height - firstStoryHeight;
        
        //double firstStoryUpperLeftY = y + roofHeight;
        
        // Make the first story
        
        Rectangle2D.Double Hose1 = 
            new Rectangle2D.Double(x, y ,
                          width, hose1height);
                          
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
	
        
	Rectangle2D.Double Hose2 =
	    new Rectangle2D.Double(x-hose1height, y ,
				   hose1height, hose1height * 1.5);
	
	Rectangle2D.Double Head =
            new Rectangle2D.Double(x-hose1height, y ,
                                   hose1height, hose1height * 1.5);
        
	Line2D.Double headTop = 
	    new Line2D.Double (x - 3*hose1height, y + hose1height * 1.5,
			       x + 2*hose1height, y + hose1height * 1.5);
	Line2D.Double headButton =
            new Line2D.Double (x - 4*hose1height, y + hose1height * 4,
                               x + 3*hose1height, y + hose1height * 4);

	Line2D.Double headLeft =
            new Line2D.Double (x - 3*hose1height, y + hose1height * 1.5,
                               x - 4*hose1height, y + hose1height * 4);

	 Line2D.Double headRight =
	     new Line2D.Double (x + 2*hose1height, y + hose1height * 1.5,
				x + 3*hose1height, y + hose1height * 4);


	
	// Line2D.Double rightRoof =
	//  new Line2D.Double (x + width/2.0, y,
	//                     x + width, y + roofHeight);

        // put the whole house together
       
        GeneralPath wholeShowerHead = this.get();
        wholeShowerHead.append(Hose1, false);
        wholeShowerHead.append(Hose2, false);
        wholeShowerHead.append(headTop, false); 
	wholeShowerHead.append(headButton, false);
	wholeShowerHead.append(headLeft, false);
	wholeShowerHead.append(headRight, false);

       
    }

}
