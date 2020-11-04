package com.shareforever.intvwdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

;

public class WarmUp {
    public static void main(String[] args) {
        // testcases
        String[] testcases = new String[]{"abcd", null, "", "aaaa", "abcaaa","a","abc"};

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------ LET'S WARM UP ---------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        // is num has a square foot
        System.out.println("num 4: " + isSquare(4));


        // even : print 1  ,   Odd : print 0 ;
        String result11 = evenOneOddZero(5);
        System.out.println("evenOneOddZero : " + result11);

        // int[] to Integer[] ,  Integer[] to int[]
        int[] arr2 = new int[]{54, 432, 53, 21, 43, 12, 45, 11, 10, 9};
        int[] sameArr2 = intToIntegerThenToInt(arr2);

        // isAllSame
        for (String s : testcases) {
            boolean isUnique = isAllSame(s);
            System.out.println(s + " : " + isUnique);
        }

        // isAllUnique
        for (String s : testcases) {
            boolean isUnique = isAllUnique(s);
            System.out.println(s + " : " + isUnique);
        }

        // fizzbuzz  -- warmup your fingers =  divisible by 3 fizz, divisible by 5 : fuzz,  divisible by 3 and 5 then fizzbuzz
        fizzbuzz();

        // Fibonacci  0,1,1,2,3,5,8... -- PUB -- fib(0) = 0, fib(1) = 1, fib(2) = 1
        int result = fibRecursive(10);
        System.out.println("fib:" + result);

        // Fibonacci Recursive  3 vars :  PP, P, C  ( prevprev, prev and current in for loop)
        result = fibIterative(10);
        System.out.println("fibRecurisve:" + result);

        // factorial  5*4*3*2*1
        int factorial = factorial(6);
        factorial = factorialIterative(6);
        System.out.println("factorial:" + factorial);

        // reverse xyzu to uzyx with recursive method -- PUB
        String test = "xyzu";
        String teststr = reverse(test);
        System.out.println("reverse:" + teststr);

        // reverse int[] array
        int[] arr3 = new int[]{54, 432, 53, 21, 43, 12, 45, 11, 10, 9};
        reverseIntArray(arr3);

        // reverse int value like 12345  to 54321 without using array
        int originalInt = 1234;
        int reversedNumber = reverseIntNumber(originalInt);

        // reverse a number recursively
        int ans = 0;
        ans =  reverseIntNumberRecursively(originalInt,ans);
        System.out.println(ans);



        // power calculation
        powerMe(3, 5);

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------  Midium level ---------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");


        // find the Kth highest   -- PUB bank
        int[] arr1 = {40, 2, 12, 34, 3, 44, 4, 41, 11, 10, 50, 40, 50};
        int kthHighestNum = findKthHighestNum(arr1, 3);
        System.out.println("kth highest num:" + kthHighestNum + "\t");

        // find k-most  -- attentive (first interview)
        String frestr = "cat cat dog cat cat dog fish dog frog fish bird cat";
        printkMostFrequent(frestr, 2);

        // find smallest and largest from int array
        int[] intArrays = new int[]{-20, 34, 21, -87, 92, Integer.MAX_VALUE};
        printSmallestAndLargest(intArrays);

        // find the missing integer from 1 to 100 integer arrays ( no duplicates )
        findOneMissingNumberInConsecutiveArray();

        // find intersection of 2 arrays
        int[] arra = {21, 34, 41, 22, 35};
        int[] arrb = {61, 34, 45, 21, 11, 456, 22};
        int output[] = intersection(arra, arrb);
        for (int i : output) {
            System.out.println("s:" + i);
        }

        /*
         find the missing string Ex -
            String one - "This is an example"   ;  String two - "is example"
            answer - This, an
            brute force : 2 loop with flag and put in another array: https://www.w3resource.com/java-exercises/basic/java-basic-exercise-190.php
        */
        String src = "This is an example";
        String target = "is example";
        String missingString = findMissingString(src, target);
        System.out.println(missingString);

        // occurrences of a target substring in a string. return a list of starting indexes e.g. ( 1, 5, 10)   means 'cat' starts at 1 , 5 and 7.
        String occurrenceStr = "cat cat dog cat dog seal cat";
        List<Integer> listOfIdx = occurrencesIndexes(occurrenceStr, "cat");
        listOfIdx.forEach(System.out::println);


        // return int[] for elements appears more than 1 in the original array
        int[] intArray = new int[]{1, 2, 3, 4, 4, 6, 6};
        int[] resultArray = countDuplicate(intArray);

        // reverse chars  -- yangyang
        char[] chars = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        reverse(chars);

        // permutation : print all permutation: XYZ, XZY, YXZ, YZX, ZXY,ZYX.  -- Teksystem
        String s = "XYZ";
        permutation(s, "");

        // find non repeating chars
        String nrc1 = "ababyabj,cdeded";
        char c = findFirstNonRepeating(nrc1);
        System.out.println(c);

        // replace string by string
        String replaceStr = "Java is Great Java is try again is no.";
        String newString = replaceStr.replace(" ", "20%");  // this would replace all occurrences.
        System.out.println(newString);

        // replace char by char
        String newone = replace(replaceStr, 'i', 'o');
        System.out.println(newone);

        // replace string with another string.
        String contents = "Tutorials point is not working, Tutorials point is down";
        contents = contents.replaceAll("\\bTutorials point\\b", "TP");
        System.out.println(contents);

        // Palindrome String  radar and radar
        System.out.println("is radar1 PL: " + isPalindrome("radar1"));
        System.out.println("is radar  PL: " + isPalindromeUsingStackAndQueue("radar"));
        System.out.println("is 121 PL: " + isPalindrome(121)); // int is done via a different way  divide ?

        // find all divisors of an integer and sum them up and print it out.
        divisorSum(6);
        // find whether there are two integers x and y such that x^2 + y^2 is equal to a given positive number.
        sumOfSquareNum(81);

        // delete duplicate from String "hi this is sample test", keeping the order according to last occurrences
        String duplicateString = "hi this is sample test";
        deleteDuplicateAndKeepTheLastOccurrence(duplicateString);
        deleteDuplicateAndKeepOrderWithFirstOccurrence(duplicateString);


        // rotate int arr by d steps to the right  e.g. d = 3 , then  5,6,7,1,2,3,4
        int seed[] = {1, 2, 3, 4, 5, 6, 7};
        String seedStr = Arrays.toString(seed).replaceAll("\\[|\\,|\\s|\\]", "");
        System.out.println("int[] to string : " + seedStr);  //1234567
        rotateArray(seed, 3);

        // rotate String
        String seedString = "iamacat";
        rotateLeft(seedString, 3);


        // joining string arrays
        List<String> listOfString = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "cat", "cat", "dog", "dog", "dog");
        String joinedStrs = joinedStr(listOfString);
        System.out.println(joinedStrs);


