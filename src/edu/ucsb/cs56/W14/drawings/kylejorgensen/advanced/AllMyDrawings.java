package edu.ucsb.cs56.w14.drawings.kylejorgensen.advanced;

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
 * @author Kyle Jorgensen, TA
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	SoccerBall s1 = new SoccerBall(125, 250, 100);
	g2.setColor(Color.BLACK);
	g2.draw(s1);
         
       
       // @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
      
       g2.drawString("Soccer Ball created by Alexander Mousavi and Kyle Jorgensen",20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	SoccerBall s1 = new SoccerBall(125, 250, 100);
	g2.setColor(Color.BLUE);
	g2.draw(s1);

	// translate and scale the soccer ball to 1/4 the first soccerball
	Shape h2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);	
	h2 = ShapeTransforms.translatedCopyOf(h2,200,0);
	g2.setColor(Color.ORANGE);
	g2.draw(h2);

	// Make the lines thicker when drawn
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);     
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.GREEN); 

	// translate and rotate the ball
	Shape h3 = ShapeTransforms.rotatedCopyOf(s1,Math.PI/3);
	h3 = ShapeTransforms.translatedCopyOf(h3,350,-125);
	g2.draw(h3);

	// translate, rotate and scale the ball
	Shape h4 = ShapeTransforms.rotatedCopyOf(s1,Math.PI/3);
	h4 = ShapeTransforms.translatedCopyOf(h4,350,-125);
	h4 = ShapeTransforms.scaledCopyOfLL(h4,0.25,0.25);
	Stroke thick2 = new BasicStroke (2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
     	orig=g2.getStroke();
	g2.setStroke(thick2);
	g2.setColor(Color.MAGENTA);
	g2.draw(h4);

	// write labels
	g2.setColor(Color.BLACK);
	g2.drawString("Original", 100, 130);
	g2.drawString("Scaled", 255, 240);
	g2.drawString("Rotated", 450, 20);
	g2.drawString("Translated, rotated, and scaled", 400, 250);  
	

    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad", 20,20);

	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
