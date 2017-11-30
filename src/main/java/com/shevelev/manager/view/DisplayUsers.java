package com.shevelev.manager.view;

import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.InsertModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

/**
 * View of head project
 */
public class DisplayUsers {
    private JFrame frame;
    private JPanel panelCenter;
    private JPanel panelInfo;
    private PanelDisplayDirectory panelDisplayDirectory;
    private PanelInfoAboutDirectory panelInfoAboutDirectory;

    /**
     * Constructor head project DeeShev
     */
    public DisplayUsers() {
        frame = new JFrame("File manager \"DeeShev\"");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));

        FileToDirectoryModel fileToDirectoryModel = new FileToDirectoryModel();
        BackAndNextModel backAndNextModel = new BackAndNextModel();
        InsertModel insertModel = new InsertModel();

        File rootSystem = new File("/");

        fileToDirectoryModel.setFileToDirectory(rootSystem);
        backAndNextModel.setPreviousFiles(rootSystem);

        panelInfo = new JPanel();
        frame.add(panelInfo, BorderLayout.SOUTH);
        panelInfoAboutDirectory = new PanelInfoAboutDirectory(panelInfo, fileToDirectoryModel);

        panelCenter = new JPanel();
        frame.add(panelCenter, BorderLayout.CENTER);
        panelDisplayDirectory = new PanelDisplayDirectory(panelCenter, fileToDirectoryModel, this, backAndNextModel);

        JPanel panelTree = new JPanel();
        frame.add(panelTree, BorderLayout.WEST);
        PanelTree panelTreeClass = new PanelTree(panelDisplayDirectory, panelTree, fileToDirectoryModel, this, backAndNextModel);

        JPanel panelDirectory = new JPanel();
        PanelByDirectory panelByDirectory = new PanelByDirectory(panelDirectory, panelTreeClass, fileToDirectoryModel, this, backAndNextModel);

        JPanel panelMenu = new JPanel();
        frame.add(panelMenu, BorderLayout.NORTH);
        new TopMenuBar(panelMenu, fileToDirectoryModel, panelTreeClass, this, panelByDirectory, insertModel);

        panelMenu.add(panelDirectory, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Function get frame
     * @return this frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     *  Procedure repaint this frame (repaint panelDisplayDirectory and panelInfo).
     * @param currentFiles - list files in current directory
     */
    public void repaintGUI(List<File> currentFiles) {
        panelDisplayDirectory.getPanelInPanelCenter().removeAll();
        panelCenter.removeAll();
        panelDisplayDirectory.updateCurrentDirectory(currentFiles);

        panelInfo.removeAll();
        panelInfoAboutDirectory.addPanelInfo();

        frame.repaint();
        frame.validate();
    }
}
