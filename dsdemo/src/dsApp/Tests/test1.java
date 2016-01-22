package dsApp.Tests;

import basicDS.SortMethods.Insertion;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] a = {5.0, 3.0, 6.0, 8.0, 4.0, 9.0, 2.0};
		//Double[] a = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
		//timer.wait(1000, nanos);
		//System.out.println(System.currentTimeMillis()-timer);
		Insertion insertion = new Insertion();
		insertion.sort(a);
		//Insertion.sort(a);
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i]+"    ");
		}
		
	}

}
