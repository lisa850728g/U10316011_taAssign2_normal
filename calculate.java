import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**此程式將用GUI介面計算三個幾何圖形的面積和周長
 * 分別是:圓形、三角形以及方形(四角皆為直角)
 * 而這三個幾何圖形都寫在不同的類別當中
 * 再從main class 的constructor中呼叫
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
		
		//設定Reset Button的動作
		circle.jbtReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//清除JTextFields中的資料
				circle.jtfRadius.setText("");
				circle.jtfCircleArea.setText("");
				circle.jtfCirclePerimeter.setText("");
			}
		});
		
		//設定Calculate Button的動作
		circle.jbtCaculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//拿使用者輸入的半徑
				circle.radius = Integer.parseInt(circle.jtfRadius.getText());
				//計算圓形的面積
				circle.circleArea = circle.radius * circle.radius * Math.PI;
				//計算圓形的周長
				circle.circlePerimeter = 2 * circle.radius * Math.PI;
				//顯示圓形的面積
				circle.jtfCircleArea.setText(String.format("%.2f" , circle.circleArea));
				//顯示圓形的周長
				circle.jtfCirclePerimeter.setText(String.format("%.2f" , circle.circlePerimeter));
			}
		});
		
		//new an object in Triangle
		Triangle triangle = new Triangle();
		
		//call methods in Triangle and add them into the frame
		add(triangle.titleTriangle());
		add(triangle.setFirstLength());
		add(triangle.setSecondLength());
		add(triangle.setThirdLength());
		add(triangle.getTriangleArea());
		add(triangle.getTrianglePerimeter());
		
		//設定Reset Button的動作
		triangle.jbtReset1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//清除JTextFields中的資料
				triangle.jtfFirstLength.setText("");
				triangle.jtfSecondLength.setText("");
				triangle.jtfThirdLength.setText("");
				triangle.jtfTriangleArea.setText("");
				triangle.jtfTrianglePerimeter.setText("");
			}
		});
		
		//設定Calculate Button的動作
		triangle.jbtCaculate1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//拿使用者輸入的三個邊長
				triangle.firstLength = Integer.parseInt(triangle.jtfFirstLength.getText());
				triangle.secondLength = Integer.parseInt(triangle.jtfSecondLength.getText());
				triangle.thirdLength = Integer.parseInt(triangle.jtfThirdLength.getText());
				//計算三角形的周長
				triangle.trianglePerimeter = triangle.firstLength + triangle.secondLength + triangle.thirdLength;
				//計算三角形的面積
				triangle.triangleArea = Math.pow(((triangle.trianglePerimeter/2) * (triangle.trianglePerimeter/2 - triangle.firstLength) * 
							(triangle.trianglePerimeter/2 - triangle.secondLength) * (triangle.trianglePerimeter/2 - triangle.thirdLength)) , 0.5);
				//顯示出三角形的面積
				triangle.jtfTriangleArea.setText(String.format("%.2f" , triangle.triangleArea));
				//顯示出三角形的周長
				triangle.jtfTrianglePerimeter.setText(String.format("%.2f" , triangle.trianglePerimeter));
			}
		});
		
		//new an object in Square
		Square square = new Square();
		
		//call methods in Square and add them into the frame
		add(square.titleSquare());
		add(square.setLength());
		add(square.setWidth());
		add(square.getSquareArea());
		add(square.getSquarePerimeter());
		
		//設定Reset Button的動作
		square.jbtReset2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//清除JTextFields中的資料
				square.jtfLength.setText("");
				square.jtfWidth.setText("");
				square.jtfSquareArea.setText("");
				square.jtfSquarePerimeter.setText("");
			}
		});
		
		//設定Calculate Button的動作
		square.jbtCaculate2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//拿使用者輸入的長跟寬
				square.length = Integer.parseInt(square.jtfLength.getText());
				square.width = Integer.parseInt(square.jtfWidth.getText());
				//計算方形的面積
				square.squareArea = square.length * square.width;
				//計算方形的周長
				square.squarePerimeter = ( square.length + square.width ) * 2 ;
				//顯示出方形的面積
				square.jtfSquareArea.setText(String.format("%d" , square.squareArea));
				//顯示出方形的周長
				square.jtfSquarePerimeter.setText(String.format("%d" , square.squarePerimeter));
			}
		});
	}
	public static void main(String[] args){
		calculate frame = new calculate();
		frame.setTitle("U10316011_GeoCalculate");//視窗名稱
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 540);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(15,1));//將frame分割成15列1行
	}
}

