import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Evaluator e = new Evaluator();
		Scanner input = new Scanner(System.in);
		input.useLocale(java.util.Locale.ENGLISH);
		System.out.print("f(x) = ");
		e.setFunction(input.nextLine());
		/*
		System.out.print("a = ");
		double a=input.nextDouble();
		System.out.print("b = ");
		double b=input.nextDouble();
		System.out.println(e.integralRect(a,b,500));
		System.out.println(e.integralTrap(a,b,500));
		System.out.println(e.integralSimpson(a, b, 10));*/
		System.out.print("x0 = ");
		double x0 = input.nextDouble();
		System.out.println(e.derivate2(x0, 1000));
		System.out.println(Math.exp(x0));
		/*System.out.println(e.bisectionZero(a,b,10E-12, 1000));
		System.out.println(Math.PI);*/
		input.close();
	}

}
