package dsApp;

public class QuickSort {

	public void sort(int[] array, int low, int high){
		 if (low < high)  
		 {  
		     //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
		     int i = low, j = high, x = array[low];  
		     while (i < j)  
		     {  
		         while(i < j && array[j] >= x) // 从右向左找第一个小于x的数  
		             j--;    
		         if(i < j)   
		             array[i++] = array[j];  
		             
		         while(i < j && array[i] < x) // 从左向右找第一个大于等于x的数  
		        	 i++;    
		         if(i < j)   
		             array[j--] = array[i];  
		     }  
		     array[i] = x;  
		     printArray(array);
		     //System.out.println("left portion quick sort");
		     sort(array, low, i - 1); // 递归调用  
		     //System.out.println("right portion quick sort");
		     sort(array, i + 1, high); 
		  }    
	}
	
	public void printArray(int[] array){
		for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
		System.out.println();
	}
	
	public void mysort(int[] array, int low, int high){
		//int i = low, j = high
		
		if(low < high){
			int pivot = choosePivot(array, low, high);
			int pivot_value = array[pivot];
			exchange(array, pivot, high);
			int i = low, j = high-1;
			 while (true) {
	                while (array[i] < pivot_value) {
	                    i++;
	                }
	                while (array[j] > pivot_value) {
	                    j--;
	                }

	                if (i >= j) {
	                    break;
	                }
	                exchange(array, i, j);
	            }

			exchange(array, i, high);
			printArray(array);
			System.out.println("low is: "+low+" i is: "+i);
			mysort(array, low, i - 1); // 递归调用 
			System.out.println("i is: "+i+" high is: "+i);
		    mysort(array, i + 1, high+1); 	
		}
	}
	
	public int[] exchange(int[] array, int i, int j){
		System.out.println("exchange: "+ array[i]+" and "+array[j]);
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
		return array;
	}
	
	public int choosePivot(int[] array, int low, int high){
		return (high-low)/2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort quickSort = new QuickSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        int[] array1 = {7, 6, 5, 4, 3, 2, 1};
        //int[] array1 = {2, 3, 1};
        //quickSort.sort(array1, 0, array1.length-1);
        quickSort.mysort(array1, 0, array1.length-1);
        quickSort.printArray(array1);
	}

}
