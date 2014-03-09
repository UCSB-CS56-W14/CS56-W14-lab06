package edu.ucsb.cs56.w14.drawings.kmai.advanced;

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
 * @author Kevin Mai
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Triangles and Stars of Davids
     */

    public static void drawPicture1(Graphics2D g2) {

	Triangle t1 = new Triangle(100,250,100);

	g2.setColor(Color.RED) ; g2.draw(t1);

	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two StarsOfDavids
	StarOfDavid st1 = new StarOfDavid(120,120,100);
	StarOfDavid st2 = new StarOfDavid(220,120,100);

	g2.draw(st1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(st2);
	
	
	g2.setStroke(orig);

	g2.setColor(Color.YELLOW);
	g2.setStroke(thick);
	t2 = ShapeTransforms.translatedCopyOf(st2,100,0);

	g2.draw(t2);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Triangles and Star of Davids by Kevin Mai", 20,20);
    }


    /** Draw a picture with Triangles and Stars of Davids
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some triangles
	
	Triangle xsmall = new Triangle(50,50,50);
	Triangle small = new Triangle(100,100,100);
	Triangle medium = new Triangle(200,200,150);
	Triangle large = new Triangle(350,350,200);
	
	g2.setColor(Color.RED);     g2.draw(xsmall);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(medium);
	g2.setColor(Color.MAGENTA); g2.draw(large);
	
	Shape x = ShapeTransforms.scaledCopyOfLL(medium,2,2);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       	
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.CYAN); g2.draw(x);
	

	Shape t1 = ShapeTransforms.scaledCopyOfLL(medium,0.5,0.5);
	t1 = ShapeTransforms.translatedCopyOf(t1,150,0);
	g2.setColor(Color.BLACK); g2.draw(t1);
	

	t1 = ShapeTransforms.scaledCopyOfLL(t1,4,4);
	t1 = ShapeTransforms.translatedCopyOf(t1,150,0);
	
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t1); 
	
	// Draw two Stars of Davids
	
	StarOfDavid S1 = new StarOfDavid(120,100,200);
	StarOfDavid S2 = new StarOfDavid(200,350,300);
	
	g2.draw(S1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second Star of David 45 degrees around its center.
	Shape S3 = ShapeTransforms.rotatedCopyOf(S2, Math.PI/4.0);

	g2.draw(S3);
	
	
	g2.setColor(Color.BLACK); 
	g2.drawString("Abstract Art with Triangles and Stars of Davids by Kevin Mai", 20,20);
    }
  
    /** Draw a bunch of rotated Stars of Davids
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Stars Of Davids by Kevin Mai", 20,20);
	//Start Drawing
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       	
	
	g2.setStroke(thick);
	g2.setColor(Color.BLUE);
	StarOfDavid st1 = new StarOfDavid(100,500,50);
	Shape st2 = ShapeTransforms.translatedCopyOf(st1,0,0);
	for(int i = 0; i <= 200; i=i+50){
	    for(int j = 10; j > 0; --j){
		g2.draw(st2);
		if(j%2 == 0)
		    g2.setColor(Color.BLACK);
		else
		    g2.setColor(Color.BLUE);
		st2 = ShapeTransforms.translatedCopyOf(st2,0,-50);
	    }
	    st2 = ShapeTransforms.translatedCopyOf(st1, i + 50, 0);
	    st2 = ShapeTransforms.rotatedCopyOf(st2, i + 50);
	}
	g2.setColor(Color.RED);
	for(int i = 200; i <= 400; i=i+50){
	    for(int j = 10; j > 0; --j){
		g2.draw(st2);
		if(j%2 == 0)
		    g2.setColor(Color.YELLOW);
		else
		    g2.setColor(Color.RED);
		st2 = ShapeTransforms.translatedCopyOf(st2,0,-50);
	    }
	    st2 = ShapeTransforms.translatedCopyOf(st1, i + 50, 0);
	    st2 = ShapeTransforms.rotatedCopyOf(st2, i + 50);
	}

    }
}
