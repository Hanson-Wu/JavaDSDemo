package dsApp.Tests;

import basicDS.SortMethods.Insertion;;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] a = {5.0, 3.0, 6.0, 8.0, 4.0, 9.0, 2.0};
		Insertion insertion = new Insertion();
		insertion.adjust(a, 0, 1);
		for(int k = 0; k<a.length; k++){
			System.out.print(a[k]+"    ");
		}
	}

}
