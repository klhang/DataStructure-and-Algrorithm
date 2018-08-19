```java
Problem 1: Given two arrays of integers A and B, write a function that takes two arrays and return the length of longest subarry that appears in both A and B.  For example, if A = <1, 2, 3, 4>, B = <3, 5, 2, 3, 5>, the result is 2.

public int commonSubarray(int[] A, int[] B) {
	int max = 0;
	int[][] dp = new int[A.length + 1][B.length + 1];
	for (int i = 0; i < A.length; i ++) {
		for (int j = 0; j < B.length; j ++) {
			if (A[i] = B[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1
      }
      max = Math.max(max, dp[i + 1][j + 1]);
    }
  }
  return max;
}
 - if for string, res = (s.substring(i - cache[i][j] + 1, i + 1));


Problem 2: Given two arrays of integers A and B, write a function that takes two arrays and return the length of longest subsequence that appears in both A and B.  For example, if A = <1, 2, 3, 4>, B = <3, 5, 2, 4, 5>, the result is 2.

public int commonSubsequence(int[]A, int[] B) {
	int m = A.length;
	int n = B.length;
	int max = 0;
	Int [][] dp = new int[m + 1][n + 1];
	for (int i = 0; i < m; i ++) {
		for (int j = 0; j < n; j ++) {
			if (A[i] == B[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1;
      } else {
	      dp[i + 1][j + 1] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
      max = Math.max(max, dp[i + 1][j + 1]);
    }
  }
  return max;
}


```
