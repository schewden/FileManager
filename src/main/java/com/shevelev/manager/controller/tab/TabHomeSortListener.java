package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * In this class, the sort button listener controller is implemented
 */
public class TabHomeSortListener implements ActionListener{
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;


    /**
     * Constructor
     *
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     */
    public TabHomeSortListener(FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers){
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        if (menuItem.getText().equals("Имя")){
            fileToDirectoryModel.setName(true);
            fileToDirectoryModel.setType(false);
            fileToDirectoryModel.setData(false);
            fileToDirectoryModel.setSize(false);
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());

        }else if (menuItem.getText().equals("Тип")){
            fileToDirectoryModel.setType(true);
            fileToDirectoryModel.setName(false);
            fileToDirectoryModel.setData(false);
            fileToDirectoryModel.setSize(false);
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }else if (menuItem.getText().equals("Дата")){
            fileToDirectoryModel.setType(false);
            fileToDirectoryModel.setName(false);
            fileToDirectoryModel.setData(true);
            fileToDirectoryModel.setSize(false);
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }else {
            fileToDirectoryModel.setType(false);
            fileToDirectoryModel.setName(false);
            fileToDirectoryModel.setData(false);
            fileToDirectoryModel.setSize(true);
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }
    }
}
