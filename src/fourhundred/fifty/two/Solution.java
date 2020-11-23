package fourhundred.fifty.two;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) return -1;
                else if(o1[1] > o2[1]) return 1;
                else {
                    if(o1[0] < o2[0]) return -1;
                    else return 1;
                }
            }
        });
        int count = 1;
        int lastFinal = points[0][1];
        for(int i = 0; i < points.length; i++) {
            if(points[i][0] > lastFinal) {
                lastFinal = points[i][1];
                count ++;
            }
        }
        return count;
    }
}
