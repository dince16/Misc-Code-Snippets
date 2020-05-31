class UniquePaths {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[n][m];
        uniquePathsHelper(0, 0);
        return memo[0][0];
    }

    public void uniquePathsHelper(int r, int c) {
        if (r == memo.length - 1 && c == memo[0].length - 1) {
            memo[r][c] = 1;
        }
        if (r < memo.length && c < memo[0].length) {
            if (memo[r][c] == 0) {
                uniquePathsHelper(r + 1, c); // down
                uniquePathsHelper(r, c + 1); // right
                if (c + 1 == memo[0].length) {
                    memo[r][c] = memo[r + 1][c];
                } else if (r + 1 == memo.length) {
                    memo[r][c] = memo[r][c + 1];
                } else {
                    memo[r][c] = memo[r + 1][c] + memo[r][c + 1];
                }
            }
        }
    }
}
