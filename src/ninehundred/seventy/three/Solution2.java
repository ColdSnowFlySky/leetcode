package ninehundred.seventy.three;

public class Solution2 {
    public static void main(String[] args) {
        int[][] test = {{0, 1}, {1, 0}};
        int[][] result = new Solution2().kClosest(test, 2);
        for(int[] o : result) {
            System.out.println("{" + o[0] + ", " + o[1] +"} ");
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        int[] range_stack = new int[K];
        int[] index_stack = new int[K];
        int index = 0;

        int[][] value = new int[K][2];
        for(int i=0; i < index_stack.length; i++) {
            value[i][0] = points[index_stack[i]][0];
            value[i][1] = points[index_stack[i]][1];
        }
        return value;
    }

    public boolean movel(int[] tree, int insertIndex) {
        if(insertIndex == 0) {
            if(tree[insertIndex]>tree[insertIndex*2+1] && tree[insertIndex]>tree[insertIndex*2+2]) {
                return true;
            } else {
                if(tree[insertIndex]<tree[insertIndex*2+1]) {
                    int temp = tree[insertIndex];
                    tree[insertIndex] = tree[insertIndex*2+1];
                    tree[insertIndex*2+1] = temp;
                    if(movel(tree, insertIndex*2+1)) {
                        return true;
                    }
                } else {
                    int temp = tree[insertIndex];
                    tree[insertIndex] = tree[insertIndex*2+2];
                    tree[insertIndex*2+2] = temp;
                    if(movel(tree, insertIndex*2+2)) {
                        return true;
                    }
                }
            }
        } else {
            if(insertIndex%2==0){
                int parentIndex = (insertIndex - 2) / 2;
                if(tree[insertIndex] < tree[parentIndex]) {
                    return true;
                } else {
                    int temp = tree[insertIndex];
                    tree[insertIndex] = tree[parentIndex];
                    tree[parentIndex] = temp;
                    if(movel(tree, parentIndex)) {
                        return true;
                    }
                }
            } else {
                int parentIndex = (insertIndex - 1) / 2;
                if(tree[insertIndex] < tree[parentIndex]) {
                    return true;
                } else {
                    int temp = tree[insertIndex];
                    tree[insertIndex] = tree[parentIndex];
                    tree[parentIndex] = temp;
                    if(movel(tree, parentIndex)) {
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
