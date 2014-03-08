package edu.ucsb.cs56.w14.drawings.maxsorenson.advanced;
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
   A vector drawing of a television with
   an antenna and buttons that implements the 
   Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Max Sorenson 
   @version for CS56, Winter 14, UCSB
   
*/
public class TelevisionAntenna extends Television implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of television
       @param y y coord of lower left corner of television
       @param width width of the television
       @param height of television (including stand but not antenna)
     */
    public TelevisionAntenna(double x, double y, double width, double height)
    {
	super(x,y,width,height);
       
	GeneralPath g = this.get();
                      
        // make the television.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
	
	double antennaHeight = y - height - ( height * .05);
	double buttonHeight = (y + height) -( height * .075);

        Line2D.Double leftAntenna = 
            new Line2D.Double (x + width/2.0, y,
                               x, antennaHeight );
                               
        Line2D.Double rightAntenna =
            new Line2D.Double (x + width/2.0, y,
                               x + width, antennaHeight );
	
	Ellipse2D.Double button1 = 
	    new Ellipse2D.Double (x + width*.05, buttonHeight,
				  width*.05, height*.05 );
	
        // put the whole television together
       
        GeneralPath wholeTelevision = this.get();
        wholeTelevision.append(rightAntenna, false);
        wholeTelevision.append(leftAntenna, false);
        wholeTelevision.append(button1, false); 
        
    }

}
