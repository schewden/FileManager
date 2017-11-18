package com.shevelev.manager.view.menu;

import com.shevelev.manager.controller.tab.TabHomePanelListener;
import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.PanelDisplayDirectory;
import com.shevelev.manager.view.PanelInfoAboutDirectory;
import com.shevelev.manager.view.PanelTree;

import javax.swing.*;
import java.awt.*;

/**
 * class of the tab home
 */
public class TabHomePanel {
    private JPanel panel;
    private JButton copy;
    private JButton insert;
    private JButton cut;
    private JButton copyPath;
    private JButton delete;
    private JButton rename;
    private JButton createDirectory;
    private JButton insertTag;

    private JLabel copyLabel;
    private JLabel insertLabel;
    private JLabel cutLabel;
    private JLabel copyPathLabel;
    private JLabel deleteLabel;
    private JLabel renameLabel;
    private JLabel createDirectoryLabel;
    private JLabel insertTagLabel;

    private Font font;

    private TabHomePanelListener homeListener;

    /**
     * Constructor
     */
    public TabHomePanel(JFrame frame, DirectoryFile directoryFile, PanelDisplayDirectory panelDisplayDirectory, PanelInfoAboutDirectory panelInfoAboutDirectory, PanelTree panelTree) {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        homeListener = new TabHomePanelListener(frame, directoryFile, panelDisplayDirectory,panelInfoAboutDirectory,panelTree);

        font = new Font("Times New Roman", Font.ITALIC, 11);
        copy = new JButton();
        addButtonItem(copy, "src/main/resources/images/copy.png", 0);

        insert = new JButton();
        addButtonItem(insert, "src/main/resources/images/documents32.png", 1);

        insertTag = new JButton();
        addButtonItem(insertTag, "src/main/resources/images/import32.png", 2);

        cut = new JButton();
        addButtonItem(cut, "src/main/resources/images/cut.png", 3);

        copyPath = new JButton();
        addButtonItem(copyPath, "src/main/resources/images/paper-plane.png", 4);

        delete = new JButton();
        addButtonItem(delete, "src/main/resources/images/del.png", 5);

        rename = new JButton();
        addButtonItem(rename, "src/main/resources/images/rename32.png", 6);

        createDirectory = new JButton();
        addButtonItem(createDirectory, "src/main/resources/images/Folder.png", 7);
        createDirectory.addActionListener(homeListener);

        copyLabel = new JLabel();
        addButtonLabel(copyLabel,"Копировать",0);

        insertLabel = new JLabel();
        addButtonLabel(insertLabel,"Вставить",1);

        insertTagLabel = new JLabel();
        addButtonLabel(insertTagLabel,"Вставить ярлык",2);

        cutLabel = new JLabel();
        addButtonLabel(cutLabel,"Вырезать",3);

        copyPathLabel = new JLabel();
        addButtonLabel(copyPathLabel,"Скопировать путь",4);

        deleteLabel = new JLabel();
        addButtonLabel(deleteLabel,"Удалить",5);

        renameLabel = new JLabel();
        addButtonLabel(renameLabel,"Переименовать",6);

        createDirectoryLabel = new JLabel();
        addButtonLabel(createDirectoryLabel,"Создать папку",7);
    }

    /***
     * Function of obtaining the value of the panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * The procedure for creating a button
     * @param newButton - new button
     * @param pathButtonIcon - path to the icon
     * @param gridx - column
     */
    private void addButtonItem(JButton newButton, String pathButtonIcon,int gridx){
        newButton.setIcon(new ImageIcon(pathButtonIcon));
        newButton.setBackground(Color.WHITE);
        panel.add(newButton,new GridBagConstraints(gridx,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(2,2,0,2),0,0));
    }

    /**
     * The procedure for creating a label
     * @param newLabel  - new label
     * @param nameLabel - label name
     * @param gridx - column
     */
    private void addButtonLabel(JLabel newLabel,String nameLabel, int gridx){
        newLabel.setText(nameLabel);
        newLabel.setFont(font);
        panel.add(newLabel,new GridBagConstraints(gridx,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(0,2,2,2),0,0));
    }

}