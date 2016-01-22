package dsApp;

public class BinarySum {
	public static int binarySum(int[] data, int low, int high){
		if(low > high)return 0;
		else if(low == high){
			System.out.print(data[low]+"\t");
			return data[low];
		}else{
			int mid = (low+high)/2;
			System.out.println("here");
			return binarySum(data, low, mid) + binarySum(data, mid+1, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = {1,2,3,4,5,6,7,8,9};
		int totalSum = binarySum(myArray, 0, 8);
		System.out.println();
		System.out.println("Final result is: " + totalSum);
	}

}
