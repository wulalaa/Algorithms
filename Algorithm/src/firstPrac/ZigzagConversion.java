package firstPrac;

public class ZigzagConversion {


	public static void main(String [ ] args)
	{
		String s = "ABCDE";

		String res = convert(s, 4);
		System.out.println(res);
	}

	public static String convert(String s, int numRows) {
		int len = s.length();
		if (len<=numRows)   return s;
		StringBuilder result = new StringBuilder(); 
		int  cycle = 2*numRows-2;
		for (int i = 0; i<numRows; i++)
		{			
			int offset = cycle-(2*numRows - 2*i - 2);
			for (int j = i; j<len; )
			{
				System.out.println("i = "+i+"; j = "+ j);
				result.append(s.charAt(j));
				if (i == 0 || i == numRows-1)
					offset = cycle;
				else
					offset = cycle-offset;
				j += offset;
				System.out.println("update: j= "+ j);
			} 
		}
		return result.toString();
	}
}
