package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Hayes extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Hayes() throws IOException {
		super(50, new DataSet("src/resources-elm", "hayes.train", 5), new DataSet("src/resources-elm", "hayes.test", 5),
				new Sigmoid(), new MultiplicationMethod(null), "Hayes", 3000);
	}
}
