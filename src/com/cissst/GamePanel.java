package com.cissst;

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
	
	@Override
	public void paint(Graphics g) {
		for(int i = 0;i <Config.map.length;i++) {
			for(int j=0;j<Config.map[i].length;j++) {
				if(Config.map[i][j]==Config.WALL) {
					g.drawImage(wall,Config.WIDTH*j,Config.WIDTH*i,null);
				}
			}
		}
		this.repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Config.SWIDTH,Config.SHEIGH);
	}
	
	
	
	
	
	
}
