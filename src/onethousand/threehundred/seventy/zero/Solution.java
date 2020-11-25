package onethousand.threehundred.seventy.zero;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().sortString("ggggggg"));
    }
    public String sortString(String s) {
        char[] cs = s.toCharArray();
        if(cs.length == 0) return s;
        int[] data = new int[26];
        List<Integer> list = new ArrayList<>();
        for(char c : cs) data[c - 'a'] ++;
        for(int i = 0; i < data.length; i++) if(data[i] > 0) list.add(i);
        boolean a = true;
        char[] result = new char[cs.length];
        int index = 0;
        while(true) {
            int i;
            if(a) i = 0;
            else i = list.size() - 1;
            while(true) {
                if(data[list.get(i)] > 0) {
                    result[index++] = (char)(list.get(i)+'a');
                    data[list.get(i)]--;
                }
                if(a) i++;
                else i--;
                if(i < 0 || i >= list.size()) break;
            }
            if(index == cs.length) break;
            a = !a;
        }
        return String.valueOf(result);
    }
}
