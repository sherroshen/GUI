package com.cissst;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	public BufferedImage wall;
	public BufferedImage left[] = new BufferedImage[4];
	public BufferedImage right[] = new BufferedImage[4];
	public BufferedImage up[] = new BufferedImage[4];
	public BufferedImage down[] = new BufferedImage[4];
	
	private int row = 0;//小人的row
	private int col = 0;//小人的col
	
	
	public GamePanel() {
		super();
		this.setSize(Config.SWIDTH,Config.SHEIGH);
		this.setVisible(true);
		initImag();
	}
	/**
	 * 初始化游戏中的图片
	*/
	public void initImag() {
		try {
			wall = ImageIO.read(GamePanel.class.getClass().getResource("/com/res/wall.bmp"));
	//		wall = ImageIO.read(this.getClass().getResource("/com/res/wall.bmp"));
			for(int i =1;i <= 4;i++) {
				left[i-1]=ImageIO.read(this.getClass().getResource("/com/res/2."+i+".bmp"));
			}
			for(int i =1;i <= 4;i++) {
				right[i-1]=ImageIO.read(this.getClass().getResource("/com/res/3."+i+".bmp"));
			}
			for(int i =1;i <= 4;i++) {
				up[i-1]=ImageIO.read(this.getClass().getResource("/com/res/4."+i+".bmp"));
			}
			for(int i =1;i <= 4;i++) {
				down[i-1]=ImageIO.read(this.getClass().getResource("/com/res/1."+i+".bmp"));
			}
			
			
			
		} catch (IOException e) {
			System.out.println("ERROR_001_加载图片出错！");
			e.printStackTrace();
		} 
	}
	
	/**
	 * 初始化地图
	 */
	public void initMap(Graphics g) {
		// 设置底面白色
		g.setColor(Color.white);
		g.fillRect(0, 0, Config.SWIDTH, Config.SHEIGH);

		for (int i = 0; i < Config.map.length; i++) {
			for (int j = 0; j < Config.map[i].length; j++) {
				//將入口坐標方到row col
				if(Config.map[i][j] == Config.ENTER) {
					row = i;
					col = j;
				}
				if(Config.map[i][j] == Config.EXIT) {
					g.setColor(Color.red);
					g.fillRect(j*Config.WIDTH, i*Config.WIDTH, Config.WIDTH, Config.WIDTH);
					g.setColor(Color.yellow);
					g.fillOval(j*Config.WIDTH+15, i*Config.WIDTH+20, 10, 10);
					g.fillOval(j*Config.WIDTH+35, i*Config.WIDTH+20, 10, 10);
				}
				if (Config.map[i][j] == Config.WALL) {
					g.drawImage(wall, Config.WIDTH * j, Config.WIDTH * i, null);
				}
			}
		}
		initEnter(g);
	}
	
	public void initEnter(Graphics g) {
		if(col-1>0&&Config.map[row][col-1]==Config.ROAD) {
			//小人应该向左
			g.drawImage(left[0],col*Config.WIDTH,row*Config.WIDTH,null);
		}else if(col+1<10&&Config.map[row][col+1]==Config.ROAD){
			//小人应该向右
			g.drawImage(right[0],col*Config.WIDTH,row*Config.WIDTH,null);
		}else if(row-1>0&&Config.map[row-1][col]==Config.ROAD){
			//小人应该向上
			g.drawImage(up[0],col*Config.WIDTH,row*Config.WIDTH,null);
		}else if(row+1<10&&Config.map[row+1][col]==Config.ROAD){
			//小人应该向下
			g.drawImage(down[0],col*Config.WIDTH,row*Config.WIDTH,null);
		}
		
		//g.drawImage(right[0],col*Config.WIDTH,row*Config.WIDTH,null);
	}
	
	@Override
	public void paint(Graphics g) {
		
		this.initMap(g);
		this.repaint();
		//System.out.println("初始化");
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Config.SWIDTH,Config.SHEIGH);
	}
	
	
	
	
	
	
}
