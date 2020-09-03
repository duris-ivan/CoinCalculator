package com.heritInternational;

import java.util.ArrayList;
import java.util.*;

public class GetMinCount {
    int coinIndex = 0;
    ArrayList<Integer> coinToPayWith = new ArrayList<>();
    /**
     * getMinCoin = method to find the minimum value among coins
     */
    public int getMinCoin(int[] coins){
        int minCoin = coins[0];
        for (int coin : coins)
            if (minCoin > coin)
                minCoin = coin;
        return minCoin;
    }

    /**
     * this method is to list the specific coins to be used to pay the entered amount
     * */
    public ArrayList<Integer> calculateCoins(int amount,int [] coins) {
        int changeLeft= amount;

    if((float) changeLeft/coins[coinIndex]>=1){ //if changeLeft is bigger than 1 after division by current coin, it means the current coin is a potential match
            changeLeft=changeLeft-coins[coinIndex]; // if yes...then subtract current coin amount from changeLeft
            if(changeLeft<getMinCoin(coins)){ //if changeLeft is smaller than the smallest coin ...
                if(changeLeft==0){ //if it is zero, than ...
                    coinToPayWith.add(coins[coinIndex]); //...add the current coin to the result
                    return coinToPayWith;
                }
                changeLeft=changeLeft+coins[coinIndex]; //...get back to the former changeLeft
                // ToDo /case input: 11€/: if som vyskusal poslednu mincu a nemam zvysok nula, vyhod mincu 8 a vyskusaj s 5tkou odznova
                if(coinIndex>=coins.length-1){ //if it is the last coin in array Coins
                    return null; //...then return the empty array / result: "no match found"
                }
                coinIndex++; //raise coinIndex and...
                calculateCoins(changeLeft,coins); //...recursion /- try with next coin
            }
            else{
                coinToPayWith.add(coins[coinIndex]);   //...add the current coin to the result
                calculateCoins(changeLeft,coins); //...recursion /- try with next coin
            }
        }
        else{
            if(coins[coinIndex]==getMinCoin(coins)){ //if the ChangeLeft is smaller than the smallest coin
                return null;    //...then return the empty array / result: "no match found"
            }
            if((float) changeLeft/coins[coinIndex]!=0){ //if the changeLeft is not equal zero
                coinIndex++; //raise coinIndex and...
                calculateCoins(changeLeft,coins); //...recursion /- try with next coin
            }
            else
                return coinToPayWith; //return the whole matching array of suitable coins
        }
        return coinToPayWith; //return the whole matching array of suitable coins8
    }

    /**
     * this method is to enumerate how many coins need to be used
     * */
    public ArrayList<Integer> getCoinToPayWith() {
        return coinToPayWith;
    }

}