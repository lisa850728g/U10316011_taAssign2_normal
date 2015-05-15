import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class calculate extends JFrame{
	calculate(){
		Circle circle = new Circle();
		
		add(circle.titleCircle());
		add(circle.setRadius());
		add(circle.setCircleArea());
		add(circle.setCirclePerimeter());
		
		circle.jbtReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				circle.jtfRadius.setText("");
				circle.jtfCircleArea.setText("");
				circle.jtfCirclePerimeter.setText("");
			}
		});
		
		circle.jbtCaculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				circle.radius = Integer.parseInt(circle.jtfRadius.getText());
				circle.circleArea = circle.radius * circle.radius * Math.PI;
				circle.circlePerimeter = 2 * circle.radius * Math.PI;
				
				circle.jtfCircleArea.setText(String.format("%.2f" , circle.circleArea));
				circle.jtfCirclePerimeter.setText(String.format("%.2f" , circle.circlePerimeter));
			}
		});
		
		Triangle triangle = new Triangle();
		
		add(triangle.titleTriangle());
		add(triangle.setFirstLength());
		add(triangle.setSecondLength());
		add(triangle.setThirdLength());
		add(triangle.getTriangleArea());
		add(triangle.getTrianglePerimeter());
		
		triangle.jbtReset1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				triangle.jtfFirstLength.setText("");
				triangle.jtfSecondLength.setText("");
				triangle.jtfThirdLength.setText("");
				triangle.jtfTriangleArea.setText("");
				triangle.jtfTrianglePerimeter.setText("");
			}
		});
		
		triangle.jbtCaculate1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				triangle.firstLength = Integer.parseInt(triangle.jtfFirstLength.getText());
				triangle.secondLength = Integer.parseInt(triangle.jtfSecondLength.getText());
				triangle.thirdLength = Integer.parseInt(triangle.jtfThirdLength.getText());
				triangle.trianglePerimeter = triangle.firstLength + triangle.secondLength + triangle.thirdLength;
				triangle.triangleArea = Math.pow(((triangle.trianglePerimeter/2) * (triangle.trianglePerimeter/2 - triangle.firstLength) * 
							(triangle.trianglePerimeter/2 - triangle.secondLength) * (triangle.trianglePerimeter/2 - triangle.thirdLength)) , 0.5);
				
	
				triangle.jtfTriangleArea.setText(String.format("%.2f" , triangle.triangleArea));
				triangle.jtfTrianglePerimeter.setText(String.format("%.2f" , triangle.trianglePerimeter));
			}
		});
		
		Square square = new Square();
		
		add(square.titleSquare());
		add(square.setLength());
		add(square.setWidth());
		add(square.getSquareArea());
		add(square.getSquarePerimeter());
		
		square.jbtReset2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				square.jtfLength.setText("");
				square.jtfWidth.setText("");
				square.jtfSquareArea.setText("");
				square.jtfSquarePerimeter.setText("");
			}
		});
		
		square.jbtCaculate2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				square.length = Integer.parseInt(square.jtfLength.getText());
				square.width = Integer.parseInt(square.jtfWidth.getText());
				square.squareArea = square.length * square.width;
				square.squarePerimeter = ( square.length + square.width ) * 2 ;
				
				square.jtfSquareArea.setText(String.format("%d" , square.squareArea));
				square.jtfSquarePerimeter.setText(String.format("%d" , square.squarePerimeter));
			}
		});
	}
	public static void main(String[] args){
		calculate frame = new calculate();
		frame.setTitle("U10316011_GeoCalculate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 540);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(15,1));
	}
}

class Circle{
	JTextField jtfRadius = new JTextField(10);
	JTextField jtfCircleArea = new JTextField(10);
	JTextField jtfCirclePerimeter = new JTextField(10);
	JButton jbtCaculate = new JButton("Calculate");
	JButton jbtReset = new JButton("Reset");
	
	int radius;
	double circleArea;
	double circlePerimeter;
	
	public Panel titleCircle(){
		Panel titleCircle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleCircle.setSize(100,100);
		titleCircle.add(new JLabel("Circle : "));
		return titleCircle;
	}
	
	public Panel setRadius(){
		Panel setRadius = new Panel(new FlowLayout(FlowLayout.LEADING));
		setRadius.setSize(200,100);
		setRadius.add(new JLabel("Radius : "));
		setRadius.add(jtfRadius);
		setRadius.add(jbtCaculate);
		setRadius.add(jbtReset);
		return setRadius;
	}
	
