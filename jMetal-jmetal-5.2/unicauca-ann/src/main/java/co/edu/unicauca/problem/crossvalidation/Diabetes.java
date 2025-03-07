package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Diabetes extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Diabetes() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Diabetes", new DataSet("src/resources-elm", "diabetes.train", 8),
				new DataSet("src/resources-elm", "diabetes.test", 8), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}

}
