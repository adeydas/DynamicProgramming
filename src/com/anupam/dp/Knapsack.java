package com.anupam.dp;
/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */

/**
 * Knapsack with repetition
 * During a robbery, a burglar finds much more loot than he had expected and has to decide what
to take. His bag (or knapsack) will hold a total weight of at most W pounds. There are n
items to pick from, of weight w1; : : : ; wn and dollar value v1; : : : ; vn. What's the most valuable
combination of items he can t into his bag?
In this  version he can't take multiple times an item.
 *
 *
 */
public class Knapsack {
	int[] value;
	int[] weight;
	int[] item;
	
	Knapsack(int[] pValue,int[] pWeight, int[] pitem){
		value=pValue;
		weight=pWeight;
		item=pitem;
		
	}
	
	public int getMaximumValue(int maxWeight){
		int[][] DPValue=new int[maxWeight+1][item.length+1];
		//DPValue(w; j) = maximum value achievable using a knapsack of capacity w and items 1; : : : ; j:
		
		//Initialize all DPValue(0; j) = 0 and all DPValue(w; 0) = 0

		for(int j=0;j<=item.length;j++){
			DPValue[0][j]=0;
		}
		for(int w=0;w<=maxWeight;w++){
			DPValue[w][0]=0;
		}
	
		for(int j=1;j<=item.length;j++){
			for(int w=1;w<=maxWeight;w++){
				if(weight[j-1]>w){
					DPValue[w][j]=DPValue[w][j-1];
				}
				else{
					DPValue[w][j]=max(DPValue[w][j-1],DPValue[w-weight[j-1]][j-1]+value[j-1]);
				}
			}
			
		}
		
		
		return DPValue[maxWeight][item.length];
		
	}
	
	public int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}
}
