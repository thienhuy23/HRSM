/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class MsgBox {

    /**
     * @param parent
     * @param message
     */
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Training Management System", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * @param parent
     * @param message
     * @return 
     */
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,"Training Management System",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    /**
     *
     * @param parent 
     * @param message
     * @return
     */
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "Training Management System", JOptionPane.INFORMATION_MESSAGE);
    }

}
