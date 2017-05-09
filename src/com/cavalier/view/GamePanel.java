package com.cavalier.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.cavalier.controller.Controller;
import com.cavalier.entities.Food;
import com.cavalier.entities.Ground;
import com.cavalier.entities.Snake;
import com.cavalier.game.EditAccess;
import com.cavalier.game.Login;
import com.cavalier.game.Search;
import com.cavalier.net.*;
import com.cavalier.util.Global;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Snake snake;
	private Food food;
	private Ground ground;	
	public Color backgroundColor;
	public String modescore;
	
	public GamePanel() {
		setLocation(200,60);		
		/* 设置大小和布局 */
		this.setSize(Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT* Global.CELL_SIZE);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setFocusable(true);
		
	}


	public void display(Snake snake,Food food,Ground ground) {
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		
		repaint();
	}

	
	//清空游戏面板（擦除效果）
	public void clearDraw(Graphics g) {
			if(backgroundColor==null) {
				g.setColor(new Color(0x4169E1));
			}
			else {
				g.setColor(backgroundColor);
				
			}
			g.fillRect(0, 0, Global.WIDTH*Global.CELL_SIZE, Global.HEIGHT*Global.CELL_SIZE);
	}
	
	
	@Override
	public void paint(Graphics g) {
			clearDraw(g);
			//重新显示		
			if(ground != null && snake != null && food != null) {
					ground.drawMe(g);
					food.drawMe(g);
					snake.drawMe(g);
			}
			if(snake!=null && snake.isLife()==false)  {
				recover(g);
			}
	
		}

	
	//恢复工作
	public void recover(Graphics g) {
		clearDraw(g);
		
		//在游戏主面板区绘制“game over”
		g.setColor(Color.white);
		g.setFont(new Font("Serif",Font.BOLD,50));
		g.drawString("Game Over", 130, 210);
		int score = BottonPanel.score;
		Send.smess=Integer.toString(score);
		Send.main(null);
		
		EditAccess data = new EditAccess();
		Search se = new Search();
		int mode = Controller.mode;
		boolean updateflag = se.searchScore(Login.userflag, score,mode);
		if(updateflag == true){
			data.setDatasourceName("signups");
			String backMess = data.record();
			if(mode==1)		modescore = "mode1score";
			if(mode==2)		modescore = "mode2score";
			if(mode==3)		modescore = "mode3score";
			data.setSQL("UPDATE information SET "+modescore+" = '"+score+"' WHERE username = '"+Login.userflag+"'");
			backMess = data.record();
			
		}
	}
	
	
}
