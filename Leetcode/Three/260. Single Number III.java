public class Solution {
    public int[] singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result^=num;
        }
        //------------------//
        int pivot = result & (-result);
        int one = 0;
        int two = 0;
        for(int num : nums) {
            if((num & pivot) == 0) one^=num;
            else two^=num;
        }
        int[] numbers = new int[2];
        numbers[0] = one;
        numbers[1] = two;
        return numbers;
    }
}
