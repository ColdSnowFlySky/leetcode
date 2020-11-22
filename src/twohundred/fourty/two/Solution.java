package twohundred.fourty.two;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        if(cs1.length != cs2.length) return false;
        for(char c : cs1) count[c - 'a']++;
        for(char c : cs2) if((--count[c - 'a']) < 0) return false;
        return true;


        //超慢HashMap
//        char[] cs1 = s.toCharArray();
//        char[] cs2 = t.toCharArray();
//        if(cs1.length != cs2.length) return false;
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//        for(char c : cs1)
//            if(map1.containsKey(c)) map1.put(c, map1.get(c) + 1);
//            else map1.put(c, 1);
//        for(char c : cs2)
//            if(map2.containsKey(c)) map2.put(c, map2.get(c) + 1);
//            else map2.put(c, 1);
//
//        return map1.equals(map2);
    }
}
