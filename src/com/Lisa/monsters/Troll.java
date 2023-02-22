package com.Lisa.monsters;

import java.util.jar.JarEntry;

public class Troll extends GameCharacter {
    public Troll(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void takeHit(int damage) {
        Observer.getInstance().input(Observer.RecordType.SPEECH,name,"", 0,Resources.getLanguageBundle().getString("SpeechTrollTakeHit"));
        hp -= damage;
    }

    @Override
    public void attack(GameCharacter target) {
        Observer.getInstance().input(Observer.RecordType.SPEECH,name,"", 0,Resources.getLanguageBundle().getString("SpeechTrollAttack"));

        boolean target_blocked = target.isBlocked();

        //Damage calculation
        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.8) {
                Observer.getInstance().input(Observer.RecordType.INFO,target.getName(),"", 0," blocked the attack");
                return;
            } else {
                damage *= 2;
            }
        }
        //Hit
        target.takeHit(damage);

        Observer.getInstance().input(Observer.RecordType.ATTACK,name,target.getName(), damage,"");

    }

    @Override
    public void blockAction() {
        Observer.getInstance().input(Observer.RecordType.BLOCK,name,"", 0,Resources.getLanguageBundle().getString("SpeechTrollBlockaction"));
        hp++;
        block = true;
        Observer.getInstance().input(Observer.RecordType.INFO,name,"", 0," is trying to block next attack. Get +1 hp  ");
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    @Override
    public void resetBlock() {
        block = false;
    }


}

