package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Letter extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Letter() throws IOException {
		super(50, new DataSet("src/resources-elm", "letter.train", 16),
				new DataSet("src/resources-elm", "letter.test", 16), new Sigmoid(), new MultiplicationMethod(null),
				"Letter", 3000);
	}
}
