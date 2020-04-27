package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Wine extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Wine() throws IOException {
		super(50, new DataSet("src/resources-elm", "wine.train", 13), new DataSet("src/resources-elm", "wine.test", 13),
				new Sigmoid(), new MultiplicationMethod(null), "Wine", 3000);
	}
}
