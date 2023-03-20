package com.snakeandladder.snakeandladder.util;

import java.util.Random;

public class Dice {
    public synchronized static int roll() {
        Random rand = new Random();
        int min = 1;
        int max = 6;
        return rand.nextInt((max - min) + 1) + min;
    }
}
