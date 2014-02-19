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
In this simplified version he can take multiple times an item.
 *
 *
 */
public class UnboundedKnapsack {
	int[] value;
	int[] weight;
	int[] item;
	
	UnboundedKnapsack(int[] pValue,int[] pWeight, int[] pitem){
		value=pValue;
		weight=pWeight;
		item=pitem;
		
	}
	
	public int getMaximumValue(int maxWeight){
		int[] DPValue=new int[maxWeight+1];
		//THis is the DP array, where indices refer to weight and value refer to max value,
		//i.e. DPValue[a]=X, says for a max weight allowed 'a', max value of items that can be carried is 'X '
		
		DPValue[0]=0;
		for(int weightValues=1;weightValues<=maxWeight;weightValues++){
			
			int maxWeightGain=0;
			for(int i=0;i<weight.length;i++){
				if(weight[i]<=weightValues){
					int WeightGain=DPValue[weightValues-weight[i]]+value[i];
					if(WeightGain>maxWeightGain)
						maxWeightGain=WeightGain;
				}
			}
			DPValue[weightValues]=maxWeightGain;
		}
		
		return DPValue[maxWeight];
		
	}
}
