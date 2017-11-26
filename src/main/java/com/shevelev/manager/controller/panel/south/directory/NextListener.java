package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.controller.tab.ErrorMessage;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class NextListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;
    private BackAndNextModel backAndNextModel;

    public NextListener(FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers,
                        PanelTree panelTree, BackAndNextModel backAndNextModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.panelTree = panelTree;
        this.backAndNextModel = backAndNextModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (backAndNextModel.getFutureFiles().isEmpty()) {
            String msg = "Вы находитесь в последнем каталоге!";
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            errorMessage.errorMessagePane(msg, "Ошибка панели по каталогам");
        } else {
            File backFile = backAndNextModel.getFutureFiles().getLast();
            backAndNextModel.setPreviousFiles(backFile);
            backAndNextModel.getFutureFiles().removeLast();
            fileToDirectoryModel.setFileToDirectory(backFile);
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
            panelTree.openCurrentFileInJTree(backFile);
        }
    }
}
