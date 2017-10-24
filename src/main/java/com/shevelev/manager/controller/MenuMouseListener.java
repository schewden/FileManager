package com.shevelev.manager.controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by denis on 23.10.17.
 */
public class MenuMouseListener implements MouseListener {
    private JMenu menuFile;
    private JPanel panelHomeNorth;


    public MenuMouseListener(JMenu menuFile, JPanel panelHomeNorth) {
        this.menuFile = menuFile;
        this.panelHomeNorth = panelHomeNorth;
    }


    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (menuFile.isSelected()) {
            panelHomeNorth.setVisible(false);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (!menuFile.isSelected()) {
            panelHomeNorth.setVisible(false);
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (menuFile.isPopupMenuVisible()) {
            panelHomeNorth.setVisible(false);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (!menuFile.isPopupMenuVisible()) {
            panelHomeNorth.setVisible(true);
        }
    }
}
