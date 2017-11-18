package com.shevelev.manager.controller.menu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by denis on 23.10.17.
 */
public class MenuMouseListener implements MouseListener {
    private JMenu menuFile;
    JTabbedPane tabbedPane;

    public MenuMouseListener(JMenu menuFile, JTabbedPane tabbedPane) {
        this.menuFile = menuFile;
        this.tabbedPane = tabbedPane;
    }

    public void mouseClicked(MouseEvent e) {
        if (!menuFile.isPopupMenuVisible()) {
            tabbedPane.setVisible(true);
        }else {
            tabbedPane.setVisible(false);
        }
    }

    public void mousePressed(MouseEvent e) {
        if (!menuFile.isPopupMenuVisible()) {
            tabbedPane.setVisible(true);
        }else {
            tabbedPane.setVisible(false);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (!menuFile.isPopupMenuVisible()) {
            tabbedPane.setVisible(true);
        }else {
            tabbedPane.setVisible(false);
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
