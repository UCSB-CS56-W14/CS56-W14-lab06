package edu.ucsb.cs56.w14.drawings.xin.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves                                                                                        
import java.awt.geom.AffineTransform; // translation, rotation, scale                                                                                        
import java.awt.Shape; // general class for shapes                                                                                                           
// all imports below this line needed if you are implementing Shape                                                                                           
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
   A vector drawing of an balloon that implements                                                                                                            
   the Shape interface, and so can be drawn, as well as                                                                                                      
   rotated, scaled, etc.                                                                                                                                      
   @author Yue Xin                                                                                                                                           
   @version for CS56, Winter 14, UCSB                                                                                                                         
*/

public class BalloonWithString extends Balloon implements Shape
{
    public BalloonWithString(double x, double y, double r){

	super(x,y,r);
	GeneralPath gp= this.get();

	double sTopX= x; 
	double sTopY= y + 2*r;
	double sBottomX=x+ (double)(1/2)*r;
	double sBottomY= sTopY+ 2*r;

	Line2D.Double s= new Line2D.Double(sTopX,sTopY,sBottomX,sBottomY);

	GeneralPath balloon=this.get();
	balloon.append(s,false);

    }



}