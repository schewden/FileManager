package com.shevelev.manager.view.menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 17.11.17.
 */
public class NewFilePanel {
    private JPanel newFilePanel;
    private JRadioButton newTypeFile;
    private JRadioButton newTypeDirectory;
    private JTextField name;

    public NewFilePanel(){
        newFilePanel = new JPanel(new BorderLayout(3,3));

        JPanel southRadio = new JPanel(new GridLayout(1,0,2,2));
        newTypeFile = new JRadioButton("Файл");
        newTypeDirectory = new JRadioButton("Папка",true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(newTypeFile);
        bg.add(newTypeDirectory);
        southRadio.add(newTypeFile);
        southRadio.add(newTypeDirectory);

        name = new JTextField(15);

        newFilePanel.add(new JLabel("Имя"), BorderLayout.WEST );
        newFilePanel.add(name);
        newFilePanel.add(southRadio, BorderLayout.SOUTH);
    }

    public JPanel getNewFilePanel() {
        return newFilePanel;
    }

    public JRadioButton getNewTypeDirectory() {
        return newTypeDirectory;
    }

    public JTextField getName() {
        return name;
    }
}
