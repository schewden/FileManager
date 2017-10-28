package com.shevelev.manager.view.menu;

import javax.swing.*;
import java.awt.*;

/**
 * class top pane menu
 */
public class ButtonFileMenu {

    private JMenu openNewWindows;
    private JMenu openCMD;
    private JMenu reference;
    private JMenuItem closeFM;
    private JMenuItem openToNewWindows;
    private JMenuItem openToNewWindowsProcess;
    private JMenuItem openCmdToDirectory;
    private JMenuItem openCmdToDirectoryAdmin;
    private JMenuItem referenceFM;
    private JMenuItem aboutProgram;
    private Font font;

    /**
     * Constructor
     * @param menuFile - submenu "File"
     */
    public ButtonFileMenu(JMenu menuFile) {
        font = new Font("Times New Roman", Font.ITALIC, 14);

        openNewWindows = new JMenu();
        addMenuItem(menuFile,openNewWindows,"Открыть в новом окне","src/main/resources/images/new.png");

        openToNewWindows = new JMenuItem();
        addMenuItem(openNewWindows,openToNewWindows,"Открыть в новом окне","src/main/resources/images/add232.png");

        openToNewWindowsProcess = new JMenuItem();
        addMenuItem(openNewWindows,openToNewWindowsProcess,"Открыть в новом окне нового процесса","src/main/resources/images/Process.png");

        openCMD = new JMenu();
        addMenuItem(menuFile,openCMD,"Открыть командную строку","src/main/resources/images/Terminal.png");

        openCmdToDirectory = new JMenuItem();
        addMenuItem(openCMD,openCmdToDirectory,"Открыть командную строку","src/main/resources/images/computer32.png");

        openCmdToDirectoryAdmin = new JMenuItem();
        addMenuItem(openCMD,openCmdToDirectoryAdmin,"Открыть командную строку как админ","src/main/resources/images/Admin.png");

        reference = new JMenu();
        addMenuItem(menuFile,reference,"Справка","src/main/resources/images/help.png");

        referenceFM = new JMenuItem();
        addMenuItem(reference,referenceFM,"Справка","src/main/resources/images/info32.png");

        aboutProgram = new JMenuItem();
        addMenuItem(reference,aboutProgram,"О программе", "src/main/resources/images/Faq.png");

        closeFM = new JMenuItem();
        addMenuItem(menuFile,closeFM,"Закрыть", "src/main/resources/images/exit.png");
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
        menuItem.setIcon(new ImageIcon(pathFileIcon));
        menuHead.add(menuItem);
        menuItem.setFont(font);
    }
}
