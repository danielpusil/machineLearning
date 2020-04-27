package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Ionosphere extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Ionosphere() throws IOException {
		super(50, new DataSet("src/resources-elm", "ionosphere.train", 34),
				new DataSet("src/resources-elm", "ionosphere.test", 34), new Sigmoid(), new MultiplicationMethod(null),
				"Ionosphere", 3000);
	}
}
