package com.anupam.dp;
/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */
public class DPMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Lets Solve some DPs");
		{
			System.out.println(":::::::::::::::::::::::::::::");
			System.out.println("Minimum Steps to One");
			System.out.println("Input Value"+10);
			MinStepsToOne obj=new MinStepsToOne(10);
			System.out.println("Solution is"+obj.getMinSteps());
		}
		{
			System.out.println(":::::::::::::::::::::::::::::");
			System.out.println("Longest Increasing Subsequence");
			System.out.println("Input Value ::0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15");
			LongestIncreasingSubsequence obj=new LongestIncreasingSubsequence(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15});
			//LongestIncreasingSubsequence obj=new LongestIncreasingSubsequence(new int[]{1,2,1,4,1,5});
			System.out.println("Solution is"+obj.getLongestIncreasingSubsequence());
			
		}
		{
			System.out.println(":::::::::::::::::::::::::::::");
			System.out.println("Longest Common Subsequence");
			System.out.println("AGCAT and GAC");
			LongestCommonSubsequence obj=new LongestCommonSubsequence("ABCDGH","AEDFHR");
			System.out.println("Solution is"+obj.getLongestCommonSubsequence());
			
		}
		{
			System.out.println(":::::::::::::::::::::::::::::");
			System.out.println("Unbounded knapsack problem");
			UnboundedKnapsack obj=new UnboundedKnapsack(new int[]{30,14,16,9},new int[]{6,3,4,2},new int[]{1,2,3,4});
			System.out.println("Solution is"+obj.getMaximumValue(10));
			
			
		}
		{
			System.out.println(":::::::::::::::::::::::::::::");
			System.out.println("0/1 knapsack problem");
			Knapsack obj=new Knapsack(new int[]{30,14,16,9},new int[]{6,3,4,2},new int[]{1,2,3,4});
			System.out.println("Solution is"+obj.getMaximumValue(10));
			
			
		}
		

	}

}
