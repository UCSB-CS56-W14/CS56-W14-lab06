package edu.ucsb.cs56.w14.drawings.mdelgado.advanced;
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
   A vector drawing of a flag that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Miguel Delgado
   @version for CS56, Winter 14, UCSB
   
*/
public class Flag extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of flag
       @param y y coord of lower left corner of flag
       @param width width of the flag
       @param height of flag 
     */
    public Flag(double x, double y, double width, double height)
    {
	Rectangle2D.Double FlagShape = new Rectangle2D.Double(x,y, width, height);
	GeneralPath FullFlag = this.get();
       	 FullFlag.append(FlagShape,false);
	 
        
    }

}
