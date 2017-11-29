package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RefreshListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private PanelTree panelTree;

    public RefreshListener(FileToDirectoryModel fileToDirectoryModel, PanelTree panelTree){
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.panelTree = panelTree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File currentFile = fileToDirectoryModel.getFileToDirectory();
        int row = panelTree.getTreeDirectory().getRowCount() - 1;
        while (row > 0){
            panelTree.getTreeDirectory().collapseRow(row);
            row--;
        }
        panelTree.openCurrentFileInJTree(currentFile);
    }
}
