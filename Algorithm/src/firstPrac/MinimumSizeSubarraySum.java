package firstPrac;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s = 80;
		int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
		int res = minSubArrayLen(s, nums);
		System.out.println(res);
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
        /**if (nums.length<1)   return 0;
        int result = Integer.MAX_VALUE;
        int lind = 0, rind = 0, sum = nums[0];
        while (rind<nums.length)
        {
            if (sum < s)
            {
                rind++;
                if (rind<nums.length)
                    sum+=nums[rind];
            }
            else{
                result = Math.min(result, rind-lind+1);
                sum -= nums[lind];
                lind++;
            }
        }
        return result == Integer.MAX_VALUE? 0:result;
        */
        int len = nums.length, res = Integer.MAX_VALUE;
        if (len == 0)  return 0;
        int []ss = new int[len+1];
        for (int i = 1; i<len+1; i++)
        {
            ss[i] = ss[i-1] + nums[i-1];
        }
        
        // ss : binary search
        int rbound = 0;
        for (int st = 0; st<len; st++)
        {
            rbound = minSubhelper(s, ss, st);
            if (rbound != st)
            	res = Math.min(rbound-st, res);
        	System.out.println(res + "; st = "+nums[st]);
        }
        return res;
    }
    
    public static int minSubhelper(int s, int[] ss, int st){
        int len = ss.length;
        int l = st, r = len-1, imid = 0;
        if (ss[r]-ss[l]<s)   return st;
        while (l<r)
        {
        	
            imid = l + ((r-l)>>1);
        	System.out.println("l = "+l+"; r = "+r+"; mid = "+imid);

            if (ss[imid] - ss[st]== s)
                return imid;
            else if (ss[imid] - ss[st] < s)
                l = imid+1;
            else
                r = imid;
        }
        return r;
    }

}
