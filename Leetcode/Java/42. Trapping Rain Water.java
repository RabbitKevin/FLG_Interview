/*
    原先的2个array的方法直接超时.......
    做优化，其实并不需要array去存，先找到最高点，然后分别计算左右两侧
*/
public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        if(height.length == 0) return sum;
        int max = -1;
        int index = -1;
        for(int i = 0; i < height.length; ++i) {
            if(height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        //-------------------------------------//
        int h = height[0];
        for(int i = 1; i < index; ++i) {
            sum+=Math.max(Math.min(h, max)-height[i],0);
            h = Math.max(h, height[i]);
        }
        h = height[height.length-1];
        for(int i = height.length-2; i > index; --i) {
            sum+=Math.max(Math.min(h, max)-height[i],0);
            h = Math.max(h, height[i]);
        }
        return sum;
    }
}
