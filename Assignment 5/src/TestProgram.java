/*
 * @author Paul Mould
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

//Runs the program
public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("** Select Line Design to draw");
		System.out.println("1. Predefine pictures");
		System.out.println("2. Random pictures");
		Scanner in = new Scanner(System.in);
		int choices= in.nextInt();
		switch (choices)
		{
		case 1: drawPredefinedDesigns();
		case 2: drawRandomDesigns();
		}
	}
	/*
	 * draws predifined line designs on display
	 */
	private static void drawPredefinedDesigns() {
		
		JFrame frame = new JFrame();

		frame.setSize(900, 700);
		frame.setTitle("PREDEFINE DESIGN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LineDesignComponent component = new LineDesignComponent();
		
		LineDesign  box = new LineDesign(650,450,150,90,Color.BLUE);
		LineDesign	hexagon= new LineDesign(175,175,75,60,Color.GREEN);
		LineDesign	sprialhexagon= new LineDesign(200,425,75,59,Color.PINK);
		LineDesign	sprialPolygon= new LineDesign(475,300,150,88,Color.BLACK);
		LineDesign	CrazyLineDesign= new LineDesign(400,500,100,155,Color.YELLOW);
		LineDesign  box1 = new LineDesign(350,450,150,90,Color.BLUE);
		LineDesign	hexagon1= new LineDesign(375,175,75,60,Color.GREEN);
		LineDesign	sprialhexagon1= new LineDesign(400,425,75,59,Color.PINK);
		LineDesign	sprialPolygon1= new LineDesign(275,300,150,88,Color.BLACK);
		LineDesign	CrazyLineDesign1= new LineDesign(200,500,100,155,Color.YELLOW);
		LineDesign	CrazyLineDesign2= new LineDesign(600,500,100,155,Color.YELLOW);
		
	
		LineDesign [] DesignCollection = {box, hexagon,sprialhexagon,sprialPolygon,CrazyLineDesign
				,box1, hexagon1,sprialhexagon1,sprialPolygon1,CrazyLineDesign1,CrazyLineDesign2};
		
		for(int i = 0;i<DesignCollection.length;i++)
		{
		 component.add(DesignCollection[i]);
		}
		frame.add(component);

		frame.setVisible(true);
	}
	/*
	 * draws random line designs on display
	 */
private static void drawRandomDesigns() {
		
		JFrame frame = new JFrame();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter frame width");
		int frameWidth= in.nextInt();
		System.out.println("Enter frame height");
		int frameHeight= in.nextInt();
		
		
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("RANDOM DESIGN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		System.out.println("Enter the number of LineDesigns to be displayed");
		int Num_Lines= in.nextInt();
		
		System.out.println("Enter the minimum length of the LineDesigns");
		int lengthMin= in.nextInt();
		
		System.out.println("Enter the maximum length of the LineDesigns");
		int lengthMax= in.nextInt();
		
		System.out.println("Enter the mininum angle of the LineDesigns");
		int angleMin= in.nextInt();
		
		System.out.println("Enter the maximum angle of the LineDesigns");
		int angleMax= in.nextInt();
		
		Random randomNumber = new Random();
		
		
		LineDesignComponent component = new LineDesignComponent(10);
		//for(int i = )
		int y = 500;
		int x = 500;
		
		for(int i = 0;i< Num_Lines;i++)
		{
			Random randomNumer =  new Random();
			  Color randomColor = new Color(randomNumer.nextInt(225),randomNumer.nextInt(255),randomNumer.nextInt(155));
			component.add(new LineDesign((int) (frameWidth*Math.random()),(int) (frameHeight*Math.random()),lengthMin+randomNumber.nextInt(lengthMax+1),angleMin+randomNumber.nextInt(angleMax+1),randomColor));
			
					
		}

		frame.add(component);
	

		frame.setVisible(true);
	}
}
