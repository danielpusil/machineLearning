
package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;
import co.edu.unicauca.problem.AbstractELMEvaluator;

public class Contraceptive extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Contraceptive() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Contraceptive",
				new DataSet("src/resources-elm", "contraceptive.train", 9),
				new DataSet("src/resources-elm", "contraceptive.test", 9), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}

}
