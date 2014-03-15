package edu.ucsb.cs56.w14.drawings.khalid.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few ice cream cones
     */

    public static void drawPicture1(Graphics2D g2) {

        IceCreamCone c1 = new IceCreamCone(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(c1);
	

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,250,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	c2 = ShapeTransforms.scaledCopyOfLL(c2,3,3);
	c2 = ShapeTransforms.translatedCopyOf(c2,100,150);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	
	SprinkledIceCreamCone sp1 = new SprinkledIceCreamCone(50,400,40);
        SprinkledIceCreamCone sp2 = new SprinkledIceCreamCone(200,450,80);
	
	g2.draw(sp1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sp2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few ice cream cones by Khalid Dhanani", 20,20);
    }


    /** Draw a picture with a few ice cream cones
     */
    public static void drawPicture2(Graphics2D g2) {

	
        IceCreamCone large = new IceCreamCone(330,360,90);
        IceCreamCone small = new IceCreamCone(30,450,30);
	
	g2.setColor(Color.BLUE);    g2.draw(large);
	g2.setColor(Color.MAGENTA); g2.draw(small);
	
	IceCreamCone c1 = new IceCreamCone(100,350,65);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	c2 = ShapeTransforms.scaledCopyOfLL(c2,2,2);
	c2 = ShapeTransforms.translatedCopyOf(c2,350,50);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	
        SprinkledIceCreamCone sp1 = new SprinkledIceCreamCone(50,350,25);
	SprinkledIceCreamCone sp2 = new SprinkledIceCreamCone(370,500,55);
	
	g2.draw(sp1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second cone 45 degrees around its center.
	Shape sp3 = ShapeTransforms.rotatedCopyOf(sp2, Math.PI/4.0);

	g2.draw(sp3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("More ice cream cones by Khalid Dhanani", 20,20);
    }
  
    /** Draw a different picture with a few ice cream cones
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of ice cream cones by Khalid Dhanani", 20,20);

	
	IceCreamCone large = new IceCreamCone(200,350,40);
       IceCreamCone small = new IceCreamCone(120,250,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
