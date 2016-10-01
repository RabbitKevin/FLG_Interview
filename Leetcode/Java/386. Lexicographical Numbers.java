/*
    not the fastest
    recursion, can change to iteration

    Create a help method to get all number starts with number i
*/
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new LinkedList<>();
        for(int i = 1; i <= 9; ++i) {
            help(n, i, result);
        }
        return result;
    }
    private void help(int n, int i, List<Integer> list) {
        if(i > n) return;
        list.add(i);
        int num = i*10;
        for(int j = num; j <= Math.min(num+9, n); ++j) {
            help(n, j, list);
        }
    }
}


/*
    Iteration method
*/
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new LinkedList<>();
        int num = 1;
        for(int i = 1; i <= n; ++i) {
            result.add(num);
            int next = num*10;
            if(next <= n) num = next;
            else {
                while(num%10 == 9 || num == n) num/=10;
                num++;
            }
        }
        return result;
    }
}
//Faster coding
/*
    for most case, %10 != 9.
*/
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
