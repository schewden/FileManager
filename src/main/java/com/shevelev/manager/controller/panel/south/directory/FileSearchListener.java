package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.SearchModel;
import com.shevelev.manager.view.DisplayUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FileSearchListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;

    public FileSearchListener(FileToDirectoryModel FileToDirectoryModel, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = FileToDirectoryModel;
        this.displayUsers = displayUsers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchModel searchModel = new SearchModel();

        JTextField nameSearchFile = (JTextField) e.getSource();

        HashMap<String, File> currentFilesInDirectory = new HashMap<>();
        List<String> currentFilesStringInDirectory = new ArrayList<>();

        searchModel.setCurrentFilesStringInDirectory(currentFilesStringInDirectory);
        searchModel.setCurrentFilesInDirectory(fileToDirectoryModel.getFileToDirectory(), currentFilesInDirectory);

        List<File> foundListFiles = new ArrayList<>();
        for (int i = 0; i < currentFilesInDirectory.size(); i++) {
            if (currentFilesStringInDirectory.get(i).contains(nameSearchFile.getText())) {
                File foundFile = currentFilesInDirectory.get(currentFilesStringInDirectory.get(i));
                foundListFiles.add(foundFile);
            }
        }
        displayUsers.repaintGUI(foundListFiles);
    }
}


