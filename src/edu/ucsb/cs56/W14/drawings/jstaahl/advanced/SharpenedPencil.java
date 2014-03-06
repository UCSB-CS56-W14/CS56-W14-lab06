package edu.ucsb.cs56.w14.drawings.jstaahl.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;


/**
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class SharpenedPencil extends Pencil implements Shape
{
    protected static final double TipScale = 1.3;
    protected static final double LeadWidthScale = 0.2;
    protected static final double RidgeHeightScale = 0.3;

    /**
     * Constructor for objects of class CoffeeCup
     */
    public SharpenedPencil(double x, double y, double width, double length)
    {
	// construct the unsharpened pencil with the length of the pencil adjusted
	// to allow for the sharpened tip and the ridges above the tip to be drawn
	super(x,y,width,length < (width*SharpenedPencil.TipScale + width*SharpenedPencil.RidgeHeightScale) ? 
	      width*SharpenedPencil.RidgeHeightScale : length - width*SharpenedPencil.TipScale);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// save the Y coord of the bottom of the flat pencil (marked by an asterisk
	// in the diagram below
	double bottomY = y + width*Pencil.EraserHeightScale + width*Pencil.RingHeightScale +
	    (length < (width*SharpenedPencil.TipScale + width*SharpenedPencil.RidgeHeightScale) ? 
	     width*SharpenedPencil.RidgeHeightScale : length - width*SharpenedPencil.TipScale);
	

	// x-coordinate landmarks from left to right for drawing the ridges above the tip:
	// |  |  |  |
	// |/\|/\|/\|   <--
	// *---------
	// \        /
	//  \      /
	//   \    /
	//    \--/
	//     \/
	double leftWoodEdgeX = x + width*Pencil.RingThicknessScale;
	double leftPanelEdgeX = x + (width - width*Pencil.CenterPanelScale)/2.0;
	double rightPanelEdgeX = leftPanelEdgeX + width*Pencil.CenterPanelScale;
	double rightWoodEdgeX = x + width - width*Pencil.RingThicknessScale;

	double tipLength = width*SharpenedPencil.TipScale;
	double leadWidth = width*SharpenedPencil.LeadWidthScale;
	double leadLineY = bottomY + tipLength - leadWidth*(tipLength/(rightWoodEdgeX-leftWoodEdgeX));
	    
	//draw the tip
	Line2D.Double leftTip =
	    new Line2D.Double(leftWoodEdgeX, bottomY,
			      x + width/2.0, bottomY + tipLength);
	Line2D.Double rightTip =
	    new Line2D.Double(x + width/2.0, bottomY + tipLength,
			      rightWoodEdgeX, bottomY);
	Line2D.Double leadLine =
	    new Line2D.Double(x + (width-leadWidth)/2.0, leadLineY,
			      x + (width-leadWidth)/2.0 + leadWidth, leadLineY);

	// draw the ridges above the tip
	double ridgeHeight = width*SharpenedPencil.RidgeHeightScale;
	Line2D.Double leftRidgeLeft =
	    new Line2D.Double(leftWoodEdgeX, bottomY,
			      leftWoodEdgeX + (leftPanelEdgeX-leftWoodEdgeX)/2, bottomY - ridgeHeight);
	Line2D.Double leftRidgeRight =
	    new Line2D.Double(leftWoodEdgeX + (leftPanelEdgeX-leftWoodEdgeX)/2, bottomY - ridgeHeight,
			      leftPanelEdgeX, bottomY);
	Line2D.Double middleRidgeLeft =
	    new Line2D.Double(leftPanelEdgeX, bottomY,
			      leftPanelEdgeX + (rightPanelEdgeX-leftPanelEdgeX)/2, bottomY - ridgeHeight);
	Line2D.Double middleRidgeRight =
	    new Line2D.Double(leftPanelEdgeX + (rightPanelEdgeX-leftPanelEdgeX)/2, bottomY - ridgeHeight,
			      rightPanelEdgeX, bottomY);
	Line2D.Double rightRidgeLeft =
	    new Line2D.Double(rightPanelEdgeX, bottomY,
			      rightPanelEdgeX + (rightWoodEdgeX-rightPanelEdgeX)/2, bottomY - ridgeHeight);
	Line2D.Double rightRidgeRight =
	    new Line2D.Double(rightPanelEdgeX + (rightWoodEdgeX-rightPanelEdgeX)/2, bottomY - ridgeHeight,
			      rightWoodEdgeX, bottomY);
	    
	// add the tip and ridges to the pencil
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholePencil = this.get();
        wholePencil.append(leftTip, false);
        wholePencil.append(rightTip, false);
        wholePencil.append(leadLine, false);
	wholePencil.append(leftRidgeLeft, false);
        wholePencil.append(leftRidgeRight, false);
        wholePencil.append(middleRidgeLeft, false);
	wholePencil.append(middleRidgeRight, false);
        wholePencil.append(rightRidgeLeft, false);
        wholePencil.append(rightRidgeRight, false);
    }

}
