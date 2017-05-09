package com.cavalier.controller;

//控制器负责处理各组件的变化
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JColorChooser;
import com.cavalier.entities.Food;
import com.cavalier.entities.Ground;
import com.cavalier.entities.Snake;
import com.cavalier.game.ChoseRank;
import com.cavalier.game.Helps;
import com.cavalier.game.Search;
import com.cavalier.listener.SnakeListener;
import com.cavalier.net.Ip;
import com.cavalier.view.BottonPanel;
import com.cavalier.view.GamePanel;



public class Controller extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	private BottonPanel bottonPanel;
	private int i=0;
	public int puase=0;
	public static int map2=0;
	public static int direction=0;
	public static int mode=0;
	public Controller(Snake snake, Food food, Ground ground,GamePanel gamePanel,BottonPanel bottonPanel) {
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
		this.bottonPanel = bottonPanel;
		init();
	}

	
	//控制器的初始化，主要初始化对控件的监听
	public void init() {
		bottonPanel.getStartButton().addActionListener(new startHandler());
		bottonPanel.getPauseButton().addActionListener(new pauseHandler());
		bottonPanel.getEndButton().addActionListener(new endHandler());
		bottonPanel.getMapItem0Button().addActionListener(new mapItem0Handler());
		bottonPanel.getMapItem1Button().addActionListener(new mapItem1Handler());
		bottonPanel.getMapItem2Button().addActionListener(new mapItem2Handler());
	    bottonPanel.getMapItem3Button().addActionListener(new mapItem3Handler());  
	    bottonPanel.getGetItem1().addActionListener(new Item1Handler());
		bottonPanel.getGetItem4().addActionListener(new Item4Handler());
		bottonPanel.getEndButton0().addActionListener(new end());
		bottonPanel.getRankButton().addActionListener(new Rank());
		bottonPanel.getHelpButton().addActionListener(new Help());
		bottonPanel.getStartButton().setEnabled(true);	
	}

	//获取各对象
	public Snake getSnake() {
		return snake;
	}
	
	public Ground getGround() {
		return ground;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	
	public BottonPanel getBottonPanel() {
		return bottonPanel;
	}
	
	
	//键盘按键的监听
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:			
				snake.changeDirection(Snake.UP);
				direction=1;
				break;
			case KeyEvent.VK_S:				
				snake.changeDirection(Snake.DOWN);
				direction=2;
				break;
			case KeyEvent.VK_A:
				snake.changeDirection(Snake.LEFT);
				direction=3;
				break;
			case KeyEvent.VK_D:
				snake.changeDirection(Snake.RIGHT);
				direction=4;
				break;
			case KeyEvent.VK_UP:
				snake.speedUp();
				break;
			case KeyEvent.VK_DOWN:
				snake.speedDown();
				break;
			case KeyEvent.VK_SPACE:
				snake.changePause();
			default:
				break;
		}
	}

	
	//实现蛇移动的接口，处理蛇移动过程发生的各种事情
	@Override
	public void snakeMoved(Snake snake) {
		//每移动一次，就更新一次面板
		gamePanel.display(snake, food, ground);			
		bottonPanel.repaint();
		if(food.isFoodEated(snake)) {
			snake.eatFood();
			food.newFood(ground.getPoint());
			//更新得分显示面板	
			bottonPanel.repaint();
			setScore();		
		}
		if(ground.isGroundEated(snake)) {
			if(Snake.lifenum==0){
			snake.die();
			i=0;
		    }
			else{
				Snake.lifenum--;
			
			}
			bottonPanel.getStartButton().setEnabled(true);
		}
		
		if(snake.isEatBody()) {
			if(Snake.lifenum==0){
			snake.die();
			i=0;
			}
			else{
				Snake.lifenum--;
			}
			bottonPanel.getStartButton().setEnabled(true);
		}
			
	}
	public void setScore() {
		int score = snake.getFoodCount() ;
		bottonPanel.setScore(score);
	}
	

	
	// 开始一个新游戏	
	public void newGame() {
		
		ground.clear();
		
		switch (ground.getMapType()) {
			case 1:
				ground.generateRocks1();
				break;
			case 2:
				ground.generateRocks2();
				break;
			case 3:
				ground.generateRocks3();
				break;
		}
		snake.setSleepTime(300);
		Snake.lifenum=0;
		food.newFood(ground.getPoint());	
		bottonPanel.setScore(0);			        
		bottonPanel.repaint();	
	}
	//开始游戏按钮的监听
	class startHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {	
			if(i==0) {
			i=1;
				//!!使游戏面板区获得焦点
			snake.clear();
			snake.init();		
			snake.begin();
			newGame();	
			}
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}
	//暂停按钮的监听
	class pauseHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			puase=1;
			gamePanel.requestFocus(true);
			if(i==1) {
			snake.changePause();
			if(e.getActionCommand()=="     暂停游戏")
				bottonPanel.getPauseButton().setText("     继续游戏");
			else {
				bottonPanel.getPauseButton().setText("     暂停游戏");
			}
			}
		}
		
	}
	//结束游戏按钮的监听
	class endHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		
			i=0;
			gamePanel.requestFocus(true);
			snake.die();
			bottonPanel.repaint();
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}
	class end implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			gamePanel.requestFocus(true);
			snake.die();
			System.exit(0);
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}	
	
	class Item1Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(puase==0)
			snake.changePause();
			Color color = JColorChooser.showDialog(gamePanel, "请选择背景颜色", Color.BLACK);	
			gamePanel.backgroundColor = color;snake.changePause();
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);		
		}
		
	}
	class Item2Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color;
			color= Color.blue;
			food.setFoodColor(color);
		}
		
	}

	class Item3Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color = JColorChooser.showDialog(gamePanel, "请选择颜色", Color.BLACK);	
			snake.setHeadColor(color);
		}	
	}
	
	class Item4Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(puase==0)
			snake.changePause();
			Color color = JColorChooser.showDialog(gamePanel, "请选择蛇身颜色", Color.BLACK);	
			snake.setBodyColor(color);
			snake.changePause();
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}
	
	class spItem1Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			snake.setSleepTime(600);
			
		}
		
	}
	
	class spItem2Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			snake.setSleepTime(350);
			
		}	
	}
	
	
	class spItem3Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			snake.setSleepTime(150);
		}	
	}
	
	class spItem4Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			snake.setSleepTime(80);
			
		}	
	}
	
  class mapItem0Handler	implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}
	//模式
	class mapItem1Handler	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mode=1;
			Search scoreList = new Search();
			scoreList.readScore(mode);
			Color color;
			color= null;
			food.setFoodColor(color);
			ground.setMapType(1);
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}
	
	class mapItem2Handler	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mode=2;
			map2=1;
			Search scoreList = new Search();
			scoreList.readScore(mode);
			Color color;
			color= Color.blue;
			food.setFoodColor(color);
			ground.setMapType(2);
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);
			Ip frame = new Ip();
			frame.setVisible(true);
		}
		
	}
	
	class mapItem3Handler	implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mode=3;
			map2=1;
			Search scoreList = new Search();
			scoreList.readScore(mode);
			Color color;
			color= Color.blue;
			food.setFoodColor(color);
			ground.setMapType(3);
			gamePanel.requestFocus(true);
			bottonPanel.getStartButton().setEnabled(true);
		}
		
	}
	
	//排行榜绘制
	class Rank	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ChoseRank frame = new ChoseRank();
			frame.setVisible(true);
			
			
		}
		
	}
	
	class Help	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Helps frame = new Helps();
			frame.setVisible(true);
			
			
		}
		
	}
	
	public int Map2() {
		return map2;
	}
	
}
