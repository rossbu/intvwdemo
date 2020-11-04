package com.shareforever.intvwdemo.problem;

import java.util.HashMap;
import java.util.Scanner;

public class MoneyChanges {
    /**
     *
     */
    public static void main(String[] args) {
        minusAmount();
//        divideAmount();
    }


    /*
        I am stupid , so I do below in the first INTW
     */
    private static void minusAmount() {
        Integer[] bills = new Integer[]{10, 5, 1};
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int paid = 100;
        int price = 81;
        int change = paid - price;
        int amount = 0;

        while (amount < change) {
            amount += bills[0];
            if (amount == change) {
                hashMap.put(bills[0], hashMap.getOrDefault(bills[0], 0) + 1);
                break;
            }
            if (amount > change) {
                amount = amount - bills[0];
                break;
            }
            hashMap.put(bills[0], hashMap.getOrDefault(bills[0], 0) + 1);
        }


        while (amount < change) {
            amount += bills[1];
            if (amount == change) {
                hashMap.put(bills[1], hashMap.getOrDefault(bills[1], 0) + 1);
                break;
            }
            if (amount > change) {
                amount = amount - bills[1];
                break;
            }
            hashMap.put(bills[1], hashMap.getOrDefault(bills[1], 0) + 1);
        }

        while (amount < change) {
            amount += bills[2];
            if (amount == change) {
                hashMap.put(bills[2], hashMap.getOrDefault(bills[2], 0) + 1);
                break;
            }
            if (amount > change) {
                amount = amount - bills[2];
                break;
            }
            hashMap.put(bills[2], hashMap.getOrDefault(bills[2], 0) + 1);
        }

        System.out.println(hashMap);

    }

    private static void divideAmount() {
        int price = 89 * 100;   // turn to cents/pennies to calculate.
        int provided = 100 * 100;
        int change = 0;
        if (provided > price) {
            System.out.println("The customer should be given the change as follows:");
            change = provided - price;
            // Since you multiplied by 100 you have to divide by 2000 to get the number of twenties for change.
            // if  == 0 go to next, or if >0 into if get remainder and go to next.
            int twenties = change / 2000;
            if (twenties > 0) {     // if the change is less than $20 this will be a zero
                change = change % 2000; // this resets the value of change to the remainder after the twenties are calculated but only if there was at least enough to make one twenty
                System.out.println(twenties + " $20 bill(s)");
            }

            int tens = change / 1000;
            if (tens > 0) {
                change = change % 1000;
                System.out.println(tens + " $10 bill(s)");
            }

            int fives = change / 500;  // 549
            if (fives > 0) {
                change = change % 500;
                System.out.println(fives + " $5 bill(S)");
            }

            int ones = change / 100;
            if (ones > 0) {
                change = change % 100;
                System.out.println(ones + " $1 bill(s)");
            }

            int quarters = change / 25;
            if (quarters > 0) {
                change = change % 25;
                System.out.println(quarters + " quarter coin(s)");
            }
            int dimes = change / 10;
            if (dimes > 0) {
                change = change % 10;
                System.out.println(dimes + " dime coin(s)");
            }

            int nickels = change / 5;
            if (nickels > 0) {
                change = change % 5;
                System.out.println(nickels + " nickel coin(s)");
            }
            int pennies = change;
            System.out.println(pennies + " penny coin(s)");
        }
        if (provided < price) {  // this statement is saying that if the customer doesn't pay enough, it will tell the user
            System.out.print("Not enough money!");
        } else if (provided == price) { // this statement says if the amount provided matches the price, then there is no change necessary
            System.out.print("No change is necessary!");
        }
    }
}
