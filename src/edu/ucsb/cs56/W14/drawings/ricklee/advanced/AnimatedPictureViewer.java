package edu.ucsb.cs56.w14.drawings.ricklee.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   A viewer class that animated a stickman moving around

   @author Rick Lee
   @version for UCSB CS56, W14, 03/06/2014
*/

public class AnimatedPictureViewer{

    private DrawPanel panel = new DrawPanel();

    private StickmanWithHat stickman = new StickmanWithHat(200,380,100);//x,y,height

    Thread anim;

    private final int windowWidth = 640;
    private final int windowHeight = 480;

    private int x = 200;
    private int y = 380;
    
    private int dx = 5;
    private int dy = 0;

    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
	frame.getContentPane().add(panel);
	frame.setSize(windowWidth,windowHeight);
	frame.setVisible(true);
	
	frame.getContentPane().addMouseListener(new MyMouseListener());
    }//go

    class MyMouseListener implements MouseListener{
	public void mouseEntered(MouseEvent e){
	    System.out.println("Mouse entered");
	    anim = new Animation();
	    anim.start();
	}
	public void mouseExited(MouseEvent e){
	    System.out.println("Mouse exited");
	    //Kill the animation thread
	    anim.interrupt();
	    while(anim.isAlive()){}
	    anim = null;
	    panel.repaint();
	}
	public void mousePressed(MouseEvent e){/*required by MouseListener*/}
	public void mouseReleased(MouseEvent e){/*required by MouseListener*/}
	public void mouseClicked(MouseEvent e){/*required by MouseListener*/}

    }

    class DrawPanel extends JPanel{
	public void paintComponent(Graphics g){

	    Graphics2D g2 = (Graphics2D) g;

	    //Clear panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(),this.getHeight());

	    //Draws the stickman with hat
	    g2.setColor(Color.black);
	    stickman = new StickmanWithHat(x,y,75);
	    g2.draw(stickman);	    

	}
    }//class DrawPanel

    class Animation extends Thread{
	public void run(){
	    try{
		while(true){
		    //Move
		    if(x > windowWidth-100){
			x = windowWidth-100;
			dx = 0;
			dy = -5;
		    }
		    else if(y > windowHeight-100){
			y = windowHeight-100;
			dx = 5;
			dy = 0;
		    }
		    else if(x < 0+100){
			x = 100;
			dx = 0;
			dy = 5;
		    }
		    else if(y < 0+100){
			y = 100;
			dx = -5;
			dy = 0;
		    }

		    //update coordinates
		    x += dx;
		    y += dy;
		    
		    panel.repaint();
		    Thread.sleep(50);
		}//while
	    }catch(Exception ex){
		if(ex instanceof InterruptedException){
		    //Do nothing - expected on mouseExited
		}else{
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }//try-catch

	}//run()
    }//class Animation

}
