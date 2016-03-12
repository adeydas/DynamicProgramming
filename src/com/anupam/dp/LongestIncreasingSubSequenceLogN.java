package com.anupam.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LongestIncreasingSubSequenceLogN {
	
	public static int getReplacePosition(Integer[] input, int length, int element){
		int index = 0;
		int start = 0;
		int end = length;
		boolean flag = true;
		
		if (element < input[0]) {
			index = 0;
		} else if (element > input[length-1]) {
			index = length;
		} else {
			while (flag) {
				index = start + (end-start)/2;
				if (input[index] == element) {
					flag = false;
				} else if (input[index]>element) {
					end = index;
				} else if (input[index]<element) {
					start = index;
				}
			
				if ((end-start) == 1) {
					flag = false;
					if (input[start] == element) {
						index = start;
					} else if (input[end] == element) {
						index = end;
					}
						
				}
			}
		}
		return index;
	}
	
	public static Integer[] findLISS(Integer[] input) {
		HashMap<Integer,Integer> parentFinder=new HashMap<Integer,Integer>(); 
		ArrayList<Integer> liss = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int liss_index = 0;
		
		liss.add(input[0]);
		for (int i = 1; i < input.length; i++) {
			if (input[i] > liss.get(liss_index) ) {
				//append
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
		Collections.reverse(result);
		return result.toArray(new Integer[result.size()]);
	}

	public static void main(String[] args) {
		Integer[] input2 = {5,7,1,3,8,9};
		Integer[] result = findLISS(input2);
		for(Integer i:result) {
			System.out.println(i);
		}
	}

}
