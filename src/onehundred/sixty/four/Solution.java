package onehundred.sixty.four;

public class Solution {
    public static void main(String[] args) {
        int[] test = {1,1,1,1,1,5,5,5,5,5};
        System.out.print(new Solution().maximumGap(test));
    }
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if(length < 2) return 0;
        int max = 0;
        int min = 2112211212;
        for(int i : nums) {
            if(i < min) min = i;
            if(i > max) max = i;
        }
        if(max == min) return 0;
        int[][] data;
        if((max-min)/length >= 1) {
            length = (max - min) / ((max - min) / length) + 1;
            data = new int[length][2];
        } else {
            length = max - min + 1;
            data = new int[length][2];
        }
        for(int i : nums) {
            int index = (i-min) / ((max-min)/(length - 1));
            if(i < data[index][0] || data[index][0] == 0) data[index][0] = i;
            if(i > data[index][1] || data[index][1] == 0) data[index][1] = i;
        }
        max = 0;
        length = data.length;
        for(int i = 0; i < length; i++) {
            if(data[i][1] == 0) continue;
            min = data[i][1];
            for(int j = i + 1; j < length; j++) {
                if(data[j][0] == 0) continue;
                if(max < data[j][0] - min) max = data[j][0] - min;
                i = j - 1;
                break;
            }
        }
        return max;
    }
}
