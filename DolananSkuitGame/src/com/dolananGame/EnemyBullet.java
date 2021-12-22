package com.dolananGame;

import java.awt.*;

public class EnemyBullet extends Bullet {

    public EnemyBullet(int x, int y, int speed) {
        super(x, y, speed);
        this.color = Color.BLUE;
    }
}
