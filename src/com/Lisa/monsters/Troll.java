package com.Lisa.monsters;

public class Troll extends GameCharacter {
    public Troll(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void takeHit(int damage) {
        System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechTrollTakeHit"));
        hp -= damage;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechTrollAttack"));

        boolean target_blocked = target.isBlocked();

        //Damage calculation
        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.8) {
                System.out.println(target.getName() + " blocked the attack");
                return;
            } else {
                damage *= 2;
            }
        }
        //Hit
        target.takeHit(damage);

        System.out.println(name + " damaged " + target.getName() + ". Damage:" + damage);
    }

    @Override
    public void blockAction() {
        System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechTrollBlockaction"));
        hp++;
        block = true;
        System.out.println(name + " is trying to block next attack. Get +1 hp  ");
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

