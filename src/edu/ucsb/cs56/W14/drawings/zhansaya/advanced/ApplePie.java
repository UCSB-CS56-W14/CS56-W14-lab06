package edu.ucsb.cs56.w14.drawings.zhansaya.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Arc2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;


/**
   A subclass of Pie that adds apples on the pie to make it look more realistic. 
      
   @author Zhansaya Abdikarimova
   @version Lab 06, CS56, W14
   
*/
public class ApplePie extends Pie implements Shape
{
	/**
	 * No arguments constructor
	 */ 
	public ApplePie(){
		// Stub
	}
	
	/**
	 * Contructor for object ApplePie
	 */
	 
	 public ApplePie(double centerx, double centery, double radius){
		// call the constructor of Pie
		super(centerx, centery, radius);
		GeneralPath wholePie = this.get();

		// append the apples within the Pie
		
		appendApple(wholePie, centerx, centery-(radius)+radius/4, radius/3);
		appendApple(wholePie, centerx-radius/2, centery-(radius)+radius/4, radius/3);
		
		appendApple(wholePie, centerx-radius/4, centery-(radius/2), radius/3);
		appendApple(wholePie, centerx+radius/4, centery-(radius/2), radius/3);
		appendApple(wholePie, centerx-radius/2-radius/4, centery-(radius/2), radius/3);
		
		appendApple(wholePie, centerx, centery-(radius/4), radius/3);
		appendApple(wholePie, centerx-radius/2, centery-radius/4, radius/3);
		appendApple(wholePie, centerx+radius/2, centery-radius/4, radius/3);
		appendApple(wholePie, centerx-radius, centery-radius/4, radius/3);
		
		appendApple(wholePie, centerx+radius/4, centery, radius/3);
		appendApple(wholePie, centerx-radius/4, centery, radius/3);
		appendApple(wholePie, centerx-radius/2-radius/4, centery, radius/3);
		
		appendApple(wholePie, centerx, centery+(radius/4), radius/3);
		appendApple(wholePie, centerx-radius/2, centery+(radius/4), radius/3);
		appendApple(wholePie, centerx+radius/2, centery+(radius/4), radius/3);
		
		appendApple(wholePie, centerx-radius/4, centery+(radius/2), radius/3);
		appendApple(wholePie, centerx+radius/4, centery+(radius/2), radius/3);
		appendApple(wholePie, centerx-radius/2-radius/4, centery+(radius/2), radius/3);
		
		appendApple(wholePie, centerx, centery+(radius)-radius/4, radius/3);
	}

	/**
	 * This function is a helper function to append the apples within the pie
	 * @param thisPath  the GeneralPath wrapper object
	 * @param centerx  the x coordinate for the center of the apple
	 * @param centery  the y coordinate for the center of the apple
	 * @param radius radius of a semicircle of an apple
	 */
    	
    	public void appendApple(GeneralPath thisPath, double centerx, 
    		double centery, double radius){
    
    		Arc2D.Double a1 = new  Arc2D.Double(centerx, centery,radius,radius,0,180,
                         Arc2D.OPEN);
    		thisPath.append(a1,false);
    
    		Line2D.Double l1 = new Line2D.Double(centerx,centery+radius/2,
					     centerx+radius,centery+radius/2);
			thisPath.append(l1,false);	     
	
    	}
}
