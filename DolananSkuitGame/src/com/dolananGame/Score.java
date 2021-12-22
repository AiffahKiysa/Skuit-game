package com.dolananGame;

import java.awt.*;

public class Score {
    int value;
    String text;
    Font font;

    public Score() {
        font = new Font("Verdana", Font.BOLD, 20);
        this.value = 0;
        this.text = "SCORE = ";
    }

    public int getValue() {
        return value;
    }

    public void paint(Graphics g){
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text + value, 5, 25);
    }

    public void addValue (){
        this.value += 1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
