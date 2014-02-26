package edu.ucsb.cs56.w14.drawings.krbriggs.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A Santa head added to the hat
      
   @author Kevin Briggs 
   @version for CS56, W14, UCSB, 02/22/2014
   
*/
public class SantaWithHat extends SantaHat implements Shape
{
    /**
     * Constructor for objects of class SantaWithHat
     */
    public SantaWithHat(double x, double y, double size)
    {
	// construct the basic santa hat
	super(x,y, size*.75,size);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	

	

	Rectangle2D.Double head =
	    new Rectangle2D.Double(x-size, y+size, size*2, size*2);
	

	Line2D.Double lefteye = 
            new Line2D.Double (x+ .5*size -size, y +.4*size +size,
                               x + .5*size -size, y + .6*size +size);

	Line2D.Double righteye = 
            new Line2D.Double (x+ 1.5*size -size, y +.4*size +size,
                               x + 1.5*size -size, y + .6*size +size);

	Rectangle2D.Double mouth =
	    new Rectangle2D.Double(x+ .5*size -size, y+2*size, size, size*.5);



	
	// add the head, eyes, and mouth to the hat
	

        GeneralPath santa = this.get();
        santa.append(head, false);
	santa.append(lefteye, false);
	santa.append(righteye, false);	
	santa.append(mouth, false);
        
    }

}
