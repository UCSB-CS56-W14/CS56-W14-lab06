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
Longer Hopscotch
@author Sohan Shah
@version for CS56, W14, UCSB, 02/25/2014
*/
public class LongerHopscotch extends Hopscotch implements Shape
{
    /**
* Constructor for objects of class LongerHopscotch
*/
    public LongerHopscotch(double x, double y, double edge)
    {
// construct the basic hopscotch shell
	super(x,y,edge);

// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

//construct another left and right space

	Rectangle2D.Double left2 =
	    new Rectangle2D.Double(x-(edge/2),y+(edge*3),edge,edge);


	Rectangle2D.Double right2 =
	    new Rectangle2D.Double(x+(edge/2),y+(edge*3),edge,edge);

//constructor for top space

	Rectangle2D.Double top =
	    new Rectangle2D.Double(x,y+(edge*4),edge,edge);

//append new parts
	gp.append(left2,false);
	gp.append(right2,false);
	gp.append(top,false);
    }
}
