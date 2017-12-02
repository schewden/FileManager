package com.shevelev.manager.controller.menu;

import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by denis on 23.10.17.
 */
public class MenuMouseListener implements ActionListener{
    private FileToDirectoryModel fileToDirectoryModel;

    public MenuMouseListener(FileToDirectoryModel fileToDirectoryModel){
        this.fileToDirectoryModel = fileToDirectoryModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        try {
            if (menuItem.getText().equals("Открыть командную строку")) {
                Process proc = Runtime.getRuntime().exec("xterm");
            }
            if (menuItem.getText().equals("Закрыть")) {
                System.exit(0);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
