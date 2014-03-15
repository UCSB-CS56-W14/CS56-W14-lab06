package edu.ucsb.cs56.w14.drawings.amwexler.advanced;
import java.awt.geom.GeneralPath; 
import java.awt.geom.AffineTransform; 
import java.awt.Shape; 

import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

public class SmileyFace extends GeneralPathWrapper implements Shape{
	
	public SmileyFace(double x, double y, double w, double h){
		
		Ellipse2D.Double mainElipse = new Ellipse2D.Double(x,y,w,h);
		Ellipse2D.Double outerEye1 = new Ellipse2D.Double(x + (.275*w), y + (.2*h), .15*w, .3*h);

		Ellipse2D.Double outerEye2 = new Ellipse2D.Double(x + (.575*w), y + (.2*h), (.15*w), (.3*h));

		Ellipse2D.Double innerEye1 = new Ellipse2D.Double(x + (.325*w), y + (.2*h) + (.05*h), .05*w, .15*h);

		Ellipse2D.Double innerEye2 = new Ellipse2D.Double(x + (.625*w), y + (.2*h) + (.05*h), .05*w, .15*h);

		//Line2D.Double leftSmile =  new Line2D.Double(x + .2*w, y + (.7 * h), x + (.4*w), y + (.8*h));
		//Line2D.Double midSmile = new Line2D.Double(x + (.4*w), y + (.8*h), x + (.6*w), y + (.8*h));
		//Line2D rightSmile = new Line2D.Double(x + (.6*w), y + (.8*h), x + (.8*w), y + (.7 * h));

		Arc2D.Double smile = new Arc2D.Double(new Rectangle2D.Double(x+(.4*w), y + (.5*h),.2*w,.1*h), 0, -180, Arc2D.OPEN);

		GeneralPath wholeFace = this.get();
		wholeFace.append(mainElipse, false);
		wholeFace.append(outerEye1, false);
		wholeFace.append(outerEye2,false);
		wholeFace.append(innerEye1,false);
		wholeFace.append(innerEye2, false);
		wholeFace.append(smile,false);
		//wholeFace.append(leftSmile,false);
		//wholeFace.append(midSmile,false);
		//wholeFace.append(rightSmile,false);

	}
}

