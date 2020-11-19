package nohundred.thirty.one;

public class Solution {
    public static void main(String[] args) {
        int[] test = {4, 3, 2, 1};
        new Solution().nextPermutation(test);
        for(int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
            System.out.print(",");
        }
    }
    public void nextPermutation(int[] nums) {
        int index1 = getIndex1(nums);
        if(index1 == -1) {
            ascent(nums, index1, nums.length - 1);
        } else {
            int index2 = nums.length - 1;
            for(int i = index1 + 1; i < nums.length; i++) {
                if(nums[index1] < nums[i]) {
                    continue;
                }
                index2 = i - 1;
                break;
            }
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
            ascent(nums, index1, nums.length - 1);
        }
    }

    public void ascent(int[] nums, int index1, int index2) {
        int temp = 0;
        for(int i = 0; i < index2-index1-1-i; i++) {
            temp = nums[i+index1+1];
            nums[i+index1+1] = nums[index2-i];
            nums[index2-i] = temp;
        }
    }

    public int getIndex1(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                return i;
            }
        }
        return -1;
    }
}