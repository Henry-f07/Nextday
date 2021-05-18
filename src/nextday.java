import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class nextday extends JFrame {

	private JPanel contentPane;
	private JLabel title, year, month, day, nextday;//标题，年，月，日，下一天
	private JTextField textY, textM, textD, textN;//标题，年，月，日，下一天
	private JButton btn_nextday,btn_reinput;//计算下一天，重新输入
	
	public nextday() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//创建组件
		title = new JLabel("请输入年、月、日：");
		year = new JLabel("年");
		month = new JLabel("月");
		day = new JLabel("日");
		nextday = new JLabel("下一天");
		textY = new JTextField(10); 
    	textM = new JTextField(10);
    	textD = new JTextField(10);
    	textN = new JTextField(10); 
    	btn_nextday = new JButton("计算下一天");
    	btn_reinput = new JButton("重新输入");
    	setLayout(null);
    	
    	//添加组件
    	add(title);
    	add(year);
    	add(month);
    	add(day);
    	add(nextday);
    	add(textY);
    	add(textM);
    	add(textD);
    	add(textN);
    	add(btn_nextday);
    	add(btn_reinput);
    	
    	//设置组件位置宽高
    	title.setBounds(130, 50, 200, 30);
    	year.setBounds(130, 90, 80, 20);
    	month.setBounds(130, 130, 80, 20);
    	day.setBounds(130, 170, 80, 20);
    	nextday.setBounds(130, 210, 80, 20);
    	textY.setBounds(200, 90, 160, 20);
    	textM.setBounds(200, 130, 160, 20);
    	textD.setBounds(200, 170, 160, 20);
    	textN.setBounds(200, 210, 160, 20);
    	btn_nextday.setBounds(130, 235, 100, 30);
    	btn_reinput.setBounds(240, 235, 100, 30);
    	
    	//下一天按钮
    	btn_nextday.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    	try{
					int a = Integer.parseInt(textY.getText()); 
					int b = Integer.parseInt(textM.getText()); 
					int c = Integer.parseInt(textD.getText());
					//按月份判断 
					switch(b) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						if(c>31||c<1) {
							textN.setText("不可能");
						}
						else {
							if(c==31)
							{
								if(b==12)
								{
									textN.setText((a+1)+" 年 1  月 1  日");
								}
								else {
									textN.setText(a+" 年 "+(b+1)+" 月 "+"1  日");
								}
							}
							else {
								textN.setText(a+" 年 "+b+" 月 "+(c+1)+" 日");
							}
						}
						break;
						
					case 4:
					case 6:
					case 9:
					case 11:
						if(c>30||c<1) {
							textN.setText("不可能");
						}
						else {
							if(c==30)
							{
								textN.setText(a+" 年 "+(b+1)+" 月 "+"1  日");
							}
							else {
								textN.setText(a+" 年 "+b+" 月 "+(c+1)+" 日");
							}
						}
						break;
					case 2://2月判断是否为闰年
					if(a%4 == 0 && a%100!=0 || a%400 == 0) {
						if(c>29||c<1)
						{
							textN.setText("不可能");
						}
						else {
							if(c==29)
							{
								textN.setText(a+" 年 3 月 "+"1  日");
							}
							else {
								textN.setText(a+" 年 "+b+" 月 "+(c+1)+" 日");
							}
						}
						break;

					}
					else {
						if(c>28||c<1)
						{
							textN.setText("不可能");
						}
						else {
							if(c==28)
							{
								textN.setText(a+" 年 3 月 "+"1  日");
							}
							else {
								textN.setText(a+" 年 "+b+" 月 "+(c+1)+" 日");
							}
						}
						break;
					}
					default:
						textN.setText("不可能");
				}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"输入参数非法！");
				}
				
			}
		});
    	btn_reinput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textY.setText("");
				textM.setText("");
				textD.setText("");
				textN.setText("");
				
			}
		});
				

		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nextday frame = new nextday();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


}
