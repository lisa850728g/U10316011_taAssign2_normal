import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class calculate extends JFrame{
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
		
		Panel titleTriangle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleTriangle.setSize(100,100);
		titleTriangle.add(new JLabel("Triangle : "));
		
		Panel setFirstLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setFirstLength.setSize(200,100);
		setFirstLength.add(new JLabel("First Length : "));
		setFirstLength.add(jtfFirstLength);
		
		Panel setSecondLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setSecondLength.setSize(100,100);
		setSecondLength.add(new JLabel("Second Length : "));
		setSecondLength.add(jtfSecondLength);
		
		Panel setThirdLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setThirdLength.setSize(100,100);
		setThirdLength.add(new JLabel("Third Length : "));
		setThirdLength.add(jtfThirdLength);
		setThirdLength.add(jbtCaculate1);
		setThirdLength.add(jbtReset1);
		
		Panel getTriangleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getTriangleArea.setSize(100,100);
		getTriangleArea.add(new JLabel("The area is : "));
		getTriangleArea.add(jtfTriangleArea);
		
		Panel getTrianglePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getTrianglePerimeter.setSize(100,100);
		getTrianglePerimeter.add(new JLabel("The perimeter is : "));
		getTrianglePerimeter.add(jtfTrianglePerimeter);
		
		add(titleTriangle);
		add(setFirstLength);
		add(setSecondLength);
		add(setThirdLength);
		add(getTriangleArea);
		add(getTrianglePerimeter);
		
		jbtReset1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtfFirstLength.setText("");
				jtfSecondLength.setText("");
				jtfThirdLength.setText("");
				jtfTriangleArea.setText("");
				jtfTrianglePerimeter.setText("");
			}
		});
		
		jbtCaculate1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				firstLength = Integer.parseInt(jtfFirstLength.getText());
				secondLength = Integer.parseInt(jtfSecondLength.getText());
				thirdLength = Integer.parseInt(jtfThirdLength.getText());
				trianglePerimeter = firstLength + secondLength + thirdLength;
				triangleArea = Math.pow(((trianglePerimeter/2) * (trianglePerimeter/2 - firstLength) * 
							(trianglePerimeter/2 - secondLength) * (trianglePerimeter/2 - thirdLength)) , 0.5);
				
	
				jtfTriangleArea.setText(String.format("%.2f" , triangleArea));
				jtfTrianglePerimeter.setText(String.format("%.2f" , trianglePerimeter));
			}
		});
		
		Panel titleSquare = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleSquare.setSize(100,100);
		titleSquare.add(new JLabel("Square : "));
		
		Panel setLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setLength.setSize(200,100);
		setLength.add(new JLabel("Length : "));
		setLength.add(jtfLength);
		
		Panel setWidth = new Panel(new FlowLayout(FlowLayout.LEADING));
		setWidth.setSize(200,100);
		setWidth.add(new JLabel("Width : "));
		setWidth.add(jtfWidth);
		setWidth.add(jbtCaculate2);
		setWidth.add(jbtReset2);
		
		Panel getSquareArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getSquareArea.setSize(100,100);
		getSquareArea.add(new JLabel("The area is : "));
		getSquareArea.add(jtfSquareArea);
		
		Panel getSquarePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getSquarePerimeter.setSize(100,100);
		getSquarePerimeter.add(new JLabel("The perimeter is : "));
		getSquarePerimeter.add(jtfSquarePerimeter);
		
		add(titleSquare);
		add(setLength);
		add(setWidth);
		add(getSquareArea);
		add(getSquarePerimeter);
		
		jbtReset2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtfLength.setText("");
				jtfWidth.setText("");
				jtfSquareArea.setText("");
				jtfSquarePerimeter.setText("");
			}
		});
		
		jbtCaculate2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				length = Integer.parseInt(jtfLength.getText());
				width = Integer.parseInt(jtfWidth.getText());
				squareArea = length * width;
				squarePerimeter = ( length + width ) * 2 ;
				
				jtfSquareArea.setText(String.format("%d" , squareArea));
				jtfSquarePerimeter.setText(String.format("%d" , squarePerimeter));
			}
		});
	}
	public static void main(String[] args){
		calculate frame = new calculate();
		frame.setTitle("U10316011_GeoCalculate");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 480);
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
