package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class BodyFat extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public BodyFat() throws IOException {
		super(50, new DataSet("src/resources-elm", "bodyFat.train", 14),
				new DataSet("src/resources-elm", "bodyFat.test", 14), new Sigmoid(), new MultiplicationMethod(null),
				"BodyFat", 3000);
	}
}
