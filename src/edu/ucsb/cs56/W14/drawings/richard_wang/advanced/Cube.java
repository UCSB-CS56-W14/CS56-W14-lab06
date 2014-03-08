package edu.ucsb.cs56.w14.drawings.richard_wang.advanced;
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
   A vector drawing of a cube that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Richard Wang
   @version for CS56, W14, UCSB
   
*/
public class Cube extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of cube
       @param y y coord of lower left corner of cube
       @param length length of a side of the cube
     */
    public Cube(double x, double y, double length)
    {
        Rectangle2D.Double frontFace = 
            new Rectangle2D.Double(x, y,
                          length, length);
        
        Line2D.Double leftOfTopFace = 
            new Line2D.Double (x, y,
                               x + length/2.0, y - length/2.0);
                               
        Line2D.Double topOfTopFace =
            new Line2D.Double (x + length/2.0, y - length/2.0,
                               x + length * 1.5, y - length/2.0);
	Line2D.Double rightOfTopFace =
	    new Line2D.Double (x + length, y,
			       x + length * 1.5, y - length/2.0);
	Line2D.Double rightOfRightFace =
	    new Line2D.Double (x + length * 1.5, y + length /2.0,
			       x + length * 1.5, y - length/2.0);
	Line2D.Double bottomOfRightFace =
	    new Line2D.Double (x + length, y + length,
			       x + length * 1.5, y + length/2.0);

        // put the whole cube together
       
        GeneralPath wholeCube = this.get();
	wholeCube.append(frontFace, false);
        wholeCube.append(leftOfTopFace, false);
        wholeCube.append(topOfTopFace, false);
        wholeCube.append(rightOfTopFace, false);
	wholeCube.append(rightOfRightFace, false);
	wholeCube.append(bottomOfRightFace, false);
        
    }

}
