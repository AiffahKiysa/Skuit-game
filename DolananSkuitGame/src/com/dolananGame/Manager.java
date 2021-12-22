package com.dolananGame;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Manager {
    public State[] List;
    public int currentState;
    public static final int MENU = 0;
    public static final int GAME = 1;
    public static final int total = 2; // total State;

    public Manager() {
        List = new State[total];
        currentState = MENU;
        load(currentState);
    }

    public void load(int state){
        if (state == MENU){
            List[state] = new Menu(this);
        }else if (state == GAME){
            List[state] = new Game(this);
        }
    }
    public void unload(int state){
        List[state] = null;
    }

//    useState in JAVA
    public void setState(int nextState){
        if (this.currentState == nextState){
            unload(currentState);
            load(nextState);
        }else {
            load(nextState);
            unload(currentState);
        }
        this.currentState = nextState;
    }

    public void update() {
        List[currentState].update();
    }
    public void draw(Graphics g) {
        List[currentState].draw(g);
    }
    public void Dragged(MouseEvent e) {
        List[currentState].Dragged(e);
    }
    public void Moved(MouseEvent e) {
        List[currentState].Moved(e);
    }
    public void Clicked(MouseEvent e) {
        List[currentState].Clicked(e);
    }
    public void Pressed(MouseEvent e) {
        List[currentState].Pressed(e);
    }
    public void Released(MouseEvent e) {
        List[currentState].Released(e);
    }
    public void Entered(MouseEvent e) {
        List[currentState].Entered(e);
    }
    public void Exited(MouseEvent e) {
        List[currentState].Exited(e);
    }
}
