package edu.ucsb.cs56.w14.drawings.kfomenko.advanced;
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
   A vector drawing of a basket that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Kateryna Fomenko
   @version for CS56, Winter 14, UCSB
   
*/
public class Basket extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of basket
       @param y y coord of upper left corner of basket
       @param width width of the basket
       @param height of basket
     */
    public Basket(double x, double y, double width, double height)
    {
            
        // Making the basket
        
		Line2D.Double leftSide =
			new Line2D.Double (x, y, x + width/6.0, y+ height );

		Line2D.Double rightSide =
			new Line2D.Double (x+ width, y, (x + width) - width/6.0, y+ height );

		Line2D.Double topSide =
			new Line2D.Double (x, y, x + width, y);

		Line2D.Double bottomSide =
			new Line2D.Double (x + width/6.0, y + height, (x + width) - width/6.0, y + height);

        // put the basket together
       
        GeneralPath basket = this.get();
        basket.append(leftSide, false);
        basket.append(bottomSide, false);
        basket.append(rightSide, false);
        basket.append(topSide, false);
        
    }

}
