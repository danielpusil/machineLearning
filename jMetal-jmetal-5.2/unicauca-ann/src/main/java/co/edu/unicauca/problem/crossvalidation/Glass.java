package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Glass extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Glass() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Glass", new DataSet("src/resources-elm", "glass.train", 9),
				new DataSet("src/resources-elm", "glass.test", 9), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
