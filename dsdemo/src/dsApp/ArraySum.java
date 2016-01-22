package dsApp;


/**
 * @author Nan
 *
 */
public class ArraySum {
	/**
	 * calculate sum value from 1 to n
	 * @param data
	 * @param n
	 * @return
	 */
	public static int linearSum(int[] data, int n){
		if(n==0)return 0;
		else return linearSum(data,n-1) + data[n-1];
	}
	/**
	 * reverse a data array
	 * @param data
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] reverseArray(int[] data, int low, int high){
		if(low < high){
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverseArray(data, low+1,high-1);
		}
		//printArray(data);
		return data;
	}
	/**
	 * printing array ending with \n
	 * @param data
	 */
	public static void printArray(int[] data){
		for(int i=0; i<data.length; i++){
			System.out.print(data[i]+"\t");
		}
		System.out.print("\n");
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		int[] myArray = {4,3,6,2,7,8,9,5};
		int[] finalArray = null;
		int a = 0;
		int b = myArray.length - 1;
		printArray(myArray);
		finalArray = reverseArray(myArray, a, b);
		printArray(finalArray);
	}
}
