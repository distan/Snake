package com.cavalier.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import com.cavalier.util.Global;


public class Food extends Point{
	/**
	 * 关于食物相关函数
	 */
	private static final long serialVersionUID = 1L;
	private Color foodColor;
	public static Color foodcolor;
	public void setFoodColor(Color foodColor) {
		this.foodColor = foodColor;
	}

	public Color getFoodColor() {
		return foodColor;
	}

	public void newFood(Point p) {
		setLocation(p);
	}
	
	public boolean isFoodEated(Snake snake) {			
		return 	this.equals(snake.getHead());
	}
//随机颜色	
	public void drawMe(Graphics g) {
		if(foodColor==null) {
			g.setColor(Color.RED);
		}else {
			Snake rand=new Snake();
			int x=rand.rand();//接收随机数
			if(x==1)
			    g.setColor(Color.CYAN);
			else if(x==2)
				g.setColor(Color.red);
			else if(x==3)
				g.setColor(Color.yellow);
			else if(x==4)
				g.setColor(Color.white);
			else if(x==5)
				g.setColor(Color.white);
			else
				g.setColor(Color.red);
		}
		foodcolor=g.getColor();
		
		g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
	
}