	public Panel setCircleArea(){
		Panel setCircleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		setCircleArea.setSize(100,100);
		setCircleArea.add(new JLabel("The area is : "));
		setCircleArea.add(jtfCircleArea);
		return setCircleArea;
	}
	
	public Panel setCirclePerimeter(){
		Panel setCirclePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		setCirclePerimeter.setSize(100,100);
		setCirclePerimeter.add(new JLabel("The perimeter is : "));
		setCirclePerimeter.add(jtfCirclePerimeter);
		return setCirclePerimeter;
	}
}

class Triangle{
	JTextField jtfFirstLength = new JTextField(10);
	JTextField jtfSecondLength = new JTextField(10);
	JTextField jtfThirdLength = new JTextField(10);
	JTextField jtfTriangleArea = new JTextField(10);
	JTextField jtfTrianglePerimeter = new JTextField(10);
	JButton jbtCaculate1 = new JButton("Calculate");
	JButton jbtReset1 = new JButton("Reset");
	
	int firstLength;
	int secondLength;
	int thirdLength;
	double triangleArea;
	double trianglePerimeter;
	
	public Panel titleTriangle(){
		Panel titleTriangle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleTriangle.setSize(100,100);
		titleTriangle.add(new JLabel("Triangle : "));
		return titleTriangle;
	}
	
	public Panel setFirstLength(){
		Panel setFirstLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setFirstLength.setSize(200,100);
		setFirstLength.add(new JLabel("First Length : "));
		setFirstLength.add(jtfFirstLength);
		return setFirstLength;
	}
	
	public Panel setSecondLength(){
		Panel setSecondLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setSecondLength.setSize(100,100);
		setSecondLength.add(new JLabel("Second Length : "));
		setSecondLength.add(jtfSecondLength);
		return setSecondLength;
	}
	
	public Panel setThirdLength(){
		Panel setThirdLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setThirdLength.setSize(100,100);
		setThirdLength.add(new JLabel("Third Length : "));
		setThirdLength.add(jtfThirdLength);
		setThirdLength.add(jbtCaculate1);
		setThirdLength.add(jbtReset1);
		return setThirdLength;
	}
	
	public Panel getTriangleArea(){
		Panel getTriangleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getTriangleArea.setSize(100,100);
		getTriangleArea.add(new JLabel("The area is : "));
		getTriangleArea.add(jtfTriangleArea);
		return getTriangleArea;
	}
	
	public Panel getTrianglePerimeter(){
		Panel getTrianglePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getTrianglePerimeter.setSize(100,100);
		getTrianglePerimeter.add(new JLabel("The perimeter is : "));
		getTrianglePerimeter.add(jtfTrianglePerimeter);
		return getTrianglePerimeter;
	}
}

class Square{
	JTextField jtfLength = new JTextField(10);
	JTextField jtfWidth = new JTextField(10);
	JTextField jtfSquareArea = new JTextField(10);
	JTextField jtfSquarePerimeter = new JTextField(10);
	JButton jbtCaculate2 = new JButton("Calculate");
	JButton jbtReset2 = new JButton("Reset");
	
	int length;
	int width;
	int squareArea;
	int squarePerimeter;
	
	public Panel titleSquare(){
		Panel titleSquare = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleSquare.setSize(100,100);
		titleSquare.add(new JLabel("Square : "));
		return titleSquare;
	}
	
	public Panel setLength(){
		Panel setLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setLength.setSize(200,100);
		setLength.add(new JLabel("Length : "));
		setLength.add(jtfLength);
		return setLength;
	}
	
	public Panel setWidth(){
		Panel setWidth = new Panel(new FlowLayout(FlowLayout.LEADING));
		setWidth.setSize(200,100);
		setWidth.add(new JLabel("Width : "));
		setWidth.add(jtfWidth);
		setWidth.add(jbtCaculate2);
		setWidth.add(jbtReset2);
		return setWidth;
	}
	
	public Panel getSquareArea(){
		Panel getSquareArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getSquareArea.setSize(100,100);
		getSquareArea.add(new JLabel("The area is : "));
		getSquareArea.add(jtfSquareArea);
		return getSquareArea;
	}
	
	public Panel getSquarePerimeter(){
		Panel getSquarePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getSquarePerimeter.setSize(100,100);
		getSquarePerimeter.add(new JLabel("The perimeter is : "));
		getSquarePerimeter.add(jtfSquarePerimeter);
		return getSquarePerimeter;
	}
}
