package com.sniffydn.sandbox.core.scenario.ui;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.Tool;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import javax.swing.JButton;

public class ToolRenderer extends javax.swing.JPanel {

    private Tool tool;

    /**
     * Creates new form BodyRenderer
     */
    public ToolRenderer(Tool tool) {
        this.tool = tool;
        initComponents();

        setBorder(javax.swing.BorderFactory.createTitledBorder(tool.getShortDescription()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionsPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));
        setLayout(new java.awt.BorderLayout());

        actionsPanel.setOpaque(false);
        actionsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        add(actionsPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionsPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tool
     */
    public Tool getTool() {
        return tool;
    }

    public void setPosition(FurniturePositions pos) {
        setBorder(javax.swing.BorderFactory.createTitledBorder(tool.getShortDescription() + " " + pos.toString()));
    }

    public void addAction(Action a) {
        JButton button = new JButton(a.getActionDescription());

        if(a.getActionShortDescription() != null) {
            button.setText(a.getActionShortDescription());
        }

        button.setToolTipText(a.getActionDescription() + "  " + a.getActionType());
        button.addActionListener(a.getActionListener());
        actionsPanel.add(button);
    }

}
