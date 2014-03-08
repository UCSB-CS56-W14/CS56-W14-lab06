package edu.ucsb.cs56.w14.drawings.dmhartsook.advanced;
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
 A Chocolate Chip Cookie
 
 @author Deanna Hartsook
 @version for CS56, W14, UCSB, 2/18/2014
 
 */
public class ChocolateChipCookie extends Cookie implements Shape
{
    /**
     * Constructor for objects of class ChocolateChipCookie
     */
    public ChocolateChipCookie(double x, double y, double r)
    {
        // construct the basic cookie shell
        super(x,y,r);
        
        // Add triangles for the chips
        double length = r/10;
        Triangle chip1 = new Triangle(x-length, y+length, length);
        Triangle chip2 = new Triangle(x+(3*length), y-(2*length), length);
        Triangle chip3 = new Triangle(x+(5*length), y+(5*length), length);
        Triangle chip4 = new Triangle(x-(7*length), y-(4*length), length);
        Triangle chip5 = new Triangle(x-(4*length), y+(4*length), length);
        
        // add the chips to the cookie
        
        GeneralPath cookie = this.get();
        cookie.append(chip1, false);
        cookie.append(chip2, false);
        cookie.append(chip3, false);
        cookie.append(chip4, false);
        cookie.append(chip5, false);
    }
    
}
