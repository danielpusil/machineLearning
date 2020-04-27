package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Yeast extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Yeast() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Yeast", new DataSet("src/resources-elm", "yeast.train", 8),
				new DataSet("src/resources-elm", "yeast.test", 8), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}