package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Hayes extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Hayes() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Hayes", new DataSet("src/resources-elm", "hayes.train", 5),
				new DataSet("src/resources-elm", "hayes.test", 5), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
