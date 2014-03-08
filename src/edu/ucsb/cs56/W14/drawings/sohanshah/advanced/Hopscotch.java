package edu.ucsb.cs56.w14.drawings.sohanshah.advanced;
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
A vector drawing of a Hopscotch board that implements
the Shape interface, and so can be drawn, as well as
rotated, scaled, etc.
@author Sohan Shah
@version for CS56, Winter 14, UCSB
*/

public class Hopscotch extends GeneralPathWrapper implements Shape
{
    /**
Constructor

@param x x coord of lower left corner of hopscotch
@param y y coord of lower left corner of hopscotch
@param edge length of one of the edges of the hopscotch squares 

*/
    public Hopscotch(double x, double y, double edge)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height. If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
          
        // Initial square
        
        Rectangle2D.Double bottomSquare =
            new Rectangle2D.Double(x, y,
                          edge, edge);
         
	// Left square
	
	Rectangle2D.Double leftSquare =
	    new Rectangle2D.Double(x-(edge/2),y+edge,edge,edge);

	//Right square
	
	Rectangle2D.Double rightSquare = 
	    new Rectangle2D.Double(x+(edge/2),y+edge,edge,edge);

	//Top square
	
	Rectangle2D.Double topSquare= 
	    new Rectangle2D.Double(x,y+(2*edge),edge,edge);
        
        // put the whole game together
       
        GeneralPath wholeHopscotch = this.get();
        wholeHopscotch.append(bottomSquare, false);
        wholeHopscotch.append(leftSquare, false);
        wholeHopscotch.append(rightSquare, false);
        wholeHopscotch.append(topSquare, false);
    }

}
