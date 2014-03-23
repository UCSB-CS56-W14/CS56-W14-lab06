package edu.ucsb.cs56.w14.drawings.wjli.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A candied fruit with orange
      
   @author Wenjian
   @version for CS56, Winter 14, UCSB
   
*/

public class CandiedFruitWithOrange extends CandiedFruit implements Shape {
     /**
     * Constructor for objects of class CandiedFruitWithOrange
     */
	public CandiedFruitWithOrange(double bottom, double height, double x){
		super(bottom, height, x);
		double singleFruitHeight = height * 2.0 / 15.0;
		double singleFruitOccupancy = height / 5.0;
		CoffeeCup orange1 = new CoffeeCup(x - 5.0 - singleFruitHeight / 2.0, bottom - 2.0 * singleFruitOccupancy, singleFruitHeight + 10.0, singleFruitOccupancy - singleFruitHeight);
		CoffeeCup orange2 = new CoffeeCup(x - 5.0 - singleFruitHeight / 2.0, bottom - 3.0 * singleFruitOccupancy, singleFruitHeight + 10.0, singleFruitOccupancy - singleFruitHeight);
		CoffeeCup orange3 = new CoffeeCup(x - 5.0 - singleFruitHeight / 2.0, bottom - 4.0 * singleFruitOccupancy, singleFruitHeight + 10.0, singleFruitOccupancy - singleFruitHeight);
		wholeFruit.append(orange1, false);
		wholeFruit.append(orange2, false);
		wholeFruit.append(orange3, false);
		
	}

}
