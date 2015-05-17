import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**This programming will use GUI 
 * and calculate three geometry figures' areas and perimeters.
 * The figures are Circle, Triangle and Square.
 * They are all in different classes and invoked by main class.
 */
public class calculate extends JFrame{
	//Constructor
	calculate(){
		//new an object in Circle
		Circle circle = new Circle();
		
		//call methods in Circle and add them into the frame
		add(circle.titleCircle());
		add(circle.setRadius());
		add(circle.setCircleArea());
		add(circle.setCirclePerimeter());
		
		//new an object in Triangle
		Triangle triangle = new Triangle();
		
		//call methods in Triangle and add them into the frame
		add(triangle.titleTriangle());
		add(triangle.setFirstLength());
		add(triangle.setSecondLength());
		add(triangle.setThirdLength());
		add(triangle.getTriangleArea());
		add(triangle.getTrianglePerimeter());
		
		//new an object in Square
		Square square = new Square();
		
		//call methods in Square and add them into the frame
		add(square.titleSquare());
		add(square.setLength());
		add(square.setWidth());
		add(square.getSquareArea());
		add(square.getSquarePerimeter());
		
	}
	public static void main(String[] args){
		JFrame frame = new calculate();
		frame.setTitle("U10316011_GeoCalculate");//the frame's name
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 540);
	    frame.setVisible(true);
		frame.setLayout(new GridLayout(15,1));//cut the frame into 15 rows and 1 column
	}
}
