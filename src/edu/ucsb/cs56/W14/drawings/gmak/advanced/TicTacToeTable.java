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
   A vector drawing of a TicTacToeTable that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Gary Mak
   @version for CS56, Winter 14, UCSB
   
*/
public class TicTacToeTable extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of table
       @param y y coord of lower left corner of table
       @param side length/height of table
     */
    public TicTacToeTable(double x, double y, double side)
    {
	//rectangle that encompasses the whole table
	Rectangle2D.Double wholeTable = 
	    new Rectangle2D.Double(x,y - side ,side ,side);
	
	//lines that separate the table into 3 columns
	Line2D.Double leftColumn =
	    new Line2D.Double(x + side / 3, y, x + side / 3, y-side);
	Line2D.Double rightColumn =
	    new Line2D.Double(x + 2 * side / 3, y, x + 2 * side / 3, y-side);

	//lines that separate the table into 3 rows
	Line2D.Double topRow =
	    new Line2D.Double(x , y - 2 * side / 3 , x + side , y - 2 * side / 3);
	Line2D.Double bottomRow =
	    new Line2D.Double(x , y - side / 3 , x + side , y - side / 3);


	//appends all lines together to a drawing
        GeneralPath wholeTicTacToeTable = this.get();
        wholeTicTacToeTable.append(wholeTable,false);
	wholeTicTacToeTable.append(leftColumn,false);
	wholeTicTacToeTable.append(rightColumn,false);
	wholeTicTacToeTable.append(topRow,false);
	wholeTicTacToeTable.append(bottomRow,false);
    }

}
