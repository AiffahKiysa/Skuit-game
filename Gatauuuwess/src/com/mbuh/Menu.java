package com.mbuh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import com.mbuh.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Glass theGlass;
	int width, height;
	private String imagePath = "background1.png";
	
	
	public Menu(Game game, Handler handler, Glass theGlass, int width, int height) {
		this.game = game;
		this.handler = handler;
		this.theGlass = theGlass;
		this.width = width;
		this.height = height;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (game.gameState == STATE.Menu) {
			if (mouseOver(mx, my, width/3, height/4 + 10, 310, 92)) {
				game.gameState = STATE.RedLightGreenLight;
				handler.addObject(new Player(Game.WIDTH/9, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new Player2(Game.WIDTH/9, Game.HEIGHT/2+32, ID.Player2));
				handler.addObject(new Player2(Game.WIDTH/9, Game.HEIGHT/2+96, ID.Player2));
			}
			if (mouseOver(mx, my, width/3, height/3 + 65, 310, 92)) {
				game.gameState = STATE.TheGlass;
			}
			if (mouseOver(mx, my, width/3, height/2 + 60, 310, 92)) {
				System.exit(0);
			}
		}
			if (game.gameState == STATE.RedLightGreenLight) {
				if (mouseOver(mx, my, 20, 20, 110, 45)) {
					game.gameState = STATE.Menu;
				}
			}
			
			
			if (game.gameState == STATE.TheGlass) {
				if (mouseOver(mx, my, 20, 20, 110, 45)) {
					game.gameState = STATE.Menu;
				}
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
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			g.drawImage(new ImageIcon(imagePath).getImage(), 0, 0, null);
			
			Font fnt = new Font("Arial", 1, 80);
			Font fnt2 = new Font("Arial", 1, 28);
			Font fnt3 = new Font("Arial", 1, 30);
			Font fnt4 = new Font("Courier Bold", 1, 40);
			
			g.setColor(Color.WHITE);
			g.setFont(fnt);
			g.drawString("Menu", width/3 + 50, height/4 - 10);
			
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawRect(width/3, height/4 + 30, 310, 92);
			g.setColor(Color.red);
			g.fillRect(width/3 + 1, height/4 + 31, 309, 90);
			g.setColor(Color.white);
			g.drawString("Red Light Green Light", width/3 + 10, height/3 + 20);
			
			g.setFont(fnt3);
			g.drawRect(width/3, height/3 + 75, 310, 92);
			g.setColor(Color.magenta);
			g.fillRect(width/3 + 1, height/3 + 76, 309, 90);
			g.setColor(Color.white);
			g.drawString("The Glass", width/2 - 80, height/2 + 10);
			
			g.setFont(fnt4);
			g.drawRect(width/3, height/2 + 60, 310, 92);
			g.setColor(Color.black);
			g.fillRect(width/3 + 1, height/2 + 61, 309, 90);
			g.setColor(Color.white);
			g.drawString("Quit", width/2 - 50, height/2 + 120);
		}
		else if(game.gameState == STATE.RedLightGreenLight) {
			Font fnt = new Font("Arial", 1, 25);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawRect(20, 20, 110, 45);
			g.drawString("<< Back", 27, 50);
		}
		else if(game.gameState == STATE.TheGlass) {
			Font fnt = new Font("Arial", 1, 25);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawRect(20, 20, 110, 45);
			g.drawString("<< Back", 27, 50);
		}
	}

}
