package edu.ucsb.cs56.w14.drawings.ricklee.advanced;
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
import edu.ucsb.cs56.w14.drawings.ricklee.simple.Circle;

/**
   A vector drawing of a stickman that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Rick Lee 
   @version for CS56, Winter 14, UCSB
   
*/
public class Stickman extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord in between the base of the feet
       @param y y coord in between the base of the feet
       @param height height of the stickman (everything else will be scaled accordingly)
    */
    public Stickman(double x, double y, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

	double legHeight = 0.45*height;
	double torsoHeight = 0.35*height;
	double handHeight = 0.4*height;
	double headHeight = 0.20*height;

	double feetDistance = height/9;
	double handDistance = height/9;
	double headRadius = height/9;

	//Make the legs (from the thigh to the feet)	
	Line2D.Double leftLeg = new Line2D.Double (x,y-legHeight,x-feetDistance,y);
	Line2D.Double rightLeg = new Line2D.Double (x,y-legHeight,x+feetDistance,y);

	//Make torso (from neck to thigh)
	Line2D.Double torso = new Line2D.Double (x,y-legHeight-torsoHeight,x,y-legHeight);

	//Make arms (from shoulder to hand)
	Line2D.Double leftArm = new Line2D.Double (x,y-legHeight-torsoHeight,x-handDistance,y-legHeight);
	Line2D.Double rightArm = new Line2D.Double (x,y-legHeight-torsoHeight,x+handDistance,y-legHeight);

	//Make head
	
	Circle head = new Circle(x,y-legHeight-torsoHeight-(headHeight/2),headRadius);

        // put the stickman together
       
        GeneralPath wholeStickman = this.get();
        wholeStickman.append(leftLeg, false);
        wholeStickman.append(rightLeg, false);
        wholeStickman.append(torso, false); 
        wholeStickman.append(leftArm, false); 
        wholeStickman.append(rightArm, false); 
        wholeStickman.append(head, false); 

    }

}
