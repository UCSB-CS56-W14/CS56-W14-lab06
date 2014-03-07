package edu.ucsb.cs56.w14.drawings.dalin.advanced;

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
 * @author Dalin Wang
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with some fish 
     */

    public static void drawPicture1(Graphics2D g2) {
    //Draw a normal fish
    Fish fish1 = new Fish(100 , 250 , 100 , 50);
        g2.setColor(Color.black);
        g2.draw(fish1);
        
    //Draw another normal fish that's half the size and moves over 150 in -y direction
    Shape fish2 = ShapeTransforms.scaledCopyOfLL(fish1,0.5,0.5);
        fish2 = ShapeTransforms.translatedCopyOf(fish1,0,-150);
        g2.setColor(Color.BLUE); g2.draw(fish2);
    
    // This fish is 4x as big (2x the original)
    // and moved over 150 pixels to right.
    fish2 = ShapeTransforms.scaledCopyOfLL(fish2,3,3);
    fish2 = ShapeTransforms.translatedCopyOf(fish2,150,100);
        
    // We'll draw this with a thicker stroke
    Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        
    Stroke orig=g2.getStroke();
    g2.setStroke(thick);
    g2.setColor(new Color(0x002FA7));
    g2.draw(fish2);
        
    //Draw a swordfish with a longbill
        
    Swordfish sfish1 = new Swordfish(300 , 250 , 100 , 50);
    Swordfish sfish2 = new Swordfish(300 , 300 , 240 , 120);
    g2.setColor(Color.red);
    g2.draw(sfish1);
        
    g2.setColor(new Color(0x8F00FF));
    g2.draw(sfish2);
    
        
    g2.setStroke(orig);
    g2.setColor(Color.BLACK);
    g2.drawString("Some fish by Dalin Wang", 20,20);
        
    
     
    }
    
    
    


    /** Draw a tank of some fish and swordfish
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some fish.
	
        Fish fish1 = new Fish(100 , 100 , 50 , 25);
        Fish fish2 = new Fish(200 , 250 , 150 , 75);
        Fish fish3 = new Fish(200 , 100 , 100 , 50);
        Fish fish4 = new Fish(300 , 350 , 200 , 100);
        
        
	g2.setColor(Color.RED);     g2.draw(fish1);
	g2.setColor(Color.GREEN);   g2.draw(fish2);
	g2.setColor(Color.BLUE);    g2.draw(fish3);
	g2.setColor(Color.MAGENTA); g2.draw(fish4);
	
	
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
    Swordfish sfish1 = new Swordfish(360 , 100 , 100 , 50);
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(sfish1);
	
	

	// Rotate the fish 180 degrees around its center.
	Shape fish5 = ShapeTransforms.rotatedCopyOf(fish2, Math.PI);
    fish5 = ShapeTransforms.translatedCopyOf(fish5, 200 , 0);
	g2.draw(fish5);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of fish and swordfish by Dalin Wang", 20,20);
    }
  
    /** Draw a a group of 8 fish and swordfish
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
        
        g2.drawString("A group four fish in love by Dalin Wang", 20,20);
    

	
	// Draw some fish.
	
        Fish fish1 = new Fish(200,300,200,100);
       
        g2.setColor(Color.RED);     g2.draw(fish1);
        
        
        Shape fish2 = ShapeTransforms.rotatedCopyOf(fish1, 0.5 * Math.PI);
        
        fish2 = ShapeTransforms.translatedCopyOf(fish2, 125 , -150 );
        
        g2.setColor(Color.BLUE);   g2.draw(fish2);
        
        
        Shape fish3 = ShapeTransforms.rotatedCopyOf(fish1, 1 * Math.PI);
        
        fish3 = ShapeTransforms.translatedCopyOf(fish3 , 250 , 0);
        
        g2.setColor(Color.PINK);   g2.draw(fish3);
        
        
        Shape fish4 = ShapeTransforms.rotatedCopyOf(fish1, 1.5 * Math.PI);
        
        fish4 = ShapeTransforms.translatedCopyOf(fish4, 125 , 150 );
        
        g2.setColor(Color.ORANGE);   g2.draw(fish4);
       
       
    }
    

}
