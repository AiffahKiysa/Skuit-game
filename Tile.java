package com.mbuh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tile extends GameObject {
	Glass theGlass;
	
	Random rand = new Random();
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	Color randomColor = new Color(r, g, b);

	public Tile(int x, int y, ID id, Glass theGlass) {
		super(x, y, id);
		this.theGlass = theGlass;
	}

	public void tick() {
		x += velX;
		y += velY;
		
	}

	public void render(Graphics g) {
		if(id == ID.Tile) {
			g.setColor(randomColor);
			g.fillRect(x, y, 100, 100);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
