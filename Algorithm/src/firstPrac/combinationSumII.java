package firstPrac;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class combinationSumII {
	public static void main(String[] args) {
		int[] candidates = {1,1};
		List<List<Integer>> sol = combinationSum2(candidates, 2);
		System.out.println(sol);
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> sol = new ArrayList<List<Integer>> ();
		int len = candidates.length;
		if (len<1)
			return sol;
		Arrays.sort(candidates);
		List<Integer> templist = new ArrayList<Integer> ();
		//System.out.println(templist+"here");
		helper(candidates, target, templist, sol,0);
		return sol;
	}
	
	public static void helper(int[] candidates, int target, List<Integer> templist, List<List<Integer>> sol, int index){
		if (target<0)
			return;
		if (target ==0)
		{
			List<Integer> x = new ArrayList(templist);
			sol.add(x);
		System.out.println(" add to sol"+sol);
			return;
		}
		for (int i=index; i<candidates.length;i++){
			if (i>index && candidates[i] == candidates[i-1])
				continue; // unique solution
			System.out.println(" i = "+i);
			templist.add(candidates[i]);
			//System.out.println(templist+"; i = "+i+"; target = "+target);
			helper(candidates, target-candidates[i], templist, sol, i+1);
			templist.remove(templist.size()-1);
		}
	}
}
