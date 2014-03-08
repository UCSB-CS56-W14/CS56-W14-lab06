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

public class Kirby extends SmileyFace implements Shape{

	public Kirby(double x, double y, double w, double h){
	
		super(x,y,w,h);

		Arc2D.Double leftArm = new Arc2D.Double(new Rectangle2D.Double(x-(.2*w), y + (.5*h), .4*w, .3*h),90,210,Arc2D.OPEN);

		Arc2D.Double rightArm = new Arc2D.Double(new Rectangle2D.Double(x+(.8*w), y + (.5*h), .4*w, .3*h),90,-210,Arc2D.OPEN);		

		Ellipse2D.Double blushL = new Ellipse2D.Double(x + .1*w, y + .5*h, .15*w, .075*h);
		Ellipse2D.Double blushR = new Ellipse2D.Double(x + .9*w - .15*w, y + .5*h, .15*w, .075*h);

		Arc2D.Double leftLeg = new Arc2D.Double(new Rectangle2D.Double(x-(.1*w), y + (.85*h),.6*w, .2*h),100,230, Arc2D.OPEN);

		Arc2D.Double rightLeg = new Arc2D.Double(new Rectangle2D.Double(x+(.5*w), y + (.85*h),.6*w, .2*h),80,-230, Arc2D.OPEN);

		GeneralPath wholeKirby = this.get();
                wholeKirby.append(leftArm, false);
		wholeKirby.append(rightArm, false);	
		wholeKirby.append(blushL, false);
		wholeKirby.append(blushR, false);
		wholeKirby.append(leftLeg, false);
		wholeKirby.append(rightLeg, false);

	}

}
