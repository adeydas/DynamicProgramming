package com.anupam.dp;
/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */

/*Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 
 * 1.) Subtract 1 from it. ( n = n - 1 )  ,
 *  2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  ,
 *   3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 *    Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 * */
public class MinStepsToOne {
	
	int givenNumber;
	
	
	MinStepsToOne(){
		givenNumber=0;
	}
	MinStepsToOne(int value){
		givenNumber=value;
	}
	
	public int getMinSteps (){
		int[] dp=new int[givenNumber+1]; 
		dp[1]=0;
		for(int i=2;i<=givenNumber;i++){
			dp[i]=dp[i-1]+1;
			if(i%2==0) dp[i] = min( dp[i] , 1+ dp[i/2] );
			if(i%3==0) dp[i] = min( dp[i] , 1+ dp[i/3] );
		}
		
		return dp[givenNumber];
		
	}
	
	public int min(int a,int b){
		if(a<b)
			return a;
		else
			return b;
	}
	
}
