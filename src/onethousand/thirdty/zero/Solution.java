package onethousand.thirdty.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.print("[");
        Arrays.stream(new Solution().allCellsDistOrder(2, 3, 1, 2))
                .forEach(e -> System.out.print("[" + e[0] + ", " + e[1] + "]"));
        System.out.print("]");
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int index = 0;
        int[][] result = new int[R*C][2];
        int test = getMaxRange(R, r0) + getMaxRange(C, c0);
        List<int[]>[] data = new List[Math.abs(getMaxRange(R, r0) - r0) + Math.abs(getMaxRange(C, c0) - c0) + 1];
        for(int i = 0; i < data.length; i++) {
            data[i] = new ArrayList<int[]>();
        }
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                data[Math.abs(i-r0)+Math.abs(j-c0)].add(new int[]{i, j});
        for(List<int[]> x : data)
            for(int[] y : x)
                result[index++] = y;

        return result;

        //超过 90% 的算法
//        int index = 1;
//        List<int[]> result = new ArrayList<>();
//        result.add(new int[]{r0, c0});
//        int a, b;
//        while(result.size()!=R*C) {
//            for(int i = 0; i < index; i++) {
//                if((a = r0-i) >= 0 && (b = c0+index-i) < C) result.add(new int[]{a, b});
//                if((a = r0-index+i) >= 0 && (b = c0-i) >= 0) result.add(new int[]{a, b});
//                if((a = r0+i) < R && (b = c0-index+i) >= 0) result.add(new int[]{a, b});
//                if((a = r0+index-i) < R && (b = c0+i) < C) result.add(new int[]{a, b});
//            }
//            index++;
//        }
//        return result.toArray(new int[][]{});

        //超级慢的排序
//        int[][] data = new int[R*C][2];
//        int index = 0;
//        for(int i = 0; i < R; i++)
//            for(int j = 0; j < C; j++) {
//                data[index][0] = i;
//                data[index++][1] = j;
//            }
//        return Arrays.stream(data).sorted(Comparator.comparing(e -> Math.abs(e[0] - r0) + Math.abs(e[1] - c0)))
//                .collect(Collectors.toList())
//                .toArray(new int[R*C][2]);
    }

    private int getMaxRange(int a, int b) {
        if(b > a - b - 1) return 0;
        return a - 1;
    }
}
