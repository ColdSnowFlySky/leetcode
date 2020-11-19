package ninehundred.twenty.two;

class Solution {
    public static void main(String[] args) {
        int[] test = {4,2,5,7};
        int[] result = new Solution().sortArrayByParityII(test);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public int[] sortArrayByParityII(int[] A) {
        int[] num1 = new int[A.length/2];
        int[] num2 = new int[A.length/2];
        int index1 = 0;
        int index2 = 0;
        boolean isFoo = true;
        for(int i = 0; i < A.length; i++) {
            if(A[i]%2==0) {
                if(!isFoo){
                    if(index2 == 0) {
                        num1[index1++] = i;
                    } else {
                        int t = A[i];
                        A[i] = A[num2[index2-1]];
                        A[num2[index2-1]] = t;
                        index2--;
                    }
                }
            } else {
                if(isFoo) {
                    if(index1 == 0) {
                        num2[index2++] = i;
                    } else {
                        int t = A[i];
                        A[i] = A[num1[index1-1]];
                        A[num1[index1-1]] = t;
                        index1--;
                    }
                }
            }
            if(isFoo) {
                isFoo = false;
            } else {
                isFoo = true;
            }
        }
        return A;
    }
}
