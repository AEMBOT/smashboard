package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Shivashriganesh Mahato
 */
public class Canvas extends JPanel {

    private ArrayList<Data> datas;

    public Canvas() {
        datas = new ArrayList<>();
    }

    public Data getData(String key) {
        for (Data data : datas)
            if (data.getKey().equals(key))
                return data;
        return null;
    }

    public Widget getWidget(String key) {
        return getData(key).getWidget();
    }

    public ArrayList<Data> getDatas() {
        return datas;
    }

    public void addData(Data data) {
        datas.add(data);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Data data : datas)
            data.getWidget().paint(g, this);
    }
}
