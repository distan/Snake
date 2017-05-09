package com.cavalier.net;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ip extends JFrame {

	/*
	 * Ip选择
	 */
	private static final long serialVersionUID = -7686609007638830905L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ip frame = new Ip();
					frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ip() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String path = null;
		 path = "src/imageIcon/background5.jpg"; 
      ImageIcon background = new ImageIcon(path);  
      // 把背景图片显示在一个标签里面  
      JLabel label = new JLabel(background);  
      // 把标签的大小位置设置为图片刚好填充整个面板  
      label.setBounds(0, -1, this.getWidth(), this.getHeight());  
      
      // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
      JPanel imagePanel = (JPanel) this.getContentPane();  
      imagePanel.setOpaque(false);  
      // 把背景图片添加到分层窗格的最底层作为背景  
      this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
      //设置可见  */
		contentPane.setLayout(null);
		
		textField = new JTextField();
		//未输入完整信息
		JLabel label1 = new JLabel("");
		label1.setBounds(160, 20, 200, 15);
		contentPane.add(label1);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key2=e.getKeyCode();
				if(key2==KeyEvent.VK_ENTER){
					String ip = textField.getText();//获取JTextField内容
					
					String receive = textField_1.getText();//获取JTextField内容
					
					String send = textField_2.getText();//获取JTextField内容
					
			
				
					Send.b=Integer.parseInt(receive);
					Send.c=Integer.parseInt(send);
					Send.IIp=ip;
					if (ip==null||receive==null||send==null) {
						label1.setText("请输入完整信息");
						label1.setForeground(Color.red);
						contentPane.add(label1);
						label1.setFont(new Font("黑体", Font.PLAIN, 12));
					} 
				else {
						ChatTalk frame = new ChatTalk();
						frame.setVisible(true);
						dispose();
				}
					
					
				}

			}
		});
		textField.setBounds(200, 51, 145, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.white));
		textField.setOpaque(false);
		textField.setFont(new Font("黑体", Font.PLAIN, 15));
		textField.setCaretColor(Color.white);
		textField.setForeground(Color.white);
	
		textField_1 = new JTextField();
		textField_1.setBounds(200, 82, 145, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.white));
		textField_1.setOpaque(false);
		textField_1.setFont(new Font("黑体", Font.PLAIN, 15));
		textField_1.setCaretColor(Color.white);
		textField_1.setForeground(Color.white);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 113, 145, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(Color.white));
		textField_2.setOpaque(false);
		textField_2.setFont(new Font("黑体", Font.PLAIN, 15));
		textField_2.setCaretColor(Color.white);
		textField_2.setForeground(Color.white);

		
		JButton btnNewButton = new JButton("确   认");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String ip = textField.getText();//获取JTextField内容
				String receive = textField_1.getText();//获取JTextField内容
				String send = textField_2.getText();//获取JTextField内容	
				Send.IIp=ip;
				if ((ip.length()==0)|(receive.length()==0)|(send.length()==0)) {
					label1.setText("请输入完整信息");
					label1.setForeground(Color.red);
					contentPane.add(label1);
					label1.setFont(new Font("黑体", Font.PLAIN, 12));
				} 
			
			else {
				Send.b=Integer.parseInt(receive);
				Send.c=Integer.parseInt(send);
					ChatTalk frame = new ChatTalk();
					frame.setVisible(true);
					dispose();
				}			
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(37, 150, 305, 33);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("黑体",Font.PLAIN, 14));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	
		
		JLabel lblip = new JLabel("请输入对战方ip");
		lblip.setBounds(37, 54, 109, 15);
		contentPane.add(lblip);
		lblip.setForeground(Color.white);
		lblip.setFont(new Font("黑体", Font.PLAIN, 15));
		
		lblNewLabel = new JLabel("接收端口");
		lblNewLabel.setBounds(37, 85, 84, 15);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 15));
		
		lblNewLabel_1 = new JLabel("发送端口");
		lblNewLabel_1.setBounds(37, 116, 84, 15);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 15));
		
		lblNewLabel_2 = new JLabel("注意：你的接收端口要和你小伙伴的发送端口相同");
		lblNewLabel_2.setBounds(22, 193,500, 15);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 15));
	
		
	}
	
}
