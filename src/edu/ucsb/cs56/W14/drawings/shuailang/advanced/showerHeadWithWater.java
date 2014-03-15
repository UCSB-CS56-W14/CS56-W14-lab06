package edu.ucsb.cs56.w14.drawings.shuailang.advanced;
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
   A shoer head with water comes out
      
   @author Shuai Lang
   @version for CS56, W14, UCSB, 02/25/2014
   
*/
public class showerHeadWithWater extends showerHead implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public showerHeadWithWater(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three windows, spaced like this, where w=width/10.0;
	// | +--+ +--+ +--+ |
	// | |  | |  | |  | |
	// | +--+ +--+ +--+ |
	// |w 2w w 2w w w2 w|
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;

	double hose1height =  height;

	Line2D.Double Water1 =
	    new Line2D.Double (x+2.8*hose1height, y+6*hose1height,
			       x+2.8*hose1height, y+17*hose1height);
	Line2D.Double Water2 =
            new Line2D.Double (x+0.5*hose1height, y+6*hose1height,
                               x+0.5*hose1height, y+13*hose1height);
	Line2D.Double Water3 =
            new Line2D.Double (x-2.8*hose1height, y+6*hose1height,
                               x-2.8*hose1height, y+16*hose1height);
	Line2D.Double Water4 =
            new Line2D.Double (x+2*hose1height, y+10*hose1height,
                               x+2*hose1height, y+22*hose1height);
	Line2D.Double Water5 =
	    new Line2D.Double (x-2*hose1height, y+10*hose1height,
			       x-2*hose1height, y+22*hose1height);
	
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeShowerHead = this.get();
         wholeShowerHead.append(Water1, false);
	 wholeShowerHead.append(Water2, false);
	 wholeShowerHead.append(Water3, false);
	 wholeShowerHead.append(Water4, false);
	 wholeShowerHead.append(Water5, false);


    }

}
