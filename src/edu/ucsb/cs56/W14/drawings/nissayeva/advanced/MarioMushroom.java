package edu.ucsb.cs56.w14.drawings.nissayeva.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;


// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A Mushroom with spots on the top
      
   @author Natasha Issayeva  
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class MarioMushroom extends Mushroom implements Shape
{
    /**
     * Constructor for objects of class Mushroom
     * @param x  x coordinate of lower left corner of mushroom top
     * @param y  y coordinate of lower left corner of mushroom top
     * @param width  width of mushroom top
     * @param height  height of whole mushroom
     */
    public MarioMushroom(double x, double y, double width, double height)
    {
	// construct the basic mushroom
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	Circle spot1 =
	    new Circle(x + (2*width)/9, y - (2*height)/9, width/9);
	Circle spot2 =
	    new Circle(x + (3*width)/5, y - height/3, width/6);
        Circle spot3 =
	    new Circle(x + width/2, y - (11*height)/12, height/12);
	
	// add the spots to the mushroom
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeMushroom = this.get();
        wholeMushroom.append(spot1, false);
        wholeMushroom.append(spot2, false);
        wholeMushroom.append(spot3, false); 
    }

}
