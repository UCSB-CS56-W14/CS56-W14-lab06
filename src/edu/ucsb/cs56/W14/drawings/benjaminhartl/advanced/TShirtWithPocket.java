package edu.ucsb.cs56.w14.drawings.benjaminhartl.advanced;
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
   A TShirtWithPocket
      
   @author Benjamin Hartl
   @version for CS56, W14, UCSB, 02/16/2014
   
*/
public class TShirtWithPocket extends TShirt implements Shape
{
    /**
     * Constructor for objects of class TShirtWithPocket
     */
    public TShirtWithPocket(double x, double y, double width, double height)
    {
	// construct the basic TShirt shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// Make A Pocket on the shirt, spaced like this, w = width / 3;
	//*****************************************************
	//*****************    Pocket    **********************

	//  The numbers corrospond to the formulas below

	//                     ___
	// |----------|         | 1 = yStart
        // 2 = xStart  ______  _|_  ___   
	//             |    |       | 4 = height of pocket  
	//             |    |      _|_  ___
	//             \____/           _|_ 6 = third of height of pocket
	//   
	//             |-3--| = width of pocket
	//             |-5|  = half width of pocket

	double topY = y + .2 * height;                       // 1
	double leftX = (x + width/2) + ( (width/2) / 6.86);  // 2
	double w = width / 6;                                // 3
	double h = height * .2;                              // 4
	double wPeak = w / 2;                                // 5
	double hPeak = h / 3;                                // 6

	GeneralPath pocket = new GeneralPath(); 
	pocket.moveTo(leftX,topY);                       // topleft
	pocket.lineTo(leftX,topY + h);                   // bottomleft
	pocket.lineTo(leftX + wPeak, topY + h + hPeak);  // bottom
	pocket.lineTo(leftX + w, topY + h);              // bottomright
	pocket.lineTo(leftX + w, topY);                  // topright
	pocket.lineTo(leftX,topY);                       // start,topleft

	GeneralPath line = new GeneralPath();
	line.moveTo(x+width*.5,y);                       // center of shirt
	line.lineTo(x+width*.5,y + height);              // bottom center

	GeneralPath buttonUpShirt = this.get();
	buttonUpShirt.append(line,false);
	buttonUpShirt.append(pocket,false);
    }
}
