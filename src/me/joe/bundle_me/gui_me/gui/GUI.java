package me.joe.bundle_me.gui_me.gui;

import me.joe.bundle_me.gui_me.element.Element;

import java.util.HashMap;

public class GUI {

    private GUIType type;
    private int size;
    private HashMap<Integer, HashMap<Integer, Element>> elements = new HashMap<>();

    public GUI(GUIType type, int size) {
        this.type = type;
        this.size = size;
    }

    public GUIType getType() {
        return type;
    }

    public void setType(GUIType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<Integer, HashMap<Integer, Element>> getElements() {
        return elements;
    }

    public void setElement(int x, int y, Element element) {
        HashMap<Integer, Element> row = this.elements.get(y);
        if (row == null) {
            HashMap<Integer, Element> newRow = new HashMap<>();
            newRow.put(x, element);
            this.elements.put(y, newRow);
            return;
        }
        this.elements.get(y).put(x, element);
    }

    public void addElement(Element element) {
        for (int i = 0; i < this.size; i++) {
            HashMap<Integer, Element> row = this.elements.get(i);
            if (row != null) {
                for (int j = 0; j < 9; j++) {
                    if (row.containsKey(j)) {
                        continue;
                    }
                    row.put(j, element);
                    return;
                }
            } else {
                HashMap<Integer, Element> newRow = new HashMap<>();
                newRow.put(0, element);
                this.elements.put(i, newRow);
                return;
            }
        }
    }

    public Element getElement(int x, int y) {
        HashMap<Integer, Element> row = this.elements.get(y);
        if (row == null) {
            return null;
        }
        return this.elements.get(y).get(x);
    }
}