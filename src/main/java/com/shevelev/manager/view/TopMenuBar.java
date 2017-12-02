package com.shevelev.manager.view;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.InsertModel;
import com.shevelev.manager.view.menu.ButtonFileMenu;
import com.shevelev.manager.view.menu.TabHomePanel;

import javax.swing.*;
import java.awt.*;


/**
 * top menu class
 */
public class TopMenuBar {
    /**
     * Constructor
     *
     * @param panelMenu            - this panel
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     * @param panelByDirectory     - panel by directories (PanelByDirectory.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     */
    public TopMenuBar(JPanel panelMenu, FileToDirectoryModel fileToDirectoryModel,
                      PanelTree panelTree, DisplayUsers displayUsers,
                      PanelByDirectory panelByDirectory, InsertModel insertModel) {

        panelMenu.setLayout(new BorderLayout());
        Font font = new Font("Times New Roman", Font.ITALIC, 14);
        JTabbedPane tabbedPane = new JTabbedPane();
        TabHomePanel tabHomePanel = new TabHomePanel(fileToDirectoryModel, panelTree, displayUsers, panelByDirectory, insertModel);
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("Файл");
        menuFile.setOpaque(true);
        menuFile.setBackground(Color.LIGHT_GRAY);
        menuFile.setFont(font);
        new ButtonFileMenu(menuFile,fileToDirectoryModel);
        menuBar.add(menuFile);

        panelMenu.add(tabbedPane, BorderLayout.NORTH);
        tabbedPane.add("Главная", tabHomePanel.getPanel());
        tabbedPane.setFont(font);

        displayUsers.getFrame().setJMenuBar(menuBar);
        //menuFile.addMouseListener(new MenuMouseListener(menuFile, tabbedPane));
    }
}
