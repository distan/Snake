package com.cavalier.game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
/*
 * 选择排行榜界面
 */
public class ChoseRank extends JFrame {
	private static final long serialVersionUID = -4971549695039533917L;
	private JPanel contentPane;
	static int mode;
	static Point origin = new Point();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoseRank frame = new ChoseRank();
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
	public ChoseRank() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 220, 300);
		setUndecorated(true);	
		this.addMouseListener(new MouseAdapter() {
            // 按下(mousePressed
            // 不是点击，而是鼠标被按下没有抬起)
            public void mousePressed(MouseEvent e) { 
                // 当鼠标按下的时候获得窗口当前的位置
                origin.x = e.getX(); 
                origin.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            // 拖动（mouseDragged
            // 指的不是鼠标在窗口中移动，而是用鼠标拖动）
            public void mouseDragged(MouseEvent e) {                                                        
                // 当鼠标拖动时获取窗口当前位置
                Point p = getLocation(); 
                // 设置窗口的位置
                // 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
               setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
                        - origin.y);
            }
        });    
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
        String path = null;
		 path = "src/imageIcon/background4.jpg"; 
        ImageIcon background = new ImageIcon(path);  
        // 把背景图片显示在一个标签里面  
        JLabel label = new JLabel(background);  
        // 把标签的大小位置设置为图片刚好填充整个面板  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //设置可见  */	
		JLabel lblNewLabel = new JLabel("选择模式：");
		lblNewLabel.setBounds(20, 20, 156, 15);
		lblNewLabel.setForeground(Color.white);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("黑体",Font.PLAIN, 18));
		JButton btnNewButton = new JButton("普通模式");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mode = 1;
				Ranks frame = new Ranks();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(60, 90, 100, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setFont(new Font("黑体",Font.PLAIN, 14));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.white));
		JButton btnNewButton_1 = new JButton("局域网对战");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mode = 2;
				Ranks frame = new Ranks();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(60, 150, 100, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setFont(new Font("黑体",Font.PLAIN, 14));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.white));
		JButton btnNewButton_2 = new JButton("挑战模式");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mode = 3;
				Ranks frame = new Ranks();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(60, 210, 100, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setFont(new Font("黑体",Font.PLAIN, 14));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.white));	
		ImageIcon buttonIcon = new ImageIcon("src/imageIcon/close1.png");
		JButton btnNewButton_3 = new JButton(buttonIcon);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	 
				dispose();
			}
		});
		btnNewButton_3.setBounds(185, 10, 30, 30);
	    btnNewButton_3.requestFocus(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		contentPane.add(btnNewButton_3);	
	}
}
