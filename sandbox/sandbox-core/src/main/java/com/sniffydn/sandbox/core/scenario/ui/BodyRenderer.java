package com.sniffydn.sandbox.core.scenario.ui;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.ScenarioListener;
import com.sniffydn.sandbox.core.scenario.Tool;
import com.sniffydn.sandbox.core.scenario.clothes.Clothes;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class BodyRenderer extends javax.swing.JPanel {

    private CommonBody body;

    /**
     * Creates new form BodyRenderer
     */
    public BodyRenderer(CommonBody body) {
        this.body = body;
        initComponents();
        updatePanel();

        ScenarioListener sl = new ScenarioListener() {

            @Override
            public void eventFired() {
            }

            @Override
            public void eventFiredCleanup() {
                updatePanel();
            }
        };
        ScenarioActionListener.addListener(sl);
    }

    private void updatePanel() {
        roomPanel.removeAll();
        actionsPanel.removeAll();
        toolsPanel.removeAll();
        wornPanel.removeAll();
        RoomRenderer roomRenderer = new RoomRenderer(body.getCurrentRoom());

        roomPanel.add(roomRenderer);

        for (Tool t : body.getTools()) {
            toolsPanel.add(new ToolRenderer(t));
        }

        for (Clothes c : body.getClothes()) {
            wornPanel.add(new ClothesRenderer(c));
        }

        if (body.getCurrentFurniture() == null) {
            furnPosLabel.setText("");
        } else {
            furnPosLabel.setText(body.getCurrentFurniturePosition() + " " + body.getCurrentFurniture().getShortDescription());
        }

        for (Action a : body.getAvailableActions()) {

            if (a.getActionType().equals(ActionType.ROOM) || a.getActionType().equals(ActionType.DOORWAY) || a.getActionType().equals(ActionType.FURNITURE)) {
                roomRenderer.addAction(a);
            } else if (a.getActionType().equals(ActionType.TOOL)) {
                boolean found = false;
                for (Component c : toolsPanel.getComponents()) {
                    if (c instanceof ToolRenderer) {
                        ToolRenderer tr = (ToolRenderer) c;
                        if (tr.getTool() == a.getCurrentTool()) {
                            found = true;
                            tr.addAction(a);
                            break;
                        }
                    }
                }

                if (!found) {
                    for (Component c : wornPanel.getComponents()) {
                        if (c instanceof ClothesRenderer) {
                            ClothesRenderer tr = (ClothesRenderer) c;
                            if (tr.getClothes()== a.getCurrentTool()) {
                                found = true;
                                tr.addAction(a);
                                break;
                            }
                        }
                    }
                    if (!found) {
                        JButton button = new JButton(a.getActionDescription());
                        button.setToolTipText(a.getActionType().toString());
                        button.addActionListener(a.getActionListener());
                        actionsPanel.add(button);
                    }
                }
            } else {
                JButton button = new JButton(a.getActionDescription());
                button.setToolTipText(a.getActionType().toString());
                button.addActionListener(a.getActionListener());
                actionsPanel.add(button);
            }

        }

        toolCarryLabel.setText(body.getCurrentToolCarry() + "");
        toolCapLabel.setText(body.getMaxToolCapacity() + "");

        StringBuilder sb = new StringBuilder("<html>");

        for (ActionType at : body.getAvailableActionTypes()) {
            sb.append(at);
            sb.append("<br/>");
        }
        sb.append("</html>");

        jTextField1.setToolTipText(sb.toString());

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                revalidate();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        rPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        furnPosLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        toolCarryLabel = new javax.swing.JLabel();
        toolCapLabel = new javax.swing.JLabel();
        wornPanel = new javax.swing.JPanel();
        toolsPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        actionsPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        rPanel.setLayout(new java.awt.GridLayout(0, 1));

        jScrollPane1.setViewportView(roomPanel);

        rPanel.add(jScrollPane1);

        jPanel1.add(rPanel, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        jTextField1.setColumns(20);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${body.name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel4.add(jTextField1);

        jPanel5.add(jPanel4);
        jPanel5.add(furnPosLabel);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        toolCarryLabel.setText("jLabel1");
        jPanel6.add(toolCarryLabel);

        toolCapLabel.setText("jLabel1");
        jPanel6.add(toolCapLabel);

        wornPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));
        jPanel6.add(wornPanel);

        jPanel5.add(jPanel6);

        jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

        toolsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tools:"));
        toolsPanel.setLayout(new java.awt.GridLayout(0, 1));
        jPanel2.add(toolsPanel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        actionsPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(actionsPanel);

        jPanel3.add(jScrollPane2);

        jSplitPane1.setRightComponent(jPanel3);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JLabel furnPosLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel rPanel;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JLabel toolCapLabel;
    private javax.swing.JLabel toolCarryLabel;
    private javax.swing.JPanel toolsPanel;
    private javax.swing.JPanel wornPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the body
     */
    public CommonBody getBody() {
        return body;
    }
}
