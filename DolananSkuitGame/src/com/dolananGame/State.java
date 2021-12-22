package com.dolananGame;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class State {

    Manager sm;

    public abstract void update();
    public abstract void draw(Graphics g);

    public int WIDTH = 1000;
    public int HEIGHT = 720;

    public void Dragged(MouseEvent e){}
    public void Moved(MouseEvent e){}
    public void Clicked(MouseEvent e){}
    public void Pressed(MouseEvent e){}
    public void Released(MouseEvent e){}
    public void Entered(MouseEvent e){}
    public void Exited(MouseEvent e){}
}
