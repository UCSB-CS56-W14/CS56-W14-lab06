package edu.ucsb.cs56.w14.drawings.sumer.advanced;
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
   A vector drawing of a Stereo that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sumer Sinha 
   @version for CS56, Winter 14, UCSB
   
*/
public class Stereo extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of left corner of stereo box
       @param y y coord of upper left corner of main stereo box ( not the handle)
       @param width width of the stereo
       @param height of stereo 
     */
    public Stereo(double x, double y, double width, double height)
    {
    
        
        Rectangle2D.Double box = 
            new Rectangle2D.Double(x, y, width, .7*height);

	GeneralPath handle = new GeneralPath();
	handle.moveTo(x+.25*width,y);
	handle.lineTo(x+.25*width, y-.3*height);
	handle.lineTo(x+.75*width, y-.3*height);
	handle.lineTo(x+.75*width,y);
                          


        // put the whole house together
       
        GeneralPath wholeStereo = this.get();
        wholeStereo.append(box, false);
        wholeStereo.append(handle, false);
        
    }

}
