package com.dolananGame;

import java.awt.*;

//Health Point
public class HP {
    int HealthPoint;
    String text;
    Font font;

    public HP() {
        font = new Font("Verdana", Font.BOLD, 20);
        this.HealthPoint = 200;
        this.text = "HealthPoint = ";
    }

    public int getHealthPoint() {
        return HealthPoint;
    }

    public void paint(Graphics g){
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text + HealthPoint, 5, 60);
    }

    public void increase(int value){
        this.HealthPoint += value;
        if (this.HealthPoint > 200) {
            this.HealthPoint = 200;
        }
    }

    public void decrease(int value){
        this.HealthPoint -= value;
        if (this.HealthPoint < 0){
            this.HealthPoint = 0;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
