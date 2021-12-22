package com.Launcher;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;

import com.Launcher.Game.STATE;
import com.dolananGame.Manager;
import com.glassBridge.Glass;

public class Game extends Canvas implements MouseListener, MouseMotionListener, Runnable{
	
	private static final long serialVersionUID = 1L;
	private static final int REFRESH_RATE = 30;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH / 12 * 9;

	private boolean running = false;
	private Thread thread;
	
	private Menu menu;
	private Manager manager;
	private Glass theGlass;
	
	public enum STATE {
		Menu,
		SquidWar,
		TheGlass
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game() {
		menu = new Menu(this, manager, theGlass, WIDTH, HEIGHT);
		manager = new Manager();
		theGlass = new Glass(WIDTH, HEIGHT);
		
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
		this.addMouseListener(theGlass);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setFocusable(true);
		
		Intro intro = new Intro(Game.WIDTH, Game.HEIGHT, "Skuid Game", this);
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
		if (gameState == STATE.SquidWar) {
			manager.update();
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
		
		if(gameState == STATE.SquidWar){
			manager.draw(g);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Dragged(e);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Moved(e);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Clicked(e);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Pressed(e);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Released(e);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Entered(e);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(gameState == STATE.SquidWar){
			manager.Exited(e);
		}
		
	}

	
}
