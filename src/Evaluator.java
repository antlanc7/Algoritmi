import net.objecthunter.exp4j.*;


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
	
	
	
	
	
	public double derivate(double x0, int prec) {
		
		double h = 1.0/prec;
		return (f(x0+h) - f(x0-h))/(2*h);
		
	}
		
	public double derivate(double x0) {
		
		return derivate(x0, 1000);
		
	}
	
}
