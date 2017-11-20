package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;
import com.shevelev.manager.view.menu.RenamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by denis on 20.11.17.
 */
public class TabHomeRenameListener implements ActionListener {

    private JFrame frame;
    private DirectoryFile directoryFile;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    private File currentSelectedFile;

    public TabHomeRenameListener(JFrame frame, DirectoryFile directoryFile,
                                 PanelTree panelTree,
                                 DisplayUsers displayUsers) {
        this.frame = frame;
        this.directoryFile = directoryFile;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }

    public void actionPerformed(ActionEvent e) {
        currentSelectedFile = directoryFile.getSelectedFile();

        RenamePanel newFilePanel = new RenamePanel();
        UIManager.put("OptionPane.yesButtonText", "Создать");
        UIManager.put("OptionPane.noButtonText", "Отмена");

        int result = JOptionPane.showConfirmDialog(frame,
                newFilePanel.getRenamePanel(),
                "Переименовать",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);




    }
}
