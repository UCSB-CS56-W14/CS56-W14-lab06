package edu.ucsb.cs56.w14.drawings.benjaminhartl.advanced;

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
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {
	// Save what the original stroke size was
	Stroke orig=g2.getStroke();

	// We'll draw the first 3 thicker
	Stroke thick = new BasicStroke (4.0f, 
					BasicStroke.CAP_BUTT, 
					BasicStroke.JOIN_BEVEL);     
	g2.setStroke(thick);


	// ---------Shirt 1------------

	// First shirt is light blue
	// In the upper left of the
	// Five that will be drawn
	// parameters(xCoordinate, yCoordinate, width, height)

	TShirt ts1 = new TShirt(50,150,100,100);
	g2.setColor(Color.CYAN);                
	g2.draw(ts1);                           
	

	// ---------Shirt 2------------

	// Second shirt will be Black
	// Half the size of the original
	// And Shifted over 200 pixels to the right

	Shape ts2 = ShapeTransforms.scaledCopyOfLL(ts1,0.5,0.5);
	ts2 = ShapeTransforms.translatedCopyOf(ts2,200,0);
	g2.setColor(Color.BLACK); g2.draw(ts2);
	


	// ---------Shirt 3-------------

	// Third shirt will be dark blue represented in hex 0x002FA7
	// It will be twice the size of the original
	// it will be shifted 300 pixels to the right of original

	ts2 = ShapeTransforms.scaledCopyOfLL(ts1,2,2);
	ts2 = ShapeTransforms.translatedCopyOf(ts2,300,0);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(ts2); 
	

	// ---------Shirt 4    &    Shirt 5--------------

	// Change the stroke to the original which is thinner to see
	//      better definition and precision
	g2.setStroke(orig);

	// parameters(xCoordinate, yCoordinate, width, height)
	TShirtWithPocket tsp1 = new TShirtWithPocket(150,275,60,75);
	TShirtWithPocket tsp2 = new TShirtWithPocket(350,300,200,100);
	
	g2.draw(tsp1);
	g2.setColor(new Color(0x8F00FF)); 
	g2.draw(tsp2);
	
	
	// Sign my name in black at the top left (xCord, yCord
	g2.setColor(Color.BLACK); 
	g2.drawString("A few TShirts by Benjamin Hartl", 20,20);
    }


    /** Draw a picture with a TShirts and some with Pockets
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some TShirts
	// ---------Shirts   1,  2,  3,  4-------------

       	// parameters(xCoordinate, yCoordinate, width, height)
	TShirt largeTS = new TShirt(100,50,225,150);         // Red
	TShirt smallTS = new TShirt(20,50,40,30);            // Green
	TShirt tallSkinnyTS = new TShirt(20,150,20,40);      // Blue
	TShirt shortFatTS = new TShirt(20,250,40,20);        // Magenta
	
	g2.setColor(Color.RED);     g2.draw(largeTS);
	g2.setColor(Color.GREEN);   g2.draw(smallTS);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinnyTS);
	g2.setColor(Color.MAGENTA); g2.draw(shortFatTS);
	

	// ---------Shirt 5-------------
	
	// Make original of 3
	// Draw a light blue shirt
	TShirt ts1 = new TShirt(350,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(ts1);
	

	// ---------Shirt 5-------------

	// Make a copy of the original but half the size
	// Make it a black TShirt
	// Move it to the left 50 pixels
	Shape ts2 = ShapeTransforms.scaledCopyOfLL(ts1,0.5,0.5);
	ts2 = ShapeTransforms.translatedCopyOf(ts2,-50,0);
	g2.setColor(Color.BLACK); g2.draw(ts2);


	// ---------Shirt 5-------------
	
	// Here's a TShirt that's four times as big as the original
	// and moved over 50 more pixels to right from the original
	// make it a dark black TShirt

	ts2 = ShapeTransforms.scaledCopyOfLL(ts1,4,4);
	ts2 = ShapeTransforms.translatedCopyOf(ts2,50,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(ts2); 
	
	// Draw two TShirts with Pockets
	// ---------Shirt 6 and Shirt 7-------------

       	// parameters(xCoordinate, yCoordinate, width, height)
	TShirtWithPocket tsp1 = new TShirtWithPocket(50,350,40,75);
	TShirtWithPocket tsp2 = new TShirtWithPocket(150,300,200,100);
	
	g2.draw(tsp1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape tsp3 = ShapeTransforms.rotatedCopyOf(tsp2, Math.PI/4.0);

	g2.draw(tsp3);
	
	// Sign my name in the orignal thickness
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of TShirts and a TShirtsWithPockets by Benjamin Hartl", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of TShirts by Benjamin Hartl", 20,20);

	
	// Draw some more TShirts.
	
	TShirtWithPocket largeTS = new TShirtWithPocket(200,250,225,150);
	g2.setColor(Color.RED);     g2.draw(largeTS);
 
	Shape tsp3 = ShapeTransforms.rotatedCopyOf(largeTS, Math.PI/4.0);
	tsp3 = ShapeTransforms.translatedCopyOf(tsp3,-100,-100);
	tsp3 = ShapeTransforms.scaledCopyOfLL(tsp3,0.5,0.5);
	g2.setColor(Color.BLACK);     g2.draw(tsp3); 

	tsp3 = ShapeTransforms.rotatedCopyOf(tsp3, Math.PI/4.0);
	tsp3 = ShapeTransforms.translatedCopyOf(tsp3,-40,-40);
	tsp3 = ShapeTransforms.scaledCopyOfLL(tsp3,0.5,0.5);
	g2.setColor(Color.BLUE);     g2.draw(tsp3); 

	tsp3 = ShapeTransforms.rotatedCopyOf(tsp3, Math.PI/4.0);
	tsp3 = ShapeTransforms.translatedCopyOf(tsp3,-15,-15);
	tsp3 = ShapeTransforms.scaledCopyOfLL(tsp3,0.5,0.5);
	g2.setColor(Color.ORANGE);     g2.draw(tsp3); 
	

	TShirtWithPocket smallTS = new TShirtWithPocket(20,150,40,30);
	g2.draw(smallTS);
	g2.setColor(Color.BLACK);
	tsp3 = smallTS;
	for(int i = 0; i < 5; i++)
	    {
		tsp3 = ShapeTransforms.translatedCopyOf(tsp3,15*(i+1),10);
		tsp3 = ShapeTransforms.scaledCopyOfLL(tsp3,1.5,1.5);
		if(i%2 == 0)
		    g2.setColor(Color.BLUE);
		else
		    g2.setColor(Color.GREEN);
			
		g2.draw(tsp3);
		
	    }
       
 
       
       
    }
    

}
