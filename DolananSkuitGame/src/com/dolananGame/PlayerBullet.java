package com.dolananGame;

import java.awt.*;

public class PlayerBullet extends Bullet{
    public PlayerBullet(int x, int y, int speed) {
        super(x, y, speed);
        this.color = Color.RED;
    }
}
