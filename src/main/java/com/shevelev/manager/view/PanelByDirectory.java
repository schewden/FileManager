package com.shevelev.manager.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 28.10.17.
 */
public class PanelByDirectory {
    private JButton buttonBack;
    private JButton buttonNext;
    private JButton buttonRefresh;
    private JButton buttonSearch;
    private JTextField addressBar;
    private JTextField fieldSearch;
    private Dimension dimension;

    public PanelByDirectory(JPanel panel){
        panel.setLayout(new GridBagLayout());

        dimension= new Dimension(34,30);

        buttonBack = new JButton();
        addButtonItem(buttonBack,"src/main/resources/images/previous.png");
        panel.add(buttonBack,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(2,2,2,2),0,0));

        buttonNext = new JButton();
        addButtonItem(buttonNext,"src/main/resources/images/next.png");
        panel.add(buttonNext,new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(2,2,2,2),0,0));

        addressBar = new JTextField();
        addressBar.setPreferredSize(dimension);
        panel.add(addressBar,new GridBagConstraints(2,0,6,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(2,2,2,2),0,0));

        buttonRefresh = new JButton();
        addButtonItem(buttonRefresh,"src/main/resources/images/recur.png");
        panel.add(buttonRefresh,new GridBagConstraints(8,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(2,2,2,2),0,0));

        fieldSearch = new JTextField();
        fieldSearch.setPreferredSize(dimension);
        panel.add(fieldSearch,new GridBagConstraints(9,0,1,1,0.2,0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(2,2,2,0),0,0));

        buttonSearch = new JButton();
        addButtonItem(buttonSearch,"src/main/resources/images/search.png");
        panel.add(buttonSearch,new GridBagConstraints(10,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(2,0,2,2),0,0));
    }

    private void addButtonItem(JButton newButton, String pathButtonIcon){
        System.out.println(newButton.getPreferredSize());
        newButton.setPreferredSize(new Dimension(34,29));
        newButton.setIcon(new ImageIcon(pathButtonIcon));
        newButton.setBackground(Color.WHITE);
    }
}
