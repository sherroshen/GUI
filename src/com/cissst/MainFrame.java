package com.cissst;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					System.out.println("左...");
					game.setDirect(Config.LEFT);
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("右...");
					game.setDirect(Config.RIGHT);
					break;
				case KeyEvent.VK_UP:
					System.out.println("上...");
					game.setDirect(Config.UP);
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("下...");
					game.setDirect(Config.DOWN);
					break;
				default:
					break;
				}
				game.playGame();
			}
			
		});
		
	}
	public static void main(String[] args) {
		new MainFrame();
		
	}

}
