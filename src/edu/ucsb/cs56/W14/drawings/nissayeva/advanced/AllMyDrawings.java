package edu.ucsb.cs56.w14.drawings.nissayeva.advanced;

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
 * @author Natasha Issayeva 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few mushrooms 
     */

    public static void drawPicture1(Graphics2D g2) {

	Mushroom m1  = new Mushroom(100,250,75,50);
	g2.setColor(Color.CYAN); g2.draw(m1);
	
	// Make a black musrhoom that's half the size, 
	// and moved over 150 pixels in x direction

	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a mushroom that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw two Mario mushrooms
	
	MarioMushroom mm1 = new MarioMushroom(50,350,75,40);
	MarioMushroom mm2 = new MarioMushroom(200,350,200,100);
	
	g2.draw(mm1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(mm2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few mushrooms by Natasha Issayeva", 20,20);
    }


    // Draw a picture with a few mushrooms and Mario mushrooms
     
    public static void drawPicture2(Graphics2D g2) {

	// Draw some mushrooms.
	
	Mushroom large = new Mushroom(100,50,225,150);
	Mushroom small = new Mushroom(20,50,40,30);
	Mushroom tallSkinny = new Mushroom(20,150,20,40);
	Mushroom shortFat = new Mushroom(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	MarioMushroom m1 = new MarioMushroom(100,250,75,50);
	g2.setColor(Color.CYAN); g2.draw(m1);
	
	// Make a black mushroom that's half the size, 
	// and moved over 150 pixels in x direction
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a mushrooom that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw two Mario mushrooms
	
	MarioMushroom mm1 = new MarioMushroom(50,350,75,40);
	MarioMushroom mm2 = new MarioMushroom(200,350,200,100);
	
	g2.draw(mm1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape mm3 = ShapeTransforms.rotatedCopyOf(mm2, Math.PI/4.0);

	g2.draw(mm3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of mushrooms by Natasha Issayeva", 20,20);
    }
  
    // Draw a different picture with a few mushrooms and Mario mushrooms
     

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of mushrooms by Natasha Issayeva ", 20,20);

	
	// Draw some mushrooms
	
       Mushroom large = new Mushroom(100,300,225,150);
       MarioMushroom small = new MarioMushroom(20,100,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       }  
       
  
    

}
