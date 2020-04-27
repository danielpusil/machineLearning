package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;
import co.edu.unicauca.problem.AbstractELMEvaluator;

public class Banknote extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Banknote() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Banknote", new DataSet("src/resources-elm", "banknote.train", 4),
				new DataSet("src/resources-elm", "banknote.test", 4), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}

}
