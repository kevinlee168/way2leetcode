package leetcode;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)
 */
public class FibonacciNumber_509 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    //使用递归的方法
    /*
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    */

    //带备忘录的递归解法
    /*
    public int fib(int n) {
        //初始化数组元素都为0
        int[] memo = new int[n + 1];

        return helper(memo, n);
    }

    public int helper(int[] memo, int n) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
    */

    /**
      dp 数组的迭代（递推）解法 （自下向上递归）
     【用空间换时间】
     **/
    /*
    public static int fib(int n) {
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    */

    /**
     用常量空间替代dp 数组的迭代（递推）解法 （自下向上递归）
     【用空间换时间】
     **/
    public static int fib(int n) {
        if (n == 0){
            return 0;
        }
        //dp[i] = dp[i - 1] + dp[i - 2];
        int dp_i_1 = 1;
        int dp_i_2 = 0;
        for(int i = 2; i <= n; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i_1;
    }
}
