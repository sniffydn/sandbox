/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sniffydn.sandbox.core;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Test extends JFrame {

    private JTable table;
    private TableModel tableModel;

    public Test() {
        tableModel = new DefaultTableModel(5, 5);

        table = new JTable(tableModel);
        table.setColumnSelectionAllowed(true);

        getContentPane().add(table);

        Action handleEnter = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                table.getCellEditor().stopCellEditing(); // store user input
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                String val = String.valueOf(table.getValueAt(row, col)).toLowerCase();
                if (val.equals("u"))
                    --row;
                else if (val.equals("d"))
                    ++row;
                else if (val.equals("l"))
                    --col;
                else if (val.equals("r"))
                    ++col;
                if (     row >= 0 && row < tableModel.getRowCount()
                      && col >= 0 && col < tableModel.getColumnCount()) {
                    table.changeSelection(row, col, false, false);
                    table.editCellAt(row, col);
                }
            }
        };
        // replace action for ENTER, since next row would be selected automatically
        table.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "handleEnter");
        table.getActionMap().put("handleEnter", handleEnter);
    }

    public static void main(String[] args) {
//        Test test = new Test();
//        test.setSize(800, 600);
//        test.setVisible(true);

        File logFileFolder = new File("C:\\temp\\lynx-messaging-services\\Logs\\");
                        if (logFileFolder.isDirectory()) {
                            for (File log : logFileFolder.listFiles()) {
//                                System.out.println(log.getName());
                                if(log.getName().endsWith(".log") && log.lastModified() < System.currentTimeMillis() - 7 * 86400000) {
//                                    System.out.println("    delete");
                                    log.delete();
                                }
                            }
                        }
    }
}