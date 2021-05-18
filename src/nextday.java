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
	private JLabel title, year, month, day, nextday;//���⣬�꣬�£��գ���һ��
	private JTextField textY, textM, textD, textN;//���⣬�꣬�£��գ���һ��
	private JButton btn_nextday,btn_reinput;//������һ�죬��������
	
	public nextday() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//�������
		title = new JLabel("�������ꡢ�¡��գ�");
		year = new JLabel("��");
		month = new JLabel("��");
		day = new JLabel("��");
		nextday = new JLabel("��һ��");
		textY = new JTextField(10); 
    	textM = new JTextField(10);
    	textD = new JTextField(10);
    	textN = new JTextField(10); 
    	btn_nextday = new JButton("������һ��");
    	btn_reinput = new JButton("��������");
    	setLayout(null);
    	
    	//������
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
    	
    	//�������λ�ÿ��
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
    	
    	//��һ�찴ť
    	btn_nextday.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    	try{
					int a = Integer.parseInt(textY.getText()); 
					int b = Integer.parseInt(textM.getText()); 
					int c = Integer.parseInt(textD.getText());
					//���·��ж� 
					switch(b) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						if(c>31||c<1) {
							textN.setText("������");
						}
						else {
							if(c==31)
							{
								if(b==12)
								{
									textN.setText((a+1)+" �� 1  �� 1  ��");
								}
								else {
									textN.setText(a+" �� "+(b+1)+" �� "+"1  ��");
								}
							}
							else {
								textN.setText(a+" �� "+b+" �� "+(c+1)+" ��");
							}
						}
						break;
						
					case 4:
					case 6:
					case 9:
					case 11:
						if(c>30||c<1) {
							textN.setText("������");
						}
						else {
							if(c==30)
							{
								textN.setText(a+" �� "+(b+1)+" �� "+"1  ��");
							}
							else {
								textN.setText(a+" �� "+b+" �� "+(c+1)+" ��");
							}
						}
						break;
					case 2://2���ж��Ƿ�Ϊ����
					if(a%4 == 0 && a%100!=0 || a%400 == 0) {
						if(c>29||c<1)
						{
							textN.setText("������");
						}
						else {
							if(c==29)
							{
								textN.setText(a+" �� 3 �� "+"1  ��");
							}
							else {
								textN.setText(a+" �� "+b+" �� "+(c+1)+" ��");
							}
						}
						break;

					}
					else {
						if(c>28||c<1)
						{
							textN.setText("������");
						}
						else {
							if(c==28)
							{
								textN.setText(a+" �� 3 �� "+"1  ��");
							}
							else {
								textN.setText(a+" �� "+b+" �� "+(c+1)+" ��");
							}
						}
						break;
					}
					default:
						textN.setText("������");
				}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"��������Ƿ���");
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
