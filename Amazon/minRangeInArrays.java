import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] x = {1, 4, 10};
        int[] y = {2, 15, 20};
        int[] z = {10,12};
        int[] indexes = findMin(x,y,z);
        System.out.println("x: "+indexes[0]+" y: "+indexes[1]+" z: "+indexes[2]);
    }
    public static int[] findMin(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int i = 0;
        int j = 0;
        int z = 0;
        int[] candiate = {0,0,0};
        int minDif = Integer.MAX_VALUE;
        while(i < a.length && j < b.length && z < c.length) {
            int max = Math.max(Math.max(a[i], b[j]), c[z]);
            int min = Math.min(Math.min(a[i], b[j]), c[z]);
            int dif = max-min;
            if(dif < minDif) {
                minDif = dif;
                candiate[0] = i;
                candiate[1] = j;
                candiate[2] = z;
            }
            if(a[i] == min) i++;
            else if(b[j] == min) j++;
            else z++;
        }
        return candiate;
    }
}
