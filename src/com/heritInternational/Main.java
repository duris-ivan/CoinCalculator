package com.heritInternational;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * CODE DESCRIPTION: Calculate the minimum count of coins you need to pay for entered amount
     * ---------------------------------
     * Interview assignment of Instea company:
     * https://instea.sk/, Instea s. r. o.
     *-------------
     * DETAILS:
     * -------------
     * ...in the field coins, there are given values of coins the system uses to pay for the entered amount.
     * EXAMPLE #1:
     * ...Input: Let us assume that coins are 10€,8€,5€,2€ and the given amount is 11€.
     * ...Output: The system shall calculate the minimum amount of 4 coins (5€,2€,2€,2€) to pay for this amount
     *
     * EXAMPLE #2:
     * ...Input: Let us assume that coins are 10€,8€,5€,2€ and the given amount is 119€.
     * ...Output: The system shall calculate the minimum amount of 14 coins to pay for this amount [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 2, 2]
     *
     * EXAMPLE #3:
     * ...Input: Let us assume that coins are 1074,9,5,2€ and the given amount is 3228€.
     * ...Output: The system shall calculate the minimum amount of 6 coins to pay for this amount [1074, 1074, 1074, 2, 2, 2]
     */

    public static void main(String[] args) {
        int[] coins = new int[] {10,8,5,2};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to be changed in coins");
        int amount = sc.nextInt();
        GetMinCount coinObject = new GetMinCount();

        System.out.println("you need these coins to pay entered amount:");
        System.out.println(coinObject.calculateCoins(amount,coins) + " ");
        System.out.println("you need altogether "+ coinObject.coinToPayWith.size() + " coins to pay with " );
    }
}