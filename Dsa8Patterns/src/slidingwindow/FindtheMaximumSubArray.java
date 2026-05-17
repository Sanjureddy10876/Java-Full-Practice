package slidingwindow;

public class FindtheMaximumSubArray {

	public static int maxValueofsubArray(int[] arr, int w) {
		int current = 0;
		for (int i = 0; i < w; i++) {
			current += arr[i];
		}
		
		int maxx = current;
		int n = 0;
		for (int i = 1; i < n-w; i++) {
			current = current - arr[i] + arr[i+w-1];
			if (current > maxx) {
				maxx = current;
			}
		}
	
		
		return maxx;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,8,2,5,7,6,12};
		int w = 4;
		
		int str = maxValueofsubArray(arr, w);
		
		System.out.println(str);
		
	}

}
