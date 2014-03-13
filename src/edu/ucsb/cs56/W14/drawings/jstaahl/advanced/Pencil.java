package edu.ucsb.cs56.w14.drawings.jstaahl.advanced;


import java.awt.Rectangle;
import java.awt.Shape; // general class for shapes
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;

/**
   A vector drawing of a pencil that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, S12, UCSB, 04/23/2012
   
*/
public class Pencil extends GeneralPathWrapper implements Shape
{
    protected static final double CenterPanelScale = 0.4;
    protected static final double RingThicknessScale = 0.05;
    protected static final double EraserHeightScale = 0.9;
    protected static final double RingHeightScale = 1.2;

    private double width;
    private double length;
    /**
       Constructor

       @param x x coord of upper left corner of the rectangle enclosing the entire pencil
       @param y y coord of upper left corner of the rectangle enclosing the entire pencil
       @param width width of the pencil (sales the eraser proportionally)
       @param length length of the pencil (just the length of the wooden part below the metal ring)
     */
    public Pencil(double x, double y, double width, double length)
    {
	this.width = width;
	this.length = length;
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and length.   If you haven't already hard
        // coded a particular drawing, this may be an easier way
        

	// initialize dimensions based on the pencil's width
	double ringThickness = width*Pencil.RingThicknessScale;
	double ringHeight = width*Pencil.RingHeightScale;
	double eraserHeight = width*Pencil.EraserHeightScale;

	// make sure that length is no less than 0
	length = length < 0 ? 0 : length;
        
	// Make the wooden pencil part
	Rectangle2D.Double woodOutline = 
	    new Rectangle2D.Double(x + ringThickness, y + eraserHeight + ringHeight,
				   width - ringThickness*2, length);
	Rectangle2D.Double centerPanel =
	    new Rectangle2D.Double(x + (width - width*Pencil.CenterPanelScale)/2.0, y + eraserHeight + ringHeight,
			      width*Pencil.CenterPanelScale, length);

	// Make the metal ring
	Rectangle2D.Double ringOutline =
	    new Rectangle2D.Double(x, y + eraserHeight,
				   width, ringHeight);

	//!! make the ribs a little thinner and a little farther apart
	Rectangle2D.Double topRib = 
	    new Rectangle2D.Double(x, y + eraserHeight + ringHeight*0.18,
				   width, ringHeight*0.10);
	Rectangle2D.Double bottomRib =
	    new Rectangle2D.Double(x, y + eraserHeight + ringHeight*0.72,
				   width, ringHeight*0.10);

	Line2D.Double crimp1 = 
	    new Line2D.Double(x + width*0.16, y + eraserHeight + ringHeight*0.40,
			      x + width*0.16, y + eraserHeight + ringHeight*0.60);
	Line2D.Double crimp2 = 
	    new Line2D.Double(x + width*0.38, y + eraserHeight + ringHeight*0.40,
			      x + width*0.38, y + eraserHeight + ringHeight*0.60);
	Line2D.Double crimp3 = 
	    new Line2D.Double(x + width*0.62, y + eraserHeight + ringHeight*0.40,
			      x + width*0.62, y + eraserHeight + ringHeight*0.60);
	Line2D.Double crimp4 = 
	    new Line2D.Double(x + width*0.84, y + eraserHeight + ringHeight*0.40,
			      x + width*0.84, y + eraserHeight + ringHeight*0.60);

        // Make the eraser
	Rectangle2D.Double eraser =
	    new Rectangle2D.Double(x + ringThickness, y,
				   width - ringThickness*2, eraserHeight);


        // put the whole pencil together
       
        GeneralPath wholePencil = this.get();
        wholePencil.append(woodOutline, false);
        wholePencil.append(centerPanel, false);
	wholePencil.append(ringOutline, false); 
	wholePencil.append(topRib, false);
	wholePencil.append(bottomRib, false);
	wholePencil.append(crimp1, false);
	wholePencil.append(crimp2, false);
	wholePencil.append(crimp3, false);
	wholePencil.append(crimp4, false);
	wholePencil.append(eraser, false); 
        
    }
    /** Get the height of the eraser in pixels */
    public double getEraserHeight() { return width*Pencil.RingHeightScale + width*Pencil.EraserHeightScale; }

}
