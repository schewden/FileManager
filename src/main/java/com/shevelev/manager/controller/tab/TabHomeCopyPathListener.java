package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.InsertModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * In this class, the copyPath button listener controller is implemented
 */
public class TabHomeCopyPathListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private InsertModel insertModel;

    /**
     * Constructor
     *
     * @param fileToDirectoryModel - model by files (FileToDirectoryModel.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     */
    public TabHomeCopyPathListener(FileToDirectoryModel fileToDirectoryModel, InsertModel insertModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.insertModel = insertModel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        insertModel.setStorageCurrentTreePath(fileToDirectoryModel.getFileToDirectory().getPath());
        insertModel.setMarkCutFileOrDir(false);
    }
}
