package one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        Arrays.stream(new Solution().twoSum(test, 9))
                .forEach(e -> System.out.print(e + " "));
    }
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
