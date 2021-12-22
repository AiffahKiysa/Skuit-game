package com.Launcher;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.text.DecimalFormat;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.Launcher.Game.STATE;

public class Intro extends JPanel {

	private static final long serialVersionUID = 1L;
	private String title;
	private JFrame frame = new JFrame(title);
	
	public Intro(int width, int height, String title, Game game) {
		//PlayAudio();
		frame.add(this);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		game.start();
		if (game.gameState == STATE.Menu) {
			try{
				File sound = new File("Resource//sound-squidGame.wav");
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
		        clip.open(audioStream);
		        clip.start();
		    }catch (Exception e){
		        System.out.println(e);
		    }
			
			try {
	            Thread.sleep(10000);
	            //frame.dispose();
		        }
			catch (Exception e){
		            System.out.println(e);
	        }
		}
		
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Game game = new Game();
	}
}
