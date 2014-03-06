package edu.ucsb.cs56.w14.drawings.jstaahl.advanced;

import java.awt.BasicStroke;
import java.awt.Color; // class for Colors
import java.awt.Graphics2D;
import java.awt.Rectangle;  // squares and rectangles
import java.awt.Shape; // general class for shapes
import java.awt.Stroke;
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Rectangle2D; // for the bounding box

/**
 A class with static methods for drawing various pictures
  
 @author Phill Conrad 
 @version CS56, Spring 2012, UCSB
 
*/


public class AllMyDrawings
{
    /** Draw a picture with a few pencils
     */

    public static void drawPicture1(Graphics2D g2) {
	
	Pencil p1 = new Pencil(25,50,40,300);
	g2.setColor(Color.RED); g2.draw(p1);
	
	SharpenedPencil p2 = new SharpenedPencil(70,50,40,300);
	g2.setColor(Color.BLACK); g2.draw(p2);

	SharpenedPencil p3 = new SharpenedPencil(115,50,40,250);
	g2.setColor(new Color(0x00008B)); g2.draw(p3);

	SharpenedPencil p4 = new SharpenedPencil(160,50,40,200);
	g2.setColor(new Color(0xA52A2A)); g2.draw(p4);

	SharpenedPencil p5 = new SharpenedPencil(365,-65,80,70);
	Stroke regular = g2.getStroke();
	Stroke thick = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
	g2.setColor(new Color(0xA52A2A));
	Shape s1 = ShapeTransforms.rotatedCopyOf(p5,0.6*Math.PI);
	g2.draw(s1);

	g2.setStroke(regular);
	Pencil p6 = new Pencil(250,135,25,250); g2.draw(p6);

	s1 = ShapeTransforms.rotatedCopyOf(p6,1.75*Math.PI);
	s1 = ShapeTransforms.translatedCopyOf(s1,135,-30);
	g2.setColor(new Color(0xFFBF00)); g2.draw(s1);

	Pencil p7 = new Pencil(450,165,25,70);
	s1 = ShapeTransforms.rotatedCopyOf(p7,1.75*Math.PI);
	g2.setColor(new Color(0x008000)); g2.draw(s1);
		
	g2.setColor(Color.BLACK); 
	g2.drawString("A few pencils by Jakob Staahl", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	Pencil p1 = new Pencil(25,50,40,300);
	g2.setColor(Color.RED); g2.draw(p1);
	
	Pencil p2 = new Pencil(70,50,40,250);
	g2.setColor(Color.BLACK); g2.draw(p2);

        Pencil p3 = new Pencil(115,50,40,200);
	g2.setColor(new Color(0x00008B)); g2.draw(p3);

	Pencil p4 = new Pencil(160,50,40,150);
	g2.setColor(new Color(0xA52A2A)); g2.draw(p4);

	SharpenedPencil p5 = new SharpenedPencil(205,50,40,150);
	g2.setColor(Color.RED); g2.draw(p5);
	
	SharpenedPencil p6 = new SharpenedPencil(250,50,40,200);
	g2.setColor(Color.BLACK); g2.draw(p6);

        SharpenedPencil p7 = new SharpenedPencil(295,50,40,250);
	g2.setColor(new Color(0x00008B)); g2.draw(p7);

	SharpenedPencil p8 = new SharpenedPencil(340,50,40,300);
	g2.setColor(new Color(0xA52A2A)); g2.draw(p8);

	Stroke regular = g2.getStroke();
	Stroke thick = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);

	g2.setColor(new Color(0xA52A2A));
	Shape s1 = ShapeTransforms.translatedCopyOf(p5,250,-30);
	s1 = ShapeTransforms.scaledCopyOf(s1,2.0,1);
	s1 = ShapeTransforms.rotatedCopyOf(s1,0.15*Math.PI);
	g2.draw(s1);

	g2.setColor(new Color(0xFF2A2A));
	s1 = ShapeTransforms.translatedCopyOf(s1,0,220);
	s1 = ShapeTransforms.rotatedCopyOf(s1,1.70*Math.PI);
	g2.draw(s1);


	g2.setStroke(regular);		
	g2.setColor(Color.BLACK); 
	g2.drawString("A few pencils by Jakob Staahl", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Pencils by Jakob Staahl", 20,20);
	
	SharpenedPencil p5 = new SharpenedPencil(205,50,40,150);

	g2.setColor(new Color(0xA52A2A));
	Shape s1 = ShapeTransforms.translatedCopyOf(p5,250,-30);
	s1 = ShapeTransforms.scaledCopyOf(s1,2.0,1);
	s1 = ShapeTransforms.rotatedCopyOf(s1,0.15*Math.PI);
	g2.draw(s1);

	g2.setColor(new Color(0xFF2A2A));
	s1 = ShapeTransforms.translatedCopyOf(s1,0,220);
	s1 = ShapeTransforms.rotatedCopyOf(s1,1.70*Math.PI);
	g2.draw(s1);

	g2.setColor(new Color(0xA50AFF));
	s1 = ShapeTransforms.translatedCopyOf(p5,150,-30);
	s1 = ShapeTransforms.scaledCopyOf(s1,2.0,1);
	s1 = ShapeTransforms.rotatedCopyOf(s1,0.15*Math.PI);
	g2.draw(s1);

	g2.setColor(new Color(0xFFFF2A));
	s1 = ShapeTransforms.translatedCopyOf(s1,0,220);
	s1 = ShapeTransforms.rotatedCopyOf(s1,1.70*Math.PI);
	g2.draw(s1);

	g2.setColor(Color.BLACK);
	g2.draw(p5);

	Pencil p1 = new Pencil(30, 30, 50, 300);
	g2.setColor(new Color(0xFF00FF));
	g2.draw(p1);
       
    }
    

}
