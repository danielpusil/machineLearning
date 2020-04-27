package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class QSARBiodegradation extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QSARBiodegradation() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "QSARBiodegradation",
				new DataSet("src/resources-elm", "QSARBiodegradation.train", 41),
				new DataSet("src/resources-elm", "QSARBiodegradation.test", 41), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
