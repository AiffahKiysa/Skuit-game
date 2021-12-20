package com.mbuh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player2 extends GameObject {
	
	Random r = new Random();

	public Player2(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		velX = 1;
	}

	public void render(Graphics g) {
		if(id == ID.Player2) g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}

