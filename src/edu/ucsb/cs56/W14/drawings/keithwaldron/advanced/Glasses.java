package edu.ucsb.cs56.w14.drawings.keithwaldron.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

public class Glasses extends GeneralPathWrapper implements Shape{

/**
       Constructor

       @param x x coord of upper left of left lense
       @param y y coord of upper left of left lense
       @param radius radius of the lenses
     */
    public Glasses(double x, double y, double radius)
    {
    
        

        double mid = radius/2;      // 1/2 the radius, length of the bridge

	double rBegin= x+radius*2+mid; //begining of right arm
	
	
        //make left arm of glasses
        Line2D.Double leftArm = 
            new Line2D.Double (x, y+mid,
                               x-mid, y-radius*.75);
        //make right arm                      
        Line2D.Double rightArm =
            new Line2D.Double  (rBegin, y+mid,
                               x+radius*2, y-radius*.75);

	//make bridge, line connecting lenses
	Line2D.Double bridge =
            new Line2D.Double  (x+radius, y+mid/2,
                               x+radius*1.5, y+mid/2);
	//make left lense
	Ellipse2D.Double leftLense  = new Ellipse2D.Double(x, y, radius, radius);
	
	//make right lense
       	Ellipse2D.Double rightLense  =
	    new Ellipse2D.Double(x+radius*1.5, y, radius, radius);
       
	//put it all together 
        GeneralPath wholeGlasses = this.get();
        wholeGlasses.append(leftArm, false);
        wholeGlasses.append(leftLense, false);
	wholeGlasses.append(bridge, false); 
        wholeGlasses.append(rightArm, false); 
	wholeGlasses.append(rightLense, false); 
        
    }

}
