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
	 * 游戏主界面
	 */
	private static final long serialVersionUID = 1L;
	 
	public static void main(String[] args) {
		new GameFrame(new Controller(new Snake(), new Food(), new Ground(), 
				new GamePanel(), new BottonPanel()));
	
	}
	static Point origin = new Point();
	//各对象
	private GamePanel gamePanel;
	private Snake snake;
	private Controller controller;	
	private JPanel buttonPanel;
	public GameFrame(Controller c) {	
		this.controller = c;
		snake = controller.getSnake();
		gamePanel = controller.getGamePanel();
		buttonPanel = controller.getBottonPanel();	
		setTitle("我的贪吃蛇");
		this.setUndecorated(true);
		setBounds(300,100,Global.WIDTH*Global.CELL_SIZE+206,Global.HEIGHT*Global.CELL_SIZE+105);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container contentPane = this.getContentPane(); 		
		contentPane.add(gamePanel);
		contentPane.add(buttonPanel);	
		setResizable(false);
		setVisible(true);      
		/* 让窗口居中 */
		this.setLocation(this.getToolkit().getScreenSize().width / 2
				- this.getWidth() / 2, this.getToolkit().getScreenSize().height
				/ 2 - this.getHeight() / 2);	
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);	
		controller.newGame();
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
	}
}
