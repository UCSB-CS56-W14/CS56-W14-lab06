package edu.ucsb.cs56.w14.drawings.gmak.advanced;

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
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a ticTacToeTables
     */

    public static void drawPicture1(Graphics2D g2) {

	TicTacToeTable  h1 = new TicTacToeTable(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black ticTacToeTable that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a ticTacToeTable that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two filledInTicTacToeTable
	
	FilledInTicTacToeTable hw1 = new FilledInTicTacToeTable(50,350,40);
	FilledInTicTacToeTable hw2 = new FilledInTicTacToeTable(200,350,200);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few TicTacToeTables by Gary Mak", 20,20);
    }


    /** Draw a picture with a few TicTacToeTables
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some TicTacToeTables
	
	TicTacToeTable large = new TicTacToeTable(100,50,225);
	TicTacToeTable smallCC = new TicTacToeTable(20,50,40);
	TicTacToeTable tallSkinny = new TicTacToeTable(20,150,20);
	TicTacToeTable shortFat = new TicTacToeTable(20,250,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	FilledInTicTacToeTable h1 = new FilledInTicTacToeTable(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black table that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a table that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw FilledInTicTacToeTables
	
	FilledInTicTacToeTable hw1 = new FilledInTicTacToeTable(50,350,40);
	FilledInTicTacToeTable hw2 = new FilledInTicTacToeTable(200,350,200);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second filledInTable 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of TicTacToeTables by Gary Mak", 20,20);
    }
  
    /** Draw a different picture with a TicTacToeTables and FilledInTicTacToeTables
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of TicTacToeTables by Gary Mak", 20,20);

	
	// Draw some tables.
	
       TicTacToeTable table1 = new TicTacToeTable(200,300,225);
       FilledInTicTacToeTable table2 = new FilledInTicTacToeTable(300,400,40);
       FilledInTicTacToeTable table3 = new FilledInTicTacToeTable(400,300,100);

       g2.setColor(Color.RED);     g2.draw(table1);
       g2.setColor(Color.GREEN);   g2.draw(table2);
       g2.setColor(Color.BLUE);    g2.draw(table3);
       
       
    }
    

}
