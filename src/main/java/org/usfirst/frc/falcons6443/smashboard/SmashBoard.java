package org.usfirst.frc.falcons6443.smashboard;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Shivashriganesh Mahato
 */
public class SmashBoard {

    private static SmashBoard instance;

    private String title;
    private int width, height;
    private ArrayList<Data> components;
    private Dashboard frame;

    private SmashBoard() {
        title = "Undefined";
        width = 640;
        height = 480;
        frame = new Dashboard(title);
        components = new ArrayList<>();
    }

    public void init(String name, int width, int height) {
        this.title = name;
        this.width = width;
        this.height = height;
        this.frame.setTitle(name);
    }

    public void putData(String name, int value) {
        boolean doesAlreadyExist = false;

        for (Data data : components) {
            if (data.getName().equals(name)) {
                doesAlreadyExist = true;
                break;
            }
        }

        if (doesAlreadyExist) {
            getData(name).setWidgetVal(value);
        } else {
            Data newData = new Data(name, value);
            components.add(newData);
            frame.getPanel().add(newData.getWidget());
        }
    }

    private Data getData(String name) {
        for (Data data : components)
            if (data.getName().equals(name))
                return data;
        return null;
    }

    public void run() {
        frame.display(width, height);

//        Timer timer = new Timer(1, e -> {
//            for (Data data 640, 480);
//        });
//        timer.start();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static SmashBoard getInstance() {
        if (instance == null) {
            instance = new SmashBoard();
        }
        return instance;
    }

	public static void main(String args[]) {
        getInstance().init("Smashboard", 640, 480);
        getInstance().run();
	}
	
}
