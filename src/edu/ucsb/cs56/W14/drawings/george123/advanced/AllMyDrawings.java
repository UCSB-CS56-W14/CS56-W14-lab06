package edu.ucsb.cs56.w14.drawings.george123.advanced;
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
 * @author George Chen 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few balls and Pokeballs 
     */

    public static void drawPicture1(Graphics2D g2) {

	Ball b1 = new Ball(70,180,70);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a ball that's half the size, 
	// and moved over 300 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,300,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a ball that's 4x as big (2x the original)
	// and moved over 100 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,100,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two Pokeballs
	
	Pokeball pb1 = new Pokeball(50,300,120);
	Pokeball pb2 = new Pokeball(150,150,180);
	
	g2.draw(pb1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(pb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("A few balls and Pokeballs by George Chen", 20,20);
    }


    /** Draw a picture with a few balls and Pokeballs
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Pokeballs.
	
	Pokeball large = new Pokeball(100,50,180);
	Pokeball small = new Pokeball(20,50,50);
	Pokeball pb1 = new Pokeball(20,150,80);
	Pokeball pb2 = new Pokeball(20,250,80);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(pb1);
	g2.setColor(Color.MAGENTA); g2.draw(pb2);
	
	Ball b1 = new Ball(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a ball that's half the size, 
	// and moved over 250 pixels up.
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,0,-250);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a ball that's 4x as big (2x the original)
	// and moved over 200 pixels to right and 100 units down.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,200,100);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two Pokeballs
	
	Pokeball pb4 = new Pokeball(50,350,100);
	Pokeball pb5 = new Pokeball(200,250,180);
	
	g2.draw(pb4);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second Pokeball 45 degrees around its center.
	Shape pb3 = ShapeTransforms.rotatedCopyOf(pb5, Math.PI/4.0);

	g2.draw(pb3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLUE); 
	g2.drawString("A bunch of Pokeballs and a few balls by George Chen", 20,20);
    }
  
    /** Draw a different picture with a bunch of Pokeballs
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A rainbow-colored giant cartwheel Pokeball by George Chen", 20,20);
	
        Pokeball pb1 = new Pokeball(100, 100, 300);
	Shape pb2 = ShapeTransforms.rotatedCopyOf(pb1, Math.PI/2.0);
	Shape pb3 = ShapeTransforms.rotatedCopyOf(pb1, Math.PI/4.0);
	Shape pb4 = ShapeTransforms.rotatedCopyOf(pb1, ((3 * Math.PI)/4.0));

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);

	g2.setColor(Color.GREEN);
        g2.draw(pb1);
	g2.setColor(Color.RED);
        g2.draw(pb3);
	g2.setColor(Color.MAGENTA);
	g2.draw(pb4);
	g2.setColor(Color.BLUE);
	g2.draw(pb2);
    }
    
}
