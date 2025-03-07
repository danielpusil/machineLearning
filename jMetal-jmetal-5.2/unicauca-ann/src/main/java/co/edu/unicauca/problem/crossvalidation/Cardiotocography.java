package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Cardiotocography extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cardiotocography() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Cardiotocography",
				new DataSet("src/resources-elm", "Cardiotocography.train", 21),
				new DataSet("src/resources-elm", "Cardiotocography.test", 21), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
