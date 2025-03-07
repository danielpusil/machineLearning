package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Servo extends AbstractCrossValidationEvaluator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Servo() throws IOException {
		super(AbstractELMEvaluator.EvaluatorType.CV, "Servo", new DataSet("src/resources-elm", "servo.train", 4),
				new DataSet("src/resources-elm", "servo.test", 4), 10, 50, new Sigmoid(),
				new MultiplicationMethod(null), 3000);
	}
}
