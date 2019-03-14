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
	
	
	public double integralSimpson(double a, double b, int n, double prec, int nmax) {
		
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
			System.out.println(n);
		} while(diff > prec && n < nmax);
		
		return area;
	}
	
	public double integralSimpson(double a, double b, int n) {
		
		return integralSimpson(a, b, n, 0.0001, (int)10E6);
		
	}


	public double derivate(double x0, int prec) {
		
		double h = 1.0/prec;
		return (f(x0+h) - f(x0-h))/(2*h);

	}

	public double derivate2(double x0, int prec){
		double h = 1.0/prec;
		return (f(x0-2*h)-8*f(x0-h)+8*f(x0+h)-f(x0+2*h))/(12*h);
	}
		
	public double derivate(double x0) {
		
		return derivate(x0, 1000);
		
	}

	public double bisectionZero(double a, double b, double eps, int nMax){
		int i=0;
		double c=0;
		while (i<nMax && Math.abs(b-a)>eps){
			c=a+(b-a)/2;
			if (Math.signum(f(a))*Math.signum(f(c))<0) b=c;
			else a=c;
		}
		return c;
	}

	public double NewtonZero (double a, double eps, int Nmax) {

		int i = 0;
		double x;
		double xn = a;
		do {
			x = xn;
			xn = x - f(x)/derivate(x);
			i++;
		} while( Math.abs(xn-x) > eps && i < Nmax);

		return xn;
	}


	
}
