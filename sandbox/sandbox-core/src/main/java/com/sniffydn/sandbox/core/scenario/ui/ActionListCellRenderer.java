package com.sniffydn.sandbox.core.scenario.ui;

import com.sniffydn.sandbox.core.scenario.Action;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class ActionListCellRenderer implements ListCellRenderer {

    JLabel label = new JLabel();

    public ActionListCellRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Action) {
            Action a = ((Action) value);
            if (a.getActionShortDescription() != null) {
                label.setText(a.getActionShortDescription());
            } else {
                label.setText(a.getActionDescription());
            }
            label.setToolTipText(a.getActionDescription());

        } else {
            if (value == null) {
                label.setText("null");
                label.setToolTipText(null);
            } else {
                label.setText(value.getClass().getSimpleName());
                label.setToolTipText(null);
            }
        }

        return label;
    }

}
