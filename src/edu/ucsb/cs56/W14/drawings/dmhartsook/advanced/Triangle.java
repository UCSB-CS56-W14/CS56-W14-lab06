package edu.ucsb.cs56.w14.drawings.dmhartsook.advanced;

import java.awt.geom.GeneralPath;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
 * Triangle extends GeneralPathWrapper to make it easier to draw triangles
 *
 * @author Deanna Hartsook
 * @version CS56, Winter 2014, UCSB
 */
public class Triangle extends GeneralPathWrapper implements java.awt.Shape
{
    /**
     * Constructor for objects of class Trianglue
     * @param x    x coordinate of bottom left of triangle
     * @param y    y coordinate of bottom left of triangle
     * @param l    length of a side
     */
    public Triangle(double x, double y, double l)
    {
        GeneralPath triangle = this.get();
        triangle.moveTo(x,y);
        triangle.lineTo(x+l, y-(2*l));
        triangle.lineTo(x+(2*l),y);
        triangle.lineTo(x, y);
    }
    
}
