package com.play.onepiece;

import java.util.Scanner;
class Character {
    public int lifePoints = 0;
    public int attackStat = 0;
    public int defenseStat = 0;
    public int stamina = 0;

    Scanner sc = new Scanner(System.in);

    public Character(int lifePoint, int attackStat, int defenseStat, int stamina) {
        this.lifePoints = lifePoint;
        this.attackStat = attackStat;
        this.defenseStat = defenseStat;
        this.stamina = stamina;
    }

    public void startAttack(Character enemy, int modifier, int stamina) {
        enemy.setLifePoints(enemy.lifePoints - this.attackStat*modifier/enemy.defenseStat);
        this.stamina -= stamina;
    }

    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int newLifePoints) {
        lifePoints = newLifePoints;
    }
}