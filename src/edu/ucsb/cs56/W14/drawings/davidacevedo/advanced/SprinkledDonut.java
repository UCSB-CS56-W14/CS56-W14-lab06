package edu.ucsb.cs56.w14.drawings.davidacevedo.advanced;
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
import edu.ucsb.cs56.w14.drawings.davidacevedo.simple.Circle;

/**
	A class that extends Donut to add Sprinkles on the picture	
	
   @author Phill Conrad 
   @author David Acevedo
   @version for Lab 06, CS56, Spring 11, UCSB
   
*/
public class SprinkledDonut extends Donut implements Shape
{

    /**
       Constructor

       @param centerx  the x coordinate for the center of the donut
       @param centery  the y coordinate for the center of the donut
       @param radius  the radius of the donut
     */
	public SprinkledDonut(double centerx, double centery, double radius){
		super(centerx, centery, radius);
		GeneralPath gp = this.get();
		addSprinkles(gp, centerx,centery,radius);
		}
		
	/**
       This function is a helper funtion used by SprinkledDonut to append all the sprinkles on the donut
       @param thisPath  the GeneralPath wrapper object
       @param centerx  the x coordinate for the center of the donut
       @param centery  the y coordinate for the center of the donut
       @param radius  the radius of the whole donut, used to avoid the inner hole of the donut

     */
		
	public void addSprinkles(GeneralPath thisPath, double centerx, double centery, double radius){
		//Sprinkle length variables, sprinkleEnd-sprinkleStart gets you the length
		double sprinkleStart = radius *.55;
		double sprinkleEnd = radius * .65;
		//creating and adding the sprinkles when y=0 for 2 and x=0 for the other 2
		Line2D.Double sprink1 = new Line2D.Double(centerx+sprinkleStart, centery,centerx+sprinkleEnd, centery);
		Line2D.Double sprink2 = new Line2D.Double(centerx-sprinkleStart, centery,centerx-sprinkleEnd, centery);
		Line2D.Double sprink3 = new Line2D.Double(centerx, centery+sprinkleStart,centerx, centery+sprinkleEnd);
		Line2D.Double sprink4 = new Line2D.Double(centerx, centery-sprinkleStart,centerx, centery-sprinkleEnd);
		//The parameters for the start and and of the angled sprinkles
		double sprinkleAngledStart = sprinkleStart*.7;
		double sprinkleAngledEnd = sprinkleEnd * .7;
		//creates the sprinkles that have to be in an angle
		Line2D.Double sprink5 = new Line2D.Double(centerx+sprinkleAngledStart, centery+sprinkleAngledStart,centerx+sprinkleAngledEnd, centery+sprinkleAngledEnd);
		Line2D.Double sprink6 = new Line2D.Double(centerx-sprinkleAngledStart, centery-sprinkleAngledStart,centerx-sprinkleAngledEnd, centery-sprinkleAngledEnd);
		Line2D.Double sprink7 = new Line2D.Double(centerx+sprinkleAngledStart, centery-sprinkleAngledStart,centerx+sprinkleAngledEnd, centery-sprinkleAngledEnd);
		Line2D.Double sprink8 = new Line2D.Double(centerx-sprinkleAngledStart, centery+sprinkleAngledStart,centerx-sprinkleAngledEnd, centery+sprinkleAngledEnd);
		//add the actual sprinkles to the donut
		thisPath.append(sprink1, false);
		thisPath.append(sprink2, false);
		thisPath.append(sprink3, false);
		thisPath.append(sprink4, false);
		thisPath.append(sprink5, false);
		thisPath.append(sprink6, false);
		thisPath.append(sprink7, false);
		thisPath.append(sprink8, false);
}
}