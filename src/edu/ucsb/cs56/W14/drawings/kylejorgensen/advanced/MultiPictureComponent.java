package edu.ucsb.cs56.w14.drawings.kylejorgensen.advanced;

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
   A component that draws a Picture by Phill Conrad
   
   @author Phill Conrad (original drawing)
   @version CS56, Spring 2012, UCSB

   
*/


public class MultiPictureComponent extends JComponent
{  
    private int whichPicture = 0;

    public MultiPictureComponent(int whichPicture) {
	this.whichPicture = whichPicture;
    }

    /** The paintComponent method is always required if you want
     * any graphics to appear in your JComponent.    
     * 
     * There is a paintComponent
     * method that is created for you in the JComponent class, but it
     * doesn't do what we want, so we have to "override" that method with
     * our own method.  
     */
    
   public void paintComponent(Graphics g)
   {  

       Graphics2D g2 = (Graphics2D) g;

       // Call a static method for drawing picture 2

       switch (this.whichPicture) {
	   
       case 1:
	   AllMyDrawings.drawPicture1(g2);
	   break;

       case 2:
	   AllMyDrawings.drawPicture2(g2);
	   break;

       case 3:
	   AllMyDrawings.drawPicture3(g2);
	   break;
       default:
	   throw new IllegalArgumentException("Unknown value for whichPicture in MultiPictureComponent" + this.whichPicture);
	   
       } // switch
   } // paintComponent
        
  
}
