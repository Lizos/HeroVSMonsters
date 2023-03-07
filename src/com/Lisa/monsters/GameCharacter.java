package com.Lisa.monsters;

abstract public class GameCharacter {
    protected String name;


    protected int hp;
    protected int attackPower;
    protected boolean block;

    abstract public void attack(GameCharacter target);


    abstract public void blockAction();

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
        return new Hero(name, 5, 3);
    }

    public static GameCharacter createWerewolf(String name) {

        return new Werewolf(name, 23, 3);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isBlocked() {

        return block;
    }


    public void resetBlock() {

        block = false;
    }

    public boolean isDead() {

        return false;
    }

    public String toJson() {
        String _tJson;
        _tJson = "{ \"name\" : \"" + this.name + "\", "  + "\"hp\" : " + this.hp + ", " + "\"attack\" : " + this.attackPower + " }";
        return _tJson;
    }


    protected void takeHit(int damage) {

        System.out.println(name + " damaged " + ". Damage:" + damage);
    }

}