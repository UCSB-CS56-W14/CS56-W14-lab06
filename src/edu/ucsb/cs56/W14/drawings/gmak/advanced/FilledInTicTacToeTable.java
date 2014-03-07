package edu.ucsb.cs56.w14.drawings.gmak.advanced;
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

import edu.ucsb.cs56.w14.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w14.drawings.utilities.GeneralPathWrapper;
/**
   A TicTacToeTable filled with X's and O's
      
   @author Gary Mak
   @version for CS56, W14, UCSB, 02/20/2014
   
*/
public class FilledInTicTacToeTable extends TicTacToeTable implements Shape
{
    /**
     * Constructor for objects of class FilledInTicTacToeTable
     */
    public FilledInTicTacToeTable(double x, double y, double side)
    {
	// construct the basic TicTacToeTable
	super(x,y,side);


	GeneralPath wholeTable = this.get();

	//Filling in with X's and O's
	// O's are a circle while X's are 2 separate lines

	Circle bottomLeft =
	    new Circle(x + side / 6, y - side / 6, side / 6);
	Circle bottomRight = 
	    new Circle(x + 5 * side / 6, y - side / 6, side / 6);
	Circle middleMiddle =
	    new Circle(x + 3 * side / 6, y - 3 * side / 6, side / 6);
	Circle middleRight = 
	    new Circle(x + 5 * side / 6, y - 3 * side / 6 , side / 6);
	Circle topMiddle = 
	    new Circle(x + 3 * side / 6, y - 5 * side / 6, side / 6);

	Line2D.Double bottomMiddleLeftToRight =
	    new Line2D.Double(x + 2 * side / 6, y - 2 * side / 6, x + 4 * side / 6, y);
	Line2D.Double bottomMiddleRightToLeft =
	    new Line2D.Double(x + 4 * side / 6, y - 2 * side / 6, x + 2 * side / 6, y);

	Line2D.Double topLeftLeftToRight =
	    new Line2D.Double(x , y - side, x + 2 * side / 6 , y - 4 * side / 6);
	Line2D.Double topLeftRightToLeft =
	    new Line2D.Double(x + 2 * side / 6, y - side, x , y - 4 * side / 6);

	Line2D.Double topRightLeftToRight =
	    new Line2D.Double(x + 4 * side / 6, y - side, x + side, y - 4 * side / 6);
	Line2D.Double topRightRightToLeft =
	    new Line2D.Double(x + side, y - side, x + 4 * side / 6, y - 4 * side / 6);

	Line2D.Double middleLeftLeftToRight =
	    new Line2D.Double(x, y - 4 * side / 6, x + 2 * side / 6, y - 2 * side / 6);
	Line2D.Double middleLeftRightToLeft =
	    new Line2D.Double(x + 2 * side / 6, y - 4 * side / 6, x, y - 2 * side / 6);


	//circle's
	wholeTable.append(bottomLeft,false);
	wholeTable.append(bottomRight,false);
	wholeTable.append(middleMiddle,false);
	wholeTable.append(middleRight,false);
	wholeTable.append(topMiddle,false);
	
	//X's
	wholeTable.append(bottomMiddleLeftToRight,false);
        wholeTable.append(bottomMiddleRightToLeft,false);

	wholeTable.append(topLeftLeftToRight,false);
	wholeTable.append(topLeftRightToLeft,false);

	wholeTable.append(topRightLeftToRight,false);
	wholeTable.append(topRightRightToLeft,false);

	wholeTable.append(middleLeftLeftToRight,false);
	wholeTable.append(middleLeftRightToLeft,false);


    }

}
