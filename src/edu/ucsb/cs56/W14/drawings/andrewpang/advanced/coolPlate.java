package edu.ucsb.cs56.w14.drawings.andrewpang.advanced;
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
   A Plate
      
   @author Andrew Pang
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class coolPlate extends Plate implements Shape
{

    public coolPlate(double x, double y, double radius)
    {
	// construct the basic house shell
		super(x,y,radius);

		// get the GeneralPath that we are going to append stuff to
		GeneralPath gp = this.get();
		
		Rectangle2D.Double firstDesign = 
	            new Rectangle2D.Double(x*.97, y+radius*.75,
	                          radius*.2, radius *.2);

	    Rectangle2D.Double secondDesign = 
            new Rectangle2D.Double(x*.97, y-radius*.94,
                          radius*.2, radius *.2);

        Rectangle2D.Double thirdDesign = 
            new Rectangle2D.Double(x+radius*.75, y*.97,
                          radius*.2, radius *.2);

        Rectangle2D.Double fourthDesign = 
            new Rectangle2D.Double(x-radius*.94, y*.97,
                          radius*.2, radius *.2);

        GeneralPath wholePlate = this.get();
        wholePlate.append(firstDesign, false);
        wholePlate.append(secondDesign, false);
      	wholePlate.append(thirdDesign, false);
   		wholePlate.append(fourthDesign, false);
    }

}
