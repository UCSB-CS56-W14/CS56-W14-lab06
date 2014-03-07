package edu.ucsb.cs56.w14.drawings.jstaahl.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

/**
   A component that draws an animated picture by Jakob Staahl
   
   @author Jakob Staahl
   @version CS56, Spring 2012, UCSB
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape pencil;
    private double eraserHeight;
    private double scribbleSpeed;
    private double amplitude = 3.2;
    private double travelSpeed;
    private double xTravel = 0;
    private double startingPosition;
    private double startingXPos;
    private double xPos;
    private double startingYPos;
    private double width;
    private double startingLength;
    private double t;
    private double angle = 1.75*Math.PI;
    private double travelDistance;


    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param startingXPos the starting x position of the pencil
	@param startingYPos the starting y position of the pencil
	@param travelSpeed the speed at which the pencil will move
	across the screen
	@param travelDistance the number of pixels the pencil will move
	across the screen before stopping
	@param scribbleSpeed the speed at which the pencil oscillates (or
	scribbles) back and forth
	@param startingLength the starting length of the pencil in pixels
	@param width the width of the pencil in pixels
    */
    public AnimatedPictureComponent(double startingXPos, double startingYPos, double travelSpeed, double travelDistance, double scribbleSpeed, double startingLength, double width) {
	this.startingXPos = startingXPos;
	this.startingYPos = startingYPos;
	this.xPos = startingXPos;
	this.travelSpeed = travelSpeed;
	this.travelDistance = travelDistance;
	this.scribbleSpeed = scribbleSpeed;
	this.startingLength = startingLength;
	this.width = width;

	pencil = new SharpenedPencil(this.xPos, this.startingYPos, this.width, this.startingLength);
	eraserHeight = ((Pencil)pencil).getEraserHeight();
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the pencil is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       //g2.draw(new Rectangle(0, 0, 
       if (xPos >= startingXPos + travelDistance) {
	   this.xPos = startingXPos;
	   this.t = 0;
	   this.xTravel = 0;
	   return;
       }
       else
	   g2.setColor(Color.BLACK); g2.draw(pencil);

       t += scribbleSpeed;
       xTravel += travelSpeed;
       xPos = xTravel + startingXPos;
       double wobble = amplitude*(1/scribbleSpeed)*Math.sin(t) + amplitude*0.8*(1/scribbleSpeed)*Math.sin(0.8*t+1.5);
       xPos += wobble;
       double length = (1 - (xTravel/travelDistance))*(startingLength - eraserHeight) + eraserHeight;
       double yPos = startingYPos + (startingLength - length);
       
       pencil = ShapeTransforms.rotatedCopyOf(new SharpenedPencil(xPos, yPos, width, length), 0.015*wobble);
   }    
  
}
