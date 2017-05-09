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
 * ѡ�����а����
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
            // ����(mousePressed
            // ���ǵ����������걻����û��̧��)
            public void mousePressed(MouseEvent e) { 
                // ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
                origin.x = e.getX(); 
                origin.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            // �϶���mouseDragged
            // ָ�Ĳ�������ڴ������ƶ�������������϶���
            public void mouseDragged(MouseEvent e) {                                                        
                // ������϶�ʱ��ȡ���ڵ�ǰλ��
                Point p = getLocation(); 
                // ���ô��ڵ�λ��
                // ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
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
        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
        JLabel label = new JLabel(background);  
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //���ÿɼ�  */	
		JLabel lblNewLabel = new JLabel("ѡ��ģʽ��");
		lblNewLabel.setBounds(20, 20, 156, 15);
		lblNewLabel.setForeground(Color.white);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("����",Font.PLAIN, 18));
		JButton btnNewButton = new JButton("��ͨģʽ");
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
		btnNewButton.setFont(new Font("����",Font.PLAIN, 14));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.white));
		JButton btnNewButton_1 = new JButton("��������ս");
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
		btnNewButton_1.setFont(new Font("����",Font.PLAIN, 14));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.white));
		JButton btnNewButton_2 = new JButton("��սģʽ");
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
		btnNewButton_2.setFont(new Font("����",Font.PLAIN, 14));
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
