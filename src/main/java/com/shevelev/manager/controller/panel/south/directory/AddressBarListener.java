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

public class AddressBarListener implements ActionListener {
    private PanelTree panelTree;
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;
    private BackAndNextModel backAndNextModel;

    public AddressBarListener(PanelTree panelTree, FileToDirectoryModel fileToDirectoryModel,
                              DisplayUsers displayUsers, BackAndNextModel backAndNextModel){
        this.panelTree = panelTree;
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.backAndNextModel = backAndNextModel;

    }

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
