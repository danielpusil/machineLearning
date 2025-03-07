package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Zoo extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Zoo() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Zoo", new DataSet("src/resources-elm", "zoo.train", 16),
				new DataSet("src/resources-elm", "zoo.test", 16), 10, 50, new Sigmoid(), new MultiplicationMethod(null),
				3000);
	}
}
