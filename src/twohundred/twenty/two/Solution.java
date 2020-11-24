package twohundred.twenty.two;

import tools.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        // 递归最秀
        if(root == null) return 0;
        else if(root.left == null) return 1;
        else if(root.right == null) return 2;
        TreeNode first = root;
        int layCount = 1;
        while(first.left != null) {
            layCount++;
            first = first.left;
        }
        int count = (int) Math.pow(2, layCount - 1);
        if(isExist(root, layCount, count, count)) return (int) Math.pow(2, layCount) - 1;
        int rowCount = count;
        boolean left = true;
        boolean right = false;
        int countTemp = count;
        while(true) {
            if(left != right) {
                rowCount = rowCount - countTemp / 2;
                right = isExist(root, layCount, count, rowCount);
                if((countTemp / 2) == 1) {
                    if(right) break;
                    rowCount--;
                    break;
                }
            } else {
                rowCount = rowCount + countTemp / 2;
                right = isExist(root, layCount, count, rowCount);
                if((countTemp / 2) == 1) {
                    if(right) break;
                    rowCount--;
                    break;
                }
            }
            countTemp = countTemp / 2;
        }
        return (int)Math.pow(2, layCount - 1) - 1 + rowCount;
    }

    public boolean isExist(TreeNode root, int layCount, int count, int index) {
        TreeNode temp = root;
        int indexTemp = index;
        int layTemp = layCount;
        int countTemp = count;
        while(layTemp != 2) {
            if(indexTemp <= countTemp / 2) {
                temp = temp.left;
                countTemp = countTemp / 2;
                layTemp--;
            } else {
                temp = temp.right;
                countTemp = countTemp / 2;
                indexTemp -= countTemp;
                layTemp--;
            }
        }
        if(indexTemp == 1) return temp.left != null;
        else return temp.right != null;
    }
}
