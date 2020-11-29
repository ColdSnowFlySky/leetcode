package six;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        if(s.length() == 0) return s;
        char[] cs = s.toCharArray();
        StringBuffer result = new StringBuffer();
        int i = 1;
        while(i <= numRows) {
            if(i == 1 || i == numRows) {
                for(int index = i - 1; index < cs.length; index += 2*(numRows - 1)) result.append(cs[index]);
            } else {
                int index = i - 1;
                if(index >= cs.length) break;
                while(true) {
                    result.append(cs[index]);
                    if(index + 2*(numRows - i) >= cs.length) break;
                    index = index + 2*(numRows - i);
                    result.append(cs[index]);
                    if(index + 2*(i - 1) >=cs.length) break;
                    index = index + 2*(i - 1);
                }
            }
            i++;
        }
        return result.toString();
    }
}