        // hard: Find all the start indices of a given string's anagrams in another specified string
        // https://www.w3resource.com/java-exercises/basic/java-basic-exercise-188.php
        String str1 = "zyxwyxyxzwxyz";
        String anagramseed = "xyz";

        // find all indices of substring from a big string
        String bigString = "Cat XYZ Dog Cat Dog Man Bat Cat Man Hero Man";
        String smallString = "Cat";
        findAllIndices(bigString, smallString);

        // Find all substrings of a String in java
        String allString = "abba";
        findAllSubString(allString);

        // Calculate changes given that you have 10$ , 5$ and 1$ bills
        int price = 30;
        int paid = 100;
        calculateChanges(price, paid);  // easier

        // Calculate changes to pennies given that you have 10$ , 5$ and 1$ bills and all coins
        double price1 = 30.12;
        double paid1 = 99.34;
        calculateChangesWithPennies(price1, paid1); // harder

        // Calculate # of boxes, that  needed use / for boxes , % for remainder weight
        calculateBoxes();

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------  Tree Section ---------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");


        // binary search ( simple version use Arrays.sort and Arrays.binarySearch)
        int[] arr = {40, 2, 12, 34, 3, 44, 4, 41, 11, 10, 50, 40};
        int x = 10;
        Arrays.sort(arr);
        int ele1 = Arrays.binarySearch(arr, x);
        System.out.println("found ele1: " + ele1);

