import net.objecthunter.exp4j.*;
import java.lang.Math.*;

public class Evaluator {
	private Expression expression;
	Evaluator(String f){
		expression=new ExpressionBuilder(f).variable("x").build();
	}
	
	Evaluator(){
		expression=new ExpressionBuilder("0").build();
	}
	
	public void setFunction(String f) {
		expression=new ExpressionBuilder(f).variable("x").build();
	}
	
	public double f(double x) {
		expression.setVariable("x", x);
		return expression.evaluate();
	}
	
	public double integralRect(double a, double b, int n) {
		
		double x = a;
		double h = (b-a)/n;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum+= f(x);
			x += h;
		}
		
		return sum*h;
	}
	
	public double integralTrap(double a, double b, int n) {
		
		double h = (b-a)/n;
		double sum = (f(a)+f(b))/2;
		double x = a + h;
		for (int i = 1; i < n; i++) {
			sum += f(x);
			x += h;
		}
		
		return sum*h;
	}
	
	
	public double integrateSimpson(double a, double b, int n, double prec) {
		
		if (n%2 != 0) n++; 
		
		double h = (b-a)/n;
		double sp = 0;
		double sd = 0;
		double x = a;
		for (int i = 1; i <= (n-2)/2; i++) {
			x += h;
			sd += f(x);
			x += h;
			sp += f(x);
		}
		x += h;
		sd += f(x);
		double FAB = f(a) + f(b);
		double area = (FAB + 4*sd + 2*sp)*h/3;
		double area1, diff;
		do {
			sp += sd;
			sd = 0;
			x = a + h/2;
			for(int i = 1; i <= n; i++) {
				sd += f(x);
				x += h;
			}
			area1 = (FAB +4*sd + 2*sp)*h/6;
			diff = Math.abs(area1-area);
			h = h/2;
			n = n*2;
		} while(diff > prec);
		
		return area;
	}
	
	public double integrateSimpson(double a, double b, int n) {
		
		return integrateSimpson(a, b, n, 0.0001);
		
	}
	
	
	public double derivate(double x0, int prec) {
		
		double h = 1.0/prec;
		return (f(x0+h) - f(x0-h))/(2*h);
		
	}
		
	public double derivate(double x0) {
		
		return derivate(x0, 1000);
		
	}
	
}
