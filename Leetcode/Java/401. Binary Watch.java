public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i <= num; ++i) {
            List<String> hours = getHours(i);
            List<String> mins = getMins(num-i);
            StringBuilder sb = new StringBuilder();
            for(String hour : hours) {
                for(String min : mins) {
                    sb.setLength(0);
                    sb.append(hour);
                    sb.append(":");
                    sb.append(min);
;                   result.add(sb.toString());
                }
            }
        }
        return result;
    }
    private List<String> getHours(int n) {
        List<String> hours = new ArrayList<>();
        int[] nums = {1, 2, 4, 8};
        helpHours(n, 0, nums, 0, 11, hours);
        return hours;
    }

    private void helpHours(int n, int i, int[] nums, int hour, int max, List<String> result) {
        if(hour > max) return;
        if(n == 0) {
            result.add(String.valueOf(hour));
            return;
        }
        for(int j = i; j < nums.length; ++j) {
            helpHours(n-1, j+1, nums, (hour|nums[j]), max, result);
        }
    }

    private List<String> getMins(int n) {
        List<String> mins = new ArrayList<>();
        int[] nums = {1, 2, 4, 8, 16, 32};
        helpMins(n, 0, nums, 0, 59, mins);
        return mins;
    }

    private void helpMins(int n, int i, int[] nums, int min, int max, List<String> result) {
        if(min > max) return;
        if(n == 0) {
            String tmp = min < 10?"0"+String.valueOf(min):String.valueOf(min);
            result.add(tmp);
            return;
        }
        for(int j = i; j < nums.length; ++j) {
            helpMins(n-1, j+1, nums, (min|nums[j]), max, result);
        }
    }
}
