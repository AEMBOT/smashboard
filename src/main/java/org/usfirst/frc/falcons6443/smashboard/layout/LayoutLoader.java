package org.usfirst.frc.falcons6443.smashboard.layout;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.Data;
import org.usfirst.frc.falcons6443.smashboard.widgets.SpeedBar;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Class used to load layouts from XML as well as save them to XML.
 *
 * @author Christopher Medlin
 */
public class LayoutLoader {
    private Layout layout;
    private NetworkTable ntable;

    public LayoutLoader () {
        layout = new Layout();
    }

    /**
     * Loads a Smashboard layout from an XML file.
     *
     * @param filename the path to the XML file
     * @param ntable the NetworkTabe to be used by the widgets contained in the loaded layout
     * @throws Exception placeholder
     */
    public Layout loadFromXML (String filename, NetworkTable ntable) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        //create a document
        Document doc = db.parse(new File(filename));

        Node layout = doc.getFirstChild();
        if (layout.getNodeName() == "layout") {
            NodeList nodes = layout.getChildNodes();
            //run processNode on all of the nodes
            for (int i = 0; i <= nodes.getLength(); i++) {
                processNode(nodes.item(i));
            }
        }

        this.ntable = ntable;
    }

    private void processNode (Node node) {
        //typecast the node to an element because they are easier to work with
        Element e = (Element) node;

        switch (node.getNodeName()) {

            //if the node is a trigger widget
            case "trigger": layout.add(new SpeedBar(e));
        }
    }
}
