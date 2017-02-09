package org.usfirst.frc.falcons6443.smashboard;

import java.util.ArrayList;

//TODO comment your stuff please
//TODO no
/**
 * @author Shivashriganesh Mahato
 */
public class SmashBoard {

    private static SmashBoard instance;

    private String title;
    private int width, height;
    private ArrayList<Data> components;
    private Dashboard frame;

    private NetworkTable table;

    private SmashBoard() {
        title = "Undefined";
        width = 640;
        height = 480;
        frame = new Dashboard(title);
        components = new ArrayList<>();
    }

    public void init(String name, int width, int height, String tableName, String ipAddress) {
        this.title = name;
        this.width = width;
        this.height = height;
        this.frame.setTitle(name);
        this.frame.init();
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress(ipAddress);
        this.table = NetworkTable.getTable(tableName);
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
            if (getData(name) != null)
                getData(name).setWidgetVal(value);
        } else {
            components.add(new Data(name, value));
        }
    }

    private Data getData(String name) {
        for (Data data : components)
            if (data.getName().equals(name))
                return data;
        return null;
    }

    public void run() {
        frame.update(components);
        frame.display(width, height);
    }

    public void runLoop() {
        while (true) {
            putData("Meme", table.getString("Meme", "69"));
            frame.update(components);
        }
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
	
}
