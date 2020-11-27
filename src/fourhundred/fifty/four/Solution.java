package fourhundred.fifty.four;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> map1 = new HashMap<>(A.length*B.length);
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                map1.merge(A[i] + B[j], 1, Integer::sum);
            }
        }
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if(map1.containsKey(-(C[i] + D[j]))) result += map1.get(-(C[i] + D[j]));
            }
        }
        return result;
    }
}
