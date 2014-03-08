package edu.ucsb.cs56.w14.drawings.ziping_he.advanced;

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
 * @author Ziping He
 * @version for CS56, lab06, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a few flags
     */

    public static void drawPicture1(Graphics2D g2) {

	Flag f1 = new Flag(100,250,75,50);
	g2.setColor(Color.MAGENTA); g2.draw(f1);
	
	// Make an orange flag that's half the size, 
	// and moved over 150 pixels in x direction

	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(f2);
	
	// Here's a flag that's 4x as big (2x the original)
	// and moved over 200 more pixels to right.
	f2 = ShapeTransforms.scaledCopyOfLL(f2,4,4);
	f2 = ShapeTransforms.translatedCopyOf(f2,200,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(f2); 
	
	// Draw two flags with sticks
	
        FlagWithStick fs1 = new FlagWithStick(50,350,75,35);
        FlagWithStick fs2 = new FlagWithStick(200,350,180,90);
	
	g2.draw(fs1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(fs2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few flags by Ziping He", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some flags.
	
	Flag large = new Flag(100,140,225,112.5);
	Flag small = new Flag(20,50,40,20);
	Flag tallSkinny = new Flag(20,150,20,40);
	Flag shortFat = new Flag(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Flag f1 = new Flag(100,250,60,30);
	g2.setColor(Color.CYAN); g2.draw(f1);
	

	// Make an orange flag that's half the size, 
	// and moved over 150 pixels in x direction

	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(f2);
	
	// Here's a flag that's 4x as big (2x the original)
	// and moved over 200 more pixels to right.
	f2 = ShapeTransforms.scaledCopyOfLL(f2,4,4);
	f2 = ShapeTransforms.translatedCopyOf(f2,200,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(f2); 
	
	// Draw two flags with sticks
	
        FlagWithStick fs1 = new FlagWithStick(50,350,75,35);
        FlagWithStick fs2 = new FlagWithStick(200,350,180,90);
	
	g2.draw(fs1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(fs2);


	// Rotate the second flag 45 degrees around its center.
	Shape fs3 = ShapeTransforms.rotatedCopyOf(fs2, Math.PI/4.0);
	fs3 = ShapeTransforms.translatedCopyOf(fs3,200,35);
	g2.draw(fs3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Flags by Ziping He", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Flags by Ziping He", 20,20);

	
	// Draw some coffee cups.
	
       Flag large = new Flag(100,140,225,112.5);
       Flag small = new Flag(20,50,40,20);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);

       	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFF7E00)); 
       
	FlagWithStick f1 = new FlagWithStick(100,250,80,40);
	g2.draw(f1);

	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,1.5,1.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,200,0);
	g2.setColor(Color.YELLOW); g2.draw(f2);

	Shape f3 = ShapeTransforms.translatedCopyOf(f2,140,100);
	f3 = ShapeTransforms.rotatedCopyOf(f3, 3*Math.PI/4.0);
	g2.setColor(new Color(0x89CFF0)); g2.draw(f3);

	
       
    }
    

}
