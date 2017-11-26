package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.CutModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by denis on 21.11.17.
 */
public class TabHomeCopyPathListener implements ActionListener {
    private FileToDirectoryModel FileToDirectoryModel;
    private PanelTree panelTree;
    private CutModel cutModel;

    public TabHomeCopyPathListener(FileToDirectoryModel FileToDirectoryModel, PanelTree panelTree, CutModel cutModel){
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelTree = panelTree;
        this.cutModel = cutModel;
    }
    public void actionPerformed(ActionEvent e) {
        cutModel.setStorageCurrentTreePath(FileToDirectoryModel.getFileToDirectory().getPath());
        cutModel.setMarkCutFileOrDir(false);
    }
}
