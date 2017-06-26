package com.sniffydn.rpg;

public class Character {
    private int hp = 10;
    private int attack = 2;
    private int defense = 1;
    private int mgAttack = 10;
    private int mgDefense = 5;
    private int speed = 1;

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * @return the mgAttack
     */
    public int getMgAttack() {
        return mgAttack;
    }

    /**
     * @param mgAttack the mgAttack to set
     */
    public void setMgAttack(int mgAttack) {
        this.mgAttack = mgAttack;
    }

    /**
     * @return the mgDefense
     */
    public int getMgDefense() {
        return mgDefense;
    }

    /**
     * @param mgDefense the mgDefense to set
     */
    public void setMgDefense(int mgDefense) {
        this.mgDefense = mgDefense;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
