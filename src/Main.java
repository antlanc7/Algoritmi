import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.print("f(x) = ");
		Evaluator e = new Evaluator(input.nextLine());
		System.out.print("x = ");
		double x=input.nextDouble();
		System.out.println(e.f(x));
	}

}
