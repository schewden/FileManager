package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * In this class, the address bar listener controller is implemented
 */
public class AddressBarListener implements ActionListener {
    private PanelTree panelTree;
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;
    private BackAndNextModel backAndNextModel;

    /**
     * Constructor
     *
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     * @param backAndNextModel     - model of travel back and forth (BackAndNextModel.java)
     */
    public AddressBarListener(PanelTree panelTree, FileToDirectoryModel fileToDirectoryModel,
                              DisplayUsers displayUsers, BackAndNextModel backAndNextModel){
        this.panelTree = panelTree;
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.backAndNextModel = backAndNextModel;

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField addressBar = (JTextField) e.getSource();
        File currentFile = new File(addressBar.getText());
        List<File> currentListParentFiles = new ArrayList<>();
        panelTree.getPathCurrentFileInJTree(currentFile,currentListParentFiles);

        fileToDirectoryModel.setFileToDirectory(currentFile);
        backAndNextModel.setPreviousFiles(currentFile);

        displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
    }
}
