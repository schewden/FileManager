package com.shevelev.manager.view.menu;

import org.openide.awt.DropDownButtonFactory;

import javax.swing.*;
import java.awt.*;

/**
 * class of the tab view
 */
public class TabViewPanel {
    private JPanel panel;
    private JButton largeIcons;
    private JButton listIcons;
    private JButton tablIcons;
    private JButton dropDownButton;
    private JLabel largeIconsLabel;
    private JLabel listIconsLabel;
    private JLabel tablIconsLabel;
    private JLabel dropDownButtonLabel;
    private JToolBar toolbarDropDown;
    private JPopupMenu popupMenuButton;
    private JMenuItem sortingName;
    private JMenuItem sortingType;
    private JMenuItem sortingDate;
    private JMenuItem sortingSize;
    private Font font;

    /**
     * Constructor
     */
    public TabViewPanel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        font = new Font("Times New Roman", Font.ITALIC, 11);
        toolbarDropDown = new JToolBar();

        largeIcons = new JButton();
        addButtonItem(largeIcons,"src/main/resources/images/binoculars_32.png",0);
        listIcons = new JButton();
        addButtonItem(listIcons,"src/main/resources/images/Text-columns32.png",1);
        tablIcons = new JButton();
        addButtonItem(tablIcons,"src/main/resources/images/ordering32.png",2);

        largeIconsLabel = new JLabel();
        addButtonLabel(largeIconsLabel,"Крупный значок",0);
        listIconsLabel = new JLabel();
        addButtonLabel(listIconsLabel,"Список",1);
        tablIconsLabel = new JLabel();
        addButtonLabel(tablIconsLabel,"Таблица",2);
        dropDownButtonLabel = new JLabel();
        addButtonLabel(dropDownButtonLabel,"Сортировать",3);

        addDropDownButton();
        panel.add(toolbarDropDown);
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
        panel.add(newButton,new GridBagConstraints(gridx,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(1,1,1,1),0,0));
    }

    /**
     * The procedure for creating a drop-down button
     */
    private void addDropDownButton(){
        popupMenuButton = new JPopupMenu();
        dropDownButton = DropDownButtonFactory.createDropDownButton(new ImageIcon("src/main/resources/images/sortascend32.png"), popupMenuButton);
        addMenuItem(popupMenuButton,sortingName,"Имя");
        addMenuItem(popupMenuButton,sortingType,"Тип");
        addMenuItem(popupMenuButton,sortingDate,"Дата создания");
        addMenuItem(popupMenuButton,sortingSize,"Размер");
        toolbarDropDown.add(dropDownButton);
    }

    /**
     * The procedure for creating a button
     * @param menuHead - component
     * @param menuItem - menu item
     * @param nameMenu - menu item name
     */
    private void addMenuItem(JComponent menuHead, JMenuItem menuItem, String nameMenu){
        menuItem = new JMenuItem();
        menuItem.setText(nameMenu);
        menuHead.add(menuItem);
        menuItem.setFont(font);
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
        panel.add(newLabel,new GridBagConstraints(gridx,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(1,1,1,1),0,0));
    }
}
