package edu.ucsb.cs56.w14.drawings.ytsai.advanced;
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
   A Robot with mad eyes
      
   @author Phill Conrad 
   @author Yantsey Tsai
   @version for CS56, W14, UCSB
   
*/
public class AngryRobot extends Robot implements Shape
{
    /**
     * Constructor for objects
     */
    public AngryRobot(double x, double y, double width, double height)
    {
	// construct the basic robot body
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make two eyes with furled eyebrows, angry face


	double headWidth = .69 * width;
        double headHeight = .26 * height;
	double eyeHeight = .2*headHeight;
	double eyeWidth = .3*headWidth;
	double browWidth = .25*headWidth;
	double browHeight = .18*headWidth;
	Rectangle2D.Double lefteye =
	    new Rectangle2D.Double(x + (.5*width - .5*headWidth) + .1*headWidth, y-.7*headHeight, eyeWidth, eyeHeight);
	Rectangle2D.Double righteye =
	    new Rectangle2D.Double(x + (.5*width - .5*headWidth) + .9*headWidth-eyeWidth, y-.7*headHeight, eyeWidth, eyeHeight);
	
	Line2D.Double rightbrow = new Line2D.Double(x + (.5*width - .5*headWidth) + .55*headWidth, y-headHeight+browHeight, x + (.5*width - .5*headWidth) + .55*headWidth+browWidth, y-headHeight );
	Line2D.Double leftbrow = new Line2D.Double(x + (.5*width - .5*headWidth) + .2*headWidth, y-headHeight,x + (.5*width - .5*headWidth) + .2*headWidth+browWidth, y-headHeight+browHeight );
	
	// add the angry face to the robot
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeRobot = this.get();
        wholeRobot.append(righteye, false);
	wholeRobot.append(lefteye, false);
	wholeRobot.append(rightbrow, false);
	wholeRobot.append(leftbrow, false);
    }

}
