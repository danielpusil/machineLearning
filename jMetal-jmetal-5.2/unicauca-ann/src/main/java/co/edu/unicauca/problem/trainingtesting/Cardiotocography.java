package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Cardiotocography extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Cardiotocography() throws IOException {
		super(50, new DataSet("src/resources-elm", "cardiotocography.train", 21),
				new DataSet("src/resources-elm", "cardiotocography.test", 21), new Sigmoid(),
				new MultiplicationMethod(null), "Cardiotocography", 3000);
	}
}
