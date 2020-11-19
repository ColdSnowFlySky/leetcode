package four;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        System.out.print(new Solution().findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int index1 = -1;
        int index2 = -1;
        boolean isOdd = false;
        if(length%2==1) isOdd = true;
        int[] local = new int[2];
        while(true) {
            //判断
            if(index1 + index2 + 1 == length / 2 && !isOdd) {
                if(local[1]==1){
                    if(local[0]==1) return ((double) nums1[index1]+nums1[index1-1])/2;
                    return ((double) nums1[index1]+nums2[index2])/2;
                } else {
                    if(local[0]==1) return ((double) nums2[index2]+nums1[index1])/2;
                    return ((double) nums2[index2]+nums2[index2-1])/2;
                }

            } else if (index1 + index2 + 2 == (length + 1) / 2 && isOdd) {
                if(local[1]==1) return (double) nums1[index1];
                return (double) nums2[index2];
            }
            // 增加
            if(index1 + 1 < length1 && index2 + 1 < length2) {
                if(nums1[index1+1]<=nums2[index2+1]) {
                    index1++;
                    local[0] = local[1];
                    local[1] = 1;
                } else {
                    index2++;
                    local[0] = local[1];
                    local[1] = 2;
                }
            } else if(index1 + 1 < length1) {
                index1++;
                local[0] = local[1];
                local[1] = 1;
            } else if(index2 + 1 < length2) {
                index2++;
                local[0] = local[1];
                local[1] = 2;
            } else break;
        }
        return (double)(length2 == 0 ? nums1[0] : nums2[0]);
    }
}
