package edu.ucsb.cs56.w14.drawings.allisonshedden.advanced;
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
   A Cereal Bowl with Chex
      
   @author Allison Shedden
   @version for CS56, W14, UCSB, 02/23/2014
   
*/
public class CerealBowlWithChex extends CerealBowl implements Shape
{
    /** Constructor */
    public CerealBowlWithChex(double x, double y, double width, double height)
    {
	// construct the basic cereal bowl shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// dimensions for Chex

	double c = 0.10 * width;
	double chexTop = y - 0.10 * height;
	double chexHt = 0.10 * height;

	Rectangle2D.Double chex1 =
	    new Rectangle2D.Double(x + c, chexTop, 1.5 * c, chexHt);
	Rectangle2D.Double chex2 =
	    new Rectangle2D.Double(x + 3.0*c, chexTop, 1.5 * c, chexHt);
	Rectangle2D.Double chex3 =
	    new Rectangle2D.Double(x + 6.0*c, chexTop, 1.5 * c, chexHt);
	Rectangle2D.Double chex4 =
	    new Rectangle2D.Double(x + 8.0*c, chexTop, 1.5 * c, chexHt);

	GeneralPath splash = new GeneralPath();
	
	splash.moveTo(x + c, chexTop - 1.5*c);
	splash.lineTo(x + c + 10, chexTop - c); // left splash

	splash.moveTo(x + 9.5*c, chexTop - 1.5*c);
	splash.lineTo(x + 9.5*c - 10, chexTop - c); // right splash
	
	// add the Chex to the cereal bowl

        GeneralPath wholeBowl = this.get();
        wholeBowl.append(chex1, false);
        wholeBowl.append(chex2, false);
        wholeBowl.append(chex3, false);
	wholeBowl.append(chex4, false);
	wholeBowl.append(splash, false);
    }

}
