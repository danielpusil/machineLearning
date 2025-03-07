package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Wilt extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Wilt() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Wilt", new DataSet("src/resources-elm", "wilt.train", 5),
				new DataSet("src/resources-elm", "wilt.test", 5), 10, 50, new Sigmoid(), new MultiplicationMethod(null),
				3000);
	}
}
