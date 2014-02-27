package edu.ucsb.cs56.w14.drawings.jrcryan.advanced;

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
 * @author Jenna Cryan
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few popsicles 
     */

    public static void drawPicture1(Graphics2D g2) {

	Popsicle p1 = new Popsicle(150,100,50,175);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);   
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two popsicles with sticks
	
	PopsicleOnAStick ps1 = new PopsicleOnAStick(350,150,80,235);
	PopsicleOnAStick ps2 = new PopsicleOnAStick(200,200,100,200);
	
	g2.draw(ps1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(ps2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few popsicles by Jenna Cryan", 20,20);
    }


    /** Draw a picture with a few popsicles
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some popsicles.
	
	PopsicleOnAStick large = new PopsicleOnAStick(100,50,150,225);
	PopsicleOnAStick small = new PopsicleOnAStick(60,50,20,40);
	PopsicleOnAStick tallSkinny = new PopsicleOnAStick(1000,150,20,40);
	PopsicleOnAStick shortFat = new PopsicleOnAStick(40,220,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Popsicle p1 = new Popsicle(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black popsicle that's half the size, 
	// and moved over 150 pixels in x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a popsicle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two popsicles with sticks
	
	PopsicleOnAStick ps1 = new PopsicleOnAStick(50,350,140,75);
	PopsicleOnAStick ps2 = new PopsicleOnAStick(250,150,300,100);
	
	g2.draw(ps1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second popsicle 45 degrees around its center.
	Shape ps3 = ShapeTransforms.rotatedCopyOf(ps2, Math.PI/4.0);

	g2.draw(ps3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of popsicles, some with sticks & some without, by Jenna Cryan", 20,20);
    }
  
    /** Draw a different picture with a few popsicles
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of popsicles by Jenna Cryan", 20,20);

       PopsicleOnAStick large = new PopsicleOnAStick(100,50,120,250);
       Popsicle small = new Popsicle(20,50,30,60);
       PopsicleOnAStick ps2 = new PopsicleOnAStick(400,125,60,150);
       Popsicle p2 = new Popsicle(250,200,100,160);

       Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
       g2.setStroke(thick);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       g2.setColor(Color.CYAN);     g2.draw(ps2);
       g2.setColor(Color.MAGENTA);   g2.draw(p2);
       
    }
    
}
