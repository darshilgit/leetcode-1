/***
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 * where m and n represents length of word1 and word2 repectively
 */

class Solution {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        // base cases
        for(int i = 0; i <= word1.length(); i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++){
            dp[0][j] = j;
        }

        for(int i = 1; i<=word1.length(); i++){
            for(int j = 1; j<=word2.length(); j++){
                // if letter at current indices match, take value directly from top left diagonal
                // because current letter are same, so MED now is same as MED without current letters
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{   // otherwise, we add 1 for the mis-match and optimise over 3 possible choices that we've got
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
