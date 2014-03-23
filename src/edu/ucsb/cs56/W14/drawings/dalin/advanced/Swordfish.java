package edu.ucsb.cs56.w14.drawings.dalin.advanced;
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
 A Swordfish
 
 @author Dalin Wang
 @version for CS56, W14, UCSB, 02/15/2014
 
 */
public class Swordfish extends Fish implements Shape
{
    /**
     * Constructor for swordfish
     */
    public Swordfish(double x, double y, double width, double height)
    {
        // construct the basic fish shell
        super(x,y,width,height);
        
        // get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();
        
        Line2D.Double longbill = new Line2D.Double(x + width , y + height/2.0 , x+ 1.50 * width , y + height/2.0);
        
        // add the longbill to the fish
        // Look up the meaning of the second parameter of append
        // (Hint--is a method of "GeneralPath")
        
        GeneralPath wholeFish = this.get();
        wholeFish.append(longbill, false);
        
    }
    
}

