package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Ecoli extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Ecoli() throws IOException {
		super(50, new DataSet("src/resources-elm", "ecoli.train", 7), new DataSet("src/resources-elm", "ecoli.test", 7),
				new Sigmoid(), new MultiplicationMethod(null), "Ecoli", 3000);
	}
}
