import net.objecthunter.exp4j.*;


public class Evaluator {
	private Expression expression;
	Evaluator(String f){
		expression=new ExpressionBuilder(f).variable("x").build();
	}
	
}
