package edu.ucsb.cs56.w14.drawings.jennyvien.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D; // single lines
import java.awt.geom.Ellipse2D; // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle; // squares and rectangles
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
* @author Jenny Vien
* @version for CS56, lab06, Winter 2014
*/


public class AllMyDrawings {
    /** 
     *	Draw a picture with a few melons.
     */

    public static void drawPicture1(Graphics2D g2) {

	Melon m1 = new Melon(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(m1);

	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);

	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7));
	g2.draw(m2);

	MelonWithSeeds ms1 = new MelonWithSeeds(50,350,40,75);
	MelonWithSeeds ms2 = new MelonWithSeeds(200,350,200,100);

	g2.draw(ms1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(ms2);

	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("A few melons by Jenny Vien", 20,20);
    }

    /** 
     * Draw another picture with a few melons.
     */
    public static void drawPicture2(Graphics2D g2) {

	Melon large = new Melon(100,50,225,150);
	Melon smallMelon = new Melon(20,50,40,30);
	Melon tallSkinny = new Melon(20,150,20,40);
	Melon shortFat = new Melon(20,250,40,20);

	g2.setColor(Color.RED); g2.draw(large);
	g2.setColor(Color.GREEN); g2.draw(smallMelon);
	g2.setColor(Color.BLUE); g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);

	Melon m1 = new Melon(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(m1);

	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);

	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7));
	g2.draw(m2);

	MelonWithSeeds ms1 = new MelonWithSeeds(50,350,40,75);
	MelonWithSeeds ms2 = new MelonWithSeeds(200,350,200,100);

	g2.draw(ms1);
	g2.setColor(new Color(0x8F00FF));

	Shape ms3 = ShapeTransforms.rotatedCopyOf(ms2, Math.PI/4.0);

	g2.draw(ms3);

	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("A bunch of melons by Jenny Vien", 20,20);
    }
  
    /** 
     * Draw a different picture with a few melons.
     */

    public static void drawPicture3(Graphics2D g2) {

	g2.drawString("A few Melons by Jenny Vien", 20,20);

	Melon large = new Melon(100,50,225,150);
	Melon smallMelon = new Melon(20,50,40,30);
	Shape rotatedMelon = ShapeTransforms.rotatedCopyOf(large, Math.PI/2.0);
	rotatedMelon = ShapeTransforms.translatedCopyOf(rotatedMelon, 300,0.0 );
	g2.setColor(Color.RED); g2.draw(large);
	g2.setColor(Color.GREEN); g2.draw(smallMelon);
	g2.setColor(Color.BLUE); g2.draw(rotatedMelon);
       
       
    }
    

}
