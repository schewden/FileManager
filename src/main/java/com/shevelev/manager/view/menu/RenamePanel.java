package com.shevelev.manager.view.menu;

import javax.swing.*;
import java.awt.*;


/**
 * In this class, a panel is implemented for renaming.
 */
public class RenamePanel {
    private JPanel renamePanel;
    private JTextField name;

    /**
     * Constructor
     */
    public RenamePanel(){
        renamePanel = new JPanel(new GridLayout(2,1));
        name = new JTextField(15);
        renamePanel.add(new JLabel("Имя файла"));
        renamePanel.add(name);
    }

    /**
     * Function of obtaining the value of the panel
     * @return renamePanel - this panel
     */
    public JPanel getRenamePanel() {
        return renamePanel;
    }

    /**
     * Function of obtaining the JTextField
     * @return name it is rename file.
     */
    public JTextField getName() {
        return name;
    }
}
