package com.anupam.dp;

/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */

/**
 * The longest common subsequence (LCS) problem is to find the longest subsequence 
 * common to all sequences in a set of sequences (often just two).
 *
 *
 */
public class LongestCommonSubsequence {
	String X;
	String Y;

	LongestCommonSubsequence(String a, String b){
		X=a;
		Y=b;
	}
	
	public int getLongestCommonSubsequence(){
		int [][] dp=new int[X.length()+1][Y.length()+1];
		
		for(int i=0;i<=X.length();i++){
			for(int j=0;j<=Y.length();j++){
				
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else if(X.charAt(i-1)==Y.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else{
					dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[X.length()][Y.length()];
	}
	
	
	public int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}
	
}
