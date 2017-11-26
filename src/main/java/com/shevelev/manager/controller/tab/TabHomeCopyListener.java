package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.CutModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.PanelTree;

import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by denis on 22.11.17.
 */
public class TabHomeCopyListener implements ActionListener{
    private File currentSelectedFile;
    private TreePath currentTreePath;
    private FileToDirectoryModel FileToDirectoryModel;
    private PanelTree panelTree;
    private CutModel cutModel;

    public TabHomeCopyListener(FileToDirectoryModel FileToDirectoryModel, PanelTree panelTree, CutModel cutModel){
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelTree = panelTree;
        this.cutModel = cutModel;

    }
    public void actionPerformed(ActionEvent e) {
        currentSelectedFile = FileToDirectoryModel.getSelectedDirectory();
        if (currentSelectedFile != null){
            cutModel.setStorageCurrentTreePath(currentSelectedFile);
            cutModel.setMarkCutFileOrDir(false);
        }
    }
}
