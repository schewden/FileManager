package com.shevelev.manager.view.menu;

import javax.swing.*;
import java.awt.*;

/**
 * In this class, a panel is implemented for add new file or directory.
 */
public class NewFilePanel {
    private JPanel newFilePanel;
    private JRadioButton newTypeDirectory;
    private JTextField name;

    /**
     *  Constructor
     */
    public NewFilePanel(){
        newFilePanel = new JPanel(new BorderLayout(1,1));
        JPanel southRadio = new JPanel(new GridLayout(1,0,1,1));

        JRadioButton newTypeFile = new JRadioButton("Файл");
        newTypeDirectory = new JRadioButton("Папка",true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(newTypeFile);
        bg.add(newTypeDirectory);

        southRadio.add(newTypeFile);
        southRadio.add(newTypeDirectory);
        name = new JTextField(10);

        newFilePanel.add(new JLabel("Имя "), BorderLayout.WEST );
        newFilePanel.add(name);
        newFilePanel.add(southRadio, BorderLayout.SOUTH);
    }

    /**
     * Function of obtaining the value of the panel
     * @return newFilePanel - this panel
     */
    public JPanel getNewFilePanel() {
        return newFilePanel;
    }

    /**
     * Function of obtaining the JRadioButton.
     * This is the user's choice if he wants to create a directory.
     * @return newTypeDirectory - it is choice of directory creation.
     */
    public JRadioButton getNewTypeDirectory() {
        return newTypeDirectory;
    }

    /**
     * Function of obtaining the JTextField
     * @return  it is name file.
     */
    public JTextField getName() {
        return name;
    }
}
