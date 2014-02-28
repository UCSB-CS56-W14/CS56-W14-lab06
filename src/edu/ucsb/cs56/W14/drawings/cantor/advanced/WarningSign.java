package edu.ucsb.cs56.w14.drawings.cantor.advanced;
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
   A House
      
   @author Phill Conrad 
   @author Antonio Cantor
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class WarningSign extends Triangle implements Shape
{
    /**
     * Constructor for objects of class WaringSign
     */
    public WarningSign(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	


	Rectangle2D.Double ExP1 =
	    new Rectangle2D.Double(2.5*x , y/8, width/4, height/2);

	Rectangle2D.Double ExP2 =
	    new Rectangle2D.Double(x/2.2 , y/1.5, width/6, height/4);

	Rectangle2D.Double ExP3 =
	    new Rectangle2D.Double(x*1.4 , y/1.2, width/10, height/10);

	
	// add the exclaimation point to the triangle
	// Look up the meaning of the second parameter of append

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(ExP1, false);
        wholeHouse.append(ExP2, false);
        wholeHouse.append(ExP3, false); 
    }

}
