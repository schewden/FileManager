package com.shevelev.manager.controller.tab;

import javax.swing.*;

/**
 * Created by denis on 21.11.17.
 */
public class ErrorMessage {
    private JFrame frame;

    public ErrorMessage(JFrame frame){
        this.frame = frame;
    }

    public void errorMessagePane(String msg, String msgTittle){
        JOptionPane.showMessageDialog(frame,msg,msgTittle,JOptionPane.ERROR_MESSAGE);
    }
}
