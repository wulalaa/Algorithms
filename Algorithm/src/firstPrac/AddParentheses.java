package firstPrac;
import java.util.ArrayList;
import java.util.List;

public class AddParentheses {

	/**
	Given a string of numbers and operators, return all possible results from computing 
	all the different possible ways to group numbers and operators. The valid operators are +, - and *.
			*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2*3-4*5";
		List<Integer> result = diffWaysToCompute(input);
		System.out.println(result);
	}
	
	public static List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Integer> result = new ArrayList<Integer> ();
        String opt = "+-*";
		for (int i = 0; i<len; i++)
		{
			if (opt.contains(""+input.charAt(i)))
			{
				List<Integer> Leftval = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightval = diffWaysToCompute(input.substring(i+1, len));
				for (Integer l:Leftval) 
					for (Integer r:rightval)
					{
						if (input.charAt(i) == '+')
							result.add(l+r);
						else if (input.charAt(i) == '-')
							result.add(l-r);
						else if (input.charAt(i) == '*')
							result.add(l*r);
					}
			}
		}
		
		if (result.size() == 0)
			result.add(Integer.valueOf(input));
		return result;
    }

}
