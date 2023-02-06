package com.Lisa.monsters;

abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected boolean block;

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isBlocked() {
        return block;
    }

}