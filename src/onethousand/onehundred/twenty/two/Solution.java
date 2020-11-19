package onethousand.onehundred.twenty.two;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] test1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] test2 = {2,1,4,3,9,6};
        int[] result = new Solution().relativeSortArray(test1, test2);
        for(int i = 0; i < test1.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        int[] result = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> other = new ArrayList<>();
        for(int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }
        for(int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])) map.put(arr1[i], map.get(arr1[i]) + 1);
            else other.add(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            int value = map.get(arr2[i]);
            while(value!=0) {
                result[index++] = arr2[i];
                value--;
            }
        }
        Collections.sort(other);
        for(int i : other) {
            result[index++] = i;
        }
        return result;
    }
}
