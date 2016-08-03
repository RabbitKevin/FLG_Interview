public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                ++i;
                ++j;
            }
            else if(nums1[i] < nums2[j]) ++i;
            else ++j;
        }
        i = 0;
        int[] nums = new int[result.size()];
        for(int num : result) {
            nums[i++] = num;
        }
        return nums;
    }
}
