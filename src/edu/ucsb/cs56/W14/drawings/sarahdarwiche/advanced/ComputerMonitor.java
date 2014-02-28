package edu.ucsb.cs56.w14.drawings.sarahdarwiche.advanced;
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
   A vector drawing of a Computer Monitor that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sarah Darwiche 
   @version for CS56, Winter 14, UCSB
   
*/
public class ComputerMonitor extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of monitor
       @param y y coord of lower left corner of monitor
       @param width width of the monitor
       @param height of monitor
     */
    public ComputerMonitor(double x, double y,  double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double outsidemonitor_height =  height;
        double insidemonitor_height =.90 * height;
	double insidemonitor_width = .90 * width;
        
        double outsidemonitorUpperLeftY = y;
	double insidemonitorUpperLeftY =( y + (outsidemonitor_height-insidemonitor_height)/2);
        
        // Make the outside monitor
        
        Rectangle2D.Double outsidemonitor = 
            new Rectangle2D.Double(x, outsidemonitorUpperLeftY ,
                          width,outsidemonitor_height);

	//Make the inside monitor
       
	Rectangle2D.Double insidemonitor = 
            new Rectangle2D.Double(x +(width - insidemonitor_width)/2, insidemonitorUpperLeftY ,
                         insidemonitor_width, insidemonitor_height);
     

        // put the whole monitor together
       
        GeneralPath wholeMonitor = this.get();
        wholeMonitor.append(outsidemonitor, false);
        wholeMonitor.append(insidemonitor, false);
        
        
    }

}
