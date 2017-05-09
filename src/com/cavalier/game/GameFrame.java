package com.cavalier.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.cavalier.controller.Controller;
import com.cavalier.entities.Food;
import com.cavalier.entities.Ground;
import com.cavalier.entities.Snake;
import com.cavalier.util.Global;
import com.cavalier.view.BottonPanel;
import com.cavalier.view.GamePanel;

public class GameFrame extends JFrame {

	/*
	 * ��Ϸ������
	 */
	private static final long serialVersionUID = 1L;
	 
	public static void main(String[] args) {
		new GameFrame(new Controller(new Snake(), new Food(), new Ground(), 
				new GamePanel(), new BottonPanel()));
	
	}
	static Point origin = new Point();
	//������
	private GamePanel gamePanel;
	private Snake snake;
	private Controller controller;	
	private JPanel buttonPanel;
	public GameFrame(Controller c) {	
		this.controller = c;
		snake = controller.getSnake();
		gamePanel = controller.getGamePanel();
		buttonPanel = controller.getBottonPanel();	
		setTitle("�ҵ�̰����");
		this.setUndecorated(true);
		setBounds(300,100,Global.WIDTH*Global.CELL_SIZE+206,Global.HEIGHT*Global.CELL_SIZE+105);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container contentPane = this.getContentPane(); 		
		contentPane.add(gamePanel);
		contentPane.add(buttonPanel);	
		setResizable(false);
		setVisible(true);      
		/* �ô��ھ��� */
		this.setLocation(this.getToolkit().getScreenSize().width / 2
				- this.getWidth() / 2, this.getToolkit().getScreenSize().height
				/ 2 - this.getHeight() / 2);	
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);	
		controller.newGame();
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
      Background(1); 
	}
	public void Background(int i) {
		String path = null;
		if (i==1) {		
		 path = "src/imageIcon/background.jpg"; 
		 } 
		if(i==2){		
		 path = "src/imageIcon/background2.jpg";
		 } 
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
	}
}
