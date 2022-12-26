public class closestString extends Map {

    public static int getclosestString(String str){

        //we traverse the vertices array and find for the string having minimum edit distance
        int minEditDistance = Integer.MAX_VALUE;
        String closest="";
        int index=0;
        for(int i=0; i<vertices.length; i++){
            int d = getLevenshteinDistance(str,vertices[i],str.length(),vertices[i].length());
            if(d<minEditDistance){
                minEditDistance = d;
                closest = vertices[i];
                index = i;
            }
        }
        return index;
    }

    public static int min(int x, int y, int z) {
        return ((x) < (y) ? ((x) < (z) ? (x) : (z)) : ((y) < (z) ? (y) : (z)));
    }

    static int getLevenshteinDistance(String str1, String str2, int m, int n) {

        // Creating a table
        int dp[][] = new int[m + 1][n + 1];

        // Filling table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Operations needed for insertion when first string is empty
                if (i == 0) {
                    dp[i][j] = j;
                }

                // Operations needed for removal when second string is empty
                else if (j == 0) {
                    dp[i][j] = i;
                }

                // If last letters are same then ignore them and solve optimised subproblem
                // Operations with same last letters = Operations with same last letter
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // check for the minimum time used for solving subproblems
                else {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}