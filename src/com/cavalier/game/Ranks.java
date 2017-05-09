package com.cavalier.game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Ranks extends JFrame {

	/*
	 * 排行榜主界面
	 */
	private static final long serialVersionUID = -4603929300495751419L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranks frame = new Ranks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Ranks() {
		int mode = ChoseRank.mode;
		Search scoreList = new Search();
		scoreList.readScore(mode);
		
		
		
		
		String name1 = scoreList.name[0];
		String name2 = scoreList.name[1];
		String name3 = scoreList.name[2];
		String name4 = scoreList.name[3];
		String name5 = scoreList.name[4];
		String score1 = ""+scoreList.scores[0];
		String score2 = ""+scoreList.scores[1];
		String score3 = ""+scoreList.scores[2];
		String score4 = ""+scoreList.scores[3];
		String score5 = ""+scoreList.scores[4];
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String path = null;
	    path = "src/imageIcon/background5.jpg"; 
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
		contentPane.setLayout(null);

		
		
		JLabel lblNewLabel = new JLabel("排行榜");
		lblNewLabel.setBounds(150, 10, 100, 50);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		
		JLabel label_0 = new JLabel("");
		label_0.setBounds(90, 80, 172, 23);
		contentPane.add(label_0);
		label_0.setForeground(Color.white);
		label_0.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(90, 110, 172, 23);
		contentPane.add(label_1);
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(90, 140, 172, 23);
		contentPane.add(label_2);
		label_2.setForeground(Color.white);
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(90, 170, 172, 23);
		contentPane.add(label_3);
		label_3.setForeground(Color.white);
		label_3.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(90, 200, 172, 23);
		contentPane.add(label_4);
		label_4.setForeground(Color.white);
		label_4.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(275, 80, 69, 23);
		contentPane.add(label_5);
		label_5.setForeground(Color.white);
		label_5.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(275, 110, 69, 23);
		contentPane.add(label_6);
		label_6.setForeground(Color.white);
		label_6.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(275, 140, 69, 23);
		contentPane.add(label_7);
		label_7.setForeground(Color.white);
		label_7.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(275, 170, 69, 23);
		contentPane.add(label_8);
		label_8.setForeground(Color.white);
		label_8.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(275, 200, 69, 23);
		contentPane.add(label_9);
	    label_9.setForeground(Color.white);
		label_9.setFont(new Font("黑体", Font.PLAIN, 18));
		
		label_0.setText(name1);
		
		label_1.setText(name2);

		label_2.setText(name3);
		
		label_3.setText(name4);
		
		label_4.setText(name5);
		
		label_5.setText(score1);
		
		label_6.setText(score2);
	
		label_7.setText(score3);
		
		label_8.setText(score4);

		label_9.setText(score5);

	}
}
