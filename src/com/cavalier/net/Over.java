package com.cavalier.net;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Over extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5699588110763920071L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Over frame = new Over();
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
	public Over() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				if ((Reception.smessage.equals("对方正在游戏中"))&&(Reception.smessage!=null)) {
					contentPane.add(textArea);
					textArea.append(Reception.smessage+"\n");
					Reception.smessage="##wait##";
			}
				if((Reception.smessage.equals("##wait##")==false)&&(Reception.smessage!=null))
				{
					contentPane.add(textArea);
					textArea.append("你的分数为："+Send.smess+"\n");//将分数改为全局
					textArea.append("对方的分数为："+Reception.smessage+"\n");
					Reception.smessage=null;
					Send.smess=null;
					
				}
			}
		});
		textArea.setBounds(0, 0, 434, 215); 
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("再次对战");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ip frame = new Ip();
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBounds(0, 210, 434, 51);
		contentPane.add(btnNewButton);
	}
}
