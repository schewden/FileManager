package com.shevelev.manager.controller.panel.south.directory;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RefreshListener implements ActionListener {
    private FileToDirectoryModel FileToDirectoryModel;
    private PanelTree panelTree;

    public RefreshListener(FileToDirectoryModel FileToDirectoryModel, PanelTree panelTree){
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelTree = panelTree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File currentFile = FileToDirectoryModel.getFileToDirectory();
        List<File> currentListParentFiles = new ArrayList<>();
        panelTree.getDefaultTreeModel().reload();
        panelTree.getPathCurrentFileInJTree(currentFile,currentListParentFiles);

    }
}
