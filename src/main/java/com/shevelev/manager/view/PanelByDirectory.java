package com.shevelev.manager.view;

import com.shevelev.manager.controller.panel.south.directory.*;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;

/**
 * View of the panel by directory
 */
public class PanelByDirectory {
    private JTextField addressBar;

    /**
     * Constructor
     *
     * @param panel                - current JPanel is framed in a frame
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     * @param backAndNextModel     - model of travel back and forth (BackAndNextModel.java)
     */
    public PanelByDirectory(JPanel panel, PanelTree panelTree, FileToDirectoryModel fileToDirectoryModel,
                            DisplayUsers displayUsers, BackAndNextModel backAndNextModel) {

        panel.setLayout(new GridBagLayout());

        Dimension dimension = new Dimension(34, 30);

        JButton buttonBack = new JButton();
        addButtonItem(buttonBack, "src/main/resources/images/previous.png");
        panel.add(buttonBack, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(5, 2, 0, 2), 0, 0));
        buttonBack.addActionListener(new BackListener(fileToDirectoryModel, displayUsers, panelTree, backAndNextModel));

        JButton buttonNext = new JButton();
        addButtonItem(buttonNext, "src/main/resources/images/next.png");
        panel.add(buttonNext, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(5, 2, 0, 2), 0, 0));
        buttonNext.addActionListener(new NextListener(fileToDirectoryModel, displayUsers, panelTree, backAndNextModel));

        addressBar = new JTextField();
        addressBar.setPreferredSize(dimension);
        panel.add(addressBar, new GridBagConstraints(2, 0, 6, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(5, 2, 0, 2), 0, 0));
        addressBar.addActionListener(new AddressBarListener(panelTree, fileToDirectoryModel, displayUsers, backAndNextModel));

        JButton buttonRefresh = new JButton();
        addButtonItem(buttonRefresh, "src/main/resources/images/recur.png");
        panel.add(buttonRefresh, new GridBagConstraints(8, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(5, 2, 0, 2), 0, 0));
        buttonRefresh.addActionListener(new RefreshListener(fileToDirectoryModel, panelTree));

        JTextField fieldSearch = new JTextField();
        fieldSearch.setPreferredSize(dimension);
        panel.add(fieldSearch, new GridBagConstraints(9, 0, 1, 1, 0.2, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(5, 2, 0, 0), 0, 0));
        fieldSearch.addActionListener(new FileSearchListener(fileToDirectoryModel, displayUsers));

        JButton buttonSearch = new JButton();
        addButtonItem(buttonSearch, "src/main/resources/images/search.png");
        panel.add(buttonSearch, new GridBagConstraints(10, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(5, 0, 0, 2), 0, 0));
    }

    /**
     * Function of obtaining the JTextField
     *
     * @return addressBar type JTextField
     */
    public JTextField getAddressBar() {
        return addressBar;
    }

    /**
     * Procedure, display buttons to the user.
     *
     * @param newButton      - new JButton
     * @param pathButtonIcon - path current icon
     */
    private void addButtonItem(JButton newButton, String pathButtonIcon) {
        newButton.setPreferredSize(new Dimension(34, 29));
        newButton.setIcon(new ImageIcon(pathButtonIcon));
        newButton.setBackground(Color.WHITE);
    }
}
