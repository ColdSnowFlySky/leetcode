package ninehundred.seventy.three;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[] range = new int[K];
        int[][] result = new int[K][2];
        int index = 1;
        int now_range = 0;
        boolean isInsert = false;
        range[0] = points[0][0]*points[0][0] + points[0][1]*points[0][1];
        result[0][0] = points[0][0];
        result[0][1] = points[0][1];
        for(int i = 1;i < points.length; i++) {
            now_range = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            isInsert = false;
            int[] now_value = {points[i][0], points[i][1]};
            for(int j = 0; j < index; j++) {
                if(range[j] >= now_range) {
                    range = insert(j, range, now_range);
                    result = insert(j, result, now_value);
                    isInsert = true;
                    if(index < K) {
                        index++;
                    }
                    break;
                }
            }
            if(index < K && !isInsert) {
                range = insert(index, range, now_range);
                result = insert(index, result, now_value);
                index++;
            }
        }
        return result;
    }

    public int[] insert(int index, int[] a, int b) {
        int[] result = a.clone();
        result[index] = b;
        for(int i = index + 1; i < a.length; i++) {
            result[i] = a[i-1];
        }
        return result;
    }

    public int[][] insert(int index, int[][] a, int[] b) {
        int[][] result = a.clone();
        result[index] = b;
        for(int i = index + 1; i < a.length; i++) {
            result[i] = a[i-1];
        }
        return result;
    }
}
