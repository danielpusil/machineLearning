package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Banknote extends TrainingTestingEvaluator {

	private static final long serialVersionUID = 1L;

	public Banknote() throws IOException {
		super(50, new DataSet("src/resources-elm", "banknote.train", 4),
				new DataSet("src/resources-elm", "banknote.test", 4), new Sigmoid(), new MultiplicationMethod(null),
				"Banknote", 3000);
	}
}