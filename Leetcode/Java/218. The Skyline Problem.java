/*
    D&C解法.
    注意merge部分的实现
*/
class Solution {
    public static void main(String[] args) {

    }
    public class Solution {
        public static List<int[]> getSkyline(int[][] buildings) {
            if(buildings.length == 0) return new ArrayList<int[]>();
            return divide(buildings, 0, buildings.length-1);
        }
        public static List<int[]> divide(int[][] buildings, int left, int right) {
            if(left == right) {
                List<int[]> result = new ArrayList<>();
                result.add(new int[]{buildings[left][0], buildings[left][2]});
                result.add(new int[]{buildings[left][1], 0});
                return result;
            }
            int mid = left+((right-left) >> 1);
            List<int[]> one = divide(buildings, left, mid);
            List<int[]> two = divide(buildings, mid+1, right);
            return merge(one, two);
        }
        public static List<int[]> merge(List<int[]> one, List<int[]> two) {
            List<int[]> result = new ArrayList<>();
            int i = 0;
            int j = 0;
            //--------//
            int h1 = 0;
            int h2 = 0;
            int pos = 0;
            int skyLine = 0;
            //-------//
            while(i < one.size() && j < two.size()) {
                int[] left = one.get(i);
                int[] right = two.get(j);
                if(left[0] < right[0]) {
                    h1 = left[1];
                    pos = left[0];
                    i++;
                }
                else if(left[0] > right[0]) {
                    h2 = right[1];
                    pos = right[0];
                    j++;
                }
                else {
                    h1 = left[1];
                    h2 = right[1];
                    pos = left[0];
                    i++;
                    j++;
                }
                if(skyLine != Math.max(h1,h2)) {
                    skyLine = Math.max(h1,h2);
                    result.add(new int[]{pos, skyLine});
                }
            }
            for(int n = i; n < one.size(); ++n) {
                result.add(one.get(n));
            }
            for(int n = j; n < two.size(); ++n) {
                result.add(two.get(n));
            }
            return result;
        }
    }
}
