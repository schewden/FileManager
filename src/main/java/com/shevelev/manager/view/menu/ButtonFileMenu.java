package com.shevelev.manager.view.menu;

import com.shevelev.manager.controller.menu.MenuMouseListener;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;

/**
 * class top pane menu
 */
public class ButtonFileMenu {
    private FileToDirectoryModel fileToDirectoryModel;

    private JMenu openNewWindows;
    private JMenuItem openCMD;
    private JMenu reference;
    private JMenuItem closeFM;
    private JMenuItem openToNewWindows;
    private JMenuItem openToNewWindowsProcess;
    private JMenuItem referenceFM;
    private JMenuItem aboutProgram;
    private Font font;

    /**
     * Constructor
     * @param menuFile - submenu "File"
     */
    public ButtonFileMenu(JMenu menuFile, FileToDirectoryModel fileToDirectoryModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;

        font = new Font("Times New Roman", Font.ITALIC, 14);

        openNewWindows = new JMenu();
        addMenuItem(menuFile,openNewWindows,"Открыть в новом окне","images/new.png");

        openToNewWindows = new JMenuItem();
        addMenuItem(openNewWindows,openToNewWindows,"Открыть в новом окне","images/add232.png");

        openToNewWindowsProcess = new JMenuItem();
        addMenuItem(openNewWindows,openToNewWindowsProcess,"Открыть в новом окне нового процесса","images/Process.png");

        openCMD = new JMenuItem();
        addMenuItem(menuFile,openCMD,"Открыть командную строку","images/Terminal.png");

        reference = new JMenu();
        addMenuItem(menuFile,reference,"Справка","images/help.png");

        referenceFM = new JMenuItem();
        addMenuItem(reference,referenceFM,"Справка","images/info32.png");

        aboutProgram = new JMenuItem();
        addMenuItem(reference,aboutProgram,"О программе", "images/Faq.png");

        closeFM = new JMenuItem();
        addMenuItem(menuFile,closeFM,"Закрыть", "images/exit.png");
    }

    /**
     * Elements of the File submenu
     * @param menuHead - submenu "File"
     * @param menuItem - submenu item
     * @param nameMenu - item name
     * @param pathFileIcon - path to the icon
     */
    private void addMenuItem(JComponent menuHead, JMenuItem menuItem, String nameMenu, String pathFileIcon){
        menuItem.setText(nameMenu);
        menuItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource(pathFileIcon)));
        menuHead.add(menuItem);
        menuItem.addActionListener(new MenuMouseListener(fileToDirectoryModel));
        menuItem.setFont(font);
    }
}
