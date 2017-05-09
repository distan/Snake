package com.cavalier.net;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.MouseMotionAdapter;

public class ChatTalk extends JFrame {	
	/*
	 * 聊天窗口
	 */
	private static final long serialVersionUID = -5996133316514798010L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatTalk frame = new ChatTalk();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}


	public ChatTalk() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		TextArea textArea = new TextArea();
		textArea.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if(Reception.smessage.equals("对方正在游戏中")) 
				{
					textArea.append("对方正在游戏中");
					Reception.smessage=null;
				}
				if (Reception.smessage!=null) {
						contentPane.add(textArea);
						textArea.append("收到消息："+Reception.smessage+"\n");
						Reception.smessage=null;
				}
			}
		});
		
		textArea.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if(Reception.smessage.equals("对方正在游戏中")) 
				{
					textArea.append("对方正在游戏中");
					Reception.smessage=null;
				}
				if (Reception.smessage!=null) {
						contentPane.add(textArea);
						textArea.append("收到消息："+Reception.smessage+"\n");
						Reception.smessage=null;
				}
			}
		});
		textArea.setBounds(0, 0, 434, 171);
		contentPane.add(textArea);
		JButton btnNewButton = new JButton("准备");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Over frame = new Over();
				frame.setVisible(true);
				Send.smess="对方正在游戏中";
				Send.main(null);
				dispose();
				
			}
		});
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(Reception.smessage.equals("对方正在游戏中")) 
				{
					textArea.append("对方正在游戏中");
					Reception.smessage=null;
				}
				if (Reception.smessage!=null) {
					contentPane.add(textArea);
					textArea.append("收到消息："+Reception.smessage+"\n");
					Reception.smessage=null;
			}
			}
		});
		btnNewButton.setBounds(253, 222, 92, 39);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("黑体",Font.PLAIN, 18));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(Color.lightGray);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.white));
		
		JTextPane textPane = new JTextPane();
		textPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(Reception.smessage.equals("对方正在游戏中")) 
				{
					textArea.append("对方正在游戏中");
					Reception.smessage=null;
				}
				if (Reception.smessage!=null) {
					contentPane.add(textArea);
					textArea.append("收到消息："+Reception.smessage+"\n");
					Reception.smessage=null;
			}
			}
		});
		textPane.setBounds(0, 169, 253, 92);
		contentPane.add(textPane);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(Reception.smessage.equals("对方正在游戏中")) 
				{
					textArea.append("对方正在游戏中");
					Reception.smessage=null;
				}
				if (Reception.smessage!=null) {
					contentPane.add(textArea);
					textArea.append("收到消息："+Reception.smessage+"\n");
					Reception.smessage=null;
			}
			}
			
		});
		btnNewButton_1.setBounds(342, 222, 92, 39);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("黑体",Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBackground(Color.lightGray);
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.white));
		
		JButton btnNewButton_2 = new JButton("发 送");
		btnNewButton_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(Reception.smessage.equals("对方正在游戏中")) 
				{
					textArea.append("对方正在游戏中");
					Reception.smessage=null;
				}
				if (Reception.smessage!=null) {
					contentPane.add(textArea);
					textArea.append("收到消息："+Reception.smessage+"\n");
					Reception.smessage=null;
			}
				
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String content = textPane.getText();
				Send.smess=content;
				Send.main(null);
				if (Send.smess!=null) {
					contentPane.add(textArea);
					textArea.append("发送消息："+Send.smess+"\n");
					Send.smess=null;
					textPane.setText("");
			}
			}
		});
		btnNewButton_2.setBounds(253, 169, 181, 55);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("黑体",Font.PLAIN, 28));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setBackground(Color.lightGray);
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.white));
		
		}
	}


