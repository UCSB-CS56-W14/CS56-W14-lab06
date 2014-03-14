package edu.ucsb.cs56.w14.drawings.nissayeva.advanced;


import java.awt.Rectangle;
import java.awt.Shape; // general class for shapes                                                        
import java.awt.geom.AffineTransform; // translation, rotation, scale                                     
import java.awt.geom.GeneralPath; // combinations of lines and curves                                     
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**                                                                                                       
   A vector drawing of a Face that implements                                                           
   the Shape interface, and so can be drawn, as well as                                                   
   rotated, scaled, etc.                                                                                  
                                                                                                          
   @author Natasha Issayeva                                                                               
   @version for CS56, W14, UCSB, 03/13/2014                                                               
                                                                                                          
*/
public class Face extends GeneralPathWrapper implements Shape
{
    /**                                                                                                   
       Constructor                                                                                        
       @param x the coordinate of the top                                                           
       @param y the coordinate of the top                                                                 
       @param radius radius of face                                                                 
     */
    public Face(double x, double y, double radius)
    {
	Ellipse2D.Double head = new Ellipse2D.Double(x-radius, y, radius*2, radius*2 );
	Ellipse2D.Double leftEye = new Ellipse2D.Double(x-radius/2, y+ radius/2, radius/7, radius/7);
	Ellipse2D.Double rightEye = new Ellipse2D.Double(x+radius/2 - 2*radius/7, y+ radius/2, radius/7, radius/7);
	Line2D.Double topMouth = new Line2D.Double(x-radius/2, y+ 3*radius/4, x+radius/2, y+3*radius/4);
	Line2D.Double leftSide = new Line2D.Double(x-radius/2, y+3*radius/4, x-radius/5, y+7*radius/8);
	Line2D.Double rightSide = new Line2D.Double(x+radius/5, y+7*radius/8, x+radius/2, y+3*radius/4);
	Line2D.Double bottomMouth = new Line2D.Double(x-radius/5, y+7*radius/8, x+radius/5, y+7*radius/8);
	
	GeneralPath face = this.get();
        face.append(head, false);
        face.append(leftEye, false);
        face.append(rightEye, false);
	face.append(topMouth, false);
      	face.append(leftSide, false);
	face.append(rightSide, false);
	face.append(bottomMouth, false);
 
    }

}
