package com.shareforever.intvwdemo.problem;


import java.util.HashMap;
import java.util.Map;

/**
 * assume that each input would have exactly one solution,
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] inputs = {1, 4, 6, 10, 7, 8};
        int target = 10;
//        solution1(inputs, target);
        solution2(inputs, target);


    }

    /**
     * use cache for all previous elements and current i + (element in the cache map) if target found then return
     *
     * @param inputs
     * @param target
     * @return
     */
    private static int[] solution2(int[] inputs, int target) {
        Map<Integer, Integer> cache = new HashMap<>(inputs.length);
        int[] result = new int[2];
        for (int i = 0; i < inputs.length; i++) {
            int cachedNum = target - inputs[i];
            if (cache.containsKey(cachedNum)) {
                result[0] = cache.get(cachedNum);
                result[1] = i;
                return result;
            }
            cache.put(inputs[i], i);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    /**
     * O(n2) :  by bu , no space complexity
     */
    private static void solution1(int[] inputs, int target) {
        boolean found = false;
        int[] indices = new int[2];
        for (int i = 0; i < inputs.length; i++) {
            int j = i + 1;
            while (j < inputs.length) {
                if (inputs[i] + inputs[j] == target) {
                    found = true;
                    indices[1] = j;
                    break;
                }
                j++;
            }

            if (found) {
                indices[0] = i;
                break;
            }
        }
        // print indices
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }
    }
}
