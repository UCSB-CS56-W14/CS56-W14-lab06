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
	//GeneralPath gp = this.get();
	
	// Make a mouse


	

	
	// add the mouse to the computer
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeComputer = this.get();
	//  wholeComputer.append(win1, false);
        //wholeComputer.append(win2, false);
        //wholeComputer.append(win3, false); 
    }

}
