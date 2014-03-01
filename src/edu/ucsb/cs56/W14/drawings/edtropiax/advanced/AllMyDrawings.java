package edu.ucsb.cs56.w14.drawings.edtropiax.advanced;

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
 * @author Marcus Liou
 * @version for CS56, W14, 2/28/2014
 */


public class AllMyDrawings
{
    /** Draw a picture with a few bongos
     */

    public static void drawPicture1(Graphics2D g2) {

	Bongo large = new Bongo(100,50,225,150);
	Bongo smallCC = new Bongo(20,50,40,30);
	Bongo tallSkinny = new Bongo(20,150,20,40);
	Bongo shortFat = new Bongo(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	g2.drawString("Some bongos by Marcus Liou", 20,20);

    }


    /** Draw a marching band
     */
    public static void drawPicture2(Graphics2D g2) {


	Drumset d1 = new Drumset(50,50,50,20);
	Drumset d2 = new Drumset(150,50,50,20);
	Drumset d3 = new Drumset(250,50,50,20);
	Drumset d4 = new Drumset(350,50,50,20);
	Drumset d5 = new Drumset(50,150,50,20);
	Drumset d6 = new Drumset(150,150,50,20);
	Drumset d7 = new Drumset(250,150,50,20);
	Drumset d8 = new Drumset(350,150,50,20);
	Drumset d9 = new Drumset(50,250,50,20);
	Drumset d10 = new Drumset(150,250,50,20);
	Drumset d11 = new Drumset(250,250,50,20);
	Drumset d12 = new Drumset(350,250,50,20);
	Drumset d13 = new Drumset(50,350,50,20);
	Drumset d14 = new Drumset(150,350,50,20);
	Drumset d15 = new Drumset(250,350,50,20);
	Drumset d16 = new Drumset(350,350,50,20);

        g2.setColor(Color.RED);
        g2.draw(d1);  g2.draw(d2);  g2.draw(d3);  g2.draw(d4);  
	g2.draw(d5);  g2.draw(d6);  g2.draw(d7);  g2.draw(d8);  
	g2.draw(d9);  g2.draw(d10);  g2.draw(d11);g2.draw(d12);
	g2.draw(d13);  g2.draw(d14);  g2.draw(d15);  g2.draw(d16);

	g2.drawString("A marching band by Marcus Liou", 20,20);
    }
  
    /** Draw a different picture with a few drums and bongos
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A musical conundrum by Marcus Liou", 20,20);

	
	// Draw some weird drums and bongos
	
       Bongo topLeft = new Bongo(50,50,50,20);
       Drumset botLeft = new Drumset(50,100,50,20);
       Drumset topRight = new Drumset(100,50,50,20);
       Bongo botRight = new Bongo(100,100,50,20);
  
       g2.setColor(Color.RED);     g2.draw(topLeft);
       g2.setColor(Color.GREEN);   g2.draw(botLeft);
       g2.setColor(Color.MAGENTA); g2.draw(topRight);
       g2.setColor(Color.BLUE);    g2.draw(botRight);
       
    }
    

}
