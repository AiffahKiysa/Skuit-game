package com.dolananGame;

import java.awt.*;

public class Bullet {
    int x, y;
    int speed;
    int width, height;
    Color color;

    public Bullet(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        this.width = 6;
        this.height = 15;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void draw (Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
    public void move(){
        this.x -= speed;
    }
}
