package firstPrac;

public class PalindromeNumber {
	//Determine whether an integer is a palindrome. 
	//Do this without extra space.

	/**
	 * Input:-2147447412
	Output: true
	Expected: false
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -2147447412;
		boolean result = isPalindrome(x);
		System.out.println(result);
	}

	public static boolean isPalindrome(int x) {
		x = Math.abs(x);
		int temp = x, h = 1;
		while (temp > 9)
		{
			temp /= 10;
			h *= 10;
		}
		System.out.println(h);
		while(x != 0)
		{
			if (x/h != x%10)
				return false;
			x = (x%h)/10;
			h /= 100;
			//System.out.println(x);
		}
		return true;
	}
}
