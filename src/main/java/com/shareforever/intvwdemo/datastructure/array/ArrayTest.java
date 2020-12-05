package com.shareforever.intvwdemo.datastructure.array;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayTest {
    public static void main(String[] args) {
        int[] primitiveArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] objectArray = new Integer[]{56, 56, 243, 129, 227, 221};
        String[] stras = {"a", "b", "c"};
        String[] strbs = {"1", "2", "3"};
        Double[] d1 = {1d, 2d};
        Double[] d2 = {4d, 5d};
        int[] arra = {1, 2, 27, 3, 3, 5, 7, 9, 10};
        int[] arrb = {12, 14, 16, 18};

        System.out.println("----- Array -  Merge --------");
//        merge2SortedArray(arra, arrb);
//        merge2SortedArray2(arra, arrb);
//        merge2SortedArray3(arra, arrb);

        System.out.println("----- Array -  Sum|Convert --------");
//        sumPrimitiveArray(primitiveArray);
//        sumIntegerArray(objectArray);
//        convertIntArraytoIntegerArray(primitiveArray);
//        convertIntegerArrayToIntArray(objectArray);

        System.out.println("----- Array -  combine --------");
//        combineArrays(primitiveArray, objectArray);
//        combineArrays(stras, strbs);
//        combineArrays(d1, d2);

        System.out.println("----- Array -  Rotate --------");
//        rotateArray(primitiveArray,2);
//        rotateArray1(primitiveArray,2);
        rotateArray2(primitiveArray,2);
//        rotateArray3(primitiveArray, 13);

        System.out.println("----- Array -  Reverse --------");
//        char[] charArrs = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
//                'm', 'a', 'k', 'e', 's', ' ',
//                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
//        reverseArray(charArrs);
//        Stream.of(charArrs).forEach(System.out::print);


    }

    /**
     *  No sc
     * Given [1, 2, 3] and n = 1, you should return [3, 1, 2]
     * @param arr
     */
    public static void tryme(int[] arr){

    }

    public static int[] merge2SortedArray3(int[] a, int[] b) {  // tc : n+m
        int[] ans = new int[a.length + b.length];
        System.arraycopy(a,0,ans,0,a.length);
        System.arraycopy(b, 0, ans,  a.length, b.length);
        Arrays.sort(ans);
        return ans;
    }
    /*
        all a[i] conditions are met , then a[i],  rest wll be all b[j]
        and vice verse
     */
    public static int[] merge2SortedArray2(int[] a, int[] b) {  // one liner
        int[] answer = new int[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = answer.length;
        while (k > 0)
            answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
//        while ( k >=0){
//            answer[k--] = (j >= 0 && a[i] <= b[j]) || (i < 0 ) ? b[j--] : a[i--];
//        }
        return answer;
    }

    public static int[] merge2SortedArray(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            answer[k++] = a[i] < b[j] ? a[i++] : b[j++];

        while (i < a.length)
            answer[k++] = a[i++];

        while (j < b.length)
            answer[k++] = b[j++];

        return answer;
    }



    /*
            Arrays.binarySearch(charArr,charKey));
            Arrays.asList(T...).stream()
            Arrays.stream(T[])   ====  Arrays.asList<T[]>.stream()
            Arrays.copyOf(existingarray, newlength)
            Arrays.toString(array) to debug
            Arrays.sort(array,Collections.reverseOrder)
            System.copyarray(src,start,dest,start,howmany)
     */
    private static void sortArray() {
        String[] a = {"2", "4", "6"};
        String[] b = {"1", "3", "5"};

        // combine
        String[] newArray = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, newArray, a.length, b.length);
        System.out.println(Arrays.toString(newArray));
    }


    /*
       Rotate from left to right   offset
       Rotate from right to left   length - offset ( using left to right )


       Given [1, 2, 3] and n = 1, you should return [3, 1, 2]
       Given [1, 2, 3, 4, 5] and n = 3, you should return [3, 4, 5, 1, 2]
   */
    private static void rotateArray(int[] arr, int offset) {
        int len = arr.length;
        if (offset > len)
            offset = offset % len;

        // move last 'offset' elements to buffer array
        int[] bufferarray = new int[offset];
        for (int i = 0; i < offset; i++) {
            bufferarray[i] = arr[len - offset + i];
        }

        // move rest to the right by offset:  such as arr[3] = arr[0]  arr[4] = arr[1] .
        int i = len - offset - 1;
        while (i >= 0) {
            arr[i + offset] = arr[i];
            i--;
        }

        // move buffer array back to original head
        System.arraycopy(bufferarray, 0, arr, 0, offset);

        IntStream.of(arr).forEach(System.out::println);
    }

    /**
     * calculate remainder.  seems not right
     */
    private static void rotateArray1(int[] arr, int k) {
        if (k > arr.length)
            k = k % arr.length;

        // tricky remainder
        int firstIndex = 0;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[(++firstIndex + k) % arr.length];
        }
        Arrays.stream(newArr).forEach(System.out::println);
    }

    /**
     *  trick: copy 3 times
     */
    public static void rotateArray2(int[] arr, int k) {
        if (k > arr.length)
            k = k % arr.length;

        // shift and copy:
        // Partitions: 1. move old tail to the new head 2. move old rest to the new tail.
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, arr.length - k, tmp, 0, k);
        System.arraycopy(arr, 0, tmp, k, arr.length - k);
        System.arraycopy(tmp, 0, arr, 0, arr.length);
    }

    /*
        Trick: reverse 3 times is enough


        Rotate array to the right by k steps.
        input : 1,2,3,4,5,6,7  and k = 2  or k = 9
        output: 6,7,1,2,3,4,5

        steps :
                7,6,5,4,3,2,1
                6,7,1,2,3,4,5
     */
    private static void rotateArray3(int[] arr, int k) {
        if (arr == null || arr.length == 0) return;
        if (k > arr.length) k %= arr.length;
        if (k == 0)  return ; // like never moved.

        reverse(arr, 0, arr.length - 1); // reverse the whole array
        reverse(arr, 0, k - 1);   // reverse 1st section
        reverse(arr, k, arr.length - 1);  // reverse 2nd section

        IntStream.of(arr).forEach(System.out::println);
    }
    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }


    private static <T> T[] combineArrays(T[] first, T[] second) {
        int fLen = first.length;
        int sLen = second.length;
        if (sLen == 0) return first;
        if (fLen == 0) return second;

        T[] both = (T[]) java.lang.reflect.Array.newInstance(first.getClass().getComponentType(), first.length + second.length);
        System.arraycopy(first, 0, both, 0, first.length);
        System.arraycopy(second, 0, both, first.length, second.length);
        Stream.of(both).forEach(System.out::println);
        return both;
    }

    private static String[] combineArrays(String[] first, String[] second) {
        String[] both = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, both, first.length, second.length);
        return both;
    }

    private static Integer[] combineArrays(int[] primitiveArray, Integer[] integerArray) {
        if (primitiveArray.length == 0) return integerArray;
        if (integerArray.length == 0) return IntStream.of(primitiveArray).boxed().toArray(Integer[]::new);
        Integer[] combined = new Integer[primitiveArray.length + integerArray.length];
        System.arraycopy(integerArray, 0, combined, 0, integerArray.length);
        System.arraycopy(IntStream.of(primitiveArray).boxed().toArray(Integer[]::new), 0, combined, integerArray.length, primitiveArray.length);
        Stream.of(combined).forEach(System.out::println);
        return combined;
    }


    public static void reverseArray(char[] chars) {
        if (chars == null) return;

        // reverse whole array
        reverse(chars, 0, chars.length - 1);

        // reverse each word in the array:  start | end index to move forward to the end
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') { // get end index
                end++;
            }
            reverse(chars, start, end - 1);
            end += 1;
            start = end;
        }
    }

    /*
        reverse the whole array
     */
    public static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }

    private static void sumIntegerArray(Integer[] objectArray) {
        System.out.println(Arrays.stream(objectArray).reduce(0, Integer::sum));
        System.out.println(Stream.of(objectArray).reduce(Integer::sum).get());
    }

    private static void sumPrimitiveArray(int[] primitiveArray) {
        System.out.println(IntStream.of(primitiveArray).sum());
        System.out.println(Arrays.stream(primitiveArray).reduce(0, Integer::sum));
    }

    private static void convertIntegerArrayToIntArray(Integer[] objectArray) {
        // convert Integer[] to int[]
        int[] intArray = new int[objectArray.length];
        int j = 0;
        for (Integer obj : objectArray) {
            intArray[j++] = obj.intValue();
        }

        // use lambda  Stream.of , Arrays.stream([]),  Arrays.asList([]).stream()
        Stream.of(objectArray).mapToInt(Integer::intValue).toArray();
        Arrays.stream(objectArray).mapToInt(e -> e.intValue()).toArray();
        Arrays.asList(objectArray).stream().mapToInt(Integer::intValue).toArray();
    }

    private static void convertIntArraytoIntegerArray(int[] primitiveArray) {
        // convert int[] to integer[]  in order to use Java8 Stream feature
        int i = 0;
        Integer[] objectArr = new Integer[primitiveArray.length];
        for (int e : primitiveArray) {
            objectArr[i++] = Integer.valueOf(e);
        }
        IntStream.of(primitiveArray).boxed().collect(toList()).toArray(Integer[]::new);
        IntStream.of(primitiveArray).boxed().toArray(Integer[]::new);
        Arrays.stream(primitiveArray).boxed().toArray(Integer[]::new);
    }
}
