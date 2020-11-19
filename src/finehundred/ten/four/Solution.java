package finehundred.ten.four;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().findRotateSteps("xrrakuulnczywjs",
                "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr"));
    }
    public int findRotateSteps(String ring, String key) {
        char[] rings = ring.toCharArray();
        char[] keys = key.toCharArray();
        int m = rings.length;
        int n = keys.length;
        //储存索引
        List<Integer>[] index = new List[26];
        for(int i = 0; i < 26; i++) {
            index[i] = new ArrayList();
        }
        for(int i = 0; i < m; i++) {
            index[rings[i]-'a'].add(i);
        }

        int[][] dt = new int[m][n];
        for(int j : index[keys[0]-'a']){
            dt[j][0] = Math.min(Math.abs(j), Math.abs(m-j)) + 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j : index[keys[i]-'a']){
                int min = 10000000;
                int temp;
                for(int k : index[keys[i-1]-'a']) {
                    temp = Math.min(dt[k][i-1] + Math.abs(j - k),
                            dt[k][i-1] + m - Math.abs(j - k));
                    if(min > temp) min = temp;
                }
                dt[j][i] = min + 1;
            }
        }

        int result = 100000000;
        for(int i : index[keys[n-1]-'a']) {
            if(result > dt[i][n-1]) result = dt[i][n-1];
        }
        return result;
    }
}
