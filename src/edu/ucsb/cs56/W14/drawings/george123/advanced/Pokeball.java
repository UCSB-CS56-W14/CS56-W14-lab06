package edu.ucsb.cs56.w14.drawings.george123.advanced;
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
   A Pokeball
      
   @author George Chen 
   @version for CS56, W14, UCSB, 02/23/2011
   
*/
public class Pokeball extends Ball implements Shape
{
    /**
     * Constructor for objects of class Pokeball
     */
    public Pokeball(double x, double y, double radius)
    {
        // construct the basic ball shell
        super(x,y,radius);

        // get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();

	double r1 = 0.15 * radius;
	double r2 = 0.25 * radius;

	Ellipse2D.Double CenterCircle1 =
	    new Ellipse2D.Double((x + ((0.5 * radius) - (0.5 * r1))), (y + ((0.5 * radius) - (0.5 * r1))), r1, r1 );
	Ellipse2D.Double CenterCircle2 =
            new Ellipse2D.Double((x + ((0.5 * radius) - (0.5 * r2))), (y + ((0.5 * radius) - (0.5 * r2))), r2, r2 );
	Line2D.Double Line1 =
	    new Line2D.Double(x, (y + (0.5 * radius)), (x + ((0.5 * radius) - (0.5 * r2))), (y + (0.5 * radius)) );
	Line2D.Double Line2 =
	    new Line2D.Double((x + ((0.5 * radius) + (0.5 * r2))) , (y + (0.5 * radius)), x + radius, (y + (0.5 * radius)));

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(CenterCircle1, false);
        wholeHouse.append(CenterCircle2, false);
        wholeHouse.append(Line1, false);
	wholeHouse.append(Line2, false);
    }

}
