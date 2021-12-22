package com.dolananGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    BufferedImage bImage;
    int x, y, height, width, state;

    public Button(BufferedImage bImage, int x, int y, int height, int width, int state) {
        this.bImage = bImage;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.state = state;
    }

    public void Clicked (int x, int y, Manager m){
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.width){
            m.setState(this.state);
        }
    }

    public void draw (Graphics g){
        g.drawImage(bImage, x,y, width,height, null);
    }
}
