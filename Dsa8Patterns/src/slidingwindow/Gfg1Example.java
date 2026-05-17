package slidingwindow;

import java.util.ArrayList;

public class Gfg1Example {
	
	static ArrayList<Integer> maxOfSubArray(int[] arr, int k){
		int n = arr.length;
	ArrayList<Integer> res = new ArrayList<Integer>();
	
	for (int i = 0; i <= n-k; i++) {
		int max = arr[i];
		for (int j = 0; j < k; j++) {
			if(arr[i+j] > max) {
				max = arr[i+j];
			}
			
		}
		res.add(max);
	}
	
	
	return res;
	}

	
	public static void main(String[] args) {
		int[] arr = {2,3,5,1,6,8,3};
		int k = 3;
		
		ArrayList<Integer> str = maxOfSubArray(arr,k);
		
		for(int maxValue : str) {
			System.out.println("maxValue : "+maxValue);
			
		}
	}
}
