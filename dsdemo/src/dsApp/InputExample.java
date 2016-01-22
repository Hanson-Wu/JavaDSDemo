package dsApp;
import java.util.Scanner;

public class InputExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter: your age: ");
		double age = input.nextDouble();
		System.out.println("Enter: your Max_HeartRate: ");
		double rate = input.nextDouble();
		double fb = (rate - age)*0.65;
		System.out.println("Your ideal fat-burning heart rate is " + fb );
	}

}
