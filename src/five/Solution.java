package five;

public class Solution {
    public String longestPalindrome(String s) {
        int isDoubleMid = 0;
        int borderIndex = 0;
        char[] data = s.toCharArray();
        int length = data.length;
        if(length == 0 && length == 1) return s;
        int max = 0;
        int maxIndex = 0;
        int maxBorder = 0;
        for(int i = 0; i < length; i++) {
            if(i+1 < length && data[i] == data[i+1]) isDoubleMid = 1;
            else isDoubleMid = 0;
            borderIndex = 0;
            while(data[i-borderIndex] == data[i+borderIndex+isDoubleMid]) {
                borderIndex++;
                if(i-borderIndex < 0 || i+borderIndex+isDoubleMid >= length) break;
            }
            if(max < (borderIndex-1)*2+isDoubleMid+1) {
                max = (borderIndex-1)*2+isDoubleMid+1;
                maxBorder = borderIndex-1;
                maxIndex = i;
            }
            if(isDoubleMid == 1) isDoubleMid = 0;
            else continue;
            borderIndex = 0;
            while(data[i-borderIndex] == data[i+borderIndex+isDoubleMid]) {
                borderIndex++;
                if(i-borderIndex < 0 || i+borderIndex+isDoubleMid >= length) break;
            }
            if(max < (borderIndex-1)*2+isDoubleMid+1) {
                max = (borderIndex-1)*2+isDoubleMid+1;
                maxBorder = borderIndex-1;
                maxIndex = i;
            }
        }
        char[] result = new char[max];
        for(int i = 0; i < max; i++) {
            result[i] = data[maxIndex-maxBorder+i];
        }
        return String.valueOf(result);
    }
}
