package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.controller.tab.ErrorMessage;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.SearchModel;
import com.shevelev.manager.view.DisplayUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileSearchListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;

    public FileSearchListener(FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchModel searchModel = new SearchModel();

        JTextField nameSearchFile = (JTextField) e.getSource();

        List<File> currentFilesInDirectory = new ArrayList<>();
        List<String> currentFilesStringInDirectory = new ArrayList<>();

        searchModel.setCurrentFilesStringInDirectory(currentFilesStringInDirectory);
        searchModel.setCurrentFilesInDirectory1(fileToDirectoryModel.getFileToDirectory(), currentFilesInDirectory);

        List<File> foundListFiles = new ArrayList<>();
        for (int i = 0; i < currentFilesInDirectory.size(); i++) {
            if (currentFilesStringInDirectory.get(i).contains(nameSearchFile.getText())) {
                File foundFile = currentFilesInDirectory.get(i);
                foundListFiles.add(foundFile);
            }
        }
        if (!foundListFiles.isEmpty()) {
            displayUsers.repaintGUI(foundListFiles);
        }else {
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            String msg = "Такого файла нет, пожалуйста проверьте корректно ли ввели имя файла!";
            errorMessage.errorMessagePane(msg,"Ошибка поиска");
        }
    }
}


