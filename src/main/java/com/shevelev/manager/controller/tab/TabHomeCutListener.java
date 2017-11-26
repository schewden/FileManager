package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.CutModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by denis on 22.11.17.
 */
public class TabHomeCutListener implements ActionListener {
    private FileToDirectoryModel FileToDirectoryModel;
    private File currentSelectedFile;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;
    private CutModel cutModel;

    public TabHomeCutListener(FileToDirectoryModel FileToDirectoryModel, PanelTree panelTree, DisplayUsers displayUsers, CutModel cutModel) {
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
        this.cutModel = cutModel;
    }
    public void actionPerformed(ActionEvent e) {
            File srcDir = FileToDirectoryModel.getSelectedDirectory();
            if (srcDir.isDirectory()) {
                cutModel.setMarkCutFileOrDir(true);
                cutModel.setStorageCurrentTreePath(srcDir);
            } else {
                cutModel.setMarkCutFileOrDir(true);
                cutModel.setStorageCurrentTreePath(srcDir);
            }
        }
}
