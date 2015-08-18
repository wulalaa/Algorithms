package firstPrac;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "-1a";
        int a = myAtoi(s);
        System.out.println(a);
    }
    
    public static int myAtoi(String str) {
    	int index = 0;
    	while(index < str.length() && str.charAt(index) == ' ')
    		index++;
    	if (index == str.length())
    		return 0;
    	boolean sign = true; // positive  
    	if (str.charAt(index)=='-')
    		{   index++;   sign = false;   }
    	else if (str.charAt(index)=='+')
    		index++;
 
    	System.out.println(index);
    	long res = 0;
    	while(index < str.length())
    	{
    		if (str.charAt(index)<'0' || str.charAt(index)>'9')
    			return sign?(int)res:(int)-res;
    		res = 10*res + (str.charAt(index)-'0');
    		if (res>Integer.MAX_VALUE && sign)
    			return Integer.MAX_VALUE;
    		if (-res<Integer.MIN_VALUE && !sign)
    			return Integer.MIN_VALUE ;
    		index++;
    	}
    	res = sign? res:-res;
    	return (int)res;
    }
}
