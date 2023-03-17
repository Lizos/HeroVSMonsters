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
        String out = "";

        Game core = new Game();

        System.out.println("1 Input: " + "EN");
        out = core.inOut("EN");
        System.out.println("1 Output: " + out);

        System.out.println("2 Input: " + "block");
        out = core.inOut("block");
        System.out.println("2 Output: " + out);

        System.out.println("3 Input: " + "attack1");
        out = core.inOut("attack1");
        System.out.println("3 Output: " + out);

        System.out.println("4 Input: " + "attack1");
        out = core.inOut("attack1");
        System.out.println("4 Output: " + out);

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