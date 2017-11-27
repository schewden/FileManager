package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        List<File> currentListParentFiles = new ArrayList<>();
        panelTree.getTreeDirectory().clearSelection();
        panelTree.getDefaultTreeModel().reload();
        panelTree.getPathCurrentFileInJTree(currentFile,currentListParentFiles);

    }
}
