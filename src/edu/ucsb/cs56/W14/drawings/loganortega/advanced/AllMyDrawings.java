package edu.ucsb.cs56.w14.drawings.loganortega.advanced;

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
 * @author Logan Ortega
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few cars and limos - Version01
     */

    public static void drawPicture1(Graphics2D g2) {

	Car c1 = new Car(100,250,90,45);
	g2.setColor(Color.BLACK); g2.draw(c1);
	
	// Make a red car that's half the size, 
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.RED); g2.draw(c2);
	
	// Here's a car that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #EC3B83 is "Cerise Pink" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xEC3B83)); 
	g2.draw(c2); 
	
	// Draw two Limo objects (longer car with more windows)
	
	Limo l1 = new Limo(50,350,90,30);
	Limo l2 = new Limo(100,60,300,100);
	
	g2.draw(l1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(l2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cars by Logan Ortega", 20,20);
    }


    /** Draw a picture with a few cars and limos - Version02
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some cars. 
	
	Car redSports = new Car(100,50,100,25);
	Car blueMini = new Car(20,50,35,35);
	Car magentaSedan = new Car(20,150,50,25);
	Car greenVan = new Car(20,250,60,40);
	
	g2.setColor(Color.RED);     g2.draw(redSports);
	g2.setColor(Color.GREEN);   g2.draw(greenVan);
	g2.setColor(Color.BLUE);    g2.draw(blueMini);
	g2.setColor(Color.MAGENTA); g2.draw(magentaSedan);
	
	Limo l1 = new Limo(50,200,90,30);
	g2.setColor(Color.CYAN); g2.draw(l1);
	
	// Make a red limo that's half the size, 
	// and moved over 180 pixels in x direction and up 100 pixels in y direction
	Shape l2 = ShapeTransforms.scaledCopyOfLL(l1,0.5,0.5);
	l2 = ShapeTransforms.translatedCopyOf(l2,180,-100);
	g2.setColor(Color.RED); g2.draw(l2);
	
	// Here's a limo that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	l2 = ShapeTransforms.scaledCopyOfLL(l2,4,4);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #CC6666 is "Fuzzy Wuzzy" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xCC6666)); 
	g2.draw(l2); 
	
	// Draw two additional cars.
	
	Car c1 = new Car(50,350,20,10);
	Car c2 = new Car(200,350,200,100);
	
	g2.draw(c1);
	g2.setColor(new Color(0xCC6666)); 

	// Rotate the second car 45 degrees around its center and shift up 100 pixels. 
	Shape c3 = ShapeTransforms.translatedCopyOf(c2,0,-100);
	Shape c4 = ShapeTransforms.rotatedCopyOf(c3, Math.PI/4.0);

	g2.draw(c4);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Cars and a few Limos by Logan Ortega", 20,20);
    }
  
    /** Draw a different picture with a few Limos - Version03
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A classic Limo and Hummer Stretch by Logan Ortega",20,20);

	
	// Draw some Limos.
	
       Limo classic = new Limo(50,70,300,100);
       Limo hummerStretch = new Limo(50,230,300,150);

       // We'll draw these with a thicker stroke
       Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
       Stroke orig = g2.getStroke();
       g2.setStroke(thick);
       g2.setColor(Color.BLACK);   g2.draw(classic);
       g2.setColor(Color.WHITE);   g2.draw(hummerStretch);
       
       
    }
    

}
