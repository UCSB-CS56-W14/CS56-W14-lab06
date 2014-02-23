package edu.ucsb.cs56.w14.drawings.vwtan.advanced;
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
   A gun with a silencer
      
   @author Vincent Tan 
   @version for CS56, W14, UCSB, 02/23/2014
   
*/

public class gunWithSilencer extends gun implements Shape
{
    /**                                                                                 
     * Constructor of objects of class Gun                                                          
     */

    public gunWithSilencer(double x, double y, double width, double height)
    {

	super (x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//Make a silencer where 
	// height = gunBodyHeight * 1.1  
	// width = .5 gunWidth
	
	double widthOfSilencer = .5 * width;
	double heightOfSilencer = (.25 * height)* 1.1;
	
	Rectangle2D.Double silencer1 =
	    new Rectangle2D.Double(x-widthOfSilencer, y - (.05*heightOfSilencer), widthOfSilencer, heightOfSilencer);

	// add the silencer to the gun

	GeneralPath wholeGun = this.get();
	wholeGun.append(silencer1, false);
    }


}
