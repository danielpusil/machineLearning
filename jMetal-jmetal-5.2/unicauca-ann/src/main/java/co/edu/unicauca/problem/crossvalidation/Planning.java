package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Planning extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Planning() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Planning", new DataSet("src/resources-elm", "planning.train", 12),
				new DataSet("src/resources-elm", "planning.test", 12), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
