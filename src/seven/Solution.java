package seven;

public class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x / 10 != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        result = result * 10 + x % 10;
        return result > (1 << 30) * 2 - 1 || result < 1 << 31 ? 0 : (int) result;
    }
}
