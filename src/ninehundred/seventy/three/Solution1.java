package ninehundred.seventy.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution1 {
    public static void main(String[] args) {
        int[][] test = {{1, 2}, {5, 5}, {0, 1}};
        int[][] result = new Solution1().kClosest(test, 2);
        for(int[] o : result) {
            System.out.println("{" + o[0] + ", " + o[1] +"} ");
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        return Arrays.stream(points).sorted(Comparator.comparing(o -> o[0]*o[0] + o[1]*o[1]))
                .limit(K)
                .collect(Collectors.toList())
                .toArray(new int[K][2]);
    }
}
