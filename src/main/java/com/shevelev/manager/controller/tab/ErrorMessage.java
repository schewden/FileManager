package com.shevelev.manager.controller.tab;

import javax.swing.*;

/**
 * In this class the implementation of the output of the error on the screen
 */
public class ErrorMessage {
    private JFrame frame;

    /**
     * Constructor
     *
     * @param frame this is the frame of our application
     */
    public ErrorMessage(JFrame frame) {
        this.frame = frame;
    }


    /**
     * The procedure for out error
     *
     * @param msg      - type String, this is error message
     * @param msgTitle - name tittle message
     */
    public void errorMessagePane(String msg, String msgTitle) {
        JOptionPane.showMessageDialog(frame, msg, msgTitle, JOptionPane.ERROR_MESSAGE);
    }
}
