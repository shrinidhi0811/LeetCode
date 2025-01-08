class Solution {
    public int countSubstrings (String s) {
        int n = s.length ();
        if (n <= 1) return 1;

        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt (i) == s.charAt (i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
                count++;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt (i) == s.charAt (j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                    count++;
                }
            }
        }

        return count;
    }
}