package edu.ucsb.cs56.w14.drawings.chrisluo.advanced;
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
import java.awt.geom.Ellipse2D;


import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A House
      
   @author Phill Conrad 
   @author Chris Luo
   @version for CS56, W14, UCSB, 02/28/2014
   
*/
public class PumpkinJack extends Pumpkin implements Shape
{
    public PumpkinJack(double x, double y, double width, double height)
    {
	// construct the basic pumpkin
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	Ellipse2D.Double eye1 =
	    new Ellipse2D.Double(x+width/6,y+height/4,width*.25,height*.25);
	Ellipse2D.Double eye2 =
	    new Ellipse2D.Double(x+width/1.7,y+height/4,width*.25, height*.25);
	Line2D.Double mouth =
	    new Line2D.Double(x+width/4.5, y+height/1.35, x+width/1.35, y+height/1.35);
	Line2D.Double nose =
	    new Line2D.Double(x+width/2,y+height/2.2,x+width/2,y+height/1.65);
	Line2D.Double mouth1 = 
	    new Line2D.Double(x+width/4.5, y+height/1.35, (x+width/4.5)*.9, (y+height/1.35)*.9);
	Line2D.Double mouth2 = 
	    new Line2D.Double(x+width/1.35, y+height/1.35, (x+width/1.35)/.9195, (y+height/1.35)*.9);
	Ellipse2D.Double eye3 =
	    new Ellipse2D.Double((x+width/4),y+height/3,width*.1,height*.1);
	Ellipse2D.Double eye4 =
	    new Ellipse2D.Double((x+width/1.5),y+height/3,width*.1,height*.1);
	
	// add the eyes to the pumpkin
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholepumpkin = this.get();
        wholepumpkin.append(eye1, false);
        wholepumpkin.append(eye2, false);
        wholepumpkin.append(mouth, false);
	wholepumpkin.append(nose, false);
	wholepumpkin.append(mouth1, false);
	wholepumpkin.append(mouth2, false);
	wholepumpkin.append(eye3, false);
	wholepumpkin.append(eye4,false);
    }

}
