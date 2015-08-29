package firstPrac;


public class DivideTwoIntegers {
	public static void main(String[] args){
		int result = divide(1, -1);
		System.out.println(result);
	}

	public static int divide(int dividend, int divisor) {
		int result = 0, resulttemp = 1;
		if (divisor == 0)  return Integer.MAX_VALUE;
		if (divisor == Integer.MIN_VALUE)
		{
			if (dividend == Integer.MIN_VALUE)
				return 1;
			return 0;
		}
		
		if (dividend == Integer.MIN_VALUE)
		{
			if (divisor == -1)
				return Integer.MAX_VALUE;
			dividend += Math.abs(divisor);
			
			result++;
		}
		
		int sign = -1;
		if ((dividend >0 && divisor >0 ) || (dividend <0 && divisor <0 ))
			sign = 1;
		divisor = Math.abs(divisor);
		long temp = divisor;
		dividend = Math.abs(dividend);
		System.out.println(sign);
		while (dividend >= divisor)
		{
			if (dividend<temp)
			{
				temp = divisor;
				resulttemp = 1;

			}
			dividend -= temp;
			result += resulttemp;
			temp  <<= 1;
			resulttemp <<= 1;
		}
		return result*sign;
	}
}
