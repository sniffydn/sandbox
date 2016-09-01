package com.sniffydn.sandbox.core.scenario.ui;

import com.sniffydn.sandbox.core.scenario.Action;
import com.sniffydn.sandbox.core.scenario.ActionType;
import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.Doorway;
import com.sniffydn.sandbox.core.scenario.Room;
import com.sniffydn.sandbox.core.scenario.ScenarioActionListener;
import com.sniffydn.sandbox.core.scenario.ScenarioListener;
import com.sniffydn.sandbox.core.scenario.furniture.Furniture;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RoomRenderer extends javax.swing.JPanel {

    private Room room;

    /**
     * Creates new form BodyRenderer
     */
    public RoomRenderer(Room room) {
        this(room, false);
    }

    public RoomRenderer(Room room, boolean addScenarioListener) {
        this.room = room;
        initComponents();

        updatePanel();

        if (addScenarioListener) {
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
        jPanel5.setVisible(false);
    }

    private void updatePanel() {
        doorwaysPanel.removeAll();
        furniturePanel.removeAll();
        bodiesPanel.removeAll();

        for (Furniture furn : room.getFurniture()) {
            furniturePanel.add(new FurnitureRenderer(furn));
        }
        for (Doorway dw : room.getDoorways()) {
            Room r = dw.getRoom1();
            if (r == room) {
                r = dw.getRoom2();
            }
            String locked = "";
            if (dw.isDoorLocked()) {
                locked = " locked";
            }
            String oneWay = "";
            if (dw.isOneWayDoorway()) {
                oneWay = " one way";
            }
            String closed = "";
            if (!dw.isDoorOpen()) {
                closed = " Closed";
            }
            doorwaysPanel.add(new JLabel(r.getShortDescription() + closed + locked + oneWay));
        }

        for (CommonBody body : room.getBodies()) {
            bodiesPanel.add(new JLabel(body.getName()));
        }

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

        furnPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        furniturePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        doorwaysPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(80, 0), new java.awt.Dimension(60, 32767));
        roomChangeActionsPanel = new javax.swing.JPanel();
        bodiesPanel = new javax.swing.JPanel();
        roomActionsPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.BorderLayout());

        furnPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Furniture:"));
        furnPanel.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setViewportView(furniturePanel);

        furnPanel.add(jScrollPane1);

        add(furnPanel, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Short:");
        jPanel1.add(jLabel1);

        jTextField1.setColumns(20);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${room.shortDescription}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jTextField1);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jPanel3.add(jPanel1, java.awt.BorderLayout.NORTH);

        jLabel2.setText("Long:");
        jPanel5.add(jLabel2);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${room.longDescription}"), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(jTextArea1);

        jPanel5.add(jScrollPane2);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout());

        doorwaysPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Doorways:"));
        doorwaysPanel.setLayout(new java.awt.GridLayout(0, 1));
        jPanel4.add(doorwaysPanel, java.awt.BorderLayout.CENTER);
        jPanel4.add(filler1, java.awt.BorderLayout.PAGE_START);

        roomChangeActionsPanel.setLayout(new java.awt.GridLayout(0, 1));
        jPanel4.add(roomChangeActionsPanel, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        bodiesPanel.setLayout(new java.awt.GridLayout(0, 1));
        jPanel2.add(bodiesPanel, java.awt.BorderLayout.WEST);

        add(jPanel2, java.awt.BorderLayout.NORTH);
        add(roomActionsPanel, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel5.setVisible(!jPanel5.isVisible());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                revalidate();
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodiesPanel;
    private javax.swing.JPanel doorwaysPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel furnPanel;
    private javax.swing.JPanel furniturePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel roomActionsPanel;
    private javax.swing.JPanel roomChangeActionsPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    public void addAction(Action a) {
        if (a.getActionType().equals(ActionType.ROOM)) {
            boolean found = false;

            for (Component c : furniturePanel.getComponents()) {
                if (c instanceof FurnitureRenderer) {
                    FurnitureRenderer fr = (FurnitureRenderer) c;
                    if (fr.getFurniture()== a.getCurrentFurniture()) {
                        found = true;
                        fr.addAction(a);
                        break;
                    }
                }
            }
            if (!found) {
                JButton button = new JButton(a.getActionDescription());
                button.setToolTipText(a.toString());
                button.addActionListener(a.getActionListener());
                roomActionsPanel.add(button);
            }
        } else if (a.getActionType().equals(ActionType.DOORWAY)) {
            JButton button = new JButton(a.getActionDescription());
            button.setToolTipText(a.getActionType().toString());
            button.addActionListener(a.getActionListener());
            roomChangeActionsPanel.add(button);
        } else if (a.getActionType().equals(ActionType.FURNITURE)) {
            boolean found = false;
            for (Component c : furniturePanel.getComponents()) {
                if (c instanceof FurnitureRenderer) {
                    FurnitureRenderer fr = (FurnitureRenderer) c;
                    if (fr.getFurniture() == a.getCurrentFurniture()) {
                        found = true;
                        fr.addAction(a);
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("NOT FOUND: " + a.getActionType() + "  " + a.getActionDescription());
            }
        } else {
            System.out.println(this.getClass().getSimpleName() + " deal with " + a);
        }
    }

}
