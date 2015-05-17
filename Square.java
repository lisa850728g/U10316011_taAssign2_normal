import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
		
		//設定Reset Button的動作
		jbtReset2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//清除JTextFields中的資料
				jtfLength.setText("");
				jtfWidth.setText("");
				jtfSquareArea.setText("");
				jtfSquarePerimeter.setText("");
			}
		});
		
		//設定Calculate Button的動作
		jbtCaculate2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//拿使用者輸入的長
				length = Integer.parseInt(jtfLength.getText());
				//拿使用者輸入的寬
				width = Integer.parseInt(jtfWidth.getText());
				//計算方形的面積
				squareArea = length * width;
				//計算方形的周長
				squarePerimeter = ( length + width ) * 2 ;
			
				//顯示出方形的面積
				jtfSquareArea.setText(String.format("%d" , squareArea));
				//顯示出方形的周長
				jtfSquarePerimeter.setText(String.format("%d" , squarePerimeter));
			}
		});
	
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
