package edu.ucsb.cs56.w14.drawings.zliu01.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A face with cigarette
      
   @author Zhe Liu
   @version for CS56, W14, UCSB
   
*/
public class iPhone extends MobilePhone implements Shape
{
    /**
     * Constructor for objects of class face
     */
    public iPhone(double x, double y, double width, double height)
    {
	// construct the basic face shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
       
        double homeButtonX = x + width / 2;
        double homeButtonY = y + (height) / 20;
        double homeButtonRadius = ((height) * 9) / 200;
        Circle homeButton = new Circle(homeButtonX, homeButtonY,homeButtonRadius);
        double speakerWidth = width / 5;
        double speakerX = x + (width * 2) / 5;
        double speakerHeight = height / 20;
        double speakerY = y + (9 * height) / 10 + height / 40;
        Rectangle2D.Double speaker = new Rectangle.Double(speakerX,speakerY,speakerWidth,speakerHeight);
	// add the cigarette to the face
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholePhone = this.get();
        wholePhone.append(homeButton, false);
	wholePhone.append(speaker, false);
       
    }

}
