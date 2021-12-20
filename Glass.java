package com.mbuh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.mbuh.Game.STATE;


public class Glass extends MouseAdapter{
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	private Game game;
	private Tile tile;
	int win = 0;
	int lose = 0;
	Random rand = new Random();
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	Color randomColor = new Color(r, g, b);
	
	String[] images = new String[]{"R.png", "CR.png", "R.png", "CR.png", "R.png"};
	int index = (int) (Math.random() * images.length);
	int index1, index3, index5, index7, index9, index11, index13;
	int index2 = (int) (Math.random() * images.length);
	int index4 = (int) (Math.random() * images.length);
	int index6 = (int) (Math.random() * images.length);
	int index8 = (int) (Math.random() * images.length);
	int index10 = (int) (Math.random() * images.length);
	int index12 = (int) (Math.random() * images.length);
	
	int width, height;
	public Glass(int width, int height) {
		this.width = width;
		this.height = height;
		
		start();
	}
	
	public void start() {
		
		win=0;
		lose=0;
		
		int tileWidth = game.WIDTH/9 - 30;
		for (int i=0; i<7; i++) {
			addObject(new Tile(tileWidth, Game.HEIGHT/2, ID.Tile, this));
			addObject(new Tile(tileWidth, Game.HEIGHT/3, ID.Tile, this));
			tileWidth = tileWidth+120;
		}
		
		if (index == 0 || index == 2 || index == 4) {
			index1 = 1;
		}
		if (index == 1 || index == 3) {
			index1 = 0;
		}
		if (index2 == 0 || index2 == 2 || index2 == 4) {
			index3 = 1;
		}
		if (index2 == 1 || index2 == 3) {
			index3 = 0;
		}
		if (index4 == 0 || index4 == 2 || index4 == 4) {
			index5 = 1;
		}
		if (index4 == 1 || index4 == 3) {
			index5 = 0;
		}
		if (index6 == 0 || index6 == 2 || index6 == 4) {
			index7 = 1;
		}
		if (index6 == 1 || index6 == 3) {
			index7 = 0;
		}
		if (index8 == 0 || index8 == 2 || index8 == 4) {
			index9 = 1;
		}
		if (index8 == 1 || index8 == 3) {
			index9 = 0;
		}
		if (index10 == 0 || index10 == 2 || index10 == 4) {
			index11 = 1;
		}
		if (index10 == 1 || index10 == 3) {
			index11 = 0;
		}
		if (index12 == 0 || index12 == 2 || index12 == 4) {
			index13 = 1;
		}
		if (index12 == 1 || index12 == 3) {
			index13 = 0;
		}
	}
	
	int mx, my;
	int temp = 0;
	boolean Win = false;
	boolean False = false;
	
