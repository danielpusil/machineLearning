package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Indian extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Indian() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Indian", new DataSet("src/resources-elm", "indian.train", 10),
				new DataSet("src/resources-elm", "indian.test", 10), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
