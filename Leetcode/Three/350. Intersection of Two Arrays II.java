/*
    Time: O(n);
    Space: O(n);
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> one = new HashMap<>();
        for(int num : nums1) {
            if(one.containsKey(num)) one.put(num, one.get(num)+1);
            else one.put(num,1);
        }
        Map<Integer, Integer> two = new HashMap<>();
        for(int num : nums2) {
            if(two.containsKey(num)) two.put(num, two.get(num)+1);
            else two.put(num,1);
        }
        //-----------------------------------------//
        Map<Integer, Integer> three = new HashMap<>();
        int size = 0;
        for(int num : one.keySet()) {
            if(two.containsKey(num)) {
                int add = Math.min(one.get(num), two.get(num));
                size+=add;
                three.put(num, add);
            }
        }
        int[] result = new int[size];
        int index = 0;
        for(int num : three.keySet()) {
            for(int i = 0; i < three.get(num); ++i) {
                result[index++] = num;
            }
        }
        return result;
    }
}

/*
    Sorting && 2 pointer
    Time: O(nlogn);
    Space: O(n);
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int one = 0;
        int two = 0;
        List<Integer> result = new ArrayList<>();
        while(one < nums1.length && two < nums2.length) {
            if(nums1[one] == nums2[two]) {
                result.add(nums1[one]);
                one++;
                two++;
            }
            else if(nums1[one] < nums2[two]) {
                one++;
            }
            else {
                two++;
            }
        }
        //--------------------------------------------//
        int[] nums = new int[result.size()];
        for(int i = 0; i < result.size(); ++i) {
            nums[i] = result.get(i);
        }
        return nums;
    }
}
