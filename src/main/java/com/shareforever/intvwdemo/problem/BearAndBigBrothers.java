package com.shareforever.intvwdemo.problem;


/**
 * http://codeforces.com/contest/791/problem/A
 * Question
 * Limak and Bob weigh a and b respectively.
 * It's guaranteed that Limak's weight is smaller than or equal to his brother's weight.
 * Limak eats a lot and his weight is tripled after every year, while Bob's weight is doubled after every year.
 * 3*
 * <p>
 * After how many full years will Limak become strictly larger (strictly heavier) than Bob?
 * Bear Limak wants to become the largest of bears, or at least to become larger than his brother Bob.
 * Right now, Limak and Bob weigh a and b respectively.
 * <p>
 * https://judgecodes.blogspot.com/2020/08/791a-bear-and-big-brother-codeforces.html?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+JudgeCodes+%28Judge+Codes%29
 */
public class BearAndBigBrothers {
    public static void main(String[] args) {

        int a = 1, b = 1;
        solution(a, b);
    }

    private static void solution(int a, int b) {
        int ans = 0;
        while (a <= b) {
            a = 3 * a;
            b = 2 * b;
            ans++;
        }
        System.out.println(ans);
    }

}
