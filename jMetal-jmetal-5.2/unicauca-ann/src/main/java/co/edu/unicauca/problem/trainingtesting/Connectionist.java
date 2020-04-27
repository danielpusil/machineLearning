package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Connectionist extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Connectionist() throws IOException {
		super(50, new DataSet("src/resources-elm", "connectionist.train", 60),
				new DataSet("src/resources-elm", "connectionist.test", 60), new Sigmoid(),
				new MultiplicationMethod(null), "Connectionist", 3000);
	}
}
