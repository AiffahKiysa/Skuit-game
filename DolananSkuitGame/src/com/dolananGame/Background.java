package com.dolananGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background {
    int MinX, MinY, MaxX, MaxY;
    float x, y;
    private Color colorFilled;
    BufferedImage image;

    public Background(int x, int y, int width, int height,
                      Color colorfilled) {
        this.MinX = x;
        this.MinY = y;
        this.MaxX = x + width - 1;
        this.MaxY = y + height -1;
        this.y = this.MinY - 600;
        try {
            image = ImageIO.read(new File("resource/DolananGame.jpg"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    public void draw(Graphics g){
        g.setColor(this.colorFilled);
        g.drawImage(image, 0,0, null);
    }
}
