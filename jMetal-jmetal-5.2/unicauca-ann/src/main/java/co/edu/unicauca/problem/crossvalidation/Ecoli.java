package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Ecoli extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ecoli() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Ecoli", new DataSet("src/resources-elm", "ecoli.train", 7),
				new DataSet("src/resources-elm", "ecoli.test", 7), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
