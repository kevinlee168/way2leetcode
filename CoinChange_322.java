package leetcode;

import java.util.Arrays;

public class CoinChange_322 {
    static int[] memo;

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    /**
     *使用动态规划+备忘录，自顶向下递归求解。
     * 以空间换时间减小算法复杂度
     *
     * 「状态」，也就是目标金额作为变量， 体现在dp函数参数
     */
    /*
    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -100);

        return dp(coins, amount);
    }

    //「状态」，也就是目标金额作为变量， 体现在dp函数参数
    public static int dp(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;

        //查询备忘录，避免不必要的重复计算，减小时间复杂度（以空间换时间）
        if (memo[amount] != -100) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算自问题的结果
            int subProblem = dp(coins, amount - coin);
            //如果子问题没有解，跳过循环
            if (subProblem == -1) continue;

            //在子问题中寻找最优解答，并加1
            res = Math.min(res, subProblem + 1);
        }
        //将结果添加到备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;

        return memo[amount];
    }
     */

    /**
     * 使用动态规划+dp 数组，自下而上递归求解。
     * 以空间换时间减小算法复杂度
     *
     * //「状态」，也就是目标金额作为变量，在dp数组索引中体现
     */
    public static int coinChange(int[] coins, int amount) {
        //dp数组，并初始化值为 amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环, 遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环, 求所有选择的最小值
            for (int coin : coins) {
                // 「状态」，数组索引 i 就是子问题的目标金额。 如果 i - coin < 0, 子问题无解，跳过。
                if (i - coin < 0) continue;
                //只有当 coin < i (子问题的目标金额)时，才运行
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
