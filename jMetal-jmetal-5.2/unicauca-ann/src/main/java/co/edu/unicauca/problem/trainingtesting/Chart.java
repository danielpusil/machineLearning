package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Chart extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Chart() throws IOException {
		super(50, new DataSet("src/resources-elm", "chart.train", 60),
				new DataSet("src/resources-elm", "chart.test", 60), new Sigmoid(), new MultiplicationMethod(null),
				"Chart", 3000);
	}
}
