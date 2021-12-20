package com.mbuh;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.text.html.ImageView;

import com.mbuh.Game.STATE;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH / 12 * 9;

	private boolean running = false;
	private Thread thread;
	
	private Handler handler;
	private Menu menu;
	private Glass theGlass;
	
	
	public static AudioInputStream stream;
	public static Clip clip;
	
	public enum STATE {
		Menu,
		RedLightGreenLight,
		TheGlass
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game() {
		handler = new Handler();
		menu = new Menu(this, handler, theGlass, WIDTH, HEIGHT);
		theGlass = new Glass(WIDTH, HEIGHT);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		this.addMouseListener(theGlass);
		new Intro(WIDTH, HEIGHT, "Skuid Game", this);
	}
	
	public synchronized void start() {
		//if(running)
			//return;
		
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		//if(!running)
			//return;
		
		//running = false;
		try{
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				// update++;
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				// updates = 0
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		if (gameState == STATE.RedLightGreenLight) {
			handler.tick();
		}
		
		else if(gameState == STATE.TheGlass) {
			theGlass.tick();
		}
		
		else if(gameState == STATE.Menu) {
			menu.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		menu.render(g);
		
		if(gameState == STATE.RedLightGreenLight){
			handler.render(g);
		}
		else if(gameState == STATE.TheGlass) {
			theGlass.render(g);
		}
		else if(gameState == STATE.Menu) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	
	}

}
