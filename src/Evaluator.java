import net.objecthunter.exp4j.*;


public class Evaluator {
	private Expression expression;
	Evaluator(String f){
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
	
}
