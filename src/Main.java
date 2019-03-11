import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Evaluator e = new Evaluator();
		Scanner input = new Scanner(System.in);
		System.out.print("f(x) = ");
		e.setFunction(input.nextLine());
		System.out.println(e.f(x));
		System.out.print("a = ");
		double a=input.nextDouble();
		System.out.print("b = ");
		double b=input.nextDouble();
		System.out.println(e.integralRect(a,b,500));
		System.out.println(e.integralTrap(a,b,500));
		input.close();
	}

}
