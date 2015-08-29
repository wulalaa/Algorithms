package firstPrac;
import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args)
	{
		int[] l1 = new int[5];
		l1[0] = 1;
		//l1[1] = 5;
		int[] l2 = {};
		merge(l1, 1, l2, 0);
		System.out.println(Arrays.toString(l1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind1 = m-1, ind2 = n-1;
        for (int ind = m+n-1; ind>=0 ; ind--){
            if (ind1 < 0 || (ind2 >= 0 && nums1[ind1] <= nums2[ind2]))
            {
                nums1[ind] = nums2[ind2--];
            }
            else 
            {
                nums1[ind] = nums1[ind1--];
            }
        }
    }
}
