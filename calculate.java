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
	}
	public static void main(String[] args){
		calculate frame = new calculate();
		frame.setTitle("U10316011_GeoCalculate");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(400, 480);
	  frame.setVisible(true);
		frame.setLayout(new GridLayout(4,1));
	}
}
