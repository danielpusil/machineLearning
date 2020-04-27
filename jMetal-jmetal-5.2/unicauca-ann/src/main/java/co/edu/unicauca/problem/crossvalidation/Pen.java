package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Pen extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pen() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Pen", new DataSet("src/resources-elm", "pen.train", 16),
				new DataSet("src/resources-elm", "pen.test", 16), 10, 50, new Sigmoid(), new MultiplicationMethod(null),
				3000);
	}
}
