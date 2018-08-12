package com.cissst;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private GamePanel game = new GamePanel();
	public MainFrame() {
		super("迷宫v1.0");
		this.setSize(Config.SWIDTH,Config.SHEIGH+32);
		this.setLocation(100,30);
		this.add(game);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new MainFrame();
		
	}

}
