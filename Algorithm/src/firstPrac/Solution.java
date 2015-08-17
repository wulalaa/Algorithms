package firstPrac;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;

public class Solution {
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int result[]= new int[2];
		int len = nums.length;
		for (int i = 0; i<len; i++)
		{
			hmap.put(nums[i], i);
		}

		for (int j = 0; j<len-1; j++)
		{
			if (hmap.containsKey(target-nums[j]) && hmap.get(target-nums[j]) != j)
			{
				result[0] = j+1;
				result[1] = hmap.get(target-nums[j])+1;
				break;
			}
			else
				hmap.remove(nums[j]);
		}
		return result;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)   return l1;
		if (l2 == null)   return l2;
		ListNode result = new ListNode(-1);
		ListNode move = result;
		int a = 0, cur = 0;
		while(l1 != null && l2 != null)
		{
			cur = l1.val + l2.val + a;
			move.next = new ListNode(cur%10);
			a = cur/10;
			l1 = l1.next;
			l2 = l2.next;
			move = move.next;
		}
		while(l1 != null)
		{
			cur = l1.val+a;
			move.next = new ListNode(cur%10);
			a = cur/10;
			l1 = l1.next;
			move = move.next;
		}
		while(l2 != null)
		{
			cur = l2.val+a;
			move.next = new ListNode(cur%10);
			a = cur/10;
			l2 = l2.next;
			move = move.next;
		}

		return result.next;	
	}

	public int lengthOfLongestSubstring(String s) {
		int map[] = new int[26]; // store the index
		if (s.length() < 1)  return 0;
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		int result = 0, start = 0, end = 0;
		while (end < s.length())
		{
			char cur = s.charAt(end);
			System.out.println(cur);
			if (hmap.containsKey(cur) && hmap.get(cur)>=start) // repeat
			{
				result = Math.max(end-start,result);
				start = hmap.get(cur)+1;
			}
			hmap.put(cur, end++);
			System.out.println("Pos = "+ end + "; start = "+ start);
		}	
		result = Math.max(end-start,result);
		return result;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0)
			return -1;
		if (nums1.length == 0)
			//odd number
			return nums2.length%2 == 1? nums2[nums2.length/2]:(nums2[nums2.length/2] + nums2[nums2.length/2-1])/2.0;

			if (nums2.length == 0)
				//even number
			{	
				return nums1.length%2 == 1? nums1[nums1.length/2]:(nums1[nums1.length/2] + nums1[nums1.length/2-1])/2.0;
			}

			//return findMedianHelper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
			int numsl = nums1.length + nums2.length;
			double f1 = findMedianHelper2(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, numsl/2);
			if (numsl%2 == 1) // odd
				return f1;
			else
			{	double f2 = findMedianHelper2(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, numsl/2-1);
			System.out.println("f1 = " +f1+"; f2 = " + f2 );
			return (f2+f1)/2;} 
	}

	public double findMedianHelper2(int[] nums1, int[] nums2, int st1, int end1, int st2, int end2, int k) 
	{
		int l1 = end1 - st1 + 1, l2 = end2 - st2 + 1; 
		//double med1 = (l1%2 == 1)?nums1[st1 + l1/2]:(nums1[st1 + l1/2] + nums1[st1 + l1/2-1])/2.0;
		//double med2 = (l2%2 == 1)?nums2[st2 + l2/2]:(nums2[st2 + l2/2] + nums2[st2 + l2/2-1])/2.0;

		if (l1 == 0)    		return nums2[st2+k];
		if (l2 == 0)    		return nums1[st1+k];
		if (k == 0)           return Math.min(nums1[st1], nums2[st2]);
		if (l1>l2)  return findMedianHelper2(nums2, nums1, st2, end2, st1, end1, k);
		int pos1 = Math.min(k/2, l1-1), pos2 = k-pos1-1;
		System.out.println(pos1 + " "+ pos2+"; k = "+k);
		if (nums1[pos1+st1] == nums2[pos2+st2])
			return nums1[pos1+st1];
		if (nums1[pos1+st1] < nums2[pos2+st2])
		{
			k = k-(pos1+1);
			st1 += pos1+1;
			end2 = pos2+st2;
			System.out.println("A: "+st1 +" " +end1+" " + st2 +" "+ end2+" ; k = "+k);
			return findMedianHelper2(nums1, nums2, st1, end1, st2, end2, k);
		}
		else
		{
			end1 = st1+ pos1;
			k = k-(pos2+1);
			st2 += pos2;
			System.out.println(st1 +" " +end1+" " + st2 +" "+ end2);
			return findMedianHelper2(nums1, nums2, st1, end1, st2, end2, k);
		}
	}



	public double findMedianHelper(int[] nums1, int[] nums2, int st1, int end1, int st2, int end2) {
		int l1 = end1 - st1 + 1, l2 = end2 - st2 + 1; 
		double med1 = (l1%2 == 1)?nums1[st1 + l1/2]:(nums1[st1 + l1/2] + nums1[st1 + l1/2-1])/2.0;
		double med2 = (l2%2 == 1)?nums2[st2 + l2/2]:(nums2[st2 + l2/2] + nums2[st2 + l2/2-1])/2.0;

		if (l1 == 0)    		return med2;
		if (l2 == 0)    		return med1;
		if (l1<=2 && l2<=2)
		{
			int nums[] = new int[l1+l2], i = st1, j = st2, k=0;
			while(i<=end1 && j<=end2)
			{
				nums[k++] = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
			}
			System.out.println(j);
			while(i<=end1)
				nums[k++] = nums1[i++];
			while(j<=end2)
				nums[k++] = nums2[j++];
			System.out.println(Arrays.toString(nums));
			return k%2==1?nums[k/2]:(nums[k/2]+nums[k/2-1])/2.0;
		}
		if (med1<med2)
		{
			st1 += (l1)/2;
			end2 -= (l2)/2;
		}
		else
		{
			end1 -= (l1)/2;
			st2 += (l2)/2;
		}
		System.out.println(st1 +" " +end1+" " + st2 +" "+ end2);
		return findMedianHelper(nums1, nums2, st1, end1, st2, end2) ;   	
	}

	public String longestPalindrome(String s) {
		// return substring
		int len = s.length();
		if (len<= 1)  return s;
		int maxlen = 0;
		int []res = new int[2], oddres = new int[2], evenres=new int[2];
		for (int i = 0; i<len; i++)
		{
			oddres = longestPalindromehelper1(s, i);
			evenres = longestPalindromehelper2(s, i);
			if (oddres[1]-oddres[0]+1>maxlen)
				res = oddres; 
			if (evenres[1]-evenres[0]+1>maxlen)
				res = evenres; 
			maxlen = res[1] - res[0];
			System.out.println("ddd "+Arrays.toString(res) + "; maxlen = "+maxlen);
		}
		System.out.println(s.substring(res[0], res[1]+1) );
		return s.substring(res[0], res[1]+1);
	}

	
	public int[] longestPalindromehelper1(String s, int k)
	{
		int res[] = {k, k};
		while (res[0]>= 0 && res[1]< s.length() && s.charAt(res[0]) == s.charAt(res[1]))
		{
			res[0] --;
			res[1] ++;
		}
		res[0]++;
		res[1]--;
		return res;
	}

	public int[] longestPalindromehelper2(String s, int k)
	{
		int res[] = {k, k+1};
		if (k == s.length()-1)
		{	res[1] = k;
			return res;}
		
		while (res[0]>= 0 && res[1]< s.length() && s.charAt(res[0]) == s.charAt(res[1]))
		{
			res[0] --;
			res[1] ++;
		}
		res[0]++;
		res[1]--;
		return res;
	}
	
}
