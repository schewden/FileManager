package com.shevelev.manager.view;

import com.shevelev.manager.controller.panel.south.directory.*;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;

public class PanelByDirectory {
    private JButton buttonBack;
    private JButton buttonNext;
    private JButton buttonRefresh;
    private JButton buttonSearch;
    private JTextField addressBar;
    private JTextField fieldSearch;
    private Dimension dimension;

    public PanelByDirectory(JPanel panel, PanelTree panelTree, FileToDirectoryModel FileToDirectoryModel,
                            DisplayUsers displayUsers, BackAndNextModel backAndNextModel) {

        panel.setLayout(new GridBagLayout());

        dimension = new Dimension(34, 30);

        buttonBack = new JButton();
        addButtonItem(buttonBack, "src/main/resources/images/previous.png");
        panel.add(buttonBack, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
        buttonBack.addActionListener(new BackListener(FileToDirectoryModel, displayUsers, panelTree, backAndNextModel));

        buttonNext = new JButton();
        addButtonItem(buttonNext, "src/main/resources/images/next.png");
        panel.add(buttonNext, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
        buttonNext.addActionListener(new NextListener(FileToDirectoryModel, displayUsers, panelTree, backAndNextModel));

        addressBar = new JTextField();
        addressBar.setPreferredSize(dimension);
        panel.add(addressBar, new GridBagConstraints(2, 0, 6, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        addressBar.addActionListener(new AddressBarListener(panelTree, FileToDirectoryModel, displayUsers, backAndNextModel));

        buttonRefresh = new JButton();
        addButtonItem(buttonRefresh, "src/main/resources/images/recur.png");
        panel.add(buttonRefresh, new GridBagConstraints(8, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
        buttonRefresh.addActionListener(new RefreshListener(FileToDirectoryModel, panelTree));

        fieldSearch = new JTextField();
        fieldSearch.setPreferredSize(dimension);
        panel.add(fieldSearch, new GridBagConstraints(9, 0, 1, 1, 0.2, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 0), 0, 0));
        fieldSearch.addActionListener(new FileSearchListener(FileToDirectoryModel, displayUsers));

        buttonSearch = new JButton();
        addButtonItem(buttonSearch, "src/main/resources/images/search.png");
        panel.add(buttonSearch, new GridBagConstraints(10, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(2, 0, 2, 2), 0, 0));
    }

    public JTextField getAddressBar() {
        return addressBar;
    }

    public JButton getButtonNext() {
        return buttonNext;
    }

    private void addButtonItem(JButton newButton, String pathButtonIcon) {
        newButton.setPreferredSize(new Dimension(34, 29));
        newButton.setIcon(new ImageIcon(pathButtonIcon));
        newButton.setBackground(Color.WHITE);
    }
}
