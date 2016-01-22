package basicDS.SortMethods;

public class Insertion {
	public void sort(Double[] a){
		int len = a.length;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < i; j++){
				if(a[i] < a[j]){
					adjust(a, j, i);
				  //System.out.println("\n");
				}
				//System.out.println(j);
			}
			//System.out.println("The "+i+" sort!");
			//for(int k = 0; k<a.length; k++){
			//	System.out.print(a[k]+"    ");
			//}
		}
	}
	public Double[] adjust(Double[] a, int p, int q){
		Double temp = a[q];
		for(int i = q; i > p; i--){
			 a[i] = a[i-1];
		}
		a[p] = temp;
		//System.out.println(a[p]);
		
		
		return a;
	}
}
