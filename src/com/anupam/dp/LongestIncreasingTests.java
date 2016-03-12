package com.anupam.dp;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class LongestIncreasingTests {
	@Test
	public void testGetReplacePosition() {
		Integer[][][] dataset = { 
				{   //input array
					{3,8},
					    //Search element & result
					    {0,0},
					    {1,0},
					    {9,2},
					    {5,1}
				},
				{	//input array 
					{20,30,40,80},
						//Search element & result
						{10,0},
						{20,0},
						{30,1},
						{80,3}
				}
			};
		
		for(Integer[][] temp:dataset) {
			assertEquals("First", (int)temp[1][1], LongestIncreasingSubSequenceLogN.getReplacePosition(temp[0], temp[0].length, temp[1][0]));
			assertEquals("Second", (int)temp[2][1], LongestIncreasingSubSequenceLogN.getReplacePosition(temp[0], temp[0].length, temp[2][0]));
			assertEquals("Third", (int)temp[3][1], LongestIncreasingSubSequenceLogN.getReplacePosition(temp[0], temp[0].length, temp[3][0]));
			assertEquals("Fourth", (int)temp[4][1], LongestIncreasingSubSequenceLogN.getReplacePosition(temp[0], temp[0].length, temp[4][0]));
		}
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testFindLISS() {
		Integer[][][] dataset = { 
				{	//input array
					{22,1,2,23,27,26},
					//LongestIncreasingSubSequence
					{1,2,23,26}
				},
				{	//input array
					{5,7,1,8,9},
					//LongestIncreasingSubSequence
					{5,7,8,9}
				},
				{	//input array
					{5,7,1,6,9},
					//LongestIncreasingSubSequence
					{1,6,9}
				},
				{	//input array
					{20,50,80,79},
					//LongestIncreasingSubSequence
					{20,50,79}
				}
			};
		
		for(Integer[][] temp:dataset) {
			assertEquals("First", LongestIncreasingSubSequenceLogN.findLISS(temp[0]), temp[1]);
		}
	}
}