        // binary Search complex version
        int ele2 = binarySearch(arr, 10);
        System.out.println("found ele2: " + ele2);

        // convert a left unbalanced BST to a balanced BST
        // https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/?ref=rp
        convertUnBalancedBST2BalancedBST();

        // Valid Parentheses Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
        // The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
        System.out.println("{}[]() is closed : " + isValidParentheseUsing2Pointers("{}[]()"));
        System.out.println("{}[](1) is closed : " + isValidParentheseUsing2Pointers("{}[](1)"));
        System.out.println("{}[]9 is closed : " + isValidParentheseUsing2Pointers("{}[]9"));

        // Balanced Parentheses , harder.
        boolean balanced = isBalancedParentheses("[()]{}{[()()]()}");
//        boolean balanced =isBalancedParentheses("(}()");
        System.out.println("balanced : " + balanced);

    }
    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1.0d == 0.0d;
    }

    public static String evenOneOddZero(int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += i % 2 == 0 ? "1" : "0";
        }
        return result;
    }

    private static void fizzbuzz() {
        IntStream.rangeClosed(1, 100).boxed()
                .forEachOrdered(
                        e -> {
                            if (e % 3 == 0 && e % 5 == 0) {
                                System.out.println("fizzbuzz");
                            } else if (e % 3 == 0) {
                                System.out.println("fizz");
                            } else if (e % 5 == 0) {
                                System.out.println("buzz");
                            } else {
                                System.out.println(e);
                            }
                        }
                );
    }

    private static boolean isAllUnique(String s) {
        if (s == null || s.length() <= 1) return false;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean isUnique = false;

        // M0: ask interviewer should I use stream
        isUnique = s.chars().distinct().count() == s.length();

        // M1: hashing check length
        HashSet<Character> set = new HashSet<Character>();
        for (char c : chars)
            set.add(c);
        isUnique = len == set.size() ? true : false;





        // M3
        Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        boolean notUnique = map.entrySet().stream().anyMatch(e -> e.getValue() > 1);
        System.out.println(s + " isAllUnique ? " + !notUnique);

        return isUnique;
    }

    private static boolean isAllSame(String s) {


        // M1 , check if all match the first one or last one
        boolean isSame = s.chars().allMatch(c -> c == s.charAt(0));


        // M2: check if disinct and count equals 1
        isSame = s.chars().distinct().count() == 1 ? true : false;

        // M3: Hashing, then the set size should be 1
        HashSet<Character> characters = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            characters.add(c);
        }

        // M4 : one line hashsert
        s.chars().forEach( c -> characters.add((char)c));
        isSame = characters.size() == 1 ? true : false;

        // M5: use codePoint
        int allPoints = s.charAt(0) * s.length();
        for (char c : s.toCharArray()) {
            allPoints -= (int) c;
        }
        isSame = allPoints == 0 ? true : false;
        return isSame;
    }

    /*
      // [()]{}{[()()]()} : Balanced  and    [(])  : Not-Balanced
      // write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
     */
    static boolean isBalancedParentheses(String s) {         // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the Expression
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    x = stack.pop();
                    if (x == '{' || x == '[') {
                        System.out.println(x);
                        return false;
                    }
                    break;

                case '}':
                    x = stack.pop();
                    if (x == '(' || x == '[')
                        return false;
                    break;

                case ']':
                    x = stack.pop();
                    if (x == '(' || x == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }

    static void convertUnBalancedBST2BalancedBST() {

    }

    static int divisorSum(int n) {
        HashSet<Integer> divisors = new HashSet<Integer>();
        int sum = 0;
        int idx = 0;
        int upperBound = n / 2;
        while (idx++ <= upperBound) {
            int remainder = n % idx;
            int divisor = n / idx;
            if (remainder == 0) {
                if (!divisors.contains(idx)) {
                    divisors.add(idx);
                    sum += idx;
                }
                if (!divisors.contains(divisor)) {
                    divisors.add(divisor);
                    sum += divisor;
                }
            }
        }
        return sum;
    }

    private static String isPalindromeUsingStackAndQueue(String s) {
        return s;

    }

    private static int powerMe(int n, int p) {
        return (int) Math.pow(n, p);
    }

    /*
        Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
        Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (4 * 10) = 40, then 400, 4000
        Dividing an integer by 10 will remove the rightmost digit. (1234 / 10) = 123

        steps
        a. Extract off the rightmost digit of your input number. (1234 % 10) = 4
        b. Take that digit (4) and add it into a new reversedNum.
        c. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the right of your (4).
        d. Divide the input by 10, (removing the rightmost digit). (1234 / 10) = 123
        e. Repeat at step a with 123
     */
    private static int reverseIntNumber(int originalInt) {

        // so if argument is a string, you need to think more carefully it's it's overflown for int,
        // so use long would be better or ask interviewer for that aquesiton.  use Long or Int
        // try do while instead of while , same
        int reversedNum = 0;
        while (originalInt != 0) {
            reversedNum = reversedNum * 10;   // shift
            reversedNum = reversedNum + originalInt % 10;   // with extract off the right most number
            originalInt = originalInt / 10;   // remove the right most number off original one
        }
        System.out.println("reversed Int number : " + reversedNum);
        return reversedNum;
    }

    static int reverseIntNumberRecursively(int n, int ans){
        if ( n == 0) return ans;
        int remainder = n % 10;
        int quotient = n /10 ;
        ans = ans * 10 + remainder;
        return reverseIntNumberRecursively(quotient,ans); // when reaching the end, return 4 times in the stack from bottom to top and done.
    }

    private static void reverseIntArray(int[] arr) {
        System.out.println("------ reverse int [] ------- ");
//        // reverse
//        for ( int i=0 ; i< arr.length/2 ; i++){
//            int t = arr[i];
//            arr[i] = arr[arr.length-1-i];
//            arr[arr.length-1-i] = t;
//        }

        // much simpler if just to print it out
        int n = arr.length;
        while (n > 0) {
            System.out.print(arr[--n] + " ");
        }
        System.out.println();
    }

    /*
        e.g iamacat -> macatiam -- left shifts 3  == right shifts n -3 = 5
        req:
            please use array rotation
            you can not use any existing rotate api
     */
    private static String rotateLeft(String s, int shifts) {
        String rotated = s.substring(shifts) + s.substring(0, shifts);
        return rotated;
    }

    static void simpleReverse(int[] arr, int l, int r) {  // r is len -1
        while (l < r) {
            int t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }

    private static void rotateArray(int[] seed, int d) {
        if (seed == null || seed.length <= 1) return;

        // 1.  calculate remainder of n
        d = d % seed.length;

        // 2. reverse whole array
        simpleReverse(seed, 0, seed.length - 1);

        // 3. reverse from 0 to d and reverse from d+1 to len-1
        simpleReverse(seed, 0, d - 1);
        simpleReverse(seed, d, seed.length - 1);

        // 4. print out for testing
        IntStream.of(seed).forEach(System.out::println);

    }

    private static int[] intToIntegerThenToInt(int[] arr) {
        return  IntStream.of(arr).mapToObj(Integer::valueOf).mapToInt(Integer::intValue).toArray();
//        return IntStream.of(arr).boxed().mapToInt(e -> e).toArray();
    }

    static void calculateBoxes() {
        int weightEachItem = 18; // lb;
        int numOfItems = 36;

        int capacityForty = 40;
        int capacityThirty = 30;
        int capacityTen = 10;
        int capacityOne = 1;
        int boxesOfForty = 0;
        int boxesOfThirty = 0;
        int boxesOfTen = 0;
        int boxesOfOne = 0;

        int totalWeight = weightEachItem * numOfItems;

        if (totalWeight > 0) {
            boxesOfForty = totalWeight / capacityForty;
            totalWeight = totalWeight % capacityForty;

        }
        if (totalWeight > 0) {
            boxesOfThirty = totalWeight / capacityThirty;
            totalWeight = totalWeight % capacityThirty;
        }
        if (totalWeight > 0) {
            boxesOfTen = totalWeight / capacityTen;
            totalWeight = totalWeight % capacityTen;
        }
        if (totalWeight > 0) {
            boxesOfOne = totalWeight / capacityOne;
            totalWeight = totalWeight % capacityOne;
        }
        System.out.println("40 boxes\t: " + boxesOfForty);
        System.out.println("30 boxes\t: " + boxesOfThirty);
        System.out.println("10 boxes\t: " + boxesOfTen);
        System.out.println("1  boxes\t: " + boxesOfOne);


    }

    static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int result = binarySearch(arr, left, right, n);
        return result;
    }

    static int binarySearch(int[] arr, int left, int right, int n) {
        if (right > left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                return binarySearch(arr, left, mid - 1, n);
            } else if (arr[mid] < n) {
                return binarySearch(arr, mid + 1, right, n);
            }
        }
        return -1;
    }

    static void calculateChangesWithPennies(double price, double paid) {

    }

    static void calculateChanges(int price, int paid) {
        if (paid < price) return;
        int TEN_BILL = 10;
        int FIVE_BILL = 5;
        int ONE_BILL = 1;
        int fives = 0, tens = 0, ones = 0;
        int changes = paid - price;
        if (changes > 0) {
            tens = changes / TEN_BILL;
            changes = changes % TEN_BILL;

            if (changes != 0) {
                fives = changes / FIVE_BILL;
                changes = changes % FIVE_BILL;
            }
            if (changes != 0) {
                ones = changes / ONE_BILL;
            }
            System.out.println("10$:" + tens);
            System.out.println("5$:" + fives);
            System.out.println("1$:" + ones);
        } else {
            System.out.println("all paid, no changes");
        }
    }

    private static int fibIterative(int nTh) {
        int prevprev = 0;
        int prev = 0;
        int current = 1;
        for (int i = 1; i < nTh; i++) {
            prevprev = prev;
            prev = current;
            current = prevprev + prev;
        }
        return current;
    }

    /*
     myself uses this way.
     */
    static boolean isValidParentheseUsing2Pointers(String testString) {
        if (testString == null || "".equals(testString)) return false;
        if (testString.length() % 2 != 0) return false;

        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put('<', '>');
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put('(', ')');
        char[] charArray = testString.toCharArray();
        for (int i = 0, j = i + 1; j < charArray.length; i = i + 2, j = i + 1) {
            char currentc = charArray[i];
            char nextc = charArray[j];
            char closingChar = hashMap.get(currentc);
            if (closingChar != nextc)
                return false;
        }
        return true;
    }

    private static void findAllSubString(String allString) {

    }

    /*
    https://www.baeldung.com/java-indexOf-find-string-occurrences
     */
    private static int[] findAllIndices(String bigString, String smallString) {
        List<Integer> list = new ArrayList<Integer>();
        for (int idx = 0; ; ) {
            idx = bigString.indexOf(smallString, idx);
            if (idx >= 0) {
                list.add(idx);
                idx = idx + smallString.length();
                continue;
            } else {
                break;
            }
        }
        return list.stream().peek(System.out::println).mapToInt(e -> e).toArray();

    }

    private static int[] findIndices(String bigString, String smallString) {
        List<Integer> list = new ArrayList<Integer>();
        int idx = 0;
        int wholeLen = bigString.length();
        int cuttedLen = 0;
        for (; bigString.indexOf(smallString) >= 0; ) {
            idx = bigString.indexOf(smallString);
            list.add(idx + cuttedLen);
            bigString = bigString.substring(idx + smallString.length());
            cuttedLen = wholeLen - bigString.length();
        }
        return list.stream().mapToInt(e -> e).peek(System.out::println).toArray();
    }

    static void sumOfSquareNum(int n) {
        int start = 0;
        int end = (int) Math.sqrt(n);
        boolean found = false;
        while (start <= end) {
            System.out.println(start + ":" + end);
            if ((start * start + end * end) == n) {
                found = true;
                break;
            } else if ((start * start + end * end) < n) {
                start++;
            } else if ((start * start + end * end) > n) {
                end--;
            }
        }
        if (found)
            System.out.println(start + ":::" + end);
        else
            System.out.println("Not found");

    }

    static String findMissingString(String src, String target) {
        String[] srcArr = src.split(" ");
        String[] targetArr = target.split(" ");
        List<String> srcList = Arrays.stream(srcArr).collect(Collectors.toList());
        for (int i = 0; i < targetArr.length; i++) {
            String s = targetArr[i];
            if (src.contains(s)) {
                srcList.remove(s); // o(1)
            }
        }
        String output = srcList.stream().collect(Collectors.joining(", "));
        return output;

    }

    static String joinedStr(List<String> listOfString) {
        return listOfString.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "));
    }

    static int[] intersection(int[] input1, int[] input2) {
        List<Integer> outputList = new ArrayList<Integer>();
        HashSet<Integer> hs1 = IntStream.of(input1).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int i : input2) {
            if (hs1.contains(Integer.valueOf(i))) {
                outputList.add(Integer.valueOf(i));
            }
        }
        return outputList.stream().mapToInt(i -> i).toArray();

    }

    /*
        simple : The simplest version of this question is to find missing elements in an area of 100 integers,
        e.g  1,2,3,4,5,.... 55,57,58,59.......99,100.  the answer should be 56.
         find it and return the number or index
     */
    static void findOneMissingNumberInConsecutiveArray() {
        int expectedSum = (100 * (100 + 1)) / 2;
        int sum = 0;
        int[] arrays = new int[100];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i + 1;
            sum = sum + arrays[i];
        }
        System.out.println("expectedSum: " + expectedSum);
        sum = sum - arrays[55];
        System.out.println("sum: " + sum);


        System.out.println("the ONE MIssing integer is : " + (expectedSum - sum));
    }


    static void printSmallestAndLargest(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > largest) {
                largest = i;
            } else if (i < smallest) {
                smallest = i;
            }
        }
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }


    /*
        input: 12121
        input: 1234
        input: 0
        input: 1221
     */
    private static int isPalindrome(int num) {
        int reverse = 0;
        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }
        return reverse;
    }

    /*
        input radar  then return true
        input null   then return true;
        input ""     then return true;
        input radar1 then return false;
     */
    static boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) return true;
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    /*
        input: "hi this is sample test"
        output:
     */

    static void deleteDuplicateAndKeepOrderWithFirstOccurrence(String input) {
        if (input == null || input.length() <= 1) return;

        String output = "";
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (output.indexOf(chars[i]) <= 0) {
                output += chars[i];
            }
        }
        System.out.println("after deletion of first occurrence: " + output);

    }

    /*
            Input :   hi this is sample test
            Output  : hiampl est
            hint    : use hashset - collection

            brute force with 2 loops or simple check if char occors in the new str.
     */
    private static String deleteDuplicateAndKeepTheLastOccurrence(String input) {
        if (input == null || input.length() <= 1) return input;
        String output = "";
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (output.indexOf(chars[i]) < 0) {
                output = chars[i] + output;
            }
        }
        System.out.println("new str: " + output);
        return output;

    }


    static List<Integer> occurrencesIndexes(String src, String target) {
        List<Integer> list = new ArrayList<>();
        for (int idx = 0; ; ) {
            idx = src.indexOf(target, idx);
            if (idx < 0) break;
            else {
                list.add(idx);
                idx += target.length();
            }
        }
        return list;
    }


    static String replace(String src, char target, char replacement) {
        if (target != replacement) {
            char[] value = src.toCharArray();
            int len = value.length;
            int i = -1;
            char[] val = value; /* avoid getfield opcode */

            while (++i < len) {
                if (val[i] == target) {
                    break;
                }
            }
            if (i < len) {
                char buf[] = new char[len];
                for (int j = 0; j < i; j++) {
                    buf[j] = val[j];
                }
                while (i < len) {
                    char c = val[i];
                    buf[i] = (c == target) ? replacement : c;
                    i++;
                }
                return new String(buf);
            }
        }
        return src;
    }


    static int convertToInt(String s) {
        if (s == null || s.equalsIgnoreCase("")) return -1;
        System.out.println(Integer.valueOf(s));
        return Integer.valueOf(s);
    }


    static int countOccurence(String s, char c) {
        int occurs = 0;
        char[] chars = s.toCharArray();
        for (char cin : chars) {
            if (cin == c) occurs++;
        }
        System.out.println("occurence:  " + occurs);
        return occurs;
    }


    static char findFirstNonRepeating(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            String rest = s.substring(0, i) + s.substring(i + 1);
            boolean foundSame = false;
            for (int j = 0; j < rest.toCharArray().length; j++) {
                if (rest.toCharArray()[j] == curr) {
                    foundSame = true;
                    continue;
                }
            }

            if (!foundSame) {
                return chars[i];
            }
        }
        return ' ';


    }

    static void permutation(String s, String ans) {
        if (s == null || s.length() == 0) {
            System.out.println(ans);
        }

        // locate each element, and permute teh rest of it e.g. x then do yz
        for (int i = 0; i < s.length(); i++) {
            String rest = s.substring(0, i) + s.substring(i + 1);
            char c = s.charAt(i);
            permutation(rest, ans + c);
        }

    }


    public static void reverse(char[] chars) {
        int len = chars.length;

        // reverse all array
        swap(chars, 0, chars.length - 1);

        // reverse each word with space separator
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            swap(chars, start, end - 1);
            end += 1;
            start = end;
        }

        // print
        System.out.println(String.valueOf(chars));
    }

    public static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }


    public static void printkMostFrequent(String s, int k) {
        // put all in the map ( word, frequency) - hashmap or treeMap?
        String[] arr = s.split(" ");
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        // use Collections.frequency to populate teh map
        for ( String w : arr){
            int eachFrequency = Collections.frequency(Arrays.asList(arr),w);
            hm.putIfAbsent(w,eachFrequency);
        }

        // put Map.Entry into list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());

        // sort the list ( Note:  you can't sort the hashSet )
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        // print out top k
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }


    }

    public static int[] countDuplicate(int[] nums) {
        Map<Integer,Long> map = IntStream.of(nums).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting()));

        System.out.println(map);

        return map.entrySet().stream().filter( e -> e.getValue() > 1).mapToInt( e -> e.getKey()).toArray();
    }


    public static int findKthHighestNum(int[] nums, int k) {

        int result = 0 ;
        // find first hightest
        result =  Arrays.stream(nums)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(k - 1)
                .findFirst()
                .get()
                .intValue();

        // .findFirst().orElseGet( () -> -1);  toArray(Integer[]::new)[0)    or mapToInt( e -> e).toArray()[0);

        // method 2:
        // int[] use IntStream, dis, sorted[reverse], collection toLinkedHashSet
        LinkedHashSet<Integer> set1 = IntStream.of(nums).boxed().distinct().sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));


        // LinkedHashset to ArrayList and get by index
        result = new ArrayList<Integer>(set1).get(k-1);
        return result;
    }


    public static String reverse(String s) {
        if (s.length() == 0) return "";
        return reverse(s.substring(1)) + s.charAt(0);
    }


    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
    static int factorialIterative(int num){
        int product = 1;
        while ( num >=1) {
            product = product * num--;
        }
        return product;
    }

    public static int fibRecursive(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

}
