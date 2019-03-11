import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("f(x) = ");
		Evaluator e = new Evaluator(input.nextLine());
		System.out.print("x = ");
		double x=input.nextDouble();
		System.out.println(e.f(x));
		System.out.print("a = ");
		double a=input.nextDouble();
		System.out.print("b = ");
		double b=input.nextDouble();
		System.out.println(e.integralRect(a,b,1000));
		input.close();
	}

}
