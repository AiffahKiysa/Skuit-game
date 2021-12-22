package com.dolananGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CharSprite {
    int x, y;
    int width, height;
    Color color;
    BufferedImage image;

    int minX, minY;

    public CharSprite(Color color) {
        this.height = 120;
        this.width = 50;
        this.color = color;
    }

    public boolean bulletHit (Bullet bullet) {
        if (((bullet.x > minX && bullet.x < minX + width)
                || (bullet.x + bullet.width > minX && bullet.x + bullet.width < minX + width))
                && (bullet.y >= minY && bullet.y <= minY + height)) {
            return(true);
        } return(false);
    }
}
