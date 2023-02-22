package com.Lisa.monsters;

public class Werewolf extends GameCharacter {
    //private boolean _isWolf = false;

    public Werewolf(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void attack(GameCharacter target) {
        Observer.getInstance().input(Observer.RecordType.SPEECH,name,"", 0,name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfAttack"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfAttack"));

        boolean target_blocked = target.isBlocked();

        //Damage calculation

        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.7) {
                Observer.getInstance().input(Observer.RecordType.INFO, target.getName(),"", 0," blocked the attack");
                //System.out.println(target.getName() + " blocked the attack");
                damage = damage / 2;
            }
        }

        if (Environment.getInstance().getNight()) {
            damage *= 2;
        }


        //Hit
        target.takeHit(damage);
        Observer.getInstance().input(Observer.RecordType.ATTACK, name, target.getName(), damage, "");
        //System.out.println(name + " damaged " + target.getName() + ". Damage:" + damage);
    }

    @Override
    public void blockAction() {
        Observer.getInstance().input(Observer.RecordType.BLOCK,name,"", 0,Resources.getLanguageBundle().getString("SpeechWerewolfBlockaction"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfBlockaction"));
        hp++;
        block = true;
        Observer.getInstance().input(Observer.RecordType.INFO,name,"", 0," is trying to block next attack. Get +1 hp  ");
        //System.out.println(name + " is trying to block next attack. Get +1 hp  ");
    }

    @Override
    public void takeHit(int damage) {
        Observer.getInstance().input(Observer.RecordType.SPEECH,name,"", 0,Resources.getLanguageBundle().getString("SpeechWerewolfTakeHit"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfTakeHit"));
        hp -= damage;
    }
}
