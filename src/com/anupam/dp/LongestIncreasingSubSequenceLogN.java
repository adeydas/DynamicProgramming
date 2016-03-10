package com.anupam.dp;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestIncreasingSubSequenceLogN {
	
	public static int getReplacePosition(Integer[] input, int length, int element){
		if (length>1){
			int search = 0;
			int start = 0;
			int end = length;
			boolean flag = true;
			if (element < input[0]) {
				search = 0;
			} else if (element > input[length-1]) {
				search = length;
			} else {
				while (flag) {
					search = start + (end-start)/2;
					if (input[search] == element) {
						flag = false;
					} else if (input[search]>element) {
						end = search;
					} else if (input[search]<element) {
						start = search;
					}
					
					if ((end-start) == 1) {
						flag = false;
					}
				}
			}
			return search;
		} else {
			return 0;
		}
		
	}
	
	public static ArrayList<Integer> findLISS(int[] input) {
		//This gives the end of longest sequence
		int lastElementLISS = -1;
		HashMap<Integer,Integer> parentFinder=new HashMap<Integer,Integer>(); 
		ArrayList<Integer> liss = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int liss_index = 0;
		
		//Initialiaztion
		liss.add(input[0]);
		for (int i = 1; i < input.length; i++) {
			//System.out.println(input[i]);
			if (input[i] > liss.get(liss_index) ) {
				//append
				//if ((liss.size()-liss_index) > 0 )
				//	liss.add(input[i]);
				//else
				//	liss.set(liss_index+1,input[i]);
				liss.add(input[i]);
				parentFinder.put(liss.get(liss_index+1), liss.get(liss_index));
				liss_index++;
			} else {
				//replace
				int indexReplace = getReplacePosition(liss.toArray(new Integer[liss.size()]),liss.size(),input[i]);
				liss.set(indexReplace,input[i]);
				if (indexReplace>0)
					parentFinder.put(liss.get(indexReplace), liss.get(indexReplace-1));
				liss_index = liss.size()-1;
				
			}
		}
		
		
		int last = liss.get(liss.size()-1);
		while (last > 0) {
			result.add(last);
			if (parentFinder.containsKey(last)){
				last = parentFinder.get(last);
			} else {
				last = -1;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		//Integer[] input = {1,2,4,5,6,7};
		//System.out.println("3 is found at "+getReplacePosition(input,6,3));
		//System.out.println("6 is found at "+getReplacePosition(input,6,6));
		//System.out.println("1 is found at "+getReplacePosition(input,6,1));
		//System.out.println("3 is found at "+getReplacePosition(input,6,3));
		//Integer[] input = {5,7};
		//System.out.println("1 is found at "+getReplacePosition(input,2,1));
		//System.out.println("8 is found at "+getReplacePosition(input,2,8));
		
		int[] input2 = {5,7,1,8,9};
		//int[] input2 = {5,7,1,3,8,9};
		ArrayList<Integer> result = findLISS(input2);
		for(Integer i:result) {
			System.out.println(i);
		}
	}

}