class Circle{
	//設三個文字欄(半徑.面積.周長)
	JTextField jtfRadius = new JTextField(10);
	JTextField jtfCircleArea = new JTextField(10);
	JTextField jtfCirclePerimeter = new JTextField(10);
	//設兩個按鈕(計算.清除)
	JButton jbtCaculate = new JButton("Calculate");
	JButton jbtReset = new JButton("Reset");
	
	int radius;
	double circleArea;
	double circlePerimeter;
	
	//設一個Panel，寫上Circle，放在frame的左邊
	public Panel titleCircle(){
		Panel titleCircle = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleCircle.setSize(100,100);
		titleCircle.add(new JLabel("Circle : "));
		return titleCircle;
	}
	
	//設一個Panel，放進半徑的文字欄以及兩個按鈕，依照順序填入Panel
	public Panel setRadius(){
		Panel setRadius = new Panel(new FlowLayout(FlowLayout.LEADING));
		setRadius.setSize(200,100);
		setRadius.add(new JLabel("Radius : "));
		setRadius.add(jtfRadius);
		setRadius.add(jbtCaculate);
		setRadius.add(jbtReset);
		return setRadius;
	}
	
	//設一個Panel，放進面積的文字欄
	public Panel setCircleArea(){
		Panel setCircleArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		setCircleArea.setSize(100,100);
		setCircleArea.add(new JLabel("The area is : "));
		setCircleArea.add(jtfCircleArea);
		return setCircleArea;
	}
	
	//設一個Panel，放進周長的文字欄
	public Panel setCirclePerimeter(){
		Panel setCirclePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		setCirclePerimeter.setSize(100,100);
		setCirclePerimeter.add(new JLabel("The perimeter is : "));
		setCirclePerimeter.add(jtfCirclePerimeter);
		return setCirclePerimeter;
	}
}

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

class Square{
	//設四個文字欄(長.寬.面積.周長)
	JTextField jtfLength = new JTextField(10);
	JTextField jtfWidth = new JTextField(10);
	JTextField jtfSquareArea = new JTextField(10);
	JTextField jtfSquarePerimeter = new JTextField(10);
	//設兩個按鈕(計算.清除)
	JButton jbtCaculate2 = new JButton("Calculate");
	JButton jbtReset2 = new JButton("Reset");
	
	int length;
	int width;
	int squareArea;
	int squarePerimeter;
	
	//設一個Panel，寫上Square，放在frame的左邊
	public Panel titleSquare(){
		Panel titleSquare = new Panel(new FlowLayout(FlowLayout.LEFT));
		titleSquare.setSize(100,100);
		titleSquare.add(new JLabel("Square : "));
		return titleSquare;
	}
	
	//設一個Panel，放進長的文字欄
	public Panel setLength(){
		Panel setLength = new Panel(new FlowLayout(FlowLayout.LEADING));
		setLength.setSize(200,100);
		setLength.add(new JLabel("Length : "));
		setLength.add(jtfLength);
		return setLength;
	}
	
	//設一個Panel，放進寬的文字欄，以及兩個按鈕，依照順序填入Panel
	public Panel setWidth(){
		Panel setWidth = new Panel(new FlowLayout(FlowLayout.LEADING));
		setWidth.setSize(200,100);
		setWidth.add(new JLabel("Width : "));
		setWidth.add(jtfWidth);
		setWidth.add(jbtCaculate2);
		setWidth.add(jbtReset2);
		return setWidth;
	}
	
	//設一個Panel，放進面積的文字欄
	public Panel getSquareArea(){
		Panel getSquareArea = new Panel(new FlowLayout(FlowLayout.LEADING));
		getSquareArea.setSize(100,100);
		getSquareArea.add(new JLabel("The area is : "));
		getSquareArea.add(jtfSquareArea);
		return getSquareArea;
	}
	
	//設一個Panel，放進周長的文字欄
	public Panel getSquarePerimeter(){
		Panel getSquarePerimeter = new Panel(new FlowLayout(FlowLayout.LEADING));
		getSquarePerimeter.setSize(100,100);
		getSquarePerimeter.add(new JLabel("The perimeter is : "));
		getSquarePerimeter.add(jtfSquarePerimeter);
		return getSquarePerimeter;
	}
}
