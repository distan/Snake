package com.cavalier.game;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import com.cavalier.controller.Controller;
import com.cavalier.entities.Food;
import com.cavalier.entities.Ground;
import com.cavalier.entities.Snake;
import com.cavalier.view.BottonPanel;
import com.cavalier.view.GamePanel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5504713582305623910L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static String userflag = null;
	String user,password;
	boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		String path = null;
		 path = "src/imageIcon/background2.jpg"; 
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
		
		JButton btnNewButton = new JButton("ע���ʺ�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Sign frame = new Sign();
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBorderPainted(false);
	    btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.lightGray);
		btnNewButton.setFont(new Font("����",Font.PLAIN,12));
		btnNewButton.setBounds(300, 83, 90, 23);
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
		
		
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		textField = new JTextField();
		textField.setBounds(154, 80, 143, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setBorder(null);	
		textField_1 = new JPasswordField();
		textField_1.setBounds(154, 123, 143, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(null);	
		JLabel lblNewLabel = new JLabel("�û��� :");
		lblNewLabel.setBounds(82, 83, 54, 15);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("  ���� :");
		lblNewLabel_1.setBounds(82, 126, 54, 15);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		JLabel label1 = new JLabel("");
		label1.setBounds(160, 155, 200, 15);
		contentPane.add(label1);	
		JButton btnNewButton_1 = new JButton("��  ½");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user = textField.getText();
				password = textField_1.getText();
				Search se = new Search();
				boolean flag = se.searchKey(user,password);
				contentPane.requestFocus(true);
				btnNewButton_1.setEnabled(true);
				
				if(flag == true){
					userflag = user;
					new GameFrame(new Controller(new Snake(), new Food(), new Ground(), 
					new GamePanel(), new BottonPanel()));
				dispose();
				}
				else/*���޸�*/{
					

					label1.setText("�û������������");
					label1.setForeground(Color.red);
					contentPane.add(label1);
					label1.setFont(new Font("����", Font.PLAIN, 12));
					

	
				}
			}
		});
		
		btnNewButton_1.setBounds(120, 182, 200, 30);
		btnNewButton_1.setFont(new Font("�� ��", Font.PLAIN, 18));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("��������");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangeKey frame = new ChangeKey();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setBorderPainted(false);
	    button.setContentAreaFilled(false);
		button.setForeground(Color.lightGray);
		button.setFont(new Font("����",Font.PLAIN,12));
		button.setBounds(299, 127, 93, 23);
		contentPane.add(button);
	}
}

