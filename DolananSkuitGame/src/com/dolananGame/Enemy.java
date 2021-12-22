package com.dolananGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Enemy extends CharSprite{
    int speed;
    boolean hit;
    int shootTimer;

    public Enemy(Color color, int Width) {
        super(color);
        Random rand = new Random();
        this.x = 0 - 96;
        this.y = rand.nextInt((Width - 40)/30) * 30 + 10;
        this.speed = rand.nextInt(3 - 1 + 1) + 1;
        this.minX = x;
        this.minY = y;
        this.hit = false;
        this.shootTimer = 0;
        try {
            image = ImageIO.read(new File("resource/redCharacter.png"));
        }catch (IOException e){
//            e.printStackTrace();
        }
    }
    public void paint(Graphics g){
        g.drawImage(image, x,y, width, height,null);
    }
    public void move() {
        this.x += speed;
//        this.minY = this.y;
        this.minX = this.x;
    }
}
