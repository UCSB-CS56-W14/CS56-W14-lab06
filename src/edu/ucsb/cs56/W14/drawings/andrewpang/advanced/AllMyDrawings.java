package edu.ucsb.cs56.w14.drawings.andrewpang.advanced;

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
 * @author Andrew Pang
 * @version for CS56, W14, lab06
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Plate p1 = new Plate(100,100,50);
	g2.setColor(Color.BLACK); g2.draw(p1);

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.25,0.25);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,50);
	g2.setColor(Color.RED); g2.draw(p2);
	
	p2 = ShapeTransforms.scaledCopyOfLL(p2,10,10);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,75);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	coolPlate p3 = new coolPlate(150,250,70);
	coolPlate p4 = new coolPlate(270,350,110);
	g2.draw(p3);
	g2.setColor(Color.GREEN);
	g2.draw(p4);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few plates by Andrew Pang", 20,20);
	
	
	
    }


    public static void drawPicture2(Graphics2D g2) {

    coolPlate p1 = new coolPlate(320,220,200);
    g2.setColor(Color.ORANGE); g2.draw(p1);

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.75,1);
	p2 = ShapeTransforms.translatedCopyOf(p2,-150,50);
	g2.setColor(Color.RED); g2.draw(p2);

	Shape p3 = ShapeTransforms.scaledCopyOfLL(p1,0.75,0.25);
	p3 = ShapeTransforms.translatedCopyOf(p3,150,20);
	g2.setColor(Color.GRAY); g2.draw(p3); 
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);   
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.MAGENTA); 
	
	Plate p4 = new Plate(250,250,70);
	Shape p5 = ShapeTransforms.scaledCopyOfLL(p4,.6,.2);
	p5 = ShapeTransforms.translatedCopyOf(p5,100,70);
	g2.draw(p4);
	g2.setColor(Color.PINK);
	g2.draw(p5);   

	Shape p6 = ShapeTransforms.rotatedCopyOf(p1, Math.PI/4.0);
	g2.setColor(Color.ORANGE);
	g2.setStroke(orig);
	g2.draw(p6);
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	

	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of different plates by Andrew Pang", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few wierd plates by Andrew Pang", 20,20);

	coolPlate p1 = new coolPlate(220,220,100);
    g2.setColor(Color.BLUE); g2.draw(p1);
    
    Shape p2 = ShapeTransforms.rotatedCopyOf(p1, Math.PI/8.0);
    Shape p3 = ShapeTransforms.rotatedCopyOf(p2, Math.PI/8.0);
    Shape p4 = ShapeTransforms.rotatedCopyOf(p3, Math.PI/8.0);
    g2.draw(p2); g2.draw(p3); g2.draw(p4);
     
    g2.setColor(Color.RED);   
    Shape p5 = ShapeTransforms.scaledCopyOfLL(p1,1.25,1.25);
	p5 = ShapeTransforms.translatedCopyOf(p5,150,20);
	g2.draw(p5); 
	Shape p6 = ShapeTransforms.scaledCopyOfLL(p2,1.25,1.25);
	p6 = ShapeTransforms.translatedCopyOf(p6,150,20);
	g2.draw(p6); 
	Shape p7 = ShapeTransforms.scaledCopyOfLL(p3,1.25,1.25);
	p7 = ShapeTransforms.translatedCopyOf(p7,150,20);
	g2.draw(p7); 
	Shape p8 = ShapeTransforms.scaledCopyOfLL(p4,1.25,1.25);
	p8 = ShapeTransforms.translatedCopyOf(p8,150,20);
	g2.draw(p8); 

	Plate p9 = new Plate(320,220,200);
	g2.setColor(Color.MAGENTA); g2.draw(p9);
    }
    

}
