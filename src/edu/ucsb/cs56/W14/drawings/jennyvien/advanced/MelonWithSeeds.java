package edu.ucsb.cs56.w14.drawings.jennyvien.advanced;
import java.awt.geom.GeneralPath; 
import java.awt.geom.AffineTransform; 
import java.awt.Shape; 
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A melon with seeds.
      
   @author Phill Conrad 
   @author Jenny Vien
   @version for CS56, W14, UCSB, 02/22/2014
   
*/
public class MelonWithSeeds extends Melon implements Shape
{
    /**
     * Constructor for objects of class MelonWithSeeds
     */
    public MelonWithSeeds(double x, double y, double width, double height)
    {
	super(x,y,width,height);
		

	double w = 25 * (width/super.ORIG_WIDTH); // width of the seed
	double h = 50 * (height/super.ORIG_HEIGHT); // height of the seed
		
	double start = (width*0.2)+(width*0.025); // starting x-coordinate for seeds for seeds
	double gap1 = width*0.25; // the gap for the wholeMelon on row 1
	double gap2 = width*0.125; // the gap for the wholeMelon on rows two
	double gaph = height * 0.143; // the gap between the rows of seed
		
	Ellipse2D.Double s1 = new Ellipse2D.Double (x+start,y+gaph,w,h);
	Ellipse2D.Double s2 = new Ellipse2D.Double (x+start+gap1,y+gaph,w,h);
	Ellipse2D.Double s3 = new Ellipse2D.Double (x+start+(2*gap1),y+gaph,w,h);
	Ellipse2D.Double s4 = new Ellipse2D.Double (x+start+gap2,y+(3*gaph),w,h);
	Ellipse2D.Double s5 = new Ellipse2D.Double (x+start+(3*gap2),y+(3*gaph),w,h);
		
	GeneralPath wholeMelon = this.get();
        wholeMelon.append(s1, false);
        wholeMelon.append(s2, false);
        wholeMelon.append(s3, false);
	wholeMelon.append(s4, false);
        wholeMelon.append(s5, false);
		
	this.set(new GeneralPath(wholeMelon));
			
    }
}
		
