package com.anupam.dp;
/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */


/**
 * The Longest Increasing Subsequence problem is to find the longest increasing subsequence of a given sequence. 
 * Given a sequence S= {a1 , a2 , a3, a4, ............., an-1, an }
 *  we have to find a longest subset such that for all j and i,  j<i in the subset aj<ai.
First of all we have to find the value of the longest subsequences(LSi) at every index i with last element of sequence being ai.
 Then largest LSi would be the longest subsequence in the given sequence.
  To begin LSi is assigned to be one since ai is element of the sequence(Last element). 
  Then for all j such that j<i and aj<ai ,we find Largest LSj and add it to LSi. Then algorithm take O(n2) time.
 * */

/**
 * In the binary Van der Corput sequence
 *0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, …
 *a longest increasing subsequence is
 *0, 2, 6, 9, 13, 15.*/

 
public class LongestIncreasingSubsequence {

	int[] sequence;
	
	LongestIncreasingSubsequence(int[] passedSeq){
		sequence=passedSeq;

	}
	
	public int getLongestIncreasingSubsequence(){
		int[] dp =new int[sequence.length];
		
	
		for(int i=0;i<sequence.length;i++){
			 dp[i]=1;
			for(int j=0;j<=i-1;j++){
				if(sequence[i]>sequence[j] && dp[i]<=dp[j])
					dp[i]=dp[j]+1;
			}
		}
		int largest=1;
		for(int i=0;i<sequence.length;i++){
			 if (largest < dp[i])
                 largest = dp[i];
		}
		
		return largest;
	} 
	
}
