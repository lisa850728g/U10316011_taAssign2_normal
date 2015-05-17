import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Triangle{
	//設五個文字欄(三邊長.面積.周長)
	JTextField jtfFirstLength = new JTextField(10);
	JTextField jtfSecondLength = new JTextField(10);
	JTextField jtfThirdLength = new JTextField(10);
	JTextField jtfTriangleArea = new JTextField(10);
	JTextField jtfTrianglePerimeter = new JTextField(10);
	//設兩個按鈕(計算.清除)
	JButton jbtCaculate1 = new JButton("Calculate");
	JButton jbtReset1 = new JButton("Reset");
	
	int firstLength;
	int secondLength;
	int thirdLength;
	double triangleArea;
	double trianglePerimeter;
	
	//設一個Panel，寫上Triangle，放在frame的左邊
	public Panel titleTriangle(){
		Panel titleTriangle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleTriangle.setSize(100,100);
		titleTriangle.add(new JLabel("Triangle : "));
		return titleTriangle;
	}
	
	//設一個Panel，放進第一個邊長的文字欄
	public Panel setFirstLength(){
		Panel setFirstLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setFirstLength.setSize(200,100);
		setFirstLength.add(new JLabel("First Length : "));
		setFirstLength.add(jtfFirstLength);
		return setFirstLength;
	}
	
	//設一個Panel，放進第二個邊長的文字欄
	public Panel setSecondLength(){
		Panel setSecondLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setSecondLength.setSize(100,100);
		setSecondLength.add(new JLabel("Second Length : "));
		setSecondLength.add(jtfSecondLength);
		return setSecondLength;
	}
	
	//設一個Panel，放進第三個邊長的文字欄，以及兩個按鈕，依照順序填入Panel
	public Panel setThirdLength(){
		Panel setThirdLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setThirdLength.setSize(100,100);
		setThirdLength.add(new JLabel("Third Length : "));
		setThirdLength.add(jtfThirdLength);
		setThirdLength.add(jbtCaculate1);
		setThirdLength.add(jbtReset1);
		
		//設定Reset Button的動作
		jbtReset1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//清除JTextFields中的資料
				jtfFirstLength.setText("");
				jtfSecondLength.setText("");
				jtfThirdLength.setText("");
				jtfTriangleArea.setText("");
				jtfTrianglePerimeter.setText("");
			}
		});
		
		//設定Calculate Button的動作
		jbtCaculate1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//拿使用者輸入的三個邊長
				firstLength = Integer.parseInt(jtfFirstLength.getText());
				secondLength = Integer.parseInt(jtfSecondLength.getText());
				thirdLength = Integer.parseInt(jtfThirdLength.getText());
				//計算三角形的周長
				trianglePerimeter = firstLength + secondLength + thirdLength;
				//計算三角形的面積
				triangleArea = Math.pow(((trianglePerimeter/2) * (trianglePerimeter/2 - firstLength) * 
							(trianglePerimeter/2 - secondLength) * (trianglePerimeter/2 - thirdLength)) , 0.5);
				
				//顯示出三角形的面積
				jtfTriangleArea.setText(String.format("%.2f" , triangleArea));
				//顯示出三角形的周長
				jtfTrianglePerimeter.setText(String.format("%.2f" , trianglePerimeter));
			}
		});
	
		return setThirdLength;
	}
	
	//設一個Panel，放進面積的文字欄
	public Panel getTriangleArea(){
		Panel getTriangleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getTriangleArea.setSize(100,100);
		getTriangleArea.add(new JLabel("The area is : "));
		getTriangleArea.add(jtfTriangleArea);
		return getTriangleArea;
	}
	
	//設一個Panel，放進周長的文字欄
	public Panel getTrianglePerimeter(){
		Panel getTrianglePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getTrianglePerimeter.setSize(100,100);
		getTrianglePerimeter.add(new JLabel("The perimeter is : "));
		getTrianglePerimeter.add(jtfTrianglePerimeter);
		return getTrianglePerimeter;
	}
}
