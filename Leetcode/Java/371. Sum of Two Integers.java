/*
    Based on full-adder, take care of using '>>>'
*/
public class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int c = 0;
        for(int i = 0; i <= 31; ++i) {
            int aL = a&1;
            int bL = b&1;
            //----------//
            int r = c^aL^bL;
            c = (aL&bL)|(c&(aL|bL));
            result = result | (r << i);
            a = a >>> 1;
            b = b >>> 1;
        }
        return result;
    }
}

/*
    Using XOR & AND
*/
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
			int c = a & b; //carry
			a ^= b; //add
			b = c << 1;
		}
		return a;
    }
}