	public void mousePressed(MouseEvent e) {
		this.mx = e.getX();
		this.my = e.getY();
		
		int tileWidth = game.WIDTH/9 - 30;
		
		for (int i=0; i<14; i++) {
			
			if (mouseOver(mx, my, tileWidth, Game.HEIGHT/2, 100, 100)) {
				temp=1;
				if (index == 0 || index == 2 || index == 4) {
					win++;
				}
				if (index == 1 || index == 3) {
					lose++;
				}
			}
			else if (mouseOver(mx, my, tileWidth, Game.HEIGHT/3, 100, 100)) {
				temp=2;
				if (index1 == 0 || index1 == 2 || index1 == 4) {
					win++;
				}
				if (index1 == 1 || index1 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth+120, Game.HEIGHT/2, 100, 100)) {
				temp=3;
				if (index2 == 0 || index2 == 2 || index2 == 4) {
					win++;
				}
				if (index2 == 1 || index2 == 3) {
					lose++;
				}
			}
			else if(mouseOver(mx, my, tileWidth+120, Game.HEIGHT/3, 100, 100)) {
				temp=4;
				if (index3 == 0 || index3 == 2 || index3 == 4) {
					win++;
				}
				if (index3 == 1 || index3 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth+240, Game.HEIGHT/2, 100, 100)) {
				temp=5;
				if (index4 == 0 || index4 == 2 || index4 == 4) {
					win++;
				}
				if (index4 == 1 || index4 == 3) {
					lose++;
				}
			}
			else if (mouseOver(mx, my, tileWidth+240, Game.HEIGHT/3, 100, 100)) {
				temp=6;
				if (index5 == 0 || index5 == 2 || index5 == 4) {
					win++;
				}
				if (index5 == 1 || index5 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth+360, Game.HEIGHT/2, 100, 100)) {
				temp=7;
				if (index6 == 0 || index6 == 2 || index6 == 4) {
					win++;
				}
				if (index6 == 1 || index6 == 3) {
					lose++;
				}
			}
			else if (mouseOver(mx, my, tileWidth+360, Game.HEIGHT/3, 100, 100)) {
				temp=8;
				if (index7 == 0 || index7 == 2 || index7 == 4) {
					win++;
				}
				if (index7 == 1 || index7 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth+480, Game.HEIGHT/2, 100, 100)) {
				temp=9;
				if (index8 == 0 || index8 == 2 || index8 == 4) {
					win++;
				}
				if (index8 == 1 || index8 == 3) {
					lose++;
				}
			}
			else if (mouseOver(mx, my, tileWidth+480, Game.HEIGHT/3, 100, 100)) {
				temp=10;
				if (index9 == 0 || index9 == 2 || index9 == 4) {
					win++;
				}
				if (index9 == 1 || index9 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth+600, Game.HEIGHT/2, 100, 100)) {
				temp=11;
				if (index10 == 0 || index10 == 2 || index10 == 4) {
					win++;
				}
				if (index10 == 1 || index10 == 3) {
					lose++;
				}
			}
			else if (mouseOver(mx, my, tileWidth+600, Game.HEIGHT/3, 100, 100)) {
				temp=12;
				if (index11 == 0 || index11 == 2 || index11 == 4) {
					win++;
				}
				if (index11 == 1 || index11 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth+720, Game.HEIGHT/2, 100, 100)) {
				temp=13;
				if (index12 == 0 || index12 == 2 || index12 == 4) {
					win++;
				}
				if (index12 == 1 || index12 == 3) {
					lose++;
				}
			}
			else if (mouseOver(mx, my, tileWidth+720, Game.HEIGHT/3, 100, 100)) {
				temp=14;
				if (index13 == 0 || index13 == 2 || index13 == 4) {
					win++;
				}
				if (index13 == 1 || index13 == 3) {
					lose++;
				}
			}
			if (mouseOver(mx, my, tileWidth/3+81, height/2+250, 180, 50)) {
				game.gameState = STATE.TheGlass;
				start();
			}
		}
		if (win > lose) {
			 
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
		g.setColor(Color.white);
		Font fnt = new Font("Arial", 1, 50);
		g.setFont(fnt);
		g.drawString("Jump to The Glass", game.WIDTH/4, game.HEIGHT/5);
		int tileWidth = game.WIDTH/9 - 30;

		switch(temp){
			case 1:
				g.drawImage(new ImageIcon(images[index]).getImage(), width/9-30, height/2 + 150, null);
				break;
			case 2:
				g.drawImage(new ImageIcon(images[index1]).getImage(), width/9-30, height/2 + 150, null);
				break;
			case 3:
				g.drawImage(new ImageIcon(images[index2]).getImage(), width/5, height/2 + 150, null);
				break;
			case 4:
				g.drawImage(new ImageIcon(images[index3]).getImage(), width/5, height/2 + 150, null);
				break;
			case 5:
				g.drawImage(new ImageIcon(images[index4]).getImage(), width/3-15, height/2 + 150, null);
				break;
			case 6:
				g.drawImage(new ImageIcon(images[index5]).getImage(), width/3-15, height/2 + 150, null);
				break;
			case 7:
				g.drawImage(new ImageIcon(images[index6]).getImage(), width/4+190, height/2 + 150, null);
				break;
			case 8:
				g.drawImage(new ImageIcon(images[index7]).getImage(), width/4+190, height/2 + 150, null);
				break;
			case 9:
				g.drawImage(new ImageIcon(images[index8]).getImage(), width/2+60, height/2 + 150, null);
				break;
			case 10:
				g.drawImage(new ImageIcon(images[index9]).getImage(), width/2+60, height/2 + 150, null);
				break;
			case 11:
				g.drawImage(new ImageIcon(images[index10]).getImage(), width/2+180, height/2 + 150, null);
				break;
			case 12:
				g.drawImage(new ImageIcon(images[index11]).getImage(), width/2+180, height/2 + 150, null);
				break;
			case 13:
				g.drawImage(new ImageIcon(images[index12]).getImage(), width/2+300, height/2 + 150, null);
				break;
			case 14:
				g.drawImage(new ImageIcon(images[index13]).getImage(), width/2+300, height/2 + 150, null);
				break;
		}
		if (temp==13 || temp == 14) {
			if (win > lose) {
				g.setColor(Color.blue);
				g.fillRect(tileWidth/2+300, height/2+180, 250, 60);
				g.setColor(Color.white);
				Font fnt1 = new Font("Courier Bold", 1, 40);
				g.setFont(fnt1);
				g.drawString("You've won", tileWidth/2+320, height/2+220);
			}
			else {
				g.setColor(Color.red);
				g.fillRect(tileWidth/2+300, height/2+180, 250, 60);
				g.setColor(Color.white);
				Font fnt1 = new Font("Courier Bold", 1, 40);
				g.setFont(fnt1);
				g.drawString("You've lost", tileWidth/2+320, height/2+220);
			}
			
			Font fnt1 = new Font("Courier Bold", 1, 30);
			g.setFont(fnt1);
			g.setColor(Color.white);
			g.drawRect(tileWidth/2+300, height/2+250, 180, 50);
			g.drawString("Play Again", tileWidth/2+320, height/2+285);
			
		}
	}

	public void addObject(GameObject tempObject) {
		object.add(tempObject);
	}
	
	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}
}
