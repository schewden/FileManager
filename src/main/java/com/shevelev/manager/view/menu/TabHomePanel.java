package com.shevelev.manager.view.menu;

import com.shevelev.manager.controller.tab.*;
import com.shevelev.manager.model.InsertModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelByDirectory;
import com.shevelev.manager.view.PanelTree;
import org.openide.awt.DropDownButtonFactory;

import javax.swing.*;
import java.awt.*;

/**
 * class of the tab home
 */
public class TabHomePanel {
    private JPanel panel;
    private JButton insert;
    private JButton cut;
    private JButton copyPath;
    private JButton delete;
    private JButton rename;
    private JButton createDirectory;
    private JButton dropDownButton;

    private JLabel copyLabel;
    private JLabel insertLabel;
    private JLabel cutLabel;
    private JLabel copyPathLabel;
    private JLabel deleteLabel;
    private JLabel renameLabel;
    private JLabel createDirectoryLabel;
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
    public TabHomePanel(JFrame frame, FileToDirectoryModel fileToDirectoryModel, PanelTree panelTree, DisplayUsers displayUsers, PanelByDirectory panelByDirectory, InsertModel insertModel) {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        font = new Font("Times New Roman", Font.ITALIC, 11);

        JButton copy = new JButton();
        addButtonItem(copy, "src/main/resources/images/copy.png", 0);
        copy.addActionListener(new TabHomeCopyListener(fileToDirectoryModel, insertModel, displayUsers));

        insert = new JButton();
        addButtonItem(insert, "src/main/resources/images/documents32.png", 1);
        insert.addActionListener(new TabHomeInsertListener(fileToDirectoryModel,panelByDirectory,panelTree,displayUsers, insertModel));

        cut = new JButton();
        addButtonItem(cut, "src/main/resources/images/cut.png", 2);
        cut.addActionListener(new TabHomeCutListener(fileToDirectoryModel, insertModel,displayUsers));

        copyPath = new JButton();
        addButtonItem(copyPath, "src/main/resources/images/paper-plane.png", 3);
        copyPath.addActionListener(new TabHomeCopyPathListener(fileToDirectoryModel, insertModel));

        /*с этого места*/
        delete = new JButton();
        addButtonItem(delete, "src/main/resources/images/del.png", 4);
        delete.addActionListener(new TabHomeDeleteListener(frame, fileToDirectoryModel,panelTree,displayUsers));

        rename = new JButton();
        addButtonItem(rename, "src/main/resources/images/rename32.png", 5);
        rename.addActionListener(new TabHomeRenameListener(frame, fileToDirectoryModel,panelTree,displayUsers));

        createDirectory = new JButton();
        addButtonItem(createDirectory, "src/main/resources/images/Folder.png", 6);
        createDirectory.addActionListener(new TabHomeAddListener(frame, fileToDirectoryModel,panelTree,displayUsers));


        toolbarDropDown = new JToolBar();
        addDropDownButton(toolbarDropDown);


        copyLabel = new JLabel();
        addButtonLabel(copyLabel,"Копировать",0);

        insertLabel = new JLabel();
        addButtonLabel(insertLabel,"Вставить",1);

        cutLabel = new JLabel();
        addButtonLabel(cutLabel,"Вырезать",2);

        copyPathLabel = new JLabel();
        addButtonLabel(copyPathLabel,"Скопировать путь",3);

        deleteLabel = new JLabel();
        addButtonLabel(deleteLabel,"Удалить",4);

        renameLabel = new JLabel();
        addButtonLabel(renameLabel,"Переименовать",5);

        createDirectoryLabel = new JLabel();
        addButtonLabel(createDirectoryLabel,"Создать папку",6);

        dropDownButtonLabel = new JLabel();
        addButtonLabel(dropDownButtonLabel,"Сортировать",7);

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

    /**
     * The procedure for creating a drop-down button
     * @param newToolBar new JToolBar
     */
    private void addDropDownButton(JToolBar newToolBar){
        newToolBar.setFloatable(false);
        popupMenuButton = new JPopupMenu();
        dropDownButton = DropDownButtonFactory.createDropDownButton(new ImageIcon("src/main/resources/images/sortascend32.png"), popupMenuButton);
        addMenuItem(popupMenuButton,sortingName,"Имя");
        addMenuItem(popupMenuButton,sortingType,"Тип");
        addMenuItem(popupMenuButton,sortingDate,"Дата создания");
        addMenuItem(popupMenuButton,sortingSize,"Размер");
        newToolBar.add(dropDownButton);
        panel.add(newToolBar,new GridBagConstraints(7,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(2,2,0,2),0,0));

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
}
