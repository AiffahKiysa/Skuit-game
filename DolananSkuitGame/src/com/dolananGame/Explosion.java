package com.dolananGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Explosion {
    int x, y;
    Color color;
    BufferedImage[] images;
    int counter;

    public Explosion(int x, int y) {
        this.x = x;
        this.y = y;
        images = new BufferedImage[7];
        counter = 0;

        for (int i=0; i<7; i++){
            try{
                images[i] = ImageIO.read(new File(
                        String.format("resource/explosion/"
                                + "explosion-%d.png", i)
                ));
            }catch (Exception e){

            }
        }
    }
    public void paint(Graphics g){
        g.drawImage(images[counter], x - 50, y - 50, 100, 100, null);
        counter++;
    }
}
