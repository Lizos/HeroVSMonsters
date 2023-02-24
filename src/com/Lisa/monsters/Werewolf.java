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
        Log.getInstance().input(Log.RecordType.SPEECH,name,"", 0,name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfAttack"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfAttack"));

        boolean target_blocked = target.isBlocked();

        //Damage calculation

        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.7) {
                Log.getInstance().input(Log.RecordType.INFO, target.getName(),"", 0," blocked the attack");
                //System.out.println(target.getName() + " blocked the attack");
                damage = damage / 2;
            }
        }

        if (Environment.getInstance().getNight()) {
            damage *= 2;
        }


        //Hit
        target.takeHit(damage);
        Log.getInstance().input(Log.RecordType.ATTACK, name, target.getName(), damage, "");
        //System.out.println(name + " damaged " + target.getName() + ". Damage:" + damage);
    }

    @Override
    public void blockAction() {
        Log.getInstance().input(Log.RecordType.BLOCK,name,"", 0,Resources.getLanguageBundle().getString("SpeechWerewolfBlockaction"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfBlockaction"));
        hp++;
        block = true;
        Log.getInstance().input(Log.RecordType.INFO,name,"", 0," is trying to block next attack. Get +1 hp  ");
        //System.out.println(name + " is trying to block next attack. Get +1 hp  ");
    }

    @Override
    public void takeHit(int damage) {
        Log.getInstance().input(Log.RecordType.SPEECH,name,"", 0,Resources.getLanguageBundle().getString("SpeechWerewolfTakeHit"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechWerewolfTakeHit"));
        hp -= damage;
    }
}
