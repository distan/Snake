package com.cavalier.game;

/*Shepherd*/

import java.awt.Color;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Sign extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4868535842017956748L;
	private JPanel contentPane;
	private JTextField yonghu;
	private JPasswordField mima;
	private JPasswordField again;
	String newuser,newkey,newagain;
	static Point origin = new Point();
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign frame = new Sign();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sign() {
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
		
		yonghu = new JTextField();
		yonghu.setBounds(55, 90, 140, 21);
		yonghu.setOpaque(false);
		yonghu.setFont(new Font("����", Font.PLAIN, 15));
		yonghu.setCaretColor(Color.white);
		yonghu.setForeground(Color.white);
	
		contentPane.add(yonghu);
		yonghu.setColumns(10);
		yonghu.setBorder(new LineBorder(Color.white));
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(55, 120, 54, 15);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 12));
		
		mima = new JPasswordField();
		mima.setBounds(55, 140, 140, 21);
		contentPane.add(mima);
		mima.setColumns(10);
		mima.setOpaque(false);
		mima.setBorder(new LineBorder(Color.white));
		mima.setFont(new Font("", Font.PLAIN, 15));
		mima.setCaretColor(Color.white);
		mima.setForeground(Color.white);
		
		JLabel lblNewLabel_2 = new JLabel("ȷ������");
		lblNewLabel_2.setBounds(55, 170, 54, 15);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 12));
		
		again = new JPasswordField();
		again.setBounds(55, 190, 140, 21);
		contentPane.add(again);
		again.setColumns(10);
		again.setOpaque(false);
		again.setBorder(new LineBorder(Color.white));
		again.setFont(new Font("", Font.PLAIN, 15));
		again.setCaretColor(Color.white);
		again.setForeground(Color.white);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(60, 220, 200, 15);
		contentPane.add(label1);
		
		JButton btnNewButton_3 = new JButton("ע ��");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newuser = yonghu.getText();
				newkey = new String(mima.getPassword());
				newagain =new String(again.getPassword());
				if(newkey.equals(newagain)){
				Search se = new Search();
				boolean flag = se.searchName(newuser);
				if(flag==false){
					Signup signup = new Signup();
					signup.Signup(newuser, newkey);
					Login frame = new Login();
					frame.setVisible(true);
					dispose();
				}
				else{

						label1.setText("�û����Ѵ���");
						label1.setForeground(Color.red);
						label1.setFont(new Font("����", Font.PLAIN, 12));

					}
			}
				else 
				{
					label1.setText("���벻һ��");
					label1.setForeground(Color.red);
					label1.setFont(new Font("����", Font.PLAIN, 12));
					
				}
					
			}
		});
		btnNewButton_3.setBounds(55,250, 140, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setFont(new Font("����",Font.PLAIN, 14));
		btnNewButton_3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton btnNewButton = new JButton("�� ��");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(55, 290, 140, 23);
		btnNewButton.setFont(new Font("����",Font.PLAIN, 14));
		contentPane.add(btnNewButton);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}

	

}
