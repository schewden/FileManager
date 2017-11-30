package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.InsertModel;
import com.shevelev.manager.view.DisplayUsers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * In this class, the copy button listener controller is implemented
 */
public class TabHomeCopyListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private InsertModel insertModel;
    private DisplayUsers displayUsers;

    /**
     * Constructor
     *
     * @param fileToDirectoryModel - model by files (FileToDirectoryModel.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     */
    public TabHomeCopyListener(FileToDirectoryModel fileToDirectoryModel, InsertModel insertModel, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.insertModel = insertModel;
        this.displayUsers = displayUsers;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File currentSelectedFile = fileToDirectoryModel.getSelectedDirectory();
            if (currentSelectedFile != null) {
                insertModel.setStorageCurrentTreePath(currentSelectedFile);
                insertModel.setMarkCutFileOrDir(false);
            }
        } catch (NullPointerException npe) {
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            String msg = "Вы не выделили элемент, который хотите скопировать!";
            errorMessage.errorMessagePane(msg, "Ошибка копирования");
        }
    }
}
