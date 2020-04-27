package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Connectionist extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Connectionist() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Connectionist",
				new DataSet("src/resources-elm", "connectionist.train", 60),
				new DataSet("src/resources-elm", "connectionist.test", 60), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
