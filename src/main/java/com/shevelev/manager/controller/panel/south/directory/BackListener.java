package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.controller.tab.ErrorMessage;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BackListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;
    private BackAndNextModel backAndNextModel;

    public BackListener(FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers,
                        PanelTree panelTree, BackAndNextModel backAndNextModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.panelTree = panelTree;
        this.backAndNextModel = backAndNextModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (backAndNextModel.getPreviousFiles().size() == 1) {
            String msg = "Вы находитесь в корневом каталоге!";
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            errorMessage.errorMessagePane(msg, "Ошибка панели по каталогам");
        } else {
            backAndNextModel.setFutureFiles(backAndNextModel.getPreviousFiles().getLast());
            backAndNextModel.getPreviousFiles().removeLast();
            File backFile = backAndNextModel.getPreviousFiles().getLast();
            fileToDirectoryModel.setFileToDirectory(backFile);
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
            panelTree.openCurrentFileInJTree(backFile);
        }
    }
}
