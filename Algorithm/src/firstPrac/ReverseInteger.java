package firstPrac;

public class ReverseInteger {
	public static void main(String [ ] args)
	{
		// overflow
		int res = reverse(-412);
		System.out.println(res);
	}
	
    public static int reverse(int x) {
        long revx = 0;
        int sign = x>0? 1:-1;
        x /= sign;
        while(x != 0)
        {
        	revx = 10*revx + x%10;
        	x /= 10;
        }
        revx *= sign;
        if (revx > Integer.MAX_VALUE || revx < Integer.MIN_VALUE)
        	return 0;
    	return (int) revx;
    }
}
