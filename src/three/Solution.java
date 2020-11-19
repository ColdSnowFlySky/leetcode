package three;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().lengthOfLongestSubstring(" "));
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int index = 0;
        char[] cs = s.toCharArray();
        int length = cs.length;
        Queue<Character> queue = new LinkedList<>();
        while(index<length) {
            if(queue.contains(cs[index])) {
                if(max < queue.size()) max = queue.size();
                while(queue.poll()!=cs[index]);
            }
            queue.add(cs[index++]);
        }
        if(max < queue.size()) max = queue.size();
        return max;
    }
}
