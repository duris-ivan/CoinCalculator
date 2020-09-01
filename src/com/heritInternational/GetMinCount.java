package com.heritInternational;

import java.util.ArrayList;
import java.util.*;

public class GetMinCount {
    int coinIndex = 0;
    ArrayList<Integer> coinToPayWith = new ArrayList<Integer>();
    /**
     * getMinCoin = method to find the minimum value among coins
     */
    public int getMinCoin(int[] coins){
        int minCoin = coins[0];
        for(int i=0;i<coins.length;i++)
            if(minCoin>coins[i])
                minCoin=coins[i];
        return minCoin;
    }

    /**
     * this method is to list the specific coins to be used to pay the entered amount
     * */
    public ArrayList<Integer> calculateCoins(int amount,int [] coins) {
        int changeLeft= amount;

        if((float) changeLeft/coins[coinIndex]>=1){
            changeLeft=changeLeft-coins[coinIndex];
            if(changeLeft<getMinCoin(coins)){
                if(changeLeft==0){
                    coinToPayWith.add(coins[coinIndex]);
                    return coinToPayWith;
                }
                changeLeft=changeLeft+coins[coinIndex];
                if(coinIndex>=coins.length-1){
                    //coinToPayWith.add(1);
                    return null;
                }
                coinIndex++;
                calculateCoins(changeLeft,coins);
            }
            else{
                coinToPayWith.add(coins[coinIndex]);
                calculateCoins(changeLeft,coins);
            }
        }
        else{
            if(coins[coinIndex]==getMinCoin(coins)){
                return null;
            }
            if((float) changeLeft/coins[coinIndex]!=0){
                coinIndex++;
                calculateCoins(changeLeft,coins);
            }
            else
                return coinToPayWith;
        }
        return coinToPayWith;
    }

    /**
     * this method is to enumerate how many coins need to be used
     * */
    public ArrayList<Integer> getCoinToPayWith() {
        return coinToPayWith;
    }

}