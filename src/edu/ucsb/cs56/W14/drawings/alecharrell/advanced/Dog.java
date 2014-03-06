package edu.ucsb.cs56.w14.drawings.alecharrell.advanced;
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
   A vector drawing of a dog that implements                                 
   the Shape interface, and so can be drawn, as well as                        
   rotated, scaled, etc.                                                       
                                                                               
   @author Alec Harrell                                                        
   @version for CS56, Winter 14, UCSB                                          
                                                                               
*/
public class Dog extends GeneralPathWrapper implements Shape
{
    /**                                                                        
       Constructor                                                             
       @param x x coord of left top corner of dog                          
       @param y y coord of left top corner of dog                          
       @param width width of the dog                                         
       @param height of dog
    */
    public Dog(double x, double y, double width, double height)
    {
	Shape leftEar = new Ellipse2D.Double(x-(width/8),y+(height/8),width*.25, height*.80);

	Shape head = new Ellipse2D.Double(x, y, width, height);
       	Shape rightEar = ShapeTransforms.horizontallyFlippedCopyOf(leftEar);
	rightEar = ShapeTransforms.translatedCopyOf(rightEar, width+(width/4), 0.0);
	Shape leftEye = new Ellipse2D.Double(x+(width/4),y+(height*.3),width*.1,height*.1);
        Shape rightEye = ShapeTransforms.horizontallyFlippedCopyOf(leftEye);
	rightEye = ShapeTransforms.translatedCopyOf(rightEye,width-(width/2), 0.0); 

       

       

        // put the whole dog together                                        

        GeneralPath wholeDog = this.get();
        wholeDog.append(head, false);
        wholeDog.append(leftEar, false);
        wholeDog.append(rightEar, false);
        wholeDog.append(leftEye, false);
        wholeDog.append(rightEye, false); 

    }
}
