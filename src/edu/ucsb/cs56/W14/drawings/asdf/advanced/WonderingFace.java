package edu.ucsb.cs56.w14.drawings.asdf.advanced;
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
   A Wondering face
      
   @author Weihan Wang
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class WonderingFace extends Face implements Shape
{
    /**
     * Constructor for objects of class Wonderingface
     */
    public WonderingFace(double x, double y, double width, double height)
    {
	// construct the basic face
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double xDistance=x+width*3/8;
	double yDistance=y+height*2/3;
	Ellipse2D.Double Mouth =
	    new Ellipse2D.Double(xDistance,yDistance, height/4, height/4);

	// add the mouth to the face

        GeneralPath WonderingFace = this.get();
        WonderingFace.append(Mouth, false);
        
    }

}
