import java.util.Scanner;

public class Newton {
	
	///*
	public static void main(String[] args) {

		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Input: ");
		System.out.println("Sqrt of input: " + 
							rapsonSqrt(s.nextInt()));
		
		s.close();
	}//*/

	public static double rapsonSqrt(double c) {
		double t = c / 2;
	
		while(Math.abs(t*t) < 0.0000000000001) {
			t = (c / t + t) / 2;
		}
		
		return t;
	}
	
}