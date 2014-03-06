package edu.ucsb.cs56.w14.drawings.keithwaldron.advanced;

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
 * @author Keith Waldron
 * @version for CS56, lab06, Winter 2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few glasses 
     */

    public static void drawPicture1(Graphics2D gd2) {

	Glasses g1 = new Glasses(100,250,50);
	gd2.setColor(Color.CYAN); gd2.draw(g1);
	
	// Make black glasses that's half the size, 
	// and moved over 150 pixels in x direction

	Shape g2 = ShapeTransforms.scaledCopyOfLL(g1,0.5,0.5);
	g2 = ShapeTransforms.translatedCopyOf(g2,150,0);
	gd2.setColor(Color.BLACK); gd2.draw(g2);
	
	// Here's glasses that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	g2 = ShapeTransforms.scaledCopyOfLL(g2,4,4);
	g2 = ShapeTransforms.translatedCopyOf(g2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=gd2.getStroke();
	gd2.setStroke(thick);
	gd2.setColor(new Color(0x002FA7)); 
	gd2.draw(g2); 
	
	// Draw two bifocal glasses
	
	Bifocals sg1 = new Bifocals(50,350,40);
	Bifocals sg2 = new Bifocals(200,350,90);
	
	gd2.draw(sg1);
	gd2.setColor(new Color(0x8F00FF)); gd2.draw(sg2);
	
	
	gd2.setStroke(orig);
	gd2.setColor(Color.BLACK); 
	gd2.drawString("few Glasses by KEITH WALDRON", 20,20);
    }


    /** Draw a picture with a few glasses and bifocals
     */
    public static void drawPicture2(Graphics2D gd2) {

	// Draw some glasses.
	
        Glasses large = new Glasses(100,50,150);
	Glasses smallCC = new Glasses(20,50,40);
	Glasses tallSkinny = new Glasses(20,150,20);
	Glasses shortFat = new Glasses(20,250,300);
	
	gd2.setColor(Color.RED);     gd2.draw(large);
	gd2.setColor(Color.GREEN);   gd2.draw(smallCC);
	gd2.setColor(Color.BLUE);    gd2.draw(tallSkinny);
	gd2.setColor(Color.MAGENTA); gd2.draw(shortFat);
	
	Glasses g1 = new Glasses(100,50,75);
	gd2.setColor(Color.CYAN); gd2.draw(g1);
	
	// Make black glasses that's half the size, 
	// and moved over 150 pixels in x direction
	Shape g2 = ShapeTransforms.scaledCopyOfLL(g1,0.5,0.5);
	g2 = ShapeTransforms.translatedCopyOf(g2,150,0);
	gd2.setColor(Color.BLACK); gd2.draw(g2);
	
	// Here's glasses that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	g2 = ShapeTransforms.scaledCopyOfLL(g2,4,4);
	g2 = ShapeTransforms.translatedCopyOf(g2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=gd2.getStroke();
	gd2.setStroke(thick);
	gd2.setColor(new Color(0x002FA7)); 
	gd2.draw(g2); 
	
	// Draw two bifocal glasses
	
	Bifocals sg1 = new Bifocals(50,350,40);
	Bifocals sg2 = new Bifocals(200,350,20);
	
	gd2.draw(sg1);
	gd2.setColor(new Color(0x8F00FF)); 

	// Rotate the second pair of glasses 45 degrees around its center.
	Shape sg3 = ShapeTransforms.rotatedCopyOf(sg2, Math.PI/4.0);

	gd2.draw(sg3);
	
	gd2.setStroke(orig);
	gd2.setColor(Color.BLACK); 
	gd2.drawString("A bunch of glasses by Keith Waldron", 20,20);
    }
  
    /** Draw a different picture with a few glasses
     */

    public static void drawPicture3(Graphics2D gd2) {
	
	// label the drawing
	
	gd2.drawString("glasses by Keith Waldron", 20,20);
	
       Glasses large = new Glasses(100,50,150);
       Glasses smallCC = new Glasses(20,50,30);
       
       gd2.setColor(Color.RED);     gd2.draw(large);
       gd2.setColor(Color.GREEN);   gd2.draw(smallCC);
       
       
    }
    

}
