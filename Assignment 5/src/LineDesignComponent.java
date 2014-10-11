/*
 * @author mould_pa
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * This class is a line design component that puts several LineDesigns to be be displayed on a graphics display
 */
public class LineDesignComponent extends JComponent {
	
	int NUM_ITEMS=10;
	private int valueSize= 0;
	private LineDesign[] myLineDesigns;
	
	LineDesignComponent()
	{	
		NUM_ITEMS=10;
		myLineDesigns = new LineDesign[NUM_ITEMS];
	}
	
	LineDesignComponent(int maxDesigns)
	{	 
		NUM_ITEMS = maxDesigns;
		 myLineDesigns=new LineDesign[NUM_ITEMS];
		 if(NUM_ITEMS < 10)
			 NUM_ITEMS = 10;
	}
	 
	 
	 public boolean add(LineDesign newLineDesign)
	 {
		 if(valueSize==myLineDesigns.length)
		 
			 return false;
		 else 
		
			myLineDesigns[valueSize]=newLineDesign;
				valueSize++;
				return true;

	}
	
	
	
	 public void paintComponent(Graphics g)
	   {
		 Graphics2D g2 = (Graphics2D) g;
			for(int i=0;i<valueSize;i++)
			{
				LineDesign newLineDesign = myLineDesigns[i];
				newLineDesign.draw(g2);
			}
			
	   }
	
}



