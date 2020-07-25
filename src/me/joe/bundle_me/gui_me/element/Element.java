package me.joe.bundle_me.gui_me.element;

import me.joe.bundle_me.gui_me.gui.GUI;

public class Element {

    private final String id;
    private int x;
    private int y;
    private final GUI gui;

    public Element(String id, int x, int y, GUI gui) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.gui = gui;
    }

    public String getId() {
        return id;
    }

    public GUI getGui() {
        return gui;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
