package edu.ucsb.cs56.w14.drawings.chrisluo.advanced;

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
 *@author Chris Luo
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{

    public static void drawPicture1(Graphics2D g2) {

	Pumpkin p1 = new Pumpkin(20,200,50,50);
	g2.setColor(Color.ORANGE); g2.draw(p1);

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(p2);

	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFF7518)); 
	g2.draw(p2); 
	
	
	PumpkinJack pj1 = new PumpkinJack(25,25,50,50);
        PumpkinJack pj2 = new PumpkinJack(50,50,75,50);
	
	g2.draw(pj1);
	g2.setColor(new Color(0xFF7518)); g2.draw(pj2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few pumpkins by Chris Luo", 20,20);
    }


    /** Draw a picture with pumpkins and jack o lanterns
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some pumpkins
	
	Pumpkin large = new Pumpkin(100,50,225,150);
        Pumpkin smallCC = new Pumpkin(20,50,40,30);
        Pumpkin tallSkinny = new Pumpkin(20,150,20,40);
        Pumpkin shortFat = new Pumpkin(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Pumpkin p1 = new Pumpkin(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);

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
	
        PumpkinJack pj1 = new PumpkinJack(50,350,40,75);
	PumpkinJack pj2 = new PumpkinJack(200,350,200,100);
	
	g2.draw(pj1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape pj3 = ShapeTransforms.rotatedCopyOf(pj2, Math.PI/4.0);

	g2.draw(pj3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Pumpkins and Jack-o-lanterns by Chris Luo", 20,20);
    }
  
    /** Draw a different picture with pumpkins
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Pumpkins by Chris Luo", 20,20);

	
	// Draw some pumpkins.
	
       Pumpkin large = new Pumpkin(100,50,225,150);
       Pumpkin smallCC = new Pumpkin(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
