package edu.ucsb.cs56.w14.drawings.jennyso.advanced;
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
   A vector drawing of a cat that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad
   @author Jenny So
   @version for CS56, Winter 14, UCSB
   
*/
public class Cat extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of bottom middle of the Cat
       @param y y coord of bottom middle of the Cat
       @param width width of the house
       @param height of house (from bottom to top of cat ears)
     */
    public Cat(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double earsHeight = height*.30; 
        double eyesHeight = height*.55;
	double whiskerHeight = height*.2;
        
        // Make eyes
        
        Rectangle2D.Double rightEye = 
            new Rectangle2D.Double(x-width/5, y-eyesHeight ,
                          width*.1, height*.1);
	Rectangle2D.Double leftEye =
	    new Rectangle2D.Double(x+width/10, y-eyesHeight, width*.1, height*.1);
                          
        // make the ears.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftEar1 = 
            new Line2D.Double (x-width/2.0, y-height,
                               x-width/2.0, y-height+earsHeight);
                               
        Line2D.Double rightEar1 =
            new Line2D.Double (x - width/2.0, y-height,
                               x-width/2.0 + width*.1, y - height + height*.1);

	Line2D.Double leftEar2 = 
            new Line2D.Double (x+width/2.0, y-height,
                               x+width/2.0, y-height+earsHeight);
                               
        Line2D.Double rightEar2 =
            new Line2D.Double (x + width/2.0, y-height,
                               x+width/2.0 - width*.1, y - height + height*.1);

	// make the whiskers

	Line2D.Double bottomRightWhisker = 
	    new Line2D.Double (x-width/4.0, y-whiskerHeight, 
			       x-width/1.5, y-whiskerHeight);
	Line2D.Double middleRightWhisker = 
	    new Line2D.Double (x-width/4.0, y-height*.4, 
			       x-width/1.5, y-height*.4);
	Line2D.Double topRightWhisker = 
	    new Line2D.Double (x-width/4.0, y-height*.3,
			       x-width/1.5, y-height*.3);

	Line2D.Double bottomLeftWhisker = 
	    new Line2D.Double (x+width/4.0, y-whiskerHeight, 
			       x+width/1.5, y-whiskerHeight);
	Line2D.Double middleLeftWhisker = 
	    new Line2D.Double (x+width/4.0, y-height*.4, 
			       x+width/1.5, y-height*.4);
	Line2D.Double topLeftWhisker = 
	    new Line2D.Double (x+width/4.0, y-height*.3,
			       x+width/1.5, y-height*.3);

	// make the face
	Ellipse2D.Double face = 
	    new Ellipse2D.Double (x-width/2.0, y-height, 
				  width, height);
	
        // put the whole house together
       
        GeneralPath wholeCat = this.get();
        wholeCat.append(rightEye, false);
        wholeCat.append(leftEye, false);
        wholeCat.append(rightEar1, false);
	wholeCat.append(leftEar1, false);
	wholeCat.append(rightEar2, false);
	wholeCat.append(leftEar2, false);
	wholeCat.append(bottomRightWhisker, false);
	wholeCat.append(middleRightWhisker, false);
	wholeCat.append(topRightWhisker, false);
	wholeCat.append(bottomLeftWhisker, false);
	wholeCat.append(middleLeftWhisker, false);
	wholeCat.append(topLeftWhisker,false);
	wholeCat.append(face, false);
        
    }

}
