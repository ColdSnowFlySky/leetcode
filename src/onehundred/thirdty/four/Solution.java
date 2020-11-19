package onehundred.thirdty.four;

public class Solution {
    public static void main(String[] args) {
        int[] test1 = {5,1,2,3,4};
        int[] test2 = {4,4,1,5,1};
        System.out.print(new Solution().canCompleteCircuit(test1, test2));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0, index = 0;
        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(costSum > gasSum) return -1;
        gasSum = 0;
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] < cost[i]) continue;
            for(int j = 0; j < gas.length; j++) {
                if(i + j >= gas.length) index = i + j - gas.length;
                else index = i + j;
                gasSum = gasSum + gas[index] - cost[index];
                if(gasSum < 0) break;
            }
            if(gasSum < 0) {
                gasSum = 0;
                continue;
            } else return i;
        }
        return -1;
    }
}
