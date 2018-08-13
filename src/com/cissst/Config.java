package com.cissst;

public class Config {
	public static int SWIDTH = 660;//屏幕宽
	public static int SHEIGH = 660;
	public static int WIDTH = 66;
	
	public static int LEFT = 1;
	public static int RIGHT = 2;
	public static int UP = 3;
	public static int DOWN = 4;
	
	public static int ROAD = 0;
	public static int WALL = 1;
	public static int ENTER = 2;
	public static int EXIT = 3;
	//0路    1墙    2入口    3出口
	public static int[][] map = new int[][] {
		{1,3,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,0,1,0,1},
		{1,1,1,0,0,0,0,1,1,1},
		{1,0,0,0,1,1,1,1,1,1},
		{1,0,1,1,1,0,0,0,0,1},
		{1,0,0,0,0,0,1,1,0,1},
		{1,1,1,1,1,1,1,0,0,1},
		{1,0,0,0,0,0,0,0,1,1},
		{1,2,1,1,1,1,1,1,1,1}
	};
	
	
};
