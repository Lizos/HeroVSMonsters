package com.Lisa.monsters;

abstract public class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected boolean block;

    public static GameCharacter createRegularTroll(String name) {
        return new Troll(name, 25, 3);
    }

    public static GameCharacter createBigTroll(String name) {
        return new Troll(name, 30, 4);
    }

    public static GameCharacter createSmallTroll(String name) {
        return new Troll(name, 20, 2);
    }

    public static GameCharacter createHero(String name) {
        return new Troll(name, 30, 4);
    }

    /*public String getName() {
        return name;
    }*/

    public int getHp() {
        return hp;
    }

    public boolean isBlocked() {
        return block;
    }

    public void attack(GameCharacter target) {

    }

    public void blockAction() {

    }

    public void resetBlock() {
        block = false;
    }

    public boolean isDead() {
        return false;
    }


    protected void takeHit(int damage) {
        System.out.println(name + " damaged " + ". Damage:" + damage);
    }

   /* public void resetBlock() {

    }

    protected void takeHit(int damage) {
    }*/
}