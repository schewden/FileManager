package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.InsertModel;
import com.shevelev.manager.view.DisplayUsers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * In this class, the cut button listener controller is implemented
 */
public class TabHomeCutListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private InsertModel insertModel;
    private DisplayUsers displayUsers;

    /**
     * Constructor
     *
     * @param fileToDirectoryModel - model by files (FileToDirectoryModel.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     * @param displayUsers         - - head panel (DisplayUsers.java)
     */
    public TabHomeCutListener(FileToDirectoryModel fileToDirectoryModel, InsertModel insertModel, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.insertModel = insertModel;
        this.displayUsers = displayUsers;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    public void actionPerformed(ActionEvent e) {
        try {
            File srcDir = fileToDirectoryModel.getSelectedDirectory();
            if (srcDir.isDirectory()) {
                insertModel.setMarkCutFileOrDir(true);
                insertModel.setStorageCurrentTreePath(srcDir);
            } else {
                insertModel.setMarkCutFileOrDir(true);
                insertModel.setStorageCurrentTreePath(srcDir);
            }
        } catch (NullPointerException npe) {
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            String msg = "Вы не выделили элемент, который хотите вырезать!";
            errorMessage.errorMessagePane(msg, "Ошибка вырезки");
        }
    }
}
