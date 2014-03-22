package edu.ucsb.cs56.w14.drawings.jstaahl.simple;



/**
 * Circle extends Ellipse2D to make it easier to draw circles
 * because the parameters to the constructor are more convenient
 * 
 * @author P. Conrad  
 * @version CS56, Spring 2013, UCSB
 */
public class Circle extends java.awt.geom.Ellipse2D.Double implements java.awt.Shape
{ 
    /**
     * Constructor for objects of class Circle
     * @param x    x coordinate of center of circle
     * @param y    y coordinate of center of circle
     * @param r    radius of circle
     */
    public Circle(double x, double y, double r)
    {
        // invoke the super class constructor,
        // i.e. the one for Ellipse2D.Double, which takes
        // upper-left-x, upper-left-y (of the bounding box)
        // width, and height
        
        super( x - r, y - r,   /* upper left corner of bounding box */
               r * 2,  r * 2); /* width and height are double the radius */
    }
    
}
