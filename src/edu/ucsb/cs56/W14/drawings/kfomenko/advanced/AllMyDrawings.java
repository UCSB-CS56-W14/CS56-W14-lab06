package edu.ucsb.cs56.w14.drawings.kfomenko.advanced;

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
 * @author Kateryna Fomenko 
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few baskets 
     */

    public static void drawPicture1(Graphics2D g2) {

		Basket b1 = new Basket(100,150,50,75);
		g2.setColor(Color.MAGENTA); g2.draw(b1);
	
		// Make a black basket that's 3/4 the size, 
		// and moved over 50 pixels in x direction

		Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.75,0.5);
		b2 = ShapeTransforms.translatedCopyOf(b2,50,0);
		g2.setColor(Color.BLACK); g2.draw(b2);
	
		// Here's a basket that's 4x as big (2x the original)
		// and moved over 100 pixels to right.
		b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
		b2 = ShapeTransforms.translatedCopyOf(b2,100,0);
	
		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
		// #002FA7 is "International Klein Blue" according to Wikipedia
		// In HTML we use #, but in Java (and C/C++) its 0x
	
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0xFE6F5E)); 
		g2.draw(b2); 
	
		// Draw two baskets with berries
	
		BasketWithBerries bw1 = new BasketWithBerries(50,350,150,55);
		BasketWithBerries bw2 = new BasketWithBerries(400,350,200,75);
	
		g2.draw(bw1);
		g2.setColor(new Color(0x8DB600)); g2.draw(bw2);
	
	
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A few Baskets by Katya Fomenko", 20,20);
    }


    /** Draw some baskets
     */
    public static void drawPicture2(Graphics2D g2) {

		// Draw some coffee cups.
	
		Basket large = new Basket(100,50,225,150);
		Basket smallCC = new Basket(20,50,40,30);
		Basket tallSkinny = new Basket(20,150,20,40);
		Basket shortFat = new Basket(20,250,40,20);
	
		g2.setColor(Color.RED);     g2.draw(large);
		g2.setColor(Color.GREEN);   g2.draw(smallCC);
		g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
		g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
		Basket b1 = new Basket(100,250,50,75);
		g2.setColor(Color.CYAN); g2.draw(b1);
	
		// Make a black basket that's half the size, 
		// and moved over 150 pixels in x direction
		Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
		b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
		g2.setColor(Color.BLACK); g2.draw(b2);
	
		// Here's a basket that's 4x as big (2x the original)
		// and moved over 100 more pixels to right.
		b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
		b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
		// #002FA7 is "International Klein Blue" according to Wikipedia
		// In HTML we use #, but in Java (and C/C++) its 0x
	
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x915C83)); 
		g2.draw(b2); 
	
		// Draw two Baskets with Berries
	
		BasketWithBerries bw1 = new BasketWithBerries(50,350,40,75);
		BasketWithBerries bw2 = new BasketWithBerries(180,350,200,100);
	
		g2.draw(bw1);
		g2.setColor(new Color(0xBFFF00)); 

		// Rotate the second basket 45 degrees around its center & move it 20 px to the right
		Shape bw3 = ShapeTransforms.rotatedCopyOf(bw2, Math.PI/4.0);
		bw3 = ShapeTransforms.translatedCopyOf(bw3,100,0);

		g2.draw(bw3);
	
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("Some baskets by Katya Fomenko", 20,20);
    }
  
    /** Draw some more baskets!
     */

    public static void drawPicture3(Graphics2D g2) {
	

		// label the drawing
	
		g2.drawString("A bunch of Baskets by Katya Fomenko", 20,20);

	
		// Draw some baskets with berries
	
			 Basket b = new Basket(210,50,200,80);
		    Basket b1 = new Basket(10,100,200,80);
			 Basket b2 = new Basket(410,100,200,80);

			 BasketWithBerries bw = new BasketWithBerries(210,300,200,100);
		    BasketWithBerries bw1 = new BasketWithBerries(10,250,200,100);
			 BasketWithBerries bw2 = new BasketWithBerries(410,250,200,100);

		    g2.setColor(Color.CYAN);   g2.draw(b);
			 g2.setColor(Color.MAGENTA); g2.draw(b1);
  			 g2.setColor(Color.GREEN); g2.draw(b2);
    
   	    g2.setColor(Color.MAGENTA); g2.draw(bw);
			 g2.setColor(Color.GREEN); g2.draw(bw1);
  			 g2.setColor(Color.CYAN); g2.draw(bw2);
    }
}
