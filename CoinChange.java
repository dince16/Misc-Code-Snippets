class CoinChange {
    int[] memo;
    int[] coins;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        this.coins = coins;
        int numCoins = coinChange(amount, amount);
        if (numCoins == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return numCoins;
    }

    public int coinChange(int amount, int total) {
        if (total == 0) {
            memo[total] = 0;
        } else if (total < 0) {
            return Integer.MAX_VALUE - 1;
        } else if (memo[total] != 0) {
            return memo[total];
        } else {
            memo[total] = Integer.MAX_VALUE - 1;
            for (int i = coins.length - 1; i >= 0; i--) {
                memo[total] = Math.min(memo[total], 1 + coinChange(amount, total - coins[i]));
            }
        }
        return memo[total];
    }
}
