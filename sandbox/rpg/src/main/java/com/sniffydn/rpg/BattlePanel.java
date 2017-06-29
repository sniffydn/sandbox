package com.sniffydn.rpg;

import java.util.ArrayList;
import java.util.List;

public class BattlePanel extends javax.swing.JPanel {

    List<Character> homeCharacters;
    List<Character> awayCharacters;

    List<Character> allCharacters;
    private Character currentCharacter;
    boolean battleFinished = false;

    /**
     * Creates new form BattlePanel
     *
     * @param homeCharacters
     * @param awayCharacters
     */
    public BattlePanel(List<Character> homeCharacters,
            List<Character> awayCharacters) {
        this.homeCharacters = homeCharacters;
        this.awayCharacters = awayCharacters;
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

        homePanel = new javax.swing.JPanel();
        currentTurnPanel = new javax.swing.JPanel();
        awayPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        homePanel.setLayout(new java.awt.GridLayout(0, 1));
        add(homePanel, java.awt.BorderLayout.WEST);

        currentTurnPanel.setLayout(new java.awt.GridLayout(0, 1));
        add(currentTurnPanel, java.awt.BorderLayout.CENTER);

        awayPanel.setLayout(new java.awt.GridLayout(0, 1));
        add(awayPanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel awayPanel;
    private javax.swing.JPanel currentTurnPanel;
    private javax.swing.JPanel homePanel;
    // End of variables declaration//GEN-END:variables

    private void postInitComponents() {
        allCharacters = new ArrayList<>();

        for (Character c : homeCharacters) {
            allCharacters.add(c);
            homePanel.add(new CharacterPanel(c));
        }
        for (Character c : awayCharacters) {
            allCharacters.add(c);
            awayPanel.add(new CharacterPanel(c));
        }

        nextTurn();
    }

    private void nextTurn() {
        checkForEnd();
        if (!battleFinished) {
            while (currentCharacter == null) {
                for (Character c : allCharacters) {
                    if (c.getHp() == 0) {
                        continue;
                    }
                    c.setSpeedCurrentCounter(c.getSpeedCurrentCounter() + 1);
                    if (c.getSpeed() == c.getSpeedCurrentCounter()) {
                        currentCharacter = c;
                        break;
                    }
                }
            }
            currentTurnPanel.removeAll();
            CharacterBattlePanel cbp = new CharacterBattlePanel(currentCharacter, homeCharacters, awayCharacters) {

                @Override
                protected void finishedTurn() {
                    nextTurn();
                }
            };
            currentTurnPanel.add(cbp);
        }
    }

    private void checkForEnd() {
        boolean alive = false;
        for (Character c : homeCharacters) {
            if (c.getHp() > 0) {
                alive = true;
                break;
            }
        }
        if (!alive) {
            battleFinished = true;
        }

        alive = false;
        for (Character c : awayCharacters) {
            if (c.getHp() > 0) {
                alive = true;
                break;
            }
        }
        if (!alive) {
            battleFinished = true;
        }
    }
}
