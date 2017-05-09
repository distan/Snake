package com.cavalier.game;

import java.awt.Color;

/*Shepherd*/

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
/*
 * �޸�����Ľ���
 */
public class ChangeKey extends JFrame {
	private static final long serialVersionUID = 7550087215877587428L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	String user,newkey,oldkey;
	static Point origin = new Point();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeKey frame = new ChangeKey();
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
	public ChangeKey() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 250, 400);
		setUndecorated(true);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String path = null;
		 path = "src/imageIcon/background3.jpg"; 
       ImageIcon background = new ImageIcon(path);  
       // �ѱ���ͼƬ��ʾ��һ����ǩ����  
       JLabel label = new JLabel(background);  
       // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
       label.setBounds(0, -1, this.getWidth(), this.getHeight());  
       
       // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
       JPanel imagePanel = (JPanel) this.getContentPane();  
       imagePanel.setOpaque(false);  
       // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
       this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
       //���ÿɼ�  */
		
		
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
		
		
		
		
		JLabel lblNewLabel = new JLabel("�û���");
		lblNewLabel.setBounds(55, 70, 54, 15);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBounds(55, 90, 140, 21);
		textField.setOpaque(false);
		textField.setFont(new Font("����", Font.PLAIN, 15));
		textField.setCaretColor(Color.white);
		textField.setForeground(Color.white);
	
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.white));
		
		JLabel lblNewLabel_1 = new JLabel("������");
		lblNewLabel_1.setBounds(55, 120, 54, 15);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 12));
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(55, 140, 140, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setOpaque(false);
		textField_1.setBorder(new LineBorder(Color.white));
		textField_1.setFont(new Font("", Font.PLAIN, 15));
		textField_1.setCaretColor(Color.white);
		textField_1.setForeground(Color.white);
		
		JLabel lblNewLabel_2 = new JLabel("������");
		lblNewLabel_2.setBounds(55, 170, 54, 15);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 12));
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(55, 190, 140, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setOpaque(false);
		textField_2.setBorder(new LineBorder(Color.white));
		textField_2.setFont(new Font("", Font.PLAIN, 15));
		textField_2.setCaretColor(Color.white);
		textField_2.setForeground(Color.white);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(60, 220, 200, 15);
		contentPane.add(label1);
		
		JButton btnNewButton = new JButton("ȷ ��");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean keyflag = false;
				user = textField.getText();
				oldkey = new String(textField_1.getPassword());
				newkey = new String(textField_2.getPassword());
				Search se = new Search();
				keyflag = se.searchKey(user,oldkey);
				if(keyflag){
					Change change = new Change();
					change.Change(user,newkey);
					Login frame = new Login();
					frame.setVisible(true);
					dispose();
				}
				else{
					label1.setText("ԭ�������");
					label1.setForeground(Color.red);
					contentPane.add(label1);
					label1.setFont(new Font("����", Font.PLAIN, 12));
				}
			}
		});
		btnNewButton.setBounds(55, 250, 140, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("����",Font.PLAIN, 14));
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JButton btnNewButton_1 = new JButton("ȡ ��");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(55, 290, 140, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("����",Font.PLAIN, 14));
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
}
