package com.dolananGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Menu extends State{
    private BufferedImage logo, play;
    private Background bg;
    private ArrayList<Button> ButtonList = new ArrayList<Button>();

    public Menu(Manager sm) {
        this.sm = sm;
        bg = new Background(0, 0, WIDTH * 2, HEIGHT, Color.BLACK);
        try {
            logo = ImageIO.read(new File("resource/logo.png"));
            play = ImageIO.read(new File("resource/PLAY.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        ButtonList.add(new Button(play, WIDTH/2 - (144 * 3/4) + 2, HEIGHT/2 + 70, 135, 250, 1));
    }

    @Override
    public void draw(Graphics g) {
        bg.draw(g);
        g.drawImage(logo, 730, 0, 300, 300, null);
        for(Button b : ButtonList) {
            b.draw(g);
        }
    }

    @Override
    public void update() {}

    public void Pressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        for (Button b : ButtonList){
            b.Clicked(x,y, sm);
        }
    }
}
