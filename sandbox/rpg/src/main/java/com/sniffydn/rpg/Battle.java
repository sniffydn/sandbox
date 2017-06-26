package com.sniffydn.rpg;

public class Battle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Character c1 = new Character();
        Character c2 = new Character();
        Battle battle = new Battle(c1, c2);
    }

    Character first;
    Character second;

    private Battle(Character first, Character second) {
        this.first = first;
        this.second = second;
    }
}
