class Solution {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        int[] nums = {1,2,4,4,6,7,9,5,13};
        for(int num : nums) {
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }
        ptr = dummy.next;
        dummy.next = null;
        //--------------------------------//
        printList(ptr);
        ListNode[] result = divideNumber(ptr);
        printList(result[0]);
        printList(result[1]);
    }
    private static void printList(ListNode node) {
        ListNode ptr = node;
        while(ptr != null) {
            System.out.print(ptr.val);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public static ListNode[] divideNumber(ListNode node) {
        ListNode fib = new ListNode(1);
        ListNode non_fib = new ListNode(0);
        ListNode one = fib;
        ListNode two = non_fib;
        ListNode ptr = node;
        while(ptr != null) {
            ListNode next = ptr.next;
            if(isFib(ptr.val)) {
                one.next = ptr;
                one = one.next;
                one.next = null;
            }else {
                two.next = ptr;
                two = two.next;
                two.next = null;
            }
            ptr = next;
        }
        one = fib.next;
        fib.next = null;
        two = non_fib.next;
        non_fib.next = null;
        ListNode[] result = {one, two};
        return result;
    }
    /*
        http://www.geeksforgeeks.org/check-number-fibonacci-number/
        不知道链接的话，可以考虑先求最大值，然后做一个fib-dic备查找
    */
    private static boolean isFib(int val) {
        val = val*val*5;
        return isPerfectSquare(val+4) || isPerfectSquare(val-4);
    }
    private static boolean isPerfectSquare(int val) {
        int x = (int)Math.sqrt(val);
        return (x*x) == val;
    }
}
