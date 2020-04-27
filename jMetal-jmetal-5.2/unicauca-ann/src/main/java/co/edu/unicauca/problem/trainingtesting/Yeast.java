package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Yeast extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Yeast() throws IOException {
		super(50, new DataSet("src/resources-elm", "yeast.train", 8), new DataSet("src/resources-elm", "yeast.test", 8),
				new Sigmoid(), new MultiplicationMethod(null), "Yeast", 3000);
	}
}
