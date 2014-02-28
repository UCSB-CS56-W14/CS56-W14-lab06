package edu.ucsb.cs56.w14.drawings.zhansaya.advanced;

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
import edu.ucsb.cs56.w14.drawings.zhansaya.simple.Circle;

/**
   A vector drawing of a pie that implements the Shape interface, 
   and can be drawn as well as rotated, etc.
   
   @author Zhansaya Abdikarimova
   @version Lab 06, CS56, Winter 14, UCSB
   
*/
public class Pie extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param centerx  the x coordinate for the center of the pie
       @param centery  the y coordinate for the center of the pie
       @param radius  the radius of the pie
     */
    public Pie(double centerx, double centery, double radius)
    {
    
		Circle pie = new Circle(centerx,centery,radius);

    
    	// put the whole pie together
        GeneralPath wholePie = this.get();
		// add edge of the pie
        drawEdges(wholePie, centerx, centery, radius);
		
        wholePie.append(pie, false);
        
    }

    /**
	   This function is a helper function to draw edges of the pie.

       @param thisPath  the GeneralPath wrapper object
       @param centerx  the x coordinate for the center of the pie
       @param centery  the y coordinate for the center of the pie
    */
    
    
    public void drawEdges(GeneralPath thisPath, double centerx, double centery, double radius)
    {
    	Circle edge = new Circle(centerx,centery,radius+10);

    	thisPath.append(edge, false);
    }

}