import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class calculate extends JFrame{
	JTextField jtfRadius = new JTextField(10);
	JTextField jtfCircleArea = new JTextField(10);
	JTextField jtfCirclePerimeter = new JTextField(10);
	JButton jbtCaculate = new JButton("Calculate");
	JButton jbtReset = new JButton("Reset");
	
	int radius;
	double circleArea;
	double circlePerimeter;
	
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
	
	calculate(){
		Panel titleCircle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleCircle.setSize(100,100);
		titleCircle.add(new JLabel("Circle : "));
		
		Panel setRadius = new Panel(new FlowLayout(FlowLayout.LEADING));
		setRadius.setSize(200,100);
		setRadius.add(new JLabel("Radius : "));
		setRadius.add(jtfRadius);
		setRadius.add(jbtCaculate);
		setRadius.add(jbtReset);
		
		Panel getCircleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getCircleArea.setSize(100,100);
		getCircleArea.add(new JLabel("The area is : "));
		getCircleArea.add(jtfCircleArea);
		
		Panel getCirclePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getCirclePerimeter.setSize(100,100);
		getCirclePerimeter.add(new JLabel("The perimeter is : "));
		getCirclePerimeter.add(jtfCirclePerimeter);
		
		add(titleCircle);
		add(setRadius);
		add(getCircleArea);
		add(getCirclePerimeter);
		
		jbtReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jtfRadius.setText("");
				jtfCircleArea.setText("");
				jtfCirclePerimeter.setText("");
			}
		});
		
		jbtCaculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				radius = Integer.parseInt(jtfRadius.getText());
				circleArea = radius * radius * Math.PI;
				circlePerimeter = 2 * radius * Math.PI;
				
				jtfCircleArea.setText(String.format("%.2f" , circleArea));
				jtfCirclePerimeter.setText(String.format("%.2f" , circlePerimeter));
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
	}
	public static void main(String[] args){
		calculate frame = new calculate();
		frame.setTitle("U10316011_GeoCalculate");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 480);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(10,1));
	}
}
