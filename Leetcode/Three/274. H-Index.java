/*
    分析要求，所有 > citations.length的数，其实都是一样的...按照0~citations.length计数
*/
public class Solution {
    public int hIndex(int[] citations) {
        int size = citations.length;
        int[] dic = new int[size+1];
        for(int x : citations) {
            if(x > size) dic[size]++;
            else dic[x]++;
        }
        //------------------------------------------//
        int sum = 0;
        for(int i = size; i >= 0; --i) {
            sum+=dic[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}
