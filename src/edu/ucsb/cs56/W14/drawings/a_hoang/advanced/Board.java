package edu.ucsb.cs56.w14.drawings.a_hoang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;

/**
   A Board (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Anthony Hoang 
   @version for CS56, W14, UCSB, 02/21/2014
   
*/
public class Board extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class Board
     */
    public Board(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* skateBoard
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 165.0; 
        final double ORIG_HEIGHT = 55.0; 
        final double ORIG_WIDTH = 400.0; 
                
        GeneralPath leftSide = new GeneralPath();
 
        leftSide.moveTo(120,165);
        leftSide.lineTo(100,180);
        leftSide.lineTo(150,220);
        
        GeneralPath topAndBottom = new GeneralPath();
       
        topAndBottom.moveTo(120,165);
       	topAndBottom.lineTo(160,210); // top of board
        topAndBottom.lineTo(440,210);
        topAndBottom.lineTo(480,165);
        
        topAndBottom.moveTo(150,220);
        topAndBottom.lineTo(450,220); // bottom of board

        

       
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 400.0, 0.0);
       
        // now we put the whole thing together ino a single path.
       
        GeneralPath board = new GeneralPath ();
        board.append(topAndBottom, false);
        board.append(leftSide, false);
        board.append(rightSide, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(board, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable skateboard
        
	this.set(new GeneralPath(s));
        
    }

}
