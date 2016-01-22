package dsApp;
import java.math.*;
import java.util.Timer;

public class Sort {

	public static double time(String alg, Double[] a)
	{ //Stopwatch timer = new Stopwatch();
		double timer=System.currentTimeMillis();
		if (alg.equals("Insertion")) Insertion.sort(a);
		if (alg.equals("Selection")) Selection.sort(a);
		if (alg.equals("Shell")) Shell.sort(a);
		if (alg.equals("Merge")) Merge.sort(a);
		if (alg.equals("Quick")) Quick.sort(a);
		if (alg.equals("Heap")) Heap.sort(a);
		return (System.currentTimeMillis() -  timer);
	}
	 public static double timeRandomInput(String alg, int N, int T)
	{ // Use alg to sort T random arrays of length N.
		 double total = 0.0;
		 Double[] a = new Double[N];
		 for (int t = 0; t < T; t++)
		 { // Perform one experiment (generate and sort an array).
			 for (int i = 0; i < N; i++)
				 a[i] = Math.random();
			 total += time(alg, a);
		 }
		 return total;
	 }
	 public static void main(String[] args)
	 {
		 String alg1 = args[0];
		 String alg2 = args[1];
		 int N = Integer.parseInt(args[2]);
		 int T = Integer.parseInt(args[3]);
		 double t1 = timeRandomInput(alg1, N, T); // total for alg1
		 double t2 = timeRandomInput(alg2, N, T); // total for alg2
		 System.out.printf("For %d random Doubles\n %s is", N, alg1);
		 System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);
	 }
}
