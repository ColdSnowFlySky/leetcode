package fourhundred.two;

public class Solution {
    public String removeKdigits(String num, int k) {
        int[] ljt = new int[k];
        int ljtIndex = 0;
        char[] data = num.toCharArray();
        if(k == data.length) return "0";
        else if(k == 0) return num;
        int index = 0;
        int contact = 1;
        while(index < data.length) {
            if(data[index]<=data[contact]) {
                contact++;
                index = contact - 1;
            } else {
                ljt[ljtIndex] = index;
                index--;
            }
        }
        return null;
    }
}
