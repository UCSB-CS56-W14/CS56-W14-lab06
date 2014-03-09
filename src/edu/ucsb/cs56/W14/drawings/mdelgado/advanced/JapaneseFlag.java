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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A Japanese Flag
      
   @author Miguel Delgado 
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class JapaneseFlag extends Flag implements Shape
{
    /**
     * Constructor for objects of class JapaneseFlag
     */
    public JapaneseFlag(double x, double y, double width, double height)
    {
	// construct the basic flag shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
		
	Ellipse2D.Double circle = new Ellipse2D.Double((x+ width*.37), (y+ height*.25), (width/4), (height/2)); 

        GeneralPath wholeHouse = this.get();
       wholeHouse.append(circle, false);
 
    }

}

