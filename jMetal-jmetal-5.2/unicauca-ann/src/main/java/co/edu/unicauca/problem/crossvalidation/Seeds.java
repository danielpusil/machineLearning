package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Seeds extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Seeds() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Seeds", new DataSet("src/resources-elm", "seeds.train", 7),
				new DataSet("src/resources-elm", "seeds.test", 7), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}

}
