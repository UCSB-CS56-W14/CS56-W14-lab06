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
   A vector drawing of a candied fruit that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Wenjian
   @version for CS56, Winter 14, UCSB
   
*/
public class CandiedFruit extends GeneralPathWrapper implements Shape
{

	GeneralPath wholeFruit = this.get();
	Line2D.Double segment2;
	Line2D.Double segment3;
	Line2D.Double segment4;
    /**
       Constructor

       @param bottom bottom of the fruit
       @param height height of the fruit
       @param x horizontal position of the fruit
     */
    public CandiedFruit(double bottom, double height, double x)
    {
	double singleFruitHeight = height * 2.0 / 15.0;
	double singleFruitOccupancy = height / 5.0;
	Line2D.Double segment1 = new Line2D.Double(x, bottom, x, bottom - singleFruitOccupancy);
	segment2 = new Line2D.Double(x, bottom - singleFruitOccupancy - singleFruitHeight, x, bottom - 2.0 * singleFruitOccupancy);
	segment3 = new Line2D.Double(x, bottom - 2.0 * singleFruitOccupancy - singleFruitHeight, x, bottom - 3.0 * singleFruitOccupancy);
	segment4 = new Line2D.Double(x, bottom - 3.0 * singleFruitOccupancy - singleFruitHeight, x, bottom - 4.0 * singleFruitOccupancy);
	Line2D.Double segment5 = new Line2D.Double(x, bottom - 4.0 * singleFruitOccupancy - singleFruitHeight, x, bottom - 5.0 * singleFruitOccupancy);
	Ellipse2D.Double fruit1 = new Ellipse2D.Double(x - singleFruitHeight / 2.0, bottom - singleFruitOccupancy - singleFruitHeight, singleFruitHeight, singleFruitHeight);
	Ellipse2D.Double fruit2 = new Ellipse2D.Double(x - singleFruitHeight / 2.0, bottom - singleFruitOccupancy * 2.0 - singleFruitHeight, singleFruitHeight, singleFruitHeight);
	Ellipse2D.Double fruit3 = new Ellipse2D.Double(x - singleFruitHeight / 2.0, bottom - singleFruitOccupancy * 3.0 - singleFruitHeight, singleFruitHeight, singleFruitHeight);
	Ellipse2D.Double fruit4 = new Ellipse2D.Double(x - singleFruitHeight / 2.0, bottom - singleFruitOccupancy * 4.0 - singleFruitHeight, singleFruitHeight, singleFruitHeight);

	
	addSegment(segment1);
	addSegment(segment2);
	addSegment(segment3);
	addSegment(segment4);
	addSegment(segment5);
	wholeFruit.append(fruit1, false);
	wholeFruit.append(fruit2, false);
	wholeFruit.append(fruit3, false);
	wholeFruit.append(fruit4, false);
    }

	public void addSegment(Line2D.Double segment){
		wholeFruit.append(segment, false);
	}

}
