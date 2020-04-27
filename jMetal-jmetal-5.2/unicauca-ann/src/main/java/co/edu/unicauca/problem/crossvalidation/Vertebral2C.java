package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Vertebral2C extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vertebral2C() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Vertebral(2c)",
				new DataSet("src/resources-elm", "vertebral(2c).train", 6),
				new DataSet("src/resources-elm", "vertebral(2c).test", 6), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}

}
