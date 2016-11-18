
package com.sniffydn.sandbox.core.sn.ui;

import com.sniffydn.sandbox.core.sn.Step;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dnyffeler
 */
public class SnMain extends javax.swing.JFrame {

    /**
     * Creates new form SnMain
     */
    public SnMain() {
        initComponents();
        postInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SnMain().setVisible(true);
            }
        });



        List<Step> allSteps = new ArrayList<>();























        Step parentStep = new Step();

        Step subStep1 = new Step();
        subStep1.setPrefixText("");
        subStep1.setSuffixText("");
        allSteps.add(subStep1);

        Step subStep2 = new Step();
        subStep2.setPrefixText("");
        subStep2.setSuffixText("");
        allSteps.add(subStep2);

        Step subStep3 = new Step();
        subStep3.setPrefixText("");
        subStep3.setSuffixText("");
        allSteps.add(subStep3);

        Step subStep4 = new Step();
        subStep4.setPrefixText("");
        subStep4.setSuffixText("");
        allSteps.add(subStep4);

        Step subStep5 = new Step();
        subStep4.setPrefixText("");
        subStep4.setSuffixText("");
        allSteps.add(subStep5);


//        subStep4.print();
//        Tool tool1 = new Tool();
//        tool1.setLongDescription("Tool Long Description");
//        tool1.setShortDescription("Short Description");
//
//        Document doc = new Document();


        parentStep.print();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void postInitComponents() {
       add(new StepPanel());
       pack();
    }
}
