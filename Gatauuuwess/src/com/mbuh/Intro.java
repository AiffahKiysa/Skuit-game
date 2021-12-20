package com.mbuh;

import javax.sound.sampled.AudioSystem;
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

public class Intro extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private int wait = 900000;
	private String audioFileName = "Glass-bridge-sound.wav";
	private String title;
	private JFrame frame = new JFrame(title);
	
	public Intro(int width, int height, String title, Game game) {
		//PlayAudio();
	
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
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
    /*public void PlayAudio() {
        try{
            File audioPath = new File(audioFileName);
//            WE NEED JAVA'S AUDIO INPUT STREAM
            Game.stream = AudioSystem.getAudioInputStream(audioPath);
//            REFERENCE TO AUDIO CLIP CLASS
            Game.clip = AudioSystem.getClip();
//            OPEN THE STREAM USING THE CLIP CLASS
            Game.clip.open(Game.stream);
//            START THE MUSIC!
            Game.clip.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
            Thread.sleep(wait);
            frame.dispose();
//            Menu class
            JOptionPane.showMessageDialog(null, "Menu Will be here!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
	}*/
}
