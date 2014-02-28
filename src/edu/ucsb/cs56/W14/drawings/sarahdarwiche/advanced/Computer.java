package edu.ucsb.cs56.w14.drawings.sarahdarwiche.advanced;
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
   A Computer
      
   @author Sarah Darwiche 
   @version for CS56, W14, UCSB, 02/16/2014
   
*/
public class Computer extends ComputerMonitor implements Shape
{
    /**
     * Constructor for objects of class Computer
     */
    public Computer(double x, double y, double width, double height)
    {
	// construct the basic computer monitor shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//scale base hight and width
	double w = 0.25 * width;
	double base_top = y + height;
	double base_height =  0.25 * height;
	
	// Make a base for the computer
	
	Rectangle2D.Double comp1 =
	    new Rectangle2D.Double(x +((width-w)/2), base_top, w, base_height/2);

	Rectangle2D.Double comp2 =
	    new Rectangle2D.Double(x +((width-w)/3), base_height / 2 + base_top  , 2*w, base_height/4);

	//add base to the computers
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeComputer = this.get();
	wholeComputer.append(comp1, false);
	wholeComputer.append(comp2, false);
      
    }

}
