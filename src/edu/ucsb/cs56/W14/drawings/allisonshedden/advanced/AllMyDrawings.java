package edu.ucsb.cs56.w14.drawings.allisonshedden.advanced;

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
 * @author Allison Shedden 
 * @version for CS56, lab06, Spring 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Cereal Bowls 
     */

    public static void drawPicture1(Graphics2D g2) {

	CerealBowl c1 = new CerealBowl(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black bowl that's half the size, 
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a bowl that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two Cereal bowls with Chex
	
	CerealBowlWithChex cc1 = new CerealBowlWithChex(50,350,40,75);
	CerealBowlWithChex cc2 = new CerealBowlWithChex(200,350,200,100);
	
	g2.draw(cc1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(cc2);
	
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cereal bowls with and without Chex cereal by Allison Shedden", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some cereal bowls with and without Chex
	
	CerealBowlWithChex large = new CerealBowlWithChex(100,50,225,150);
	CerealBowl smallCB =  new CerealBowl(20,50,40,30);
	CerealBowlWithChex tallSkinny = new CerealBowlWithChex(20,150,20,40);
	CerealBowl shortFat = new CerealBowl(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCB);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	CerealBowl c1 = new CerealBowl(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black bowl that's half the size, 
	// and moved over 150 pixels in x direction
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a cereal bowl that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two houses with Windows
	
	CerealBowlWithChex cc1 = new CerealBowlWithChex(50,350,40,75);
	CerealBowlWithChex cc2 = new CerealBowlWithChex(200,350,200,100);
	
	g2.draw(cc1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape cc3 = ShapeTransforms.rotatedCopyOf(cc2, Math.PI/4.0);

	g2.draw(cc3);
	
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cereal bowls with and without Chex cereal by Allison Shedden", 20,20);
    }
  
    /** Draw a different picture with a few cereal bowls
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A couple of cereal bowls by Allison Shedden", 20,20);

	
	// Draw some ceral bowls
	
       CerealBowl large = new CerealBowl(100,50,225,150);
       CerealBowl smallCB = new CerealBowl(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCB);
       
       
    }
    

}
