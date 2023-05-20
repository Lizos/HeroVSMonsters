package com.Lisa.monsters;

import java.util.Scanner;
import java.util.ArrayList;

/*interface GameUnit {
    public void takeHit(int damage);
    public void attack(GameUnit target);
    public void blockAction();
    public boolean isDead();
    public void resetBlock();
}*/

public class MonstersApp {


    private static Scanner sc = new Scanner(System.in);


    private static void showEnemies(ArrayList<GameCharacter> enemies) {
        for (GameCharacter actual_monster : enemies) {
            System.out.println(actual_monster.getName() + " hp:" + actual_monster.hp + (actual_monster.isDead() ? "Defeated" : "Active"));
        }
    }

    public static void main(String[] args) {
        String _out = "";

        Game core = new Game();

        System.out.println("1 Input: " + "EN");
        _out = core.inOut("EN");
        System.out.println("1 Output: " + _out);

        System.out.println("2 Input: " + "block");
        _out = core.inOut("block");
        System.out.println("2 Output: " + _out);

        System.out.println("3 Input: " + "attack1");
        _out = core.inOut("attack1");
        System.out.println("3 Output: " + _out);

        System.out.println("4 Input: " + "attack1");
        _out = core.inOut("attack1");
        System.out.println("4 Output: " + _out);

        //start
        /*System.out.println(hero.getName() + " Journey is beginning");
        System.out.println(hero.getName() + " is ambushed by trolls");

        System.out.println(" Battle begins... ");*/

        /*

    }
    }
         */
    }

}