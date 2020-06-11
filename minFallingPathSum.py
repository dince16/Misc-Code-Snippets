class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        if len(A) == 1:
            return A[0][0]

        dp = [[0 for _ in range(len(A))] for _ in range(len(A))]
        for i in range(len(A[0])):
            dp[len(A) - 1][i] = A[len(A) - 1][i]
        colMin = float('inf')


        for i in reversed(range(len(A) - 1)):
            colMin = float('inf')
            for j in range(len(A[0])):
                minVal = A[i][j] + dp[i + 1][j]
                if j > 0:
                    minVal = min(minVal, A[i][j] + dp[i + 1][j - 1])
                if j < len(A[0]) - 1:
                    minVal = min(minVal, A[i][j] + dp[i + 1][j + 1])
                dp[i][j] = minVal
                colMin = min(colMin, minVal)
        return colMin
