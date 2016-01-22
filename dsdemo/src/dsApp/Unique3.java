package dsApp;
/**
 * Bad recursion method to identify if the array is unique
 * @author Nan
 *
 */
	public class Unique3 {

		  /** Returns true if there are no duplicate values from data[low] through data[high].*/
		  public static boolean unique3(int[] data, int low, int high) {
		    if (low >= high) {
		    	System.out.println("here1");
		    	return true;}                         // at most one item
		    else if (!unique3(data, low, high-1)) {
		    	System.out.println("here2");
		    	return false;}       // duplicate in first n-1
		    else if (!unique3(data, low+1, high)){
		    	System.out.println("here3");
		    	return false;}     // duplicate in last n-1
		    else {
		    	System.out.println("here4");
		    	return (data[low] != data[high]);                // do first and last differ?
		    }
		  }
		  public static void main(String[] args) {
				// TODO Auto-generated method stub
			  final int N = 100;
			   int[] data = new int[N];
					 for (int j=0; j < N; j++){
						     data[j] = 1 + 2*j;
						     System.out.print(data[j]+" ");
					 }
					 
			if(unique3(data, 0, data.length-1))
				System.out.println("It is an unique array!");
			else
				System.out.println("It is not an unique array!");
			
			}	  
	}

	

