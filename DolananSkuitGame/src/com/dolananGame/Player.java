package com.dolananGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends CharSprite {
    int HealthPoint;

    public Player(Color color, int x, int y) {
        super(color);
        this.x = x;
        this.y = y;
        this.HealthPoint = 100;
        this.minX = x - width/2;
        this.minY = y - height/2;

        try{
            image = ImageIO.read(new File("resource/player001.png"));
        }catch (IOException e){
//            e.printStackTrace();
        }
    }

    public void draw (Graphics g){
        g.drawImage(image, minX, minY, width, height, null);
    }
}
