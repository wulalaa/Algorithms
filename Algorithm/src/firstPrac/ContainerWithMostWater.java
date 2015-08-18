package firstPrac;

public class ContainerWithMostWater {

	/*
	 * Given n non-negative integers a1, a2, ..., an, 
	 * where each represents a point at coordinate (i, ai). 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, such that 
	 * the container contains the most water.

	Note: You may not slant the container.
	 */

	public static void main(String[] args)
	{
		int[] height = {1,2,1};
		int result = maxArea(height);
		System.out.println(result);
	}
	
	public static int maxArea(int[] height) {
		int len = height.length;
		if (len<=1)   return 0;
		int left = 0, right = len-1;
		int maxresult = 0, temp = 0;
		while (left<right)
		{
			temp = Math.min(height[left], height[right])*(right-left);
			if (height[left]<height[right])
				left++;
			else
				right--;
			maxresult = Math.max(temp, maxresult);
		}
		return maxresult;
	}
}
