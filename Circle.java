import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Circle{
	//set three text fields
	JTextField jtfRadius = new JTextField(10);
	JTextField jtfCircleArea = new JTextField(10);
	JTextField jtfCirclePerimeter = new JTextField(10);
	//set two buttons
	JButton jbtCaculate = new JButton("Calculate");
	JButton jbtReset = new JButton("Reset");
	
	int radius;
	double circleArea;
	double circlePerimeter;
	
	//set a panel, write down Circle and put at the frame's left side
	public Panel titleCircle(){
		Panel titleCircle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleCircle.setSize(100,100);
		titleCircle.add(new JLabel("Circle : "));
		return titleCircle;
	}
	
	//set a panel, put the text field of the radius
	public Panel setRadius(){
		Panel setRadius = new Panel(new FlowLayout(FlowLayout.LEADING));
		setRadius.setSize(200,100);
		setRadius.add(new JLabel("Radius : "));
		setRadius.add(jtfRadius);
		setRadius.add(jbtCaculate);
		setRadius.add(jbtReset);
		
		//the action of Reset Button
		jbtReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			  //clean the three text fields
				jtfRadius.setText("");
				jtfCircleArea.setText("");
				jtfCirclePerimeter.setText("");
			}
		});
	
		//the action of Calculate Button
		jbtCaculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//take the radius
				radius = Integer.parseInt(jtfRadius.getText());
				//calculate the area
				circleArea = radius * radius * Math.PI;
				//calculate the perimeter
				circlePerimeter = 2 * radius * Math.PI;
			
				//show the area
				jtfCircleArea.setText(String.format("%.2f" , circleArea));
				//show the perimeter
				jtfCirclePerimeter.setText(String.format("%.2f" , circlePerimeter));
			}
		});
		
		return setRadius;
	}
	
	//set a panel, put the text field of the area
	public Panel setCircleArea(){
		Panel setCircleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		setCircleArea.setSize(100,100);
		setCircleArea.add(new JLabel("The area is : "));
		setCircleArea.add(jtfCircleArea);
		return setCircleArea;
	}
	
  //set a panel, put the text field of the perimeter
	public Panel setCirclePerimeter(){
		Panel setCirclePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		setCirclePerimeter.setSize(100,100);
		setCirclePerimeter.add(new JLabel("The perimeter is : "));
		setCirclePerimeter.add(jtfCirclePerimeter);
		return setCirclePerimeter;
	}
}
