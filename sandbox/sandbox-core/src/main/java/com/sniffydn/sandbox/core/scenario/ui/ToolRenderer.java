package com.sniffydn.sandbox.core.scenario.ui;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.furniture.FurniturePositions;
import com.sniffydn.sandbox.core.scenario.t.Tool;
import javax.swing.DefaultComboBoxModel;

public class ToolRenderer extends javax.swing.JPanel {

    private Tool tool;
    private DefaultComboBoxModel<Action> model = new DefaultComboBoxModel<>();

    /**
     * Creates new form BodyRenderer
     */
    public ToolRenderer(Tool tool) {
        this.tool = tool;
        initComponents();

        setBorder(javax.swing.BorderFactory.createTitledBorder(tool.getShortDescription()));
        jComboBox1.setModel(model);
        jComboBox1.setRenderer(new ActionListCellRenderer());
        performActionLabel.setVisible(false);

        for(Tool t: tool.getAttachedTo()) {
            attachedPanel.add(new ToolRenderer(t, true));
        }
    }

    private ToolRenderer(Tool tool, boolean dontAddAttachedTo) {
        this.tool = tool;
        initComponents();

        setBorder(javax.swing.BorderFactory.createTitledBorder(tool.getShortDescription()));
        jComboBox1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        attachedPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        performActionLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));
        setLayout(new java.awt.BorderLayout());

        attachedPanel.setOpaque(false);
        attachedPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        add(attachedPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);

        performActionLabel.setText("<");
        performActionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                performActionLabelMousePressed(evt);
            }
        });
        jPanel1.add(performActionLabel);

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void performActionLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_performActionLabelMousePressed
        Action a = (Action) jComboBox1.getSelectedItem();
        a.getActionListener().actionPerformed();
    }//GEN-LAST:event_performActionLabelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attachedPanel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel performActionLabel;
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
        model.addElement(a);
        performActionLabel.setVisible(true);
//
//        JButton button = new JButton(a.getActionDescription());
//
//        if(a.getActionShortDescription() != null) {
//            button.setText(a.getActionShortDescription());
//        }
//
//        button.setToolTipText(a.getActionDescription() + "  " + a.getActionType());
//        button.addActionListener(a.getActionListener());
//        actionsPanel.add(button);
    }
}
