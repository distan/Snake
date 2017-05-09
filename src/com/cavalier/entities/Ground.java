package com.cavalier.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import com.cavalier.util.Global;

public class Ground {
	private boolean [][] rocks = new boolean[Global.WIDTH][Global.HEIGHT];	
	private int mapType = 1;
	public int getMapType() {
		return mapType;
	}
	public void setMapType(int mapType) {
		this.mapType = mapType;
	}
	//��ʼ������(���ʯͷ)	 
	public void clear() {
		for (int x = 0; x < Global.WIDTH; x++)
			for (int y = 0; y < Global.HEIGHT; y++)
				{
				rocks[x][y] = false;  
				}
	}
	/**
	 * ����ʯͷ, ���Ը�����������ı�ʯͷ�ڵ����ϵĲ���
	 */
	public void generateRocks1() {
		for (int x = 0; x < Global.WIDTH; x++)
			rocks[x][0] = rocks[x][Global.HEIGHT - 1] = true;
		for (int y = 0; y < Global.HEIGHT; y++)
			rocks[0][y] = rocks[Global.WIDTH - 1][y] = true;
	}
	public void generateRocks2() {
		for (int y = 0; y < 6; y++) {
			rocks[0][y] = true;
			rocks[Global.WIDTH - 1][y] = true;
			rocks[0][Global.HEIGHT - 1 - y] = true;
			rocks[Global.WIDTH - 1][Global.HEIGHT - 1 - y] = true;
		}
		for (int y = 6; y < Global.HEIGHT - 6; y++) {
			rocks[6][y] = true;
			rocks[Global.WIDTH - 7][y] = true;
		}
	}
	public void generateRocks3() {
	    int  i0=(int)(1+Math.random()*(10-1+1));
	    int  x0=(int)(13+Math.random()*(24-13+1));
        int  y0= (int)(1+Math.random()*(10-1+1));    
		for(int x=i0;x<x0;x++)
			rocks[x][y0] = true;	
	    int  i1=(int)(1+Math.random()*(10-1+1));
	    int  x1=(int)(13+Math.random()*(24-13+1));
        int  y1= (int)(16+Math.random()*(24-16+1));  
		for(int j=i1;j<x1;j++)
			rocks[y1][j] = true;	
	    int  i2=(int)(11+Math.random()*(15-11+1));
	    int  x2=(int)(17+Math.random()*(20-17+1));
        int  y2= (int)(1+Math.random()*(10-1+1));
		for(int y=i2;y<x2;y++)
			rocks[y2][y] = true;	
	    int  i3=(int)(1+Math.random()*(10-1+1));
		int  x3=(int)(13+Math.random()*(18-13+1));
	    int  y3= (int)(14+Math.random()*(18-14+1));
		for(int x=i3;x<x3;x++)
			rocks[x][y3] = true;
		int  x4=(int)(13+Math.random()*(23-13+1));
		int  y4= (int)(2+Math.random()*(11-2+1));
		for(int i=y4;i<x4;i++)
			rocks[i][Global.HEIGHT-3] = true;
	}
	//���Ƿ�Ե���ʯͷ
	public boolean isGroundEated(Snake snake) {
		for(int x=0; x<Global.WIDTH;x++) {
			for(int y=0; y<Global.HEIGHT;y++) {
				if(rocks[x][y] == true &&
					(x==snake.getHead().x &&y==snake.getHead().y)) {
					return true;
				}
			}
		}
		return false;	
	}
	public Point getPoint() {
		Random random = new Random();
		int x=0,y=0;
		do {
			x = random.nextInt(Global.WIDTH);
			y = random.nextInt(Global.HEIGHT);
		} while (rocks[x][y]==true);
		return new Point(x,y);
	}
	//��ʾ����
	public void drawMe(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		
		for(int x=0; x<Global.WIDTH;x++) {
			for(int y=0; y<Global.HEIGHT;y++) {
				if(rocks[x][y] == true) {
					g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, 
							Global.CELL_SIZE,Global.CELL_SIZE, true);
				}
			}
		}
	}
}
